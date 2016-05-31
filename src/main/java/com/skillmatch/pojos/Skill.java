package com.skillmatch.pojos;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;

/**
 * Created by agermenos on 5/30/16.
 */
@Entity
@javax.persistence.Table(name = "skill", schema = "skillmatch", catalog = "skillmatch")
public class Skill {
    @Id
    @SequenceGenerator(name = "pk_sequence", sequenceName = "skillmatch.skill_id_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pk_sequence")
    @Column(name = "id", unique = true, nullable = false)
    private Integer id;
    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="skill_desc")
    private Catalog description;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="skill_type")
    private Catalog skillType;
}
