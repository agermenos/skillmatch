package com.skillmatch.pojos;

import javax.persistence.*;

/**
 * Created by agermenos on 5/15/16.
 */

@javax.persistence.Entity
@javax.persistence.Table(name = "address", schema = "skillmatch", catalog = "skillmatch")
public final class Address {
    private Integer id;
    private String street;
    private String number;
    private String poBox;
    private String lineExtra;

    @Id
    @SequenceGenerator(name = "pk_sequence", sequenceName = "skillmatch.address_id_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pk_sequence")
    @Column(name = "id", unique = true, nullable = false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @javax.persistence.Basic
    @javax.persistence.Column(name = "street", nullable = false, length = -1)
    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    @javax.persistence.Basic
    @javax.persistence.Column(name = "number", nullable = true, length = -1)
    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @javax.persistence.Basic
    @javax.persistence.Column(name = "po_box", nullable = true, length = -1)
    public String getPoBox() {
        return poBox;
    }

    public void setPoBox(String poBox) {
        this.poBox = poBox;
    }

    @javax.persistence.Basic
    @javax.persistence.Column(name = "line_extra", nullable = true, length = -1)
    public String getLineExtra() {
        return lineExtra;
    }

    public void setLineExtra(String lineExtra) {
        this.lineExtra = lineExtra;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Address that = (Address) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (street != null ? !street.equals(that.street) : that.street != null) return false;
        if (number != null ? !number.equals(that.number) : that.number != null) return false;
        if (poBox != null ? !poBox.equals(that.poBox) : that.poBox != null) return false;
        if (lineExtra != null ? !lineExtra.equals(that.lineExtra) : that.lineExtra != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (street != null ? street.hashCode() : 0);
        result = 31 * result + (number != null ? number.hashCode() : 0);
        result = 31 * result + (poBox != null ? poBox.hashCode() : 0);
        result = 31 * result + (lineExtra != null ? lineExtra.hashCode() : 0);
        return result;
    }
}
