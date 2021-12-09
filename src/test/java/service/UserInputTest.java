package service;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.*;



import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserInputTest {

    private ByteArrayInputStream in;
    private UserInput ui=new UserInput();

    @BeforeEach
    public void setup(){

    }

    @Test
    public void testKilepesValaszIsnIfUserPressAnswerCharakter(){
        //given
        in= new ByteArrayInputStream("n".getBytes());

        //when
        char result=ui.kiLepesValasz(in);

        //then
        assertEquals('n',result);
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
