package com.vega.sprinit.domain;

import lombok.*;

import javax.persistence.*;
import java.util.Objects;

@Entity
@RequiredArgsConstructor
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Comment extends Auditable {

    @Id  //specifies the primary key of the entity
    @GeneratedValue  //provides the specification of generation stragerty of primary keys
    private Long id;
    @NonNull
    private String body;

    //link placeholder
    @ManyToOne //many comments to one link,
    @NonNull
    private Link link;  //created the properties that allow us to do the association,


}
