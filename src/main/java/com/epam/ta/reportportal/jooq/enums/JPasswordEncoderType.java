/*
 * This file is generated by jOOQ.
 */
package com.epam.ta.reportportal.jooq.enums;

import com.epam.ta.reportportal.jooq.JPublic;
import org.jooq.Catalog;
import org.jooq.EnumType;
import org.jooq.Schema;

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
public enum JPasswordEncoderType implements EnumType {

    PLAIN("PLAIN"),

    SHA("SHA"),

    LDAP_SHA("LDAP_SHA"),

    MD4("MD4"),

    MD5("MD5");

    private final String literal;

    private JPasswordEncoderType(String literal) {
        this.literal = literal;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Catalog getCatalog() {
        return getSchema() == null ? null : getSchema().getCatalog();
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
    public String getName() {
        return "password_encoder_type";
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getLiteral() {
        return literal;
    }
}
