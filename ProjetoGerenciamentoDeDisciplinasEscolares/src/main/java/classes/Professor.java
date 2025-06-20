package classes;

import java.util.Objects;


public class Professor {
    private String nome;
    private String sexo;
    private int idade;
    private String cpf;
    
    public Professor(){
        this.cpf = " ";
        this.idade = 0;
        this.nome = " ";
        this.sexo = " ";
    }

    public Professor(String nome, String sexo, int idade, String cpf) {
        this.nome = nome;
        this.sexo = sexo;
        this.idade = idade;
        this.cpf = cpf;
    }
    public void copiar(Professor outro){
        this.cpf = outro.getCpf();
        this.idade = outro.getIdade();
        this.nome = outro.getNome();
        this.sexo = outro.getSexo();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + Objects.hashCode(this.nome);
        hash = 71 * hash + Objects.hashCode(this.sexo);
        hash = 71 * hash + this.idade;
        hash = 71 * hash + Objects.hashCode(this.cpf);
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
        final Professor other = (Professor) obj;
        if (this.idade != other.idade) {
            return false;
        }
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.sexo, other.sexo)) {
            return false;
        }
        return Objects.equals(this.cpf, other.cpf);
    }

    @Override
    public String toString() {
        return "Professor{" + "nome=" + nome + ", sexo=" + sexo + ", idade=" + idade + ", cpf=" + cpf + '}';
    }
     
}
