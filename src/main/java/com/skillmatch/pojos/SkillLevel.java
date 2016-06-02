package com.skillmatch.pojos;

import javax.persistence.*;

/**
 * Created by agermenos on 6/2/16.
 */
@Entity
@Table(name = "skill_level", schema = "skillmatch", catalog = "skillmatch")
public class SkillLevel {
    private Integer id;
    private Skill skill;
    private Catalog level;

    @Id
    @Column(name = "id", nullable = false)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @ManyToOne
    @JoinColumn(name="level_id")
    public Catalog getLevel() {return level;}
    public void setLevel (Catalog level) {this.level = level;}

    @ManyToOne
    @JoinColumn(name="skill_id")
    public Skill getSkill() {return skill;}
    public void setSkill (Skill skill) {this.skill = skill;}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SkillLevel that = (SkillLevel) o;

        if (!id.equals(that.id)) return false;
        if (!skill.equals(that.skill)) return false;
        return level.equals(that.level);

    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + skill.hashCode();
        result = 31 * result + level.hashCode();
        return result;
    }
}
