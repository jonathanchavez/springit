package com.vega.sprinit.controller;

import com.vega.sprinit.domain.Link;
import com.vega.sprinit.repository.LinkRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

//@RestController
//@RequestMapping("/links")//any methond underneath this controller follows this type of path
@Controller
public class LinkController {


    private LinkRepository linkRepository;

    //    gets linkReposity into the linkController, finds the bean type of repository and autowired it in
//    dependicy injection framework we have the link reposity aviable to us inside of the controller
    public LinkController(LinkRepository linkRepository) {
        this.linkRepository = linkRepository;
    }

    @GetMapping("/")
    public String foo(Model model) {
        model.addAttribute("links", linkRepository.findAll());
        return "link/list";
    }

    @GetMapping("/link/{id}")
    public String read(@PathVariable Long id, Model model) {
        Optional<Link> link = linkRepository.findById(id);
        if (link.isPresent()) {
            model.addAttribute("link", link.get()); //get the link out of the obstraacle
           model.addAttribute("success", model.containsAttribute("success"));
            return "link/view";
        } else {
            return "redirect:/"; //returning a redirect
        }

    }

    private static final Logger logger = LoggerFactory.getLogger(LinkController.class);


    @GetMapping("/link/submit")
    public String newLinkForm(Model model) {
        model.addAttribute("link", new Link());
        return "link/submit";
    }

    @PostMapping("/link/submit") //@valid tell it to validate the link, gets a binding result to see if there was erroes on ti
    public String createLink(@Valid Link link, BindingResult bindingResult, Model model, RedirectAttributes redirectAttributes) {
        if( bindingResult.hasErrors() ) {
            logger.info("Validation errors were found while submitting a new link.");
            model.addAttribute("link",link); //link that was pass to us
            return "link/submit"; //return to the link page but with the object still intact
        } else {
            // save our link
            linkRepository.save(link);
            logger.info("New Link was saved successfully.");
            redirectAttributes
                    .addAttribute("id", link.getId())
                    .addFlashAttribute("success",true); //flashattribute only live on the next template that you vist, deletes after great way of displayin success message
            return "redirect:/link/{id}";
        }
    }

}

//
//    // list
//    @GetMapping("/")
//    public List<Link> list() {
//        return linkRepository.findAll(); //ask link repository to find all
//    }

//    // CRUD
//    @PostMapping("/create")
//    public Link create(@ModelAttribute Link link) { //modelattrubttue takes data binds binds object that are coming in to a particalur model
//
//        return linkRepository.save(link); //save the link
//    }
//    @GetMapping("/{id}")//variable in the path with {} Path Variable
//    public Optional<Link> read(@PathVariable long id) {
//
//        //findbyId returns Optional, needs optional
//        return linkRepository.findById(id);
//    }
//    @PutMapping("/{id}")
//    public Link update(@PathVariable long id, @ModelAttribute Link link) {
//         //get the id
//        return linkRepository.save(link);
//    }
//    @DeleteMapping("/{id}")
//    public void delete(@PathVariable Long id) {
//        linkRepository.deleteById(id);
//
//    }
