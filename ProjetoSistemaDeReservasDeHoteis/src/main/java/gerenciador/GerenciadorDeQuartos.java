
package gerenciador;
import classes.Quartos;
import file.SerializadorQuartosJson;
import com.fasterxml.jackson.core.JsonProcessingException;
import file.FilePersistence;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class GerenciadorDeQuartos {
    List<Quartos> lista_quartos = new ArrayList<>();
    
    public GerenciadorDeQuartos(){
        this.lista_quartos = new ArrayList<>();
    }
     public void adicionar(Quartos quarto){
        this.lista_quartos.add(quarto);
        System.out.println("Quarto adicionado com sucesso");
    }
    
    public boolean remover(String tipo){
        for(Quartos q: lista_quartos){
            if(q.getTipo().trim().equals(tipo.trim())){
                lista_quartos.remove(q);
                System.out.println("Quarto removido com sucesso");
                return true;
            }
        }
        System.out.println("Quarto nao encontrado");
        return false;
    }
    public Quartos buscar(String tipo){
        for(Quartos q: lista_quartos){
        if(q.getTipo().trim().equalsIgnoreCase(tipo.trim())){
            return q;
        }
    }
        return null;
}
    public void atualizar(String tipoAntigo, Quartos novoQuarto){
    Quartos quartoExistente = buscar(tipoAntigo);
    if(quartoExistente != null){
        int indice = lista_quartos.indexOf(quartoExistente);
        lista_quartos.set(indice, novoQuarto);
        System.out.println("Quarto atualizado com sucesso");
    }else{
        System.out.println("Quarto com o tipo " + tipoAntigo + "nao encontrado");
    }
}    
    
    public void salvarNoArquivo(String pathFile) throws FileNotFoundException, IOException{
        SerializadorQuartosJson serializadorJson = new SerializadorQuartosJson();
        String jsonData = serializadorJson.toJson(lista_quartos);
         
        FilePersistence filepersistence = new FilePersistence();
        filepersistence.saveToFile(jsonData, pathFile);
        System.out.println("Quartos salvos com sucesso em " + pathFile);
        
       
        filepersistence.saveToFile(jsonData, "listaQuartos.json");
        System.out.println("Quartos salvos com sucesso em " + "ListaQuartos.json");
    }
    
    public void carregarDoArquivo(String pathFile) throws FileNotFoundException, JsonProcessingException{
        FilePersistence filepersistence = new FilePersistence();
        String jsonData = filepersistence.loadFromFile(pathFile);
        
        SerializadorQuartosJson serializadorJson = new SerializadorQuartosJson();
        this.lista_quartos = serializadorJson.fromJson(jsonData);
        
        System.out.println("Quartos carregados com sucesso" + pathFile);
    }

    public List<Quartos> getLista_quartos() {
        return lista_quartos;
    }

    public void setLista_quartos(List<Quartos> lista_quartos) {
        this.lista_quartos = lista_quartos;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 41 * hash + Objects.hashCode(this.lista_quartos);
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
        final GerenciadorDeQuartos other = (GerenciadorDeQuartos) obj;
        return Objects.equals(this.lista_quartos, other.lista_quartos);
    }

     @Override
    public String toString() {
       StringBuilder sb = new StringBuilder();
        for (Quartos q : lista_quartos) {
            sb.append(q.toString()).append("\n");
        }
        return sb.toString();
    }
}
