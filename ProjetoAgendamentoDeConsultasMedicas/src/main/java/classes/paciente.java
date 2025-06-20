package classes;

import java.util.Objects;

public class paciente {
    private String nome;
    private String cpf;
    private String dataDeNascimento;
    private String historicoMedico;
    
    public paciente(){
        this.nome = " ";
        this.cpf = " ";
        this.dataDeNascimento = " ";
        this.historicoMedico = " ";
    }

    public paciente(String nome, String cpf, String dataDeNascimento, String historicoMedico) {
        this.nome = nome;
        this.cpf = cpf;
        this.dataDeNascimento = dataDeNascimento;
        this.historicoMedico = historicoMedico;
    }
    
    public paciente(paciente outro){
        this.nome = outro.getNome();
        this.cpf = outro.getCpf();
        this.dataDeNascimento = outro.getDataDeNascimento();
        this.historicoMedico = outro.getHistoricoMedico();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getDataDeNascimento() {
        return dataDeNascimento;
    }

    public void setDataDeNascimento(String dataDeNascimento) {
        this.dataDeNascimento = dataDeNascimento;
    }

    public String getHistoricoMedico() {
        return historicoMedico;
    }

    public void setHistoricoMedico(String historicoMedico) {
        this.historicoMedico = historicoMedico;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 89 * hash + Objects.hashCode(this.nome);
        hash = 89 * hash + Objects.hashCode(this.cpf);
        hash = 89 * hash + Objects.hashCode(this.dataDeNascimento);
        hash = 89 * hash + Objects.hashCode(this.historicoMedico);
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
        final paciente other = (paciente) obj;
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.cpf, other.cpf)) {
            return false;
        }
        if (!Objects.equals(this.dataDeNascimento, other.dataDeNascimento)) {
            return false;
        }
        return Objects.equals(this.historicoMedico, other.historicoMedico);
    }

    @Override
    public String toString() {
        return "paciente{" + "nome=" + nome + ", cpf=" + cpf + ", dataDeNascimento=" + dataDeNascimento + ", historicoMedico=" + historicoMedico + '}';
    }

    
}
