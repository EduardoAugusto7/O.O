package gerenciador;

import classes.Disciplina;
import com.fasterxml.jackson.core.JsonProcessingException;
import file.FilePersistence;
import file.SerializadorDisciplinaJson;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class GerenciadorDeDisciplinas {
    private List<Disciplina> lista_disciplinas = new ArrayList<>();
    
    public GerenciadorDeDisciplinas(){
        this.lista_disciplinas = new ArrayList<>();
    }
     public void adicionar(Disciplina disciplina){
        this.lista_disciplinas.add(disciplina);
        System.out.println("Disciplina adicionada com sucesso");
        
    }
    
    public boolean remover(String nome){
        for(Disciplina d: lista_disciplinas){
            if(d.getNome().trim().equals(nome.trim())){
                lista_disciplinas.remove(d);
            System.out.println("Disicplina removida com sucesso");
            return true;
            }
        }
        System.out.println("Disciplina nao encontrado");
        return false;
    }
    
    public Disciplina buscar(String nome){
        for(Disciplina d: lista_disciplinas){
        if(d.getNome().trim().equalsIgnoreCase(nome.trim())){
            return d;
        }
    }
    return null;
    }
    
    public void atualizarDisciplinas(String nomeAntigo, Disciplina novaDisicplina){
    Disciplina disciplinaExistente = buscar(nomeAntigo);
    if(disciplinaExistente != null){
        int indice = lista_disciplinas.indexOf(disciplinaExistente);
        lista_disciplinas.set(indice, novaDisicplina);
        System.out.println("Disciplina atualizada com sucesso");
    }else{
        System.out.println("Disciplina com o nome " + nomeAntigo + "nao encontrada");
    }
}    
    
    public void salvarNoArquivo(String pathFile) throws FileNotFoundException, IOException{
        SerializadorDisciplinaJson serializadorJson = new SerializadorDisciplinaJson();
        String jsonData = serializadorJson.toJson(lista_disciplinas);
           
        FilePersistence filepersistence = new FilePersistence();
        filepersistence.saveToFile(jsonData, pathFile);
        System.out.println("Disicplinas salvas com sucesso em " + pathFile);
        
        filepersistence.saveToFile(jsonData,pathFile);
        System.out.println("Disicplinas salvas com sucesso em " + "ListaDisciplinas.json");
    }
    
    public void carregarDoArquivo(String pathFile) throws FileNotFoundException, JsonProcessingException{
        FilePersistence filepersistence = new FilePersistence();
        String jsonData = filepersistence.loadFromFile(pathFile);
        
        SerializadorDisciplinaJson serializadorJson = new SerializadorDisciplinaJson();
        this.lista_disciplinas = serializadorJson.fromJson(jsonData);
        
        System.out.println("Disciplinas carregadas com sucesso" + pathFile);
    }

    public List<Disciplina> getLista_disciplinas() {
        return lista_disciplinas;
    }

    public void setLista_disciplinas(List<Disciplina> lista_disciplinas) {
        this.lista_disciplinas = lista_disciplinas;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.lista_disciplinas);
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
        final GerenciadorDeDisciplinas other = (GerenciadorDeDisciplinas) obj;
        return Objects.equals(this.lista_disciplinas, other.lista_disciplinas);
    }
    
    
    @Override
    public String toString() {
       StringBuilder sb = new StringBuilder();
        for (Disciplina d : lista_disciplinas) {
            sb.append(d.toString()).append("\n");
        }
        return sb.toString();
    }
}
