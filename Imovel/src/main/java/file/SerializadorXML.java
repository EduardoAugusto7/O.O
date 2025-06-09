package file;

import java.io.StringWriter;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import GerenciadorDeCasa.GerenciadorDeCasa;
import java.io.StringReader;
import javax.xml.bind.JAXBException;

public class SerializadorXML {
        public String ToXML(GerenciadorDeCasa gerenciador) {
        try {
            JAXBContext context = JAXBContext.newInstance(GerenciadorDeCasa.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            StringWriter writer = new StringWriter();
            marshaller.marshal(gerenciador, writer);
            return writer.toString();
        } catch (JAXBException e) {
            return null;
        }
    }

    public GerenciadorDeCasa fromXML(String xmlString) {
        try {
            JAXBContext context = JAXBContext.newInstance(GerenciadorDeCasa.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            StringReader reader = new StringReader(xmlString);

            return (GerenciadorDeCasa) unmarshaller.unmarshal(reader);
        } catch (JAXBException e) {
            return null;
        }
    }
}