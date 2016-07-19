package com.skillmatch.pojos;

import javax.persistence.*;

/**
 * Created by agermenos on 5/15/16.
 */

@javax.persistence.Entity
@javax.persistence.Table(name = "catalog", schema = "skillmatch", catalog = "skillmatch")
public class Catalog {
    private Integer id;
    private String text;
    private Integer parentId;

    public static final String GENERAL_SKILL_LEVELS = "Skill Levels Catalog";
    public static final String SKILL_STATUS = "Skill Status Catalog";
    public enum SKILL_LEVEL_GRAL {basic, intermediate, advanced};

    @Id
    @SequenceGenerator(name = "pk_sequence", sequenceName = "skillmatch.catalog_id_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pk_sequence")
    @Column(name = "id", unique = true, nullable = false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @javax.persistence.Basic
    @javax.persistence.Column(name = "text", nullable = true, length = -1)
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
    @javax.persistence.Basic
    @javax.persistence.Column(name = "parent_id", nullable = true, length = -1)
    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Catalog catalog = (Catalog) o;

        if (id != null ? !id.equals(catalog.id) : catalog.id != null) return false;
        if (text != null ? !text.equals(catalog.text) : catalog.text != null) return false;
        return parentId != null ? parentId.equals(catalog.parentId) : catalog.parentId == null;

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (text != null ? text.hashCode() : 0);
        result = 31 * result + (parentId != null ? parentId.hashCode() : 0);
        return result;
    }

    public Catalog(){

    }

    public Catalog(String text) {
        this.text = text;
    }
}
