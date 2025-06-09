package Classes;

import java.util.Objects;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Carro {
private String marca;
private String modelo;
private int ano;
private int preco;

public Carro(){
this.marca = " ";
this.modelo = " ";
this.ano = 0;
this.preco = 0;
}

    public Carro(String marca, String modelo, int ano, int preco) {
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
        this.preco = preco;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
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
        hash = 67 * hash + Objects.hashCode(this.marca);
        hash = 67 * hash + Objects.hashCode(this.modelo);
        hash = 67 * hash + this.ano;
        hash = 67 * hash + this.preco;
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
        final Carro other = (Carro) obj;
        if (this.ano != other.ano) {
            return false;
        }
        if (this.preco != other.preco) {
            return false;
        }
        if (!Objects.equals(this.marca, other.marca)) {
            return false;
        }
        return Objects.equals(this.modelo, other.modelo);
    }

    @Override
    public String toString() {
        return "Carro{" + "marca=" + marca + ", modelo=" + modelo + ", ano=" + ano + ", preco=" + preco + '}';
    }

    
}
