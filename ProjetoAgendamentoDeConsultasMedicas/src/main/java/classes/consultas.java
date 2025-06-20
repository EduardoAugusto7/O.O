package classes;

import java.util.Objects;

public class consultas {
    private String hora;
    private String data;
    
    public consultas(){
        this.data = " ";
        this.hora = " ";
    }

    public consultas(String hora, String data) {
        this.hora = hora;
        this.data = data;
    }
     public consultas(consultas outro){
         this.data = outro.getData();
         this.hora = outro.getHora();
     }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.hora);
        hash = 37 * hash + Objects.hashCode(this.data);
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
        final consultas other = (consultas) obj;
        if (!Objects.equals(this.hora, other.hora)) {
            return false;
        }
        return Objects.equals(this.data, other.data);
    }

    @Override
    public String toString() {
        return "consultas{" + "hora=" + hora + ", data=" + data + '}';
    }
     
    
}
