package gerenciador;

import classes.Alunos;
import com.fasterxml.jackson.core.JsonProcessingException;
import file.FilePersistence;
import file.SerializadorAlunosJson;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class GerenciadorDeAlunos {
    private List<Alunos> lista_alunos = new ArrayList<>();
    
    public GerenciadorDeAlunos(){
        this.lista_alunos = new ArrayList<>();
    }
     public void adicionar(Alunos aluno){
        this.lista_alunos.add(aluno);
        System.out.println("Aluno adicionado com sucesso");
        
    }
    
    public boolean remover(String nome){
        for(Alunos a: lista_alunos){
            if(a.getNome().trim().equals(nome.trim())){
                lista_alunos.remove(a);
            System.out.println("Aluno removido com sucesso");
            return true;
            }
        }
        System.out.println("Aluno nao encontrado");
        return false;
    }
    
    public Alunos buscar(String nome){
        for(Alunos a: lista_alunos){
        if(a.getNome().trim().equalsIgnoreCase(nome.trim())){
            return a;
        }
    }
    return null;
    }
    
    public void atualizarAlunos(String nomeAntigo, Alunos novoAluno){
    Alunos alunoExistente = buscar(nomeAntigo);
    if(alunoExistente != null){
        int indice = lista_alunos.indexOf(alunoExistente);
        lista_alunos.set(indice, novoAluno);
        System.out.println("Aluno atualizado com sucesso");
    }else{
        System.out.println("Aluno com o nome " + nomeAntigo + "nao encontrada");
    }
}    
    
    public void salvarNoArquivo(String pathFile) throws FileNotFoundException, IOException{
        SerializadorAlunosJson serializadorJson = new SerializadorAlunosJson();
        String jsonData = serializadorJson.toJson(lista_alunos);
         
        FilePersistence filepersistence = new FilePersistence();
        filepersistence.saveToFile(jsonData, pathFile);
        System.out.println("Alunos salvos com sucesso em " + pathFile);
        
       
        filepersistence.saveToFile(jsonData, "listaAlunos.json");
        System.out.println("Alunos salvos com sucesso em " + "ListaAlunos.json");
    }
    
    public void carregarDoArquivo(String pathFile) throws FileNotFoundException, JsonProcessingException{
        FilePersistence filepersistence = new FilePersistence();
        String jsonData = filepersistence.loadFromFile(pathFile);
        
        SerializadorAlunosJson serializadorJson = new SerializadorAlunosJson();
        this.lista_alunos = serializadorJson.fromJson(jsonData);
        
        System.out.println("Alunos carregados com sucesso" + pathFile);
    }

    public List<Alunos> getLista_alunos() {
        return lista_alunos;
    }

    public void setLista_alunos(List<Alunos> lista_alunos) {
        this.lista_alunos = lista_alunos;
    }


    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + Objects.hashCode(this.lista_alunos);
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
        final GerenciadorDeAlunos other = (GerenciadorDeAlunos) obj;
        return Objects.equals(this.lista_alunos, other.lista_alunos);
    }

   @Override
    public String toString() {
       StringBuilder sb = new StringBuilder();
        for (Alunos a : lista_alunos) {
            sb.append(a.toString()).append("\n");
        }
        return sb.toString();
    }
    
}
