package classes;

import java.util.Objects;


public class Alunos {
    private String nome;
    private String Sexo;
    private int idade;
    private String cpf;
    
    public Alunos(){
    this.idade = 0;
    this.Sexo = " ";
    this.cpf = " ";
    this.nome = " ";
    }

    public Alunos(String nome, String Sexo, int idade, String cpf) {
        this.nome = nome;
        this.Sexo = Sexo;
        this.idade = idade;
        this.cpf = cpf;
    }
    public void copiar(Alunos outro){
        this.Sexo = outro.getSexo();
        this.cpf = outro.getCpf();
        this.idade = outro.getIdade();
        this.nome = outro.getNome();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSexo() {
        return Sexo;
    }

    public void setSexo(String Sexo) {
        this.Sexo = Sexo;
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
        hash = 23 * hash + Objects.hashCode(this.nome);
        hash = 23 * hash + Objects.hashCode(this.Sexo);
        hash = 23 * hash + this.idade;
        hash = 23 * hash + Objects.hashCode(this.cpf);
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
        final Alunos other = (Alunos) obj;
        if (this.idade != other.idade) {
            return false;
        }
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.Sexo, other.Sexo)) {
            return false;
        }
        return Objects.equals(this.cpf, other.cpf);
    }

    @Override
    public String toString() {
        return "Alunos{" + "nome=" + nome + ", Sexo=" + Sexo + ", idade=" + idade + ", cpf=" + cpf + '}';
    }
    
    
}
