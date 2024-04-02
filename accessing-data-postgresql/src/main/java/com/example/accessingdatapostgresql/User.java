package com.example.accessingdatapostgresql;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity // This tells Hibernate to make a table out of this class
public class User {
    @Id
    @SequenceGenerator(name="user_id_seq", sequenceName = "user_id_seq", allocationSize = 1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "user_id_seq")
    // @Column(name="id", updatable = false, columnDefinition = "int8 default \"nextval('user_id_seq')\" ")
    private Integer id;

    @Column(columnDefinition = "varchar(255) default 'default' ")
    private String name;

    private String email;

}