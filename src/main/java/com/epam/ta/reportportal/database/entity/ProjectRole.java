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

package com.epam.ta.reportportal.database.entity;

import java.util.Arrays;
import java.util.Optional;

/**
 * Project Role Representation
 * 
 * @author Andrei Varabyeu
 * 
 */
public enum ProjectRole implements Comparable<ProjectRole> {

	OPERATOR(0), CUSTOMER(1), MEMBER(2), PROJECT_MANAGER(3);

	private int roleLevel;

	ProjectRole(int level) {
		this.roleLevel = level;
	}

	public boolean higherThan(ProjectRole other) {
		return this.roleLevel > other.roleLevel;
	}

	public boolean lowerThan(ProjectRole other) {
		return this.roleLevel < other.roleLevel;
	}

	public boolean sameOrHigherThan(ProjectRole other) {
		return this.roleLevel >= other.roleLevel;
	}

	public static Optional<ProjectRole> forName(final String name) {
		return Arrays.stream(ProjectRole.values()).filter(role -> role.name()
				.equalsIgnoreCase(name)).findAny();
	}

}
