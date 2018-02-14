/*
 * This file is generated by jOOQ.
*/
package com.epam.ta.reportportal.jooq.tables;

import com.epam.ta.reportportal.jooq.Indexes;
import com.epam.ta.reportportal.jooq.Keys;
import com.epam.ta.reportportal.jooq.Public;
import com.epam.ta.reportportal.jooq.tables.records.LogRecord;
import org.jooq.*;
import org.jooq.impl.DSL;
import org.jooq.impl.TableImpl;

import javax.annotation.Generated;
import java.sql.Timestamp;
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
public class Log extends TableImpl<LogRecord> {

    private static final long serialVersionUID = -12157672;

    /**
     * The reference instance of <code>public.log</code>
     */
    public static final Log LOG = new Log();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<LogRecord> getRecordType() {
        return LogRecord.class;
    }

    /**
     * The column <code>public.log.id</code>.
     */
    public final TableField<LogRecord, Long> ID = createField("id", org.jooq.impl.SQLDataType.BIGINT.nullable(false).defaultValue(org.jooq.impl.DSL.field("nextval('log_id_seq'::regclass)", org.jooq.impl.SQLDataType.BIGINT)), this, "");

    /**
     * The column <code>public.log.log_time</code>.
     */
    public final TableField<LogRecord, Timestamp> LOG_TIME = createField("log_time", org.jooq.impl.SQLDataType.TIMESTAMP.nullable(false), this, "");

    /**
     * The column <code>public.log.log_message</code>.
     */
    public final TableField<LogRecord, String> LOG_MESSAGE = createField("log_message", org.jooq.impl.SQLDataType.CLOB.nullable(false), this, "");

    /**
     * The column <code>public.log.item_id</code>.
     */
    public final TableField<LogRecord, Long> ITEM_ID = createField("item_id", org.jooq.impl.SQLDataType.BIGINT.nullable(false), this, "");

    /**
     * The column <code>public.log.last_modified</code>.
     */
    public final TableField<LogRecord, Timestamp> LAST_MODIFIED = createField("last_modified", org.jooq.impl.SQLDataType.TIMESTAMP.nullable(false), this, "");

    /**
     * The column <code>public.log.log_level</code>.
     */
    public final TableField<LogRecord, Integer> LOG_LEVEL = createField("log_level", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

    /**
     * Create a <code>public.log</code> table reference
     */
    public Log() {
        this(DSL.name("log"), null);
    }

    /**
     * Create an aliased <code>public.log</code> table reference
     */
    public Log(String alias) {
        this(DSL.name(alias), LOG);
    }

    /**
     * Create an aliased <code>public.log</code> table reference
     */
    public Log(Name alias) {
        this(alias, LOG);
    }

    private Log(Name alias, Table<LogRecord> aliased) {
        this(alias, aliased, null);
    }

    private Log(Name alias, Table<LogRecord> aliased, Field<?>[] parameters) {
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
        return Arrays.<Index>asList(Indexes.LOG_PK);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Identity<LogRecord, Long> getIdentity() {
        return Keys.IDENTITY_LOG;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public UniqueKey<LogRecord> getPrimaryKey() {
        return Keys.LOG_PK;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<UniqueKey<LogRecord>> getKeys() {
        return Arrays.<UniqueKey<LogRecord>>asList(Keys.LOG_PK);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<ForeignKey<LogRecord, ?>> getReferences() {
        return Arrays.<ForeignKey<LogRecord, ?>>asList(Keys.LOG__LOG_ITEM_ID_FKEY);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Log as(String alias) {
        return new Log(DSL.name(alias), this);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Log as(Name alias) {
        return new Log(alias, this);
    }

    /**
     * Rename this table
     */
    @Override
    public Log rename(String name) {
        return new Log(DSL.name(name), null);
    }

    /**
     * Rename this table
     */
    @Override
    public Log rename(Name name) {
        return new Log(name, null);
    }
}