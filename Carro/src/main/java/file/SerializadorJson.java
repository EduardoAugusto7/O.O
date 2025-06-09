package file;

import Classes.Carro;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.List;

public class SerializadorJson{
    
    /**
     *
     * @param listaCarros
     * @return
     * @throws com.fasterxml.jackson.core.JsonProcessingException
     */
    public String toJson(List<Carro> lista_carros) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        String jsonStr = mapper.writeValueAsString(lista_carros);
        
        return jsonStr;
    }
    
    public List<Carro> fromJson(String jsonString) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(jsonString,new TypeReference<List<Carro>>() {});
    }
}
