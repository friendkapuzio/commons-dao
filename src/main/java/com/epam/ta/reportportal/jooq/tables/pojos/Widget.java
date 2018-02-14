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
public class Widget implements Serializable {

    private static final long serialVersionUID = -303814611;

    private Integer id;
    private String  name;
    private Integer projectId;

    public Widget() {}

    public Widget(Widget value) {
        this.id = value.id;
        this.name = value.name;
        this.projectId = value.projectId;
    }

    public Widget(
        Integer id,
        String  name,
        Integer projectId
    ) {
        this.id = id;
        this.name = name;
        this.projectId = projectId;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getProjectId() {
        return this.projectId;
    }

    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Widget (");

        sb.append(id);
        sb.append(", ").append(name);
        sb.append(", ").append(projectId);

        sb.append(")");
        return sb.toString();
    }
}