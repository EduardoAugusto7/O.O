package file;
import classes.consultas;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.List;

public class SerializadorConsultasJson {
    /**
     *
     * @param lista_consultas
     * @return
     * @throws com.fasterxml.jackson.core.JsonProcessingException
     */
    public String toJson(List<consultas> lista_consultas) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        String jsonStr = mapper.writeValueAsString(lista_consultas);
        
        return jsonStr;
    }
    
    public List<consultas> fromJson(String jsonString) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(jsonString,new TypeReference<List<consultas>>() {});
    }
}
