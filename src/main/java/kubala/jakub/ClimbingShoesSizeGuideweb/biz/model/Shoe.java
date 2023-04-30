package kubala.jakub.ClimbingShoesSizeGuideweb.biz.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data                           //lombok annotation that creates for us default constructor, getters and setter, toString(), equals(), etc.
@AllArgsConstructor             //annotation that creates all args constructor
@NoArgsConstructor              //@AllArgsConstructor overridden my NoArgConstructor from @Data, so I need to add a new one
@Entity                         //for spring to know to use this class as the entity, the same as ShoeRepository as @Repository
public class Shoe {

    @Id                        //flag id
    @GeneratedValue            //telling spring to create id in the database for me, since shoes don't have their ids
    private Long id;

    @NotEmpty(message = "Rock shoe model field cannot be empty")        //validation annotation
    private String rockShoeModel;

    @NotEmpty(message = "Technical fit field cannot be empty")
    private String technicalFit;        //Hard Bouldering, Hard Sport Climbing and Elite Trad Climbing.

    @NotEmpty(message = "Semi-technical fit field cannot be empty")
    private String semiTechnicalFit;    //Hard Trad Climbing, Mid Grade Bouldering and Sport Climbing.

    @NotEmpty(message = "Traditional fit field cannot be empty")
    private String traditionalFit;      //All purpose Trad Climbing, Sun Rock Sport Climbers and Circuit Bouldering.

    @NotEmpty(message = "Entry level fit field cannot be empty")
    private String entryLevelFit;       //Beginners or people who only climb a few times a year.

    @NotEmpty(message = "Foot volume field cannot be empty")
    private String footVolume;          //High volume, Mid volume, Low volume

    @NotEmpty(message = "Foot type field cannot be empty")
    private String footType;            //Classic - egyptian feet, Square - germanic feet, Centre - greek feet, Morton's toe
}
