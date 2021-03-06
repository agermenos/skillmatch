package com.skillmatch.pojos;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by agermenos on 6/2/16.
 */
@Entity
@Table(name = "user_skill", schema = "skillmatch", catalog = "skillmatch")
public class UserSkill {
    private Integer id;
    private Date dateAdded;
    private SkillLevel skillLevel;
    private Catalog status;
    private Integer userId;

    @Id
    @SequenceGenerator(name = "pk_sequence", sequenceName = "skillmatch.user_skill_id_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pk_sequence")
    @Column(name = "id", unique = true, nullable = false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "date_added", nullable = true)
    public Date getDateAdded() {
        return dateAdded;
    }

    public void setDateAdded(Date dateAdded) {
        this.dateAdded = dateAdded;
    }

    @ManyToOne
    @JoinColumn(name="skill_level_id")
    public SkillLevel getSkillLevel() {return skillLevel;}
    public void setSkillLevel (SkillLevel skillLevel) {this.skillLevel = skillLevel;}

    @ManyToOne
    @JoinColumn(name="status_id")
    public Catalog getStatus() {return status;}
    public void setStatus (Catalog status) {this.status = status;}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserSkill userSkill = (UserSkill) o;

        if (!id.equals(userSkill.id)) return false;
        if (!dateAdded.equals(userSkill.dateAdded)) return false;
        if (!skillLevel.equals(userSkill.skillLevel)) return false;
        return status.equals(userSkill.status);

    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + dateAdded.hashCode();
        result = 31 * result + skillLevel.hashCode();
        result = 31 * result + status.hashCode();
        return result;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
    @Basic
    @Column(name = "user_id", nullable = true)
    public Integer getUserId() {
        return this.userId;
    }
}
