package com.vega.sprinit.domain;
//a class to a table model, represent a table in a database

import com.sun.istack.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity   //specifies that this class is a entity
//replace boilerplate code
@NoArgsConstructor  //public constructor gets rid
@Data //get rids of getters and setters, all togehter shortcut for getters,setters,tostring.equlas,hashcode
public class Link extends Auditable{

    @Id  //specifies the primary key of the entity
    @GeneratedValue  //provides the specification of generation stragerty of primary keys
    private Long id;
    @NotNull
    private String title;
    @NotNull
    private String url;

    //need a way to access comment for a link

    //when working with assocation always want to delacre the interface and not the implementation as the type
    @OneToMany(mappedBy = "link") //one link to many comment, since we want to be able give me the link that comment belongs to theres need to be a owner of the realtionship and use mappedby
    private List<Comment> comments = new ArrayList<>();


}
