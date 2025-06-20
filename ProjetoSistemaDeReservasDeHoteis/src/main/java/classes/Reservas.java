package classes;

import java.util.Objects;


public class Reservas {
    private String dataCheckIn;
    private String dataCheckOut;
    
    public Reservas(){
        this.dataCheckIn = " ";
        this.dataCheckOut = " ";
    }

    public Reservas(String dataCheckIn, String dataCheckOut) {
        this.dataCheckIn = dataCheckIn;
        this.dataCheckOut = dataCheckOut;
    }

    public String getDataCheckIn() {
        return dataCheckIn;
    }

    public void setDataCheckIn(String dataCheckIn) {
        this.dataCheckIn = dataCheckIn;
    }

    public String getDataCheckOut() {
        return dataCheckOut;
    }

    public void setDataCheckOut(String dataCheckOut) {
        this.dataCheckOut = dataCheckOut;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 47 * hash + Objects.hashCode(this.dataCheckIn);
        hash = 47 * hash + Objects.hashCode(this.dataCheckOut);
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
        final Reservas other = (Reservas) obj;
        if (!Objects.equals(this.dataCheckIn, other.dataCheckIn)) {
            return false;
        }
        return Objects.equals(this.dataCheckOut, other.dataCheckOut);
    }

    @Override
    public String toString() {
        return "Reservas{" + "dataCheckIn=" + dataCheckIn + ", dataCheckOut=" + dataCheckOut + '}';
    }
    
}
