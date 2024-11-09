package org.gfg.dbs.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
@Entity
public class Student {
    @Id
    private Integer id;
    @Column(unique = true,nullable = false)
    private String name;
}
// hibernate add ur constarints when u table is getting generated
// later on , may be it is not possible to add a constraint which you are asking for
// people table was already presnt so it is not going to add the constraints which u have mentioned later on ?
