package gerenciador;
import classes.consultas;
import com.fasterxml.jackson.core.JsonProcessingException;
import file.FilePersistence;
import file.SerializadorConsultasJson;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class gerenciadorDeConsultas {
    private List<consultas> lista_consultas = new ArrayList<>();
    
    public gerenciadorDeConsultas(){
        this.lista_consultas = new ArrayList<>();
    }
    
    public void adicionar(consultas Consulta){
    this.lista_consultas.add(Consulta);
    System.out.println("Consulta adicionada com sucesso");
}
public boolean Remover(String data){
    for(consultas c: lista_consultas){
            if(c.getData().trim().equals(data.trim())){
                lista_consultas.remove(c);
            System.out.println("Consulta removida com sucesso");
            return true;
            }
        }
        System.out.println("Medico nao encontrado");
        return false;
}
public consultas buscar(String data){
        for(consultas c: lista_consultas){
        if(c.getData().trim().equalsIgnoreCase(data.trim())){
            return c;
        }
    }
        return null;
}
    public void atualizar(String dataAntiga, consultas novaConsulta){
    consultas consultaExistente = buscar(dataAntiga);
    if(consultaExistente != null){
        int indice = lista_consultas.indexOf(consultaExistente);
        lista_consultas.set(indice, novaConsulta);
        System.out.println("Consulta atualizado com sucesso");
    }else{
        System.out.println("Consulta com a data " + dataAntiga + "nao encontrada");
    }
}    
    
    public void salvarNoArquivo(String pathFile) throws FileNotFoundException, IOException{
        SerializadorConsultasJson serializadorJson = new SerializadorConsultasJson();
        String jsonData = serializadorJson.toJson(lista_consultas);
         
        FilePersistence filepersistence = new FilePersistence();
        filepersistence.saveToFile(jsonData, pathFile);
        System.out.println("Consultas salvas com sucesso em " + pathFile);
        
       
        filepersistence.saveToFile(jsonData, "listaConsultas.json");
        System.out.println("Consultas salvos com sucesso em " + "ListaConsultas.json");
    }
    
    public void carregarDoArquivo(String pathFile) throws FileNotFoundException, JsonProcessingException{
        FilePersistence filepersistence = new FilePersistence();
        String jsonData = filepersistence.loadFromFile(pathFile);
        
        SerializadorConsultasJson serializadorJson = new SerializadorConsultasJson();
        this.lista_consultas = serializadorJson.fromJson(jsonData);
        
        System.out.println("Consultas carregados com sucesso" + pathFile);
    }

    public List<consultas> getLista_consultas() {
        return lista_consultas;
    }

    public void setLista_consultas(List<consultas> lista_consultas) {
        this.lista_consultas = lista_consultas;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.lista_consultas);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final gerenciadorDeConsultas other = (gerenciadorDeConsultas) obj;
        return Objects.equals(this.lista_consultas, other.lista_consultas);
    }
    
     @Override
    public String toString() {
       StringBuilder sb = new StringBuilder();
        for (consultas c : lista_consultas) {
            sb.append(c.toString()).append("\n");
        }
        return sb.toString();
    }
}
