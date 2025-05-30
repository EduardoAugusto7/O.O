
package Classes;

import java.util.ArrayList;
import java.util.List;
import Classes.Pessoa;
import java.util.Objects;


public class GerenciadorDePessoas {
    private List<Pessoa> lista_pessoas = new ArrayList<>();

    public GerenciadorDePessoas(){
    this.lista_pessoas = new ArrayList<>();
    }
    
    public void adicionar(Pessoa pessoas){
    this.lista_pessoas.add(pessoas);
        System.out.println("Pessoa adicionada com sucesso");
    }
    
    public boolean remover(String nome){
        for(Pessoa p: lista_pessoas){
            if(p.getNome().trim().equals(nome.trim())){
                lista_pessoas.remove(p);
            System.out.println("Pessoa removida com sucesso");
            return true;
            }
        }
        System.out.println("pessoa nao encontrada");
        return false;
    }
    
    public Pessoa buscarPessoas(String nome){
        for(Pessoa p: lista_pessoas){
            if(p.getNome().trim().equalsIgnoreCase(nome.trim())){
                return p;
            }
        }
        return null;
    }
    
    public void atualizarPessoas(String nomeAntigo, Pessoa novaPessoa){
        Pessoa pessoaExistente = buscarPessoas(nomeAntigo);
        if(pessoaExistente != null){
            int indice = lista_pessoas.indexOf(pessoaExistente);
            lista_pessoas.set(indice, novaPessoa);
            System.out.println("Pessoa atualizada com sucesso!");
        }else{
            System.out.println("pessoa com o nome" + nomeAntigo + "nao encontrado");
        }
    }

    public List<Pessoa> getLista_pessoas() {
        return lista_pessoas;
    }

    public void setLista_pessoas(List<Pessoa> lista_pessoas) {
        this.lista_pessoas = lista_pessoas;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + Objects.hashCode(this.lista_pessoas);
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
        final GerenciadorDePessoas other = (GerenciadorDePessoas) obj;
        return Objects.equals(this.lista_pessoas, other.lista_pessoas);
    }

     @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Pessoa p : lista_pessoas) {
            sb.append(p.toString()).append("\n");
        }
        return sb.toString();
    }
}

    
    
    

