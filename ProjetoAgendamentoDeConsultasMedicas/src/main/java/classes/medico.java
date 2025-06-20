package classes;

import java.util.Objects;


public class medico {
    private String nome;
    private String CRM;
    private String especialidade;
    private String horariodisponivel;
    
    public medico(){
        this.horariodisponivel = " ";
        this.CRM = " ";
        this.nome = " ";
        this.especialidade = " ";
    }

    public medico(String nome, String CRM, String especialidade, String horariodisponivel) {
        this.nome = nome;
        this.CRM = CRM;
        this.especialidade = especialidade;
        this.horariodisponivel = horariodisponivel;
    }
    
    public medico(medico outro){
        this.horariodisponivel = outro.getHorariodisponivel();
        this.CRM = outro.getCRM();
        this.horariodisponivel = outro.getHorariodisponivel();
        this.nome = outro.getNome();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCRM() {
        return CRM;
    }

    public void setCRM(String CRM) {
        this.CRM = CRM;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public String getHorariodisponivel() {
        return horariodisponivel;
    }

    public void setHorariodisponivel(String horariodisponivel) {
        this.horariodisponivel = horariodisponivel;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 43 * hash + Objects.hashCode(this.nome);
        hash = 43 * hash + Objects.hashCode(this.CRM);
        hash = 43 * hash + Objects.hashCode(this.especialidade);
        hash = 43 * hash + Objects.hashCode(this.horariodisponivel);
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
        final medico other = (medico) obj;
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.CRM, other.CRM)) {
            return false;
        }
        if (!Objects.equals(this.especialidade, other.especialidade)) {
            return false;
        }
        return Objects.equals(this.horariodisponivel, other.horariodisponivel);
    }

    @Override
    public String toString() {
        return "medico{" + "nome=" + nome + ", CRM=" + CRM + ", especialidade=" + especialidade + ", horariodisponivel=" + horariodisponivel + '}';
    }
    
}
