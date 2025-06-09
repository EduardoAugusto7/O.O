package classes;

import java.util.Objects;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Casa {
private String tipo;
private int quartos;
private int banheiros;
private int preco;

public Casa(){
    this.tipo = " ";
    this.quartos = 0;
    this.banheiros = 0;
    this.preco = 0;
}

    public Casa(String tipo, int quartos, int banheiros, int preco) {
        this.tipo = tipo;
        this.quartos = quartos;
        this.banheiros = banheiros;
        this.preco = preco;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getQuartos() {
        return quartos;
    }

    public void setQuartos(int quartos) {
        this.quartos = quartos;
    }

    public int getBanheiros() {
        return banheiros;
    }

    public void setBanheiros(int banheiros) {
        this.banheiros = banheiros;
    }

    public int getPreco() {
        return preco;
    }

    public void setPreco(int preco) {
        this.preco = preco;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 59 * hash + Objects.hashCode(this.tipo);
        hash = 59 * hash + this.quartos;
        hash = 59 * hash + this.banheiros;
        hash = 59 * hash + this.preco;
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
        final Casa other = (Casa) obj;
        if (this.quartos != other.quartos) {
            return false;
        }
        if (this.banheiros != other.banheiros) {
            return false;
        }
        if (this.preco != other.preco) {
            return false;
        }
        return Objects.equals(this.tipo, other.tipo);
    }

    @Override
    public String toString() {
        return "Casa{" + "tipo=" + tipo + ", quartos=" + quartos + ", banheiros=" + banheiros + ", preco=" + preco + '}';
    }
}