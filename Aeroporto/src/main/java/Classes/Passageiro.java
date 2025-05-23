
package Classes;

import java.util.Objects;
import java.util.Scanner;
import Classes.SistemaDePntosFidelidades;

public class Passageiro {
    private String name;
    private String CPF; 
    private static Scanner leitor = new Scanner(System.in);
    private SistemaDePntosFidelidades sistemadefidelidade;
    
    public Passageiro(){
    this.name = " ";
    this.CPF = " ";
    }

    public Passageiro(String name, String CPF) {
        this.name = name;
        this.CPF = CPF;
    }
    
    public void fill(){
        System.out.println("informe seu nome: ");
        this.name = leitor.next();
        System.out.println("informe seu cpf: ");
        this.CPF = leitor.next();
    
    }
     
    public void print () {
        System.out.println (this);
    }
     
    @Override
   public String toString () {
       return " Passenger{" +
              " Name: " + name + " " +
              " CPF: " + CPF + " " +
              "}";
              
   }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 37 * hash + Objects.hashCode(this.name);
        hash = 37 * hash + Objects.hashCode(this.CPF);
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
        final Passageiro other = (Passageiro) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        return Objects.equals(this.CPF, other.CPF);
    }
   
   public void copy ( Passageiro outro ) {
       this.name = outro.getName();
       this.CPF = outro.getCPF ();
   }
   
   public String getName () {
       return name;
   }
   
   public void setName (String nome) {
       this.name = name;
   }
   
   public String getCPF () {
       return CPF;
   }
   public void setCPF ( String cpf ){
       this.CPF = CPF;
   }
}
