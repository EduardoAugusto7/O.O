package gerenciador;
import classes.medico;
import com.fasterxml.jackson.core.JsonProcessingException;
import file.FilePersistence;
import file.SerializadorMedicosJson;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class gerenciadorDeMedicos {
private List<medico> lista_medicos = new ArrayList<>();

public gerenciadorDeMedicos(){
    this.lista_medicos = new ArrayList<>();
}

public void adicionar(medico Medico){
    this.lista_medicos.add(Medico);
    System.out.println("Medico adicionado com sucesso");
}
public boolean Remover(String nome){
    for(medico m: lista_medicos){
            if(m.getNome().trim().equals(nome.trim())){
                lista_medicos.remove(m);
            System.out.println("Medico removido com sucesso");
            return true;
            }
        }
        System.out.println("Medico nao encontrado");
        return false;
}
public medico buscar(String nome){
        for(medico m: lista_medicos){
        if(m.getNome().trim().equalsIgnoreCase(nome.trim())){
            return m;
        }
    }
        return null;
}
    public void atualizar(String nomeAntigo, medico novoMedico){
    medico medicoExistente = buscar(nomeAntigo);
    if(medicoExistente != null){
        int indice = lista_medicos.indexOf(medicoExistente);
        lista_medicos.set(indice, novoMedico);
        System.out.println("Medico atualizado com sucesso");
    }else{
        System.out.println("Medico com o nome " + nomeAntigo + "nao encontrada");
    }
}    
    
    public void salvarNoArquivo(String pathFile) throws FileNotFoundException, IOException{
        SerializadorMedicosJson serializadorJson = new SerializadorMedicosJson();
        String jsonData = serializadorJson.toJson(lista_medicos);
         
        FilePersistence filepersistence = new FilePersistence();
        filepersistence.saveToFile(jsonData, pathFile);
        System.out.println("Medicos salvos com sucesso em " + pathFile);
        
       
        filepersistence.saveToFile(jsonData, "listaMedicos.json");
        System.out.println("Medicos salvos com sucesso em " + "ListaMedicos.json");
    }
    
    public void carregarDoArquivo(String pathFile) throws FileNotFoundException, JsonProcessingException{
        FilePersistence filepersistence = new FilePersistence();
        String jsonData = filepersistence.loadFromFile(pathFile);
        
        SerializadorMedicosJson serializadorJson = new SerializadorMedicosJson();
        this.lista_medicos = serializadorJson.fromJson(jsonData);
        
        System.out.println("Medicos carregados com sucesso" + pathFile);
    }

    public List<medico> getLista_medicos() {
        return lista_medicos;
    }

    public void setLista_medicos(List<medico> lista_medicos) {
        this.lista_medicos = lista_medicos;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 11 * hash + Objects.hashCode(this.lista_medicos);
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
        final gerenciadorDeMedicos other = (gerenciadorDeMedicos) obj;
        return Objects.equals(this.lista_medicos, other.lista_medicos);
    }

     @Override
    public String toString() {
       StringBuilder sb = new StringBuilder();
        for (medico m : lista_medicos) {
            sb.append(m.toString()).append("\n");
        }
        return sb.toString();
    }
}
