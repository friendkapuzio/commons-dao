/*
 * Copyright 2016 EPAM Systems
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

import com.epam.ta.reportportal.database.dao.LaunchRepository;
import com.epam.ta.reportportal.database.dao.TestItemRepository;
import com.epam.ta.reportportal.ws.model.BulkRQ;
import com.epam.ta.reportportal.ws.model.OperationCompletionRS;
import com.epam.ta.reportportal.ws.model.launch.UpdateLaunchRQ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * Default implementation of {@link IUpdateLaunchHandler}
 *
 * @author Aliaksei_Makayed
 * @author Andrei_Ramanchuk
 */
@Service
public class UpdateLaunchHandler implements IUpdateLaunchHandler {

	@Autowired
	private TestItemRepository testItemRepository;

	//private ProjectRepository projectRepository;

	private LaunchRepository launchRepository;

	//private UserRepository userRepository;

//	@Autowired
//	private IIssuesAnalyzer analyzerService;
//
//	@Autowired
//	private ILogIndexer logIndexer;
//
//	@Autowired
//	@Qualifier("autoAnalyzeTaskExecutor")
//	private TaskExecutor taskExecutor;

	@Autowired
	public void setLaunchRepository(LaunchRepository launchRepository) {
		this.launchRepository = launchRepository;
	}

//	@Autowired
//	public void setUserRepository(UserRepository userRepository) {
//		this.userRepository = userRepository;
//	}
//
//	@Autowired
//	public void setProjectRepository(ProjectRepository projectRepository) {
//		this.projectRepository = projectRepository;
//	}

	@Override
	public OperationCompletionRS updateLaunch(String launchId, String projectName, String userName, UpdateLaunchRQ rq) {
//		Launch launch = launchRepository.findOne(launchId);
//		expect(launch, notNull()).verify(LAUNCH_NOT_FOUND, launchId);
//		validate(launch, userName, projectName, rq.getMode());
//		ofNullable(rq.getMode()).ifPresent(launch::setMode);
//		ofNullable(rq.getDescription()).ifPresent(launch::setDescription);
//		ofNullable(rq.getTags()).ifPresent(tags -> launch.setTags(Sets.newHashSet(EntityUtils.trimStrings(rq.getTags()))));
//		reindexLogs(launch);
//		launchRepository.save(launch);
//		return new OperationCompletionRS("Launch with ID = '" + launch.getId() + "' successfully updated.");
		return null;
	}

	@Override
	public OperationCompletionRS startLaunchAnalyzer(String projectName, String launchId) {
//		expect(analyzerService.hasAnalyzers(), Predicate.isEqual(true)).verify(
//				ErrorType.UNABLE_INTERACT_WITH_EXTRERNAL_SYSTEM, "There are no analyzer services are deployed.");
//
//		Launch launch = launchRepository.findOne(launchId);
//		expect(launch, notNull()).verify(LAUNCH_NOT_FOUND, launchId);
//
//		expect(launch.getProjectRef(), equalTo(projectName)).verify(FORBIDDEN_OPERATION,
//				Suppliers.formattedSupplier("Launch with ID '{}' is not under '{}' project.", launchId, projectName)
//		);
//
//		/* Do not process debug launches */
//		expect(launch.getMode(), equalTo(DEFAULT)).verify(INCORRECT_REQUEST, "Cannot analyze launches in debug mode.");
//
//		Project project = projectRepository.findOne(projectName);
//		expect(project, notNull()).verify(PROJECT_NOT_FOUND, projectName);
//
//		List<TestItem> toInvestigate = testItemRepository.findInIssueTypeItems(TO_INVESTIGATE.getLocator(), launchId);
//
//		taskExecutor.execute(() -> analyzerService.analyze(launch, toInvestigate));
//
//		return new OperationCompletionRS("Auto-analyzer for launch ID='" + launchId + "' started.");
		return null;
	}

	@Override
	public List<OperationCompletionRS> updateLaunch(BulkRQ<UpdateLaunchRQ> rq, String projectName, String userName) {
		return rq.getEntities()
				.entrySet()
				.stream()
				.map(entry -> updateLaunch(entry.getKey(), projectName, userName, entry.getValue()))
				.collect(toList());
	}

//	/**
//	 * If launch mode has changed - reindex items
//	 *
//	 * @param launch Update launch
//	 */
//	private void reindexLogs(Launch launch) {
//		List<TestItem> investigatedItems = testItemRepository.findItemsNotInIssueType(TO_INVESTIGATE.getLocator(), launch.getId());
//		if (!CollectionUtils.isEmpty(investigatedItems)) {
//			if (Mode.DEBUG.equals(launch.getMode())) {
//				logIndexer.cleanIndex(launch.getProjectRef(), investigatedItems.stream().map(TestItem::getId).collect(toList()));
//			} else {
//				logIndexer.indexLogs(launch.getId(), investigatedItems);
//			}
//		}
//	}
//
//	private void validate(Launch launch, String userName, String projectName, Mode mode) {
//		// BusinessRule.expect(launch.getUserRef(),
//		// Predicates.notNull()).verify(ErrorType.ACCESS_DENIED);
//		String launchOwner = launch.getUserRef();
//		User principal = userRepository.findOne(userName);
//		Project project = projectRepository.findOne(projectName);
//		if ((findUserConfigByLogin(project, userName).getProjectRole() == CUSTOMER) && (null != mode)) {
//			expect(mode, equalTo(DEFAULT)).verify(ACCESS_DENIED);
//		}
//		if (principal.getRole() != ADMINISTRATOR) {
//			expect(launch.getProjectRef(), equalTo(projectName)).verify(ACCESS_DENIED);
//			if ((null == launchOwner) || (!launchOwner.equalsIgnoreCase(userName))) {
//				/*
//				 * Only PROJECT_MANAGER roles could move launches
//				 * to/from DEBUG mode
//				 */
//				UserConfig userConfig = findUserConfigByLogin(project, userName);
//				expect(userConfig, Preconditions.hasProjectRoles(singletonList(PROJECT_MANAGER))).verify(ACCESS_DENIED);
//			} else {
//				/*
//				 * Only owner could change launch mode
//				 */
//				expect(userName, equalTo(launchOwner)).verify(ACCESS_DENIED);
//			}
//		}
//	}

}