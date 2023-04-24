package kubala.jakub.ClimbingShoesSizeGuideweb.web.controller;

import kubala.jakub.ClimbingShoesSizeGuideweb.biz.model.Shoe;
import kubala.jakub.ClimbingShoesSizeGuideweb.data.ShoeRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

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

    @GetMapping         //@GetMapping relates to HTTP operations: GET, POST, PUT, DELETE. if the request comes with /shoes resource, and that request is GET request, let this method handle that request
    public String showShoesPage() {  //go to shoes.html template and use whatever data was used in the model to fill in data used in a template
        return "shoes";     //it should respond by showing the view called "shoes", which relates to the template shoes.html
    }
}
