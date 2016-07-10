package com.skillmatch.pojos;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by agermenos on 6/2/16.
 */
@Entity
@Table(name = "skill", schema = "skillmatch", catalog = "skillmatch")
public class Skill {
    private Integer id;
    private Catalog description;
    private Date dateAdded;
    private Catalog status;
    private Catalog type;

    @Id
    @SequenceGenerator(name = "pk_sequence", sequenceName = "skillmatch.skill_id_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pk_sequence")
    @Column(name = "id", unique = true, nullable = false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @ManyToOne
    @JoinColumn(name="skill_desc")
    public Catalog getDescription() {return description;}
    public void setDescription (Catalog description) {this.description = description;}

    @Basic
    @Column(name = "date_added", nullable = true)
    public Date getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(Date dateAdded) {
        this.dateAdded = dateAdded;
    }

    @ManyToOne
    @JoinColumn(name="status_id")
    public Catalog getStatus() {return status;}
    public void setStatus (Catalog status) {this.status = status;}

    @ManyToOne
    @JoinColumn(name="skill_type")
    public Catalog getType() {return type;}
    public void setType (Catalog type) {this.type = type;}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Skill skill = (Skill) o;

        if (!id.equals(skill.id)) return false;
        if (!description.equals(skill.description)) return false;
        if (!dateAdded.equals(skill.dateAdded)) return false;
        if (!status.equals(skill.status)) return false;
        return type.equals(skill.type);

    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + description.hashCode();
        result = 31 * result + dateAdded.hashCode();
        result = 31 * result + status.hashCode();
        result = 31 * result + type.hashCode();
        return result;
    }
}
