package kubala.jakub.ClimbingShoesSizeGuideweb.web.controller;

import kubala.jakub.ClimbingShoesSizeGuideweb.biz.model.Shoe;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/shoes")
public class ShoeController {

    @GetMapping
    public String getShoes(Model model) {

        List<Shoe> shoes = List.of(
                new Shoe("Scarpa Instinct VSR", "Drop 1.5 EU Sizes", "Drop 1 EU Size", "Drop 0.5 EU Size", "NA", "Medium/High", "Centre"),
                new Shoe("Tenaya Oasi", "Drop 2.5 UK Size", "Drop 2 UK Size", "NA", "NA", "Medium", "Centre"),
                new Shoe("La Sportiva Theory", "Drop 2.5 EU Sizes ", "Drop 2 EU Size", "Drop 1.5 EU Size", "NA", "Medium", "Classic"),
                new Shoe("Evolv Shaman (2021)", "Drop 0.5 UK Size", "Buy Shoe Size", "Buy 0.5 UK Size Larger", "NA", "Medium", "Classic")
        );
        model.addAttribute("shoes", shoes);
        return "shoes";
    }
}
