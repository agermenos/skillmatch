package com.skillmatch.pojos;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by agermenos on 5/15/16.
 */
@javax.persistence.Entity
@javax.persistence.Table(name = "user", schema = "skillmatch", catalog = "skillmatch")
public class User {
    private Integer id;

    @Id
    @SequenceGenerator(name = "pk_sequence", sequenceName = "skillmatch.user_id_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pk_sequence")
    @Column(name = "id", unique = true, nullable = false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    private String name;

    @javax.persistence.Basic
    @javax.persistence.Column(name = "name", nullable = false, length = -1)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String lastName;

    @javax.persistence.Basic
    @javax.persistence.Column(name = "last_name", nullable = true, length = -1)
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    private Integer addressId;

    @javax.persistence.Basic
    @javax.persistence.Column(name = "address_id", nullable = false)
    public Integer getAddressId() {
        return addressId;
    }

    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
    }

    private Integer imageId;

    @javax.persistence.Basic
    @javax.persistence.Column(name = "image_id", nullable = true)
    public Integer getImageId() {
        return imageId;
    }

    public void setImageId(Integer imageId) {
        this.imageId = imageId;
    }

    private Set<UserSkill> userSkills;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "user")
    public Set<UserSkill> getUserSkills() {
        return userSkills;
    }

    public void setUserSkills(Set<UserSkill> userSkills) {
        this.userSkills = userSkills;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User User = (User) o;

        if (id != null ? !id.equals(User.id) : User.id != null) return false;
        if (name != null ? !name.equals(User.name) : User.name != null) return false;
        if (lastName != null ? !lastName.equals(User.lastName) : User.lastName != null) return false;
        if (addressId != null ? !addressId.equals(User.addressId) : User.addressId != null) return false;
        if (imageId != null ? !imageId.equals(User.imageId) : User.imageId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (addressId != null ? addressId.hashCode() : 0);
        result = 31 * result + (imageId != null ? imageId.hashCode() : 0);
        return result;
    }
}
