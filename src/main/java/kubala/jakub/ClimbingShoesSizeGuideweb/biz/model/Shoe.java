package kubala.jakub.ClimbingShoesSizeGuideweb.biz.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Shoe {

    private String rockShoeModel;
    private String technicalFit;        //Hard Bouldering, Hard Sport Climbing and Elite Trad Climbing.
    private String semiTechnicalFit;    //Hard Trad Climbing, Mid Grade Bouldering and Sport Climbing.
    private String traditionalFit;      //All purpose Trad Climbing, Sun Rock Sport Climbers and Circuit Bouldering.
    private String entryLevelFit;       //Beginners or people who only climb a few times a year.
    private String footVolume;          //High volume, Mid volume, Low volume
    private String footType;            //Classic - egyptian feet, Square - germanic feet, Centre - greek feet, Morton's toe
}
