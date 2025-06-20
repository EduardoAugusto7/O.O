package gerenciador;

import classes.Professor;
import com.fasterxml.jackson.core.JsonProcessingException;
import file.FilePersistence;
import file.SerializadorProfessorJson;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class GerenciadorDeProfessor {
private List<Professor> lista_professor = new ArrayList<>();

public GerenciadorDeProfessor(){
    this.lista_professor = new ArrayList<>();
}
 public void adicionar(Professor professor){
        this.lista_professor.add(professor);
        System.out.println("Professor adicionado com sucesso");
        
    }
    
    public boolean remover(String nome){
        for(Professor p: lista_professor){
            if(p.getNome().trim().equals(nome.trim())){
                lista_professor.remove(p);
            System.out.println("Professor removido com sucesso");
            return true;
            }
        }
        System.out.println("Professor nao encontrado");
        return false;
    }
    
    public Professor buscar(String nome){
        for(Professor p: lista_professor){
        if(p.getNome().trim().equalsIgnoreCase(nome.trim())){
            return p;
        }
    }
    return null;
    }
    
    public void atualizarProfessores(String nomeAntigo, Professor novoProfessor){
    Professor professorExistente = buscar(nomeAntigo);
    if(professorExistente != null){
        int indice = lista_professor.indexOf(professorExistente);
        lista_professor.set(indice, novoProfessor);
        System.out.println("Professor atualizado com sucesso");
    }else{
        System.out.println("Professor com o nome " + nomeAntigo + "nao encontrada");
    }
}    
    
    public void salvarNoArquivo(String pathFile) throws FileNotFoundException, IOException{
        SerializadorProfessorJson serializadorJson = new SerializadorProfessorJson();
        String jsonData = serializadorJson.toJson(lista_professor);
         
        FilePersistence filepersistence = new FilePersistence();
        filepersistence.saveToFile(jsonData, pathFile);
        System.out.println("Professor salvo com sucesso em " + pathFile);
        
       
        filepersistence.saveToFile(jsonData, "listaProfessores.json");
        System.out.println("Alunos salvos com sucesso em " + "ListaProfessores.json");
    }
    
    public void carregarDoArquivo(String pathFile) throws FileNotFoundException, JsonProcessingException{
        FilePersistence filepersistence = new FilePersistence();
        String jsonData = filepersistence.loadFromFile(pathFile);
        
        SerializadorProfessorJson serializadorJson = new SerializadorProfessorJson();
        this.lista_professor = serializadorJson.fromJson(jsonData);
        
        System.out.println("Professores carregados com sucesso" + pathFile);
    }

    public List<Professor> getLista_professor() {
        return lista_professor;
    }

    public void setLista_professor(List<Professor> lista_professor) {
        this.lista_professor = lista_professor;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.lista_professor);
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
        final GerenciadorDeProfessor other = (GerenciadorDeProfessor) obj;
        return Objects.equals(this.lista_professor, other.lista_professor);
    }
    
    @Override
    public String toString() {
       StringBuilder sb = new StringBuilder();
        for (Professor p : lista_professor) {
            sb.append(p.toString()).append("\n");
        }
        return sb.toString();
    }
}
