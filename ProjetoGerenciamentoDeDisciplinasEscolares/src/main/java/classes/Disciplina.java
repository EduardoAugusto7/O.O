package classes;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class Disciplina {
    private String nome;
    private int semestre;
    private int horario;
    private String profMinistrante;
    
    public Disciplina(){
        this.horario = 0;
        this.nome = " ";
        this.profMinistrante = " ";
        this.semestre = 0;
    }

    public void copiar(Disciplina outro){
        this.horario = outro.getHorario();
        this.nome = outro.getNome();
        this.profMinistrante = outro.profMinistrante;
        this.semestre = outro.getSemestre();
    }
    
    public Disciplina(String nome, int semestre, int horario, String profMinistrante) {
        this.nome = nome;
        this.semestre = semestre;
        this.horario = horario;
        this.profMinistrante = profMinistrante;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getSemestre() {
        return semestre;
    }

    public void setSemestre(int semestre) {
        this.semestre = semestre;
    }

    public int getHorario() {
        return horario;
    }

    public void setHorario(int horario) {
        this.horario = horario;
    }

    public String getProfMinistrante() {
        return profMinistrante;
    }

    public void setProfMinistrante(String profMinistrante) {
        this.profMinistrante = profMinistrante;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.nome);
        hash = 37 * hash + this.semestre;
        hash = 37 * hash + this.horario;
        hash = 37 * hash + Objects.hashCode(this.profMinistrante);

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
        final Disciplina other = (Disciplina) obj;
        if (this.semestre != other.semestre) {
            return false;
        }
        if (this.horario != other.horario) {
            return false;
        }
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        return Objects.equals(this.profMinistrante, other.profMinistrante);
    }

    @Override
    public String toString() {
        return "Disciplina{" + "nome=" + nome + ", semestre=" + semestre + ", horario=" + horario + ", profMinistrante=" + profMinistrante + '}';
    }
}
