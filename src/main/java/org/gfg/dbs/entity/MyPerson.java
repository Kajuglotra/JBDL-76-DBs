package org.gfg.dbs.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity // this class is common for db and application
@Table(name = "people")
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Getter
@Setter
public class MyPerson {

    @Id
    private Integer id;

    @Column(name = "personName", length = 25, nullable = false)
    private String name;

    @Transient
    private int age;

    private String  dob;

    public MyPerson(Integer id, String name){
        this.name=name;
        this.id = id;
    }

}
