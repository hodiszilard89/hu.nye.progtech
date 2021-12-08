import controller.MainController;
import jakarta.xml.bind.JAXBException;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws JAXBException, IOException {

        new MainController();
//
//        JAXBContext context = JAXBContext.newInstance((Person.class));
//
//        Marshaller marshaller = context.createMarshaller();
//        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,Boolean.TRUE);
//
//
//
//        Unmarshaller unmarshaller = context.createUnmarshaller();
//        Person umarshal=(Person)unmarshaller.unmarshal(new File("person.xml"));
//        System.out.println(umarshal.getName());

    }
}


