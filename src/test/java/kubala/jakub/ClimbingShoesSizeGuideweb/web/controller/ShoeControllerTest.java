package kubala.jakub.ClimbingShoesSizeGuideweb.web.controller;

import kubala.jakub.ClimbingShoesSizeGuideweb.biz.model.Shoe;
import kubala.jakub.ClimbingShoesSizeGuideweb.data.ShoeRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ShoeControllerTest {

    @Mock
    ShoeRepository shoeRepository;

    @InjectMocks
    ShoeController shoeController;

    @Test
    public void getShoesTest() {
        //given
        List<Shoe> expectedShoes = new ArrayList<>();
        expectedShoes.add(new Shoe(null,"Scarpa Instinct VSR/VS", "Drop 1.5 EU Sizes", "Drop 1 EU Size", "Drop 0.5 EU Size", "NA", "Medium/High", "Centre"));
        expectedShoes.add(new Shoe(null,"Evolv Shaman (2021)", "Drop 0.5 UK Size", "Buy Shoe Size", "Buy 0.5 UK Size Larger", "NA", "Medium", "Classic"));
        when(shoeRepository.findAll()).thenReturn(expectedShoes);

        //when
        Iterable<Shoe> actualShoes = shoeController.getShoes();

        //then
        assertEquals(expectedShoes, actualShoes);
    }

    @Test
    public void getShoeTest() {
        //given
        //when
        Shoe shoe = shoeController.getShoe();

        //then
        assertNotNull(shoe);
    }

}