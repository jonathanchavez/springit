package com.vega.sprinit.controller;

import com.vega.sprinit.domain.Link;
import com.vega.sprinit.repository.LinkRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/links")//any methond underneath this controller follows this type of path
public class LinkController {



    private LinkRepository linkRepository;

    //gets linkReposity into the linkController, finds the bean type of repository and autowired it in
//    dependicy injection framework we have the link reposity aviable to us inside of the controller
    public LinkController(LinkRepository linkRepository) {
        this.linkRepository = linkRepository;
    }

    // list
    @GetMapping("/")
    public List<Link> list() {
        return linkRepository.findAll(); //ask link repository to find all
    }

    // CRUD
    @PostMapping("/create")
    public Link create(@ModelAttribute Link link) { //modelattrubttue takes data binds binds object that are coming in to a particalur model

        return linkRepository.save(link); //save the link
    }
    @GetMapping("/{id}")//variable in the path with {} Path Variable
    public Optional<Link> read(@PathVariable long id) {

        //findbyId returns Optional, needs optional
        return linkRepository.findById(id);
    }
    @PutMapping("/{id}")
    public Link update(@PathVariable long id, @ModelAttribute Link link) {
         //get the id
        return linkRepository.save(link);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        linkRepository.deleteById(id);

    }
}