/*
 * This file is generated by jOOQ.
*/
package com.epam.ta.reportportal.jooq.tables;

import com.epam.ta.reportportal.jooq.Indexes;
import com.epam.ta.reportportal.jooq.JPublic;
import com.epam.ta.reportportal.jooq.Keys;
import com.epam.ta.reportportal.jooq.tables.records.JWidgetFilterRecord;
import org.jooq.*;
import org.jooq.impl.DSL;
import org.jooq.impl.TableImpl;

import javax.annotation.Generated;
import java.util.Arrays;
import java.util.List;


/**
 * This class is generated by jOOQ.
 */
@Generated(value = { "http://www.jooq.org", "jOOQ version:3.10.5" }, comments = "This class is generated by jOOQ")
@SuppressWarnings({ "all", "unchecked", "rawtypes" })
public class JWidgetFilter extends TableImpl<JWidgetFilterRecord> {

	private static final long serialVersionUID = -767227907;

	/**
	 * The reference instance of <code>public.widget_filter</code>
	 */
	public static final JWidgetFilter WIDGET_FILTER = new JWidgetFilter();

	/**
	 * The class holding records for this type
	 */
	@Override
	public Class<JWidgetFilterRecord> getRecordType() {
		return JWidgetFilterRecord.class;
	}

	/**
	 * The column <code>public.widget_filter.widget_id</code>.
	 */
	public final TableField<JWidgetFilterRecord, Integer> WIDGET_ID = createField(
			"widget_id", org.jooq.impl.SQLDataType.INTEGER.nullable(false), this, "");

	/**
	 * The column <code>public.widget_filter.filter_id</code>.
	 */
	public final TableField<JWidgetFilterRecord, Long> FILTER_ID = createField(
			"filter_id", org.jooq.impl.SQLDataType.BIGINT.nullable(false), this, "");

	/**
	 * Create a <code>public.widget_filter</code> table reference
	 */
	public JWidgetFilter() {
		this(DSL.name("widget_filter"), null);
	}

	/**
	 * Create an aliased <code>public.widget_filter</code> table reference
	 */
	public JWidgetFilter(String alias) {
		this(DSL.name(alias), WIDGET_FILTER);
	}

	/**
	 * Create an aliased <code>public.widget_filter</code> table reference
	 */
	public JWidgetFilter(Name alias) {
		this(alias, WIDGET_FILTER);
	}

	private JWidgetFilter(Name alias, Table<JWidgetFilterRecord> aliased) {
		this(alias, aliased, null);
	}

	private JWidgetFilter(Name alias, Table<JWidgetFilterRecord> aliased, Field<?>[] parameters) {
		super(alias, null, aliased, parameters, "");
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
	public List<Index> getIndexes() {
		return Arrays.<Index>asList(Indexes.WIDGET_FILTER_PO);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public UniqueKey<JWidgetFilterRecord> getPrimaryKey() {
		return Keys.WIDGET_FILTER_PO;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<UniqueKey<JWidgetFilterRecord>> getKeys() {
		return Arrays.<UniqueKey<JWidgetFilterRecord>>asList(Keys.WIDGET_FILTER_PO);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<ForeignKey<JWidgetFilterRecord, ?>> getReferences() {
		return Arrays.<ForeignKey<JWidgetFilterRecord, ?>>asList(
				Keys.WIDGET_FILTER__WIDGET_FILTER_WIDGET_ID_FKEY, Keys.WIDGET_FILTER__WIDGET_FILTER_FILTER_ID_FKEY);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public JWidgetFilter as(String alias) {
		return new JWidgetFilter(DSL.name(alias), this);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public JWidgetFilter as(Name alias) {
		return new JWidgetFilter(alias, this);
	}

	/**
	 * Rename this table
	 */
	@Override
	public JWidgetFilter rename(String name) {
		return new JWidgetFilter(DSL.name(name), null);
	}

	/**
	 * Rename this table
	 */
	@Override
	public JWidgetFilter rename(Name name) {
		return new JWidgetFilter(name, null);
	}
}