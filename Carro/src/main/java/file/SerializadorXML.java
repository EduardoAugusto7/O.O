package file;

import java.io.StringWriter;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import com.GerenciadorDeCarro.GerenciadorDeCarro;
import java.io.StringReader;
import javax.xml.bind.JAXBException;

public class SerializadorXML {
        public String ToXML(GerenciadorDeCarro gerenciador) {
        try {
            JAXBContext context = JAXBContext.newInstance(GerenciadorDeCarro.class);
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            StringWriter writer = new StringWriter();
            marshaller.marshal(gerenciador, writer);
            return writer.toString();
        } catch (JAXBException e) {
            return null;
        }
    }

    public GerenciadorDeCarro fromXML(String xmlString) {
        try {
            JAXBContext context = JAXBContext.newInstance(GerenciadorDeCarro.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();
            StringReader reader = new StringReader(xmlString);

            return (GerenciadorDeCarro) unmarshaller.unmarshal(reader);
        } catch (JAXBException e) {
            return null;
        }
    }
}