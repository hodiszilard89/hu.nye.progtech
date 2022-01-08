package hu.nye.progtech.configuration;

import hu.nye.progtech.entity.Tabla;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class XmlConfig {
    @Bean
    Marshaller marshaller() throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(Tabla.class);

        Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

        return marshaller;
    }

    @Bean
    Unmarshaller unmarshaller() throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(Tabla.class);

        return jaxbContext.createUnmarshaller();
    }

}
