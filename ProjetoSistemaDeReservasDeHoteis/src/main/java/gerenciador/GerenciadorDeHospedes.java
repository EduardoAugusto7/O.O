package gerenciador;
import classes.Hospedes;
import com.fasterxml.jackson.core.JsonProcessingException;
import file.FilePersistence;
import file.SerializadorHospedesJson;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class GerenciadorDeHospedes {
    List<Hospedes> lista_hospedes = new ArrayList<>();
    
    public GerenciadorDeHospedes(){
        this.lista_hospedes = new ArrayList<>();
    }
    public void adicionar(Hospedes hospede){
        this.lista_hospedes.add(hospede);
        System.out.println("Hospede adicionado com sucesso");
    }
    
    public boolean remover(String nome){
        for(Hospedes h: lista_hospedes){
            if(h.getNome().trim().equals(nome.trim())){
                lista_hospedes.remove(h);
                System.out.println("Hospede removido com sucesso");
                return true;
            }
        }
        System.out.println("Hospede nao encontrado");
        return false;
    }
    public Hospedes buscar(String nome){
        for(Hospedes h: lista_hospedes){
        if(h.getNome().trim().equalsIgnoreCase(nome.trim())){
            return h;
        }
    }
        return null;
}
    public void atualizar(String nomeAntigo, Hospedes novoHospede){
    Hospedes hospedeExistente = buscar(nomeAntigo);
    if(hospedeExistente != null){
        int indice = lista_hospedes.indexOf(hospedeExistente);
        lista_hospedes.set(indice, novoHospede);
        System.out.println("Hospede atualizado com sucesso");
    }else{
        System.out.println("Hospede com o nome " + nomeAntigo + "nao encontrada");
    }
}    
    
    public void salvarNoArquivo(String pathFile) throws FileNotFoundException, IOException{
        SerializadorHospedesJson serializadorJson = new SerializadorHospedesJson();
        String jsonData = serializadorJson.toJson(lista_hospedes);
         
        FilePersistence filepersistence = new FilePersistence();
        filepersistence.saveToFile(jsonData, pathFile);
        System.out.println("Hospedes salvos com sucesso em " + pathFile);
        
       
        filepersistence.saveToFile(jsonData, "listaHospedes.json");
        System.out.println("Hospedes salvos com sucesso em " + "ListaHospedes.json");
    }
    
    public void carregarDoArquivo(String pathFile) throws FileNotFoundException, JsonProcessingException{
        FilePersistence filepersistence = new FilePersistence();
        String jsonData = filepersistence.loadFromFile(pathFile);
        
        SerializadorHospedesJson serializadorJson = new SerializadorHospedesJson();
        this.lista_hospedes = serializadorJson.fromJson(jsonData);
        
        System.out.println("Hospedes carregados com sucesso" + pathFile);
    }

    public List<Hospedes> getLista_hospedes() {
        return lista_hospedes;
    }

    public void setLista_hospedes(List<Hospedes> lista_hospedes) {
        this.lista_hospedes = lista_hospedes;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 59 * hash + Objects.hashCode(this.lista_hospedes);
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
        final GerenciadorDeHospedes other = (GerenciadorDeHospedes) obj;
        return Objects.equals(this.lista_hospedes, other.lista_hospedes);
    }

     @Override
    public String toString() {
       StringBuilder sb = new StringBuilder();
        for (Hospedes h : lista_hospedes) {
            sb.append(h.toString()).append("\n");
        }
        return sb.toString();
    }
}
