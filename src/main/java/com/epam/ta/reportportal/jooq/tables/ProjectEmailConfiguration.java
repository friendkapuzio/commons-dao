/*
 * This file is generated by jOOQ.
*/
package com.epam.ta.reportportal.jooq.tables;

import com.epam.ta.reportportal.jooq.Indexes;
import com.epam.ta.reportportal.jooq.Keys;
import com.epam.ta.reportportal.jooq.Public;
import com.epam.ta.reportportal.jooq.tables.records.ProjectEmailConfigurationRecord;
import org.jooq.*;
import org.jooq.impl.DSL;
import org.jooq.impl.TableImpl;

import javax.annotation.Generated;
import java.util.Arrays;
import java.util.List;


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
public class ProjectEmailConfiguration extends TableImpl<ProjectEmailConfigurationRecord> {

    private static final long serialVersionUID = 163505866;

    /**
     * The reference instance of <code>public.project_email_configuration</code>
     */
    public static final ProjectEmailConfiguration PROJECT_EMAIL_CONFIGURATION = new ProjectEmailConfiguration();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<ProjectEmailConfigurationRecord> getRecordType() {
        return ProjectEmailConfigurationRecord.class;
    }

    /**
     * The column <code>public.project_email_configuration.id</code>.
     */
    public final TableField<ProjectEmailConfigurationRecord, Integer> ID = createField("id", org.jooq.impl.SQLDataType.INTEGER.nullable(false).defaultValue(org.jooq.impl.DSL.field("nextval('project_email_configuration_id_seq'::regclass)", org.jooq.impl.SQLDataType.INTEGER)), this, "");

    /**
     * The column <code>public.project_email_configuration.enabled</code>.
     */
    public final TableField<ProjectEmailConfigurationRecord, Boolean> ENABLED = createField("enabled", org.jooq.impl.SQLDataType.BOOLEAN.nullable(false).defaultValue(org.jooq.impl.DSL.field("false", org.jooq.impl.SQLDataType.BOOLEAN)), this, "");

    /**
     * The column <code>public.project_email_configuration.recipients</code>.
     */
    public final TableField<ProjectEmailConfigurationRecord, String[]> RECIPIENTS = createField("recipients", org.jooq.impl.SQLDataType.VARCHAR.getArrayDataType(), this, "");

    /**
     * Create a <code>public.project_email_configuration</code> table reference
     */
    public ProjectEmailConfiguration() {
        this(DSL.name("project_email_configuration"), null);
    }

    /**
     * Create an aliased <code>public.project_email_configuration</code> table reference
     */
    public ProjectEmailConfiguration(String alias) {
        this(DSL.name(alias), PROJECT_EMAIL_CONFIGURATION);
    }

    /**
     * Create an aliased <code>public.project_email_configuration</code> table reference
     */
    public ProjectEmailConfiguration(Name alias) {
        this(alias, PROJECT_EMAIL_CONFIGURATION);
    }

    private ProjectEmailConfiguration(Name alias, Table<ProjectEmailConfigurationRecord> aliased) {
        this(alias, aliased, null);
    }

    private ProjectEmailConfiguration(Name alias, Table<ProjectEmailConfigurationRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, "");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Schema getSchema() {
        return Public.PUBLIC;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Index> getIndexes() {
        return Arrays.<Index>asList(Indexes.PROJECT_EMAIL_CONFIGURATION_PK);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Identity<ProjectEmailConfigurationRecord, Integer> getIdentity() {
        return Keys.IDENTITY_PROJECT_EMAIL_CONFIGURATION;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<ProjectEmailConfigurationRecord> getPrimaryKey() {
        return Keys.PROJECT_EMAIL_CONFIGURATION_PK;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<ProjectEmailConfigurationRecord>> getKeys() {
        return Arrays.<UniqueKey<ProjectEmailConfigurationRecord>>asList(Keys.PROJECT_EMAIL_CONFIGURATION_PK);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ProjectEmailConfiguration as(String alias) {
        return new ProjectEmailConfiguration(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ProjectEmailConfiguration as(Name alias) {
        return new ProjectEmailConfiguration(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public ProjectEmailConfiguration rename(String name) {
        return new ProjectEmailConfiguration(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public ProjectEmailConfiguration rename(Name name) {
        return new ProjectEmailConfiguration(name, null);
    }
}