package hu.nye.progtech.service;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.*;



import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class UserInputTest {

    private ByteArrayInputStream in;
    private UIInPutService ui=new UIInPutService();

    @BeforeEach
    public void setup(){

    }

    @Test
    public void testKilepesValaszIsnIfUserPressAnswerCharakter(){
        //given
        in= new ByteArrayInputStream("n".getBytes());

        //when
        boolean result=ui.userValasz("Test kerdes",in);

        //then
        assertFalse(result);
    }

    @Test
    public void testNevBekeresWhenUserAddName(){
        //given
        String nev="tesztNev";
        in = new ByteArrayInputStream(nev.getBytes());

        //when
        String result=ui.nevBekeres(in);

        //then
        assertEquals(nev,result);
    }

}
