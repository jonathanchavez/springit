package com.vega.sprinit.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Objects;

@Entity
@Data
@NoArgsConstructor
public class Comment {

    @Id  //specifies the primary key of the entity
    @GeneratedValue  //provides the specification of generation stragerty of primary keys
    private Long id;
    private String body;

    //link placeholder


}
