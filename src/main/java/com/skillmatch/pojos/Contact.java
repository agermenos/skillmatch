package com.skillmatch.pojos;

import javax.persistence.*;

/**
 * Created by agermenos on 5/15/16.
 */
@javax.persistence.Entity
@javax.persistence.Table(name = "contact", schema = "skillmatch", catalog = "skillmatch")
public class Contact {
    private Integer id;

    @Id
    @SequenceGenerator(name = "pk_sequence", sequenceName = "skillmatch.contact_id_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pk_sequence")
    @Column(name = "id", unique = true, nullable = false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    private Integer userId;

    @javax.persistence.Basic
    @javax.persistence.Column(name = "user_id", nullable = false)
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    private Integer contactTypeId;

    @javax.persistence.Basic
    @javax.persistence.Column(name = "contact_type_id", nullable = false)
    public Integer getContactTypeId() {
        return contactTypeId;
    }

    public void setContactTypeId(Integer contactTypeId) {
        this.contactTypeId = contactTypeId;
    }    private String contactTypeValue;

    @javax.persistence.Basic
    @javax.persistence.Column(name = "contact_type_value", nullable = true, length = -1)
    public String getContactTypeValue() {
        return contactTypeValue;
    }

    public void setContactTypeValue(String contactTypeValue) {
        this.contactTypeValue = contactTypeValue;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Contact that = (Contact) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (userId != null ? !userId.equals(that.userId) : that.userId != null) return false;
        if (contactTypeId != null ? !contactTypeId.equals(that.contactTypeId) : that.contactTypeId != null)
            return false;
        if (contactTypeValue != null ? !contactTypeValue.equals(that.contactTypeValue) : that.contactTypeValue != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (userId != null ? userId.hashCode() : 0);
        result = 31 * result + (contactTypeId != null ? contactTypeId.hashCode() : 0);
        result = 31 * result + (contactTypeValue != null ? contactTypeValue.hashCode() : 0);
        return result;
    }
}
