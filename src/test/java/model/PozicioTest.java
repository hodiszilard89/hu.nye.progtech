package model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class PozicioTest {
    @Test
    public void testIsNegativeShouldReturnTrueIfPositionXOrYIsSmallerThanZero(){
        //given
        Pozicio underTest = new  Pozicio();

        //when
        underTest.setX(-1);
        underTest.setY(0);
        Boolean result=underTest.isNegativ();

        //than
        assertTrue(result);
    }
    @Test
    public void testIsNegativeShouldReturnTrueIfPositionXOrYIsBiggerThanNine(){
        //given
        Pozicio underTest = new  Pozicio();

        //when
        underTest.setX(10);
        underTest.setY(0);
        Boolean result=underTest.isOut();

        //than
        assertTrue(result);
    }
}
