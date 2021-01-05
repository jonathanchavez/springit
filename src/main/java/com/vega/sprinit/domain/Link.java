package com.vega.sprinit.domain;
//a class to a table model, represent a table in a database

import com.sun.istack.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Objects;

@Entity   //specifies that this class is a entity
//replace boilerplate code
@NoArgsConstructor  //public constructor gets rid
@Data //get rids of getters and setters, all togehter shortcut for getters,setters,tostring.equlas,hashcode
public class Link {

    @Id  //specifies the primary key of the entity
    @GeneratedValue  //provides the specification of generation stragerty of primary keys
    private Long id;
    @NotNull
    private String title;
    @NotNull
    private String url;


}
