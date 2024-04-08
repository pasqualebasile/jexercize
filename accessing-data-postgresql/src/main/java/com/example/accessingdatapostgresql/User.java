package com.example.accessingdatapostgresql;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
import java.util.Set;

@Data
@Entity // This tells Hibernate to make a table out of this class
public class User {
    @Id
    @SequenceGenerator(name="user_id_seq", sequenceName = "user_id_seq", allocationSize = 1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "user_id_seq")
    // NOTE: La prima volta da eseguire con `create` e non con `update`. Dopo non serve più, altrimenti
    //       sembra non crei la sequence.
    // TODO: Verificare se il comportamento è quello previsto e non sia un bug.
    @Column(name="id", updatable = false, columnDefinition = "int8 default nextval('user_id_seq') ")
    private Long id;

    @Column(columnDefinition = "varchar(255) default 'default' ")
    private String name;

    private String email;

    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<Post> posts;

}