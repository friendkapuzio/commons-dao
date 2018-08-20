/*
 * This file is generated by jOOQ.
 */
package com.epam.ta.reportportal.jooq.tables;

import com.epam.ta.reportportal.jooq.JPublic;
import com.epam.ta.reportportal.jooq.tables.records.JCrosstabRecord;
import org.jooq.*;
import org.jooq.impl.DSL;
import org.jooq.impl.TableImpl;

import javax.annotation.Generated;


/**
 * This class is generated by jOOQ.
 */
@Generated(
    value = {
        "http://www.jooq.org",
        "jOOQ version:3.11.4"
    },
    comments = "This class is generated by jOOQ"
)
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class JCrosstab extends TableImpl<JCrosstabRecord> {

    private static final long serialVersionUID = 1476588677;

    /**
     * The reference instance of <code>public.crosstab</code>
     */
    public static final JCrosstab CROSSTAB = new JCrosstab();

    /**
     * The class holding records for this type
     */
    @Override
    public Class<JCrosstabRecord> getRecordType() {
        return JCrosstabRecord.class;
    }

    /**
     * The column <code>public.crosstab.crosstab</code>.
     */
    public final TableField<JCrosstabRecord, Record> CROSSTAB_ = createField("crosstab", org.jooq.impl.SQLDataType.RECORD, this, "");

    /**
     * Create a <code>public.crosstab</code> table reference
     */
    public JCrosstab() {
        this(DSL.name("crosstab"), null);
    }

    /**
     * Create an aliased <code>public.crosstab</code> table reference
     */
    public JCrosstab(String alias) {
        this(DSL.name(alias), CROSSTAB);
    }

    /**
     * Create an aliased <code>public.crosstab</code> table reference
     */
    public JCrosstab(Name alias) {
        this(alias, CROSSTAB);
    }

    private JCrosstab(Name alias, Table<JCrosstabRecord> aliased) {
        this(alias, aliased, new Field[1]);
    }

    private JCrosstab(Name alias, Table<JCrosstabRecord> aliased, Field<?>[] parameters) {
        super(alias, null, aliased, parameters, DSL.comment(""));
    }

    public <O extends Record> JCrosstab(Table<O> child, ForeignKey<O, JCrosstabRecord> key) {
        super(child, key, CROSSTAB);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Schema getSchema() {
        return JPublic.PUBLIC;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public JCrosstab as(String alias) {
        return new JCrosstab(DSL.name(alias), this, parameters);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public JCrosstab as(Name alias) {
        return new JCrosstab(alias, this, parameters);
    }

    /**
     * Rename this table
     */
    @Override
    public JCrosstab rename(String name) {
        return new JCrosstab(DSL.name(name), null, parameters);
    }

    /**
     * Rename this table
     */
    @Override
    public JCrosstab rename(Name name) {
        return new JCrosstab(name, null, parameters);
    }

    /**
     * Call this table-valued function
     */
    public JCrosstab call(String __1) {
        return new JCrosstab(DSL.name(getName()), null, new Field[] { 
              DSL.val(__1, org.jooq.impl.SQLDataType.CLOB)
        });
    }

    /**
     * Call this table-valued function
     */
    public JCrosstab call(Field<String> __1) {
        return new JCrosstab(DSL.name(getName()), null, new Field[] { 
              __1
        });
    }
}