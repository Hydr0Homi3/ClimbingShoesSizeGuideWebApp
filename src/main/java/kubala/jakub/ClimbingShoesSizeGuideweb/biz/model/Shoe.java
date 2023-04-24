package kubala.jakub.ClimbingShoesSizeGuideweb.biz.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data                           //lombok annotation that creates for us default constructor, getters and setter, toString(), equals(), etc.
@AllArgsConstructor             //annotation that creates all args constructor
@NoArgsConstructor              //@AllArgsConstructor overridden my NoArgConstructor from @Data, so I need to add a new one
@Entity                         //for spring to know to use this class as the entity, the same as PersonRepository as @Repository
public class Shoe {

    @Id                        //flag id
    @GeneratedValue            //telling spring to create id in the database for me, since shoes don't have their ids
    private Long id;
    private String rockShoeModel;
    private String technicalFit;        //Hard Bouldering, Hard Sport Climbing and Elite Trad Climbing.
    private String semiTechnicalFit;    //Hard Trad Climbing, Mid Grade Bouldering and Sport Climbing.
    private String traditionalFit;      //All purpose Trad Climbing, Sun Rock Sport Climbers and Circuit Bouldering.
    private String entryLevelFit;       //Beginners or people who only climb a few times a year.
    private String footVolume;          //High volume, Mid volume, Low volume
    private String footType;            //Classic - egyptian feet, Square - germanic feet, Centre - greek feet, Morton's toe
}
