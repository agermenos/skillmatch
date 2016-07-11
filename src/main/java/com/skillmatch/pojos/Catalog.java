package com.skillmatch.pojos;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by agermenos on 5/15/16.
 */
@javax.persistence.Entity
@javax.persistence.Table(name = "catalog", schema = "skillmatch", catalog = "skillmatch")
public class Catalog {
    private Integer id;
    private String text;
    private Catalog parent;

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

    @ManyToOne
    @JoinColumn(name="parent_id")
    public Catalog getParent() {return parent;}
    public void setParent (Catalog parent) {this.parent = parent;}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Catalog catalog = (Catalog) o;

        if (!id.equals(catalog.id)) return false;
        if (!text.equals(catalog.text)) return false;
        return parent != null ? parent.equals(catalog.parent) : catalog.parent == null;

    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + text.hashCode();
        result = 31 * result + (parent != null ? parent.hashCode() : 0);
        return result;
    }

    public Catalog(){

    }

    public Catalog(String text) {
        this.text = text;
    }
}
