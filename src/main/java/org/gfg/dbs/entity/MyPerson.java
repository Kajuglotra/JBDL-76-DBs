package org.gfg.dbs.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

@Entity // this class is common for db and application
@Table(name = "people")
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Getter
@Setter
public class MyPerson {

//    @Id
//    @GeneratedValue(strategy = GenerationType.SEQUENCE)
//    @Id
//    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence-generator")
//    @GenericGenerator(
//            name = "sequence-generator",
//            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
//            parameters = {
//                    @org.hibernate.annotations.Parameter(name = "sequence_name", value = "user_sequence"),
//                    @org.hibernate.annotations.Parameter(name = "initial_value", value = "4"),
//                    @org.hibernate.annotations.Parameter(name = "increment_size", value = "1"),
//                    @org.hibernate.annotations.Parameter(name = "allocation_size", value = "1")
//            }
//    )
//@Id
//@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_seq_gen")
//@SequenceGenerator( name = "user_seq_gen",
//        sequenceName = "user_sequence",
//        initialValue = 4,
//        allocationSize = 1,
//        )

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "table-generator")
    @TableGenerator(
            name = "table-generator",
            initialValue = 1,
            allocationSize = 1
    )
private Integer id;

    @Column(name = "personName", length = 25, nullable = false, unique = true)
    private String name;

    @Transient
    private int age;

    private String  dob;

    public MyPerson(String name){
        this.name=name;
    }

}
// can i get the id from fe?
// gmail : user gmail by itself -> actually act as unique identifier?

// txnid , order id , id
// custom logic: in order to generate the id

