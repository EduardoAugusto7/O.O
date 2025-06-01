package Gerenciador;

import Classes.Livro;
import java.util.List;
import java.util.ArrayList;
import java.util.Objects;

public class GerenciadorDeLivros {
private List<Livro> lista_livros = new ArrayList<>();

public GerenciadorDeLivros(){
this.lista_livros = new ArrayList<>();
}
public void Adicionar(Livro Livros){
    this.lista_livros.add(Livros);
    System.out.println("Livro adicionado com sucesso");
}

public boolean Remover(String titulo){
     for(Livro L: lista_livros){
            if(L.getTitulo().trim().equals(titulo.trim())){
                lista_livros.remove(L);
            System.out.println("Livro removido com sucesso");
            return true;
            }
        }
        System.out.println("Livro nao encontrada");
        return false;
}

public Livro buscarLivro(String titulo){
    for(Livro L: lista_livros){
        if(L.getTitulo().trim().equalsIgnoreCase(titulo.trim())){
            return L;
        }
    }
    return null;
}

public void atualizarLivros(String tituloAntigo, Livro novoLivro){
    Livro livroExistente = buscarLivro(tituloAntigo);
    if(livroExistente != null){
        int indice = lista_livros.indexOf(livroExistente);
        lista_livros.set(indice, novoLivro);
        System.out.println("Livro atualizado com sucesso");
    }else{
        System.out.println("livro com o titulo " + tituloAntigo + "nao encontrado");
    }
}

    public List<Livro> getLista_livros() {
        return lista_livros;
    }

    public void setLista_livros(List<Livro> lista_livros) {
        this.lista_livros = lista_livros;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.lista_livros);
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
        final GerenciadorDeLivros other = (GerenciadorDeLivros) obj;
        return Objects.equals(this.lista_livros, other.lista_livros);
    }

    @Override
    public String toString() {
       StringBuilder sb = new StringBuilder();
        for (Livro L : lista_livros) {
            sb.append(L.toString()).append("\n");
        }
        return sb.toString();
    }

}

    

