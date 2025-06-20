package classes;

import java.util.Objects;

public class Hospedes {
private String nome;
private String Cpf;
private String contato;
private String endereco;

public Hospedes(){
    this.nome = " ";
    this.contato = " ";
    this.Cpf = " ";
    this.endereco = " ";
}

    public Hospedes(String nome, String Cpf, String contato, String endereco) {
        this.nome = nome;
        this.Cpf = Cpf;
        this.contato = contato;
        this.endereco = endereco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return Cpf;
    }

    public void setCpf(String Cpf) {
        this.Cpf = Cpf;
    }

    public String getContato() {
        return contato;
    }

    public void setContato(String contato) {
        this.contato = contato;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + Objects.hashCode(this.nome);
        hash = 47 * hash + Objects.hashCode(this.Cpf);
        hash = 47 * hash + Objects.hashCode(this.contato);
        hash = 47 * hash + Objects.hashCode(this.endereco);
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
        final Hospedes other = (Hospedes) obj;
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.Cpf, other.Cpf)) {
            return false;
        }
        if (!Objects.equals(this.contato, other.contato)) {
            return false;
        }
        return Objects.equals(this.endereco, other.endereco);
    }

    @Override
    public String toString() {
        return "Hospedes{" + "nome=" + nome + ", Cpf=" + Cpf + ", contato=" + contato + ", endereco=" + endereco + '}';
    }
}
