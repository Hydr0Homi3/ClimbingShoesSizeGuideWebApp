package kubala.jakub.ClimbingShoesSizeGuideweb.data;

import kubala.jakub.ClimbingShoesSizeGuideweb.biz.model.Shoe;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.List;

//class to load shoe data to the database
//implements ApplicationRunner interface from spring data framework - called whenever application starts up

@Component
public class ShoeDataLoader implements ApplicationRunner {

    private ShoeRepository shoeRepository;

    //constructor telling spring that I want it to give me an instance of the ShoeRepository after it made one
    public ShoeDataLoader(ShoeRepository shoeRepository) {
        this.shoeRepository = shoeRepository;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        //if there are already records in the shoe table, then don't do any of it since I don't need it
        if (shoeRepository.count() == 0) {
            List<Shoe> shoes = List.of(     //id can be null as it was modeled as wrapper class Long rather than primitive long. Primitives cannot be null. Null allows me to indicate the IDs need to be generated
                    new Shoe(null,"Scarpa Instinct VSR/VS", "Drop 1.5 EU Sizes", "Drop 1 EU Size", "Drop 0.5 EU Size", "NA", "Medium/High", "Centre"),
                    new Shoe(null,"Tenaya Oasi", "Drop 2.5 UK Size", "Drop 2 UK Size", "NA", "NA", "Medium", "Centre"),
                    new Shoe(null,"La Sportiva Theory", "Drop 2.5 EU Sizes", "Drop 2 EU Size", "Drop 1.5 EU Size", "NA", "Medium", "Classic"),
                    new Shoe(null,"La Sportiva Miura", "Drop 3 EU Sizes", "Drop 2.5 EU Size", "Drop 1.5 EU Size", "Drop 0.5 EU Size", "Medium", "Classic"),
                    new Shoe(null,"Five Ten Hiangle Pro ", "Buy Shoe Size", "Buy 1 UK Size Larger", "Buy 1.5 UK Size Larger", "NA", "Medium", "Centre"),
                    new Shoe(null,"Evolv Shaman (2021)", "Drop 0.5 UK Size", "Buy Shoe Size", "Buy 0.5 UK Size Larger", "NA", "Medium", "Classic")
            );
            shoeRepository.saveAll(shoes);      //just a side note, since shoeRepository is just an Interface, how come it will work? Spring data framework will dynamically create an implementation of this interface (methods inherited from CrudRepository) at runtime when the application starts *magic*
        }
    }
}
