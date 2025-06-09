package file;

import classes.Casa;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.List;

public class SerializadorJson{
    
    /**
     *
     * @param lista_casa
     * @return
     * @throws com.fasterxml.jackson.core.JsonProcessingException
     */
    public String toJson(List<Casa> lista_casa) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        String jsonStr = mapper.writeValueAsString(lista_casa);
        
        return jsonStr;
    }
    
    public List<Casa> fromJson(String jsonString) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(jsonString,new TypeReference<List<Casa>>() {});
    }
}