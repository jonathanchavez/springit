package com.vega.sprinit.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
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
    @ManyToOne //many comments to one link,
    private Link link;  //created the properties that allow us to do the association,

}
