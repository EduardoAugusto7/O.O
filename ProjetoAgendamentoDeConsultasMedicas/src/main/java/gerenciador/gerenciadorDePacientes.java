package gerenciador;

import classes.paciente;
import com.fasterxml.jackson.core.JsonProcessingException;
import file.FilePersistence;
import file.SerializadorPacienteJson;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class gerenciadorDePacientes {
    private List<paciente> lista_pacientes = new ArrayList<>();
    
    public gerenciadorDePacientes(){
        this.lista_pacientes = new ArrayList<>();
    }
    
    public void adicionar(paciente Paciente){
        this.lista_pacientes.add(Paciente);
        System.out.println("Paciente adicionado com sucesso");
    }
    public boolean remover(String nome){
        for(paciente p: lista_pacientes){
            if(p.getNome().trim().equals(nome.trim())){
                lista_pacientes.remove(p);
            System.out.println("Paciente removido com sucesso");
            return true;
            }
        }
        System.out.println("Paciente nao encontrado");
        return false;
    }
    public paciente buscar(String nome){
        for(paciente p: lista_pacientes){
        if(p.getNome().trim().equalsIgnoreCase(nome.trim())){
            return p;
        }
    }
        return null;
}
    public void atualizar(String nomeAntigo, paciente novoPaciente){
    paciente pacienteExistente = buscar(nomeAntigo);
    if(pacienteExistente != null){
        int indice = lista_pacientes.indexOf(pacienteExistente);
        lista_pacientes.set(indice, novoPaciente);
        System.out.println("Paciente atualizado com sucesso");
    }else{
        System.out.println("Paciente com o nome " + nomeAntigo + "nao encontrada");
    }
}    
    
    public void salvarNoArquivo(String pathFile) throws FileNotFoundException, IOException{
        SerializadorPacienteJson serializadorJson = new SerializadorPacienteJson();
        String jsonData = serializadorJson.toJson(lista_pacientes);
         
        FilePersistence filepersistence = new FilePersistence();
        filepersistence.saveToFile(jsonData, pathFile);
        System.out.println("Pacientes salvos com sucesso em " + pathFile);
        
       
        filepersistence.saveToFile(jsonData, "listaPacientes.json");
        System.out.println("Pacientes salvos com sucesso em " + "ListaPacientes.json");
    }
    
    public void carregarDoArquivo(String pathFile) throws FileNotFoundException, JsonProcessingException{
        FilePersistence filepersistence = new FilePersistence();
        String jsonData = filepersistence.loadFromFile(pathFile);
        
        SerializadorPacienteJson serializadorJson = new SerializadorPacienteJson();
        this.lista_pacientes = serializadorJson.fromJson(jsonData);
        
        System.out.println("Pacientes carregados com sucesso" + pathFile);
    }

    public List<paciente> getLista_pacientes() {
        return lista_pacientes;
    }

    public void setLista_pacientes(List<paciente> lista_pacientes) {
        this.lista_pacientes = lista_pacientes;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 59 * hash + Objects.hashCode(this.lista_pacientes);
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
        final gerenciadorDePacientes other = (gerenciadorDePacientes) obj;
        return Objects.equals(this.lista_pacientes, other.lista_pacientes);
    }

    @Override
    public String toString() {
       StringBuilder sb = new StringBuilder();
        for (paciente p : lista_pacientes) {
            sb.append(p.toString()).append("\n");
        }
        return sb.toString();
    }
}
