package ru.file.statistics.find.convert;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import ru.file.statistics.find.model.FileStatistic;

public class ConvertXml {

    public void convertXml(FileStatistic responce) {
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(FileStatistic.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
                jaxbMarshaller.marshal(responce, System.out);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

}
