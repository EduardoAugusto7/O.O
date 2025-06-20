
package file;
import classes.medico;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.List;

public class SerializadorMedicosJson {
     /**
     *
     * @param lista_medicos
     * @return
     * @throws com.fasterxml.jackson.core.JsonProcessingException
     */
    public String toJson(List<medico> lista_medicos) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        String jsonStr = mapper.writeValueAsString(lista_medicos);
        
        return jsonStr;
    }
    
    public List<medico> fromJson(String jsonString) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(jsonString,new TypeReference<List<medico>>() {});
    }
}
