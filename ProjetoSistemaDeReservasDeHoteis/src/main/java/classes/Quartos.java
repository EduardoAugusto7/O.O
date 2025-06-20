package classes;

import java.util.Objects;

public class Quartos {
    private int numDoQuarto;
    private String tipo;
    private int preco;
    
    public Quartos(){
        this.numDoQuarto = 0;
        this.preco = 0;
        this.tipo = " ";
    }

    public Quartos(int numDoQuarto, String tipo, int preco) {
        this.numDoQuarto = numDoQuarto;
        this.tipo = tipo;
        this.preco = preco;
    }

    public int getNumDoQuarto() {
        return numDoQuarto;
    }

    public void setNumDoQuarto(int numDoQuarto) {
        this.numDoQuarto = numDoQuarto;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getPreco() {
        return preco;
    }

    public void setPreco(int preco) {
        this.preco = preco;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + this.numDoQuarto;
        hash = 97 * hash + Objects.hashCode(this.tipo);
        hash = 97 * hash + this.preco;
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
        final Quartos other = (Quartos) obj;
        if (this.numDoQuarto != other.numDoQuarto) {
            return false;
        }
        if (this.preco != other.preco) {
            return false;
        }
        return Objects.equals(this.tipo, other.tipo);
    }

    @Override
    public String toString() {
        return "Quartos{" + "numDoQuarto=" + numDoQuarto + ", tipo=" + tipo + ", preco=" + preco + '}';
    }
    
}
