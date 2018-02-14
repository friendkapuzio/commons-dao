/*
 * Copyright 2017 EPAM Systems
 *
 *
 * This file is part of EPAM Report Portal.
 * https://github.com/reportportal/service-api
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

package com.epam.ta.reportportal.grabage.launch;

import com.epam.ta.reportportal.database.entity.launch.Launch;
import com.epam.ta.reportportal.ws.model.launch.LaunchResource;
import com.epam.ta.reportportal.ws.model.launch.Mode;
import com.google.common.base.Preconditions;

import java.util.function.Function;

/**
 * @author Pavel Bortnik
 */
public final class LaunchConverter {

	private LaunchConverter() {
		//static only
	}

	public static final Function<Launch, LaunchResource> TO_RESOURCE = db -> {
		Preconditions.checkNotNull(db);
		LaunchResource resource = new LaunchResource();
		resource.setLaunchId(db.getId().toString());
		resource.setName(db.getName());
		resource.setNumber(db.getNumber().longValue());
		resource.setDescription(db.getDescription());
		//resource.setStatus(db.getStatus() == null ? null : db.getStatus().toString());
		resource.setStartTime(db.getStartTime());
		//resource.setEndTime(db.getEndTime());
		//resource.setTags(db.getTags());
		resource.setMode(Mode.valueOf(db.getMode().toString()));
		//resource.setApproximateDuration(db.getApproximateDuration());
		resource.setOwner(db.getUserId().toString());
		//resource.setHasRetries(BooleanUtils.isTrue(db.getHasRetries()));
		//resource.setStatistics(StatisticsConverter.TO_RESOURCE.apply(db.getStatistics()));
		return resource;
	};
}