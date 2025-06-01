package Classes;

import java.util.Objects;


public class Livro {
private String titulo;
private String autor;
private int num_pag;
private double preco;

public Livro(){
    this.titulo = " ";
    this.autor = " ";
    this.num_pag = 0;
    this.preco = 0.0;
}

    public Livro(String titulo, String autor, int num_pag, double preco) {
        this.titulo = titulo;
        this.autor = autor;
        this.num_pag = num_pag;
        this.preco = preco;
    }

    public Livro(Livro outro){
        this.titulo = outro.getTitulo();
        this.autor = outro.getAutor();
        this.num_pag = outro.getNum_pag();
        this.preco = outro.getPreco();
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public int getNum_pag() {
        return num_pag;
    }

    public void setNum_pag(int num_pag) {
        this.num_pag = num_pag;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.titulo);
        hash = 37 * hash + Objects.hashCode(this.autor);
        hash = 37 * hash + this.num_pag;
        hash = 37 * hash + (int) (Double.doubleToLongBits(this.preco) ^ (Double.doubleToLongBits(this.preco) >>> 32));
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
        final Livro other = (Livro) obj;
        if (this.num_pag != other.num_pag) {
            return false;
        }
        if (Double.doubleToLongBits(this.preco) != Double.doubleToLongBits(other.preco)) {
            return false;
        }
        if (!Objects.equals(this.titulo, other.titulo)) {
            return false;
        }
        return Objects.equals(this.autor, other.autor);
    }

    @Override
    public String toString() {
        return "Livro{" + "titulo=" + titulo + ", autor=" + autor + ", num_pag=" + num_pag + ", preco=" + preco + '}';
    }
    
    
}
