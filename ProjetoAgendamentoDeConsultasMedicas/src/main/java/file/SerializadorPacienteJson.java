
package file;
import classes.paciente;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.List;


public class SerializadorPacienteJson {
    /**
     *
     * @param lista_pacientes
     * @return
     * @throws com.fasterxml.jackson.core.JsonProcessingException
     */
    public String toJson(List<paciente> lista_pacientes) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        String jsonStr = mapper.writeValueAsString(lista_pacientes);
        
        return jsonStr;
    }
    
    public List<paciente> fromJson(String jsonString) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(jsonString,new TypeReference<List<paciente>>() {});
    }
}
