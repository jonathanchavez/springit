package com.vega.sprinit.repository;

import com.vega.sprinit.domain.Link;
import org.springframework.data.jpa.repository.JpaRepository;


public interface LinkRepository extends JpaRepository<Link,Long> //object and type of object
 {

}
