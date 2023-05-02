package kubala.jakub.ClimbingShoesSizeGuideweb.web.controller;

import jakarta.validation.Valid;
import kubala.jakub.ClimbingShoesSizeGuideweb.biz.model.Shoe;
import kubala.jakub.ClimbingShoesSizeGuideweb.data.ShoeRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller                     //marking as a Controller (similar to @Component and @Repository), telling Spring this is a class I want you to register and manage. @Controller has to do with Web stuff
@RequestMapping("/shoes")       //any request that comes from the web with resource /shoes should be mapped to this class
public class ShoeController {

    private ShoeRepository shoeRepository;

    //constructor tells spring to inject any instance of type ShoeRepository that it knows about into this Class automatically
    public ShoeController(ShoeRepository shoeRepository) {
        this.shoeRepository = shoeRepository;
    }

    @ModelAttribute("shoes")                    //model attribute that was previously in showShoesPage method with hardcoded List<Shoe> shoes // model.addAttribute("shoes", shoes);
    public Iterable<Shoe> getShoes() {
        return shoeRepository.findAll();        //find all the records in the shoes table. whatever comes out of here is stored in the model with key "shoes"
    }

    @ModelAttribute                     //don't need to name this model, Spring will take the return data type of Shoe and use that name as the name for the model
    public Shoe getShoe() {             //using NoArgDefaultConstructor, blank Shoe to use as a model for user input
        return new Shoe();
    }

    @GetMapping         //@GetMapping relates to HTTP operations: GET, POST, PUT, DELETE. if the request comes with /shoes resource, and that request is GET request, let this method handle that request
    public String showShoesPage() {  //go to shoes.html template and use whatever data was used in the model to fill in data used in a template
        return "shoes";     //it should respond by showing the view called "shoes", which relates to the template shoes.html
    }

    @PostMapping        //handles any request trying to submit data into the backend (POST)
    public String saveShoe(@Valid Shoe shoe, Errors errors) {     //passing shoe object from our form and getShoe() method //@Valid says Spring to validate any data coming from the browser using constraints in Shoe Class // errors instance gives errors with validation
        if (!errors.hasErrors()) {
            shoeRepository.save(shoe);          //saving new shoe in a db
            return "redirect:shoes";             //redirect: shows refreshed version of shoes after adding new instance to the db
        }
        return "shoes";
    }


    @PostMapping(params = "delete=true")    //adding params delete=true to @PostMapping for Spring to handle any request containing this parameters
    public String deleteShoes(@RequestParam Optional<List<Long>> selections) {      //@RequestParam mapping selected shoes from the table based on their id (connected to select button) //Optional gives ability for selections to be empty
        System.out.println(selections);
        if (selections.isPresent()) {
            shoeRepository.deleteAllById(selections.get());
        }
        return "redirect:shoes";
    }

    @PostMapping(params = "edit=true")    //adding params edit=true to @PostMapping for Spring to handle any request containing this parameters
    public String editShoe(@RequestParam Optional<List<Long>> selections, Model model) {      //@RequestParam mapping selected shoes from the table based on their id (connected to select button) //Optional gives ability for selections to be empty // add model, so Spring will pass the model
        System.out.println(selections);
        if (selections.isPresent()) {
            Optional<Shoe> shoe = shoeRepository.findById(selections.get().get(0));//if somebody checks more than 1 checkbox to edit, I want to retrieve just the first element and assign it to the shoe object
            model.addAttribute("shoe", shoe);       //retrieved data is passed back to the creation form and after submitting it updates the record
        }
        return "shoes";  //no redirect as I want to get back to the page with the model intact, and with redirect it will get lost
    }
}
