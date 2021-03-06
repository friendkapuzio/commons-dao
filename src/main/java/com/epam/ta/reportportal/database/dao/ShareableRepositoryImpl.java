/*
 * Copyright 2016 EPAM Systems
 * 
 * 
 * This file is part of EPAM Report Portal.
 * https://github.com/reportportal/commons-dao
 * 
 * Report Portal is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * Report Portal is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with Report Portal.  If not, see <http://www.gnu.org/licenses/>.
 */

package com.epam.ta.reportportal.database.dao;

import com.epam.ta.reportportal.commons.Preconditions;
import com.epam.ta.reportportal.database.entity.Dashboard;
import com.epam.ta.reportportal.database.entity.sharing.AclPermissions;
import com.epam.ta.reportportal.database.entity.sharing.Shareable;
import com.epam.ta.reportportal.database.search.Filter;
import com.epam.ta.reportportal.database.search.QueryBuilder;
import com.google.common.collect.Lists;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.repository.query.MongoEntityInformation;

import java.io.Serializable;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;

import static com.epam.ta.reportportal.database.dao.ShareableRepositoryUtils.createOwnedEntityQuery;
import static com.epam.ta.reportportal.database.dao.ShareableRepositoryUtils.createSharedEntityQuery;
import static java.util.Collections.emptyList;

/**
 * Default implementation of {@link ShareableRepository} added possibility to work with shareable
 * objects.
 *
 * @param <T>
 * @param <ID>
 * @author Aliaksei_Makayed
 */
public class ShareableRepositoryImpl<T, ID extends Serializable> extends ReportPortalRepositoryImpl<T, ID>
		implements ShareableRepository<T, ID> {

	private static final String ENTITY_NAME_FIELD = "name";
	private static final String ENTITY_DESCRIPTION_FIELD = "description";
	private static final String ENTITY_OWNER_FIELD = "acl.ownerUserId";

	public ShareableRepositoryImpl(MongoEntityInformation<T, ID> metadata, MongoOperations mongoOperations) {
		super(metadata, mongoOperations);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Page<T> findSharedEntities(String projectName, List<String> fields, Sort sort, Pageable pageable) {
		if (projectName == null || fields == null || sort == null) {
			return new PageImpl<>(emptyList(), pageable, 0);
		}
		Query query = createSharedEntityQuery(projectName).with(sort).with(pageable);
		if (Preconditions.NOT_EMPTY_COLLECTION.test(fields)) {
			for (String field : fields) {
				query.fields().include(field);
			}
		}
		Class<T> entityType = getEntityInformation().getJavaType();
		return new PageImpl<>(getMongoOperations().find(query, entityType), pageable, getMongoOperations().count(query, entityType));
	}

	@Override
	public Page<T> findSharedEntitiesByName(String projectName, String term, Pageable pageable) {
		final String regex = "(?i).*" + Pattern.quote(term.toLowerCase()) + ".*";

		Query query = createSharedEntityQuery(projectName).with(pageable);
		Criteria name = Criteria.where(ENTITY_NAME_FIELD).regex(regex);
		Criteria owner = Criteria.where(ENTITY_OWNER_FIELD).regex(regex);
		Criteria description = Criteria.where(ENTITY_DESCRIPTION_FIELD).regex(regex);
		query.addCriteria(new Criteria().orOperator(name, owner, description));

		Class<T> entityType = getEntityInformation().getJavaType();
		List<T> searchResults = getMongoOperations().find(query, entityType);
		return new PageImpl<>(searchResults, pageable, getMongoOperations().count(query, entityType));
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> findOnlyOwnedEntities(Set<String> ids, String owner) {
		if (owner == null) {
			return emptyList();
		}
		Query query = createOwnedEntityQuery(owner);
		if (Preconditions.NOT_EMPTY_COLLECTION.test(ids)) {
			query.addCriteria(Criteria.where(Shareable.ID).in(ids));
		}
		Class<T> entityType = getEntityInformation().getJavaType();
		return getMongoOperations().find(query, entityType);
	}

	@Override
	public Page<T> findAllByFilter(Filter filter, Pageable pageable, String projectName, String owner) {
		if (filter == null || pageable == null || projectName == null || owner == null) {
			return new PageImpl<>(emptyList());
		}
		Query query = QueryBuilder.newBuilder().with(filter).with(pageable).build();
		query.addCriteria(getAllEntitiesCriteria(projectName, owner));
		return findPage(query, pageable);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> findByProject(String projectName) {
		if (null == projectName) {
			return emptyList();
		}
		Query query = Query.query(Criteria.where("projectName").is(projectName));
		Class<T> entityType = getEntityInformation().getJavaType();
		return getMongoOperations().find(query, entityType);
	}

	@Override
	public T findOneLoadACL(ID id) {
		return super.findById(id,
				Lists.newArrayList(Dashboard.NAME, Dashboard.PROJECT_NAME, Shareable.ACL, getEntityInformation().getIdAttribute())
		);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> findNonSharedEntities(String owner) {
		if (null == owner || owner.isEmpty()) {
			return emptyList();
		}
		Query query = ShareableRepositoryUtils.createUnsharedEntityQuery(owner);
		Class<T> entityType = getEntityInformation().getJavaType();
		return getMongoOperations().find(query, entityType);
	}

	/**
	 * Create criteria for loading owned entities and shared to specified project entities
	 *
	 * @param projectName
	 * @param userName
	 * @return
	 */
	private Criteria getAllEntitiesCriteria(String projectName, String userName) {
		return new Criteria().orOperator(new Criteria().andOperator(Criteria.where("acl.entries.projectId").is(projectName),
				Criteria.where("acl.entries.permissions").is(AclPermissions.READ.name())
		), new Criteria().andOperator(Criteria.where("acl.ownerUserId").is(userName), Criteria.where("projectName").is(projectName)));
	}
}