package com.vega.sprinit.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Data
@NoArgsConstructor
public class Vote  {

    @Id  //specifies the primary key of the entity
    @GeneratedValue  //provides the specification of generation stragerty of primary keys
    private Long id;
    private int vote;

    //user
    //link

}
