/*
 * This file is generated by jOOQ.
*/
package com.epam.ta.reportportal.jooq.tables.pojos;

import javax.annotation.Generated;
import java.io.Serializable;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.10.4"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class IssueTypeProjectConfiguration implements Serializable {

    private static final long serialVersionUID = -460071284;

    private Integer configurationId;
    private Integer issueTypeId;

    public IssueTypeProjectConfiguration() {}

    public IssueTypeProjectConfiguration(IssueTypeProjectConfiguration value) {
        this.configurationId = value.configurationId;
        this.issueTypeId = value.issueTypeId;
    }

    public IssueTypeProjectConfiguration(
        Integer configurationId,
        Integer issueTypeId
    ) {
        this.configurationId = configurationId;
        this.issueTypeId = issueTypeId;
    }

    public Integer getConfigurationId() {
        return this.configurationId;
    }

    public void setConfigurationId(Integer configurationId) {
        this.configurationId = configurationId;
    }

    public Integer getIssueTypeId() {
        return this.issueTypeId;
    }

    public void setIssueTypeId(Integer issueTypeId) {
        this.issueTypeId = issueTypeId;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("IssueTypeProjectConfiguration (");

        sb.append(configurationId);
        sb.append(", ").append(issueTypeId);

        sb.append(")");
        return sb.toString();
    }
}