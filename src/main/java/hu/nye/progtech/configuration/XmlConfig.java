package hu.nye.progtech.configuration;

import hu.nye.progtech.repository.GameSaveRep;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;
import org.jacoco.report.internal.html.table.Table;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class XmlConfig {
    @Bean
    Marshaller marshaller() throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(Table.class);

        Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

        return marshaller;
    }

    @Bean
    Unmarshaller unmarshaller() throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(Table.class);

        return jaxbContext.createUnmarshaller();
    }
    @Bean
    GameSaveRep gameSaveRep(){
        return new GameSaveRep();
    }
}
