package gerenciador;
import classes.Reservas;
import file.SerializadorReservasJson;
import com.fasterxml.jackson.core.JsonProcessingException;
import file.FilePersistence;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class GerenciadorDeReservas {
    List<Reservas> lista_reservas = new ArrayList<>();
    
    public GerenciadorDeReservas(){
        this.lista_reservas = new ArrayList<>();
    }
    public void adicionar(Reservas reserva){
        this.lista_reservas.add(reserva);
        System.out.println("Reserva adicionada com sucesso");
    }
    
    public boolean remover(String dataCheckIn){
        for(Reservas r: lista_reservas){
            if(r.getDataCheckIn().trim().equals(dataCheckIn.trim())){
                lista_reservas.remove(r);
                System.out.println("Reserva removida com sucesso");
                return true;
            }
        }
        System.out.println("Reserva nao encontrado");
        return false;
    }
    public Reservas buscar(String dataCheckIn){
        for(Reservas r: lista_reservas){
        if(r.getDataCheckIn().trim().equalsIgnoreCase(dataCheckIn.trim())){
            return r;
        }
    }
        return null;
}
    public void atualizar(String dataAntiga, Reservas novaReserva){
    Reservas reservaExistente = buscar(dataAntiga);
    if(reservaExistente != null){
        int indice = lista_reservas.indexOf(reservaExistente);
        lista_reservas.set(indice, novaReserva);
        System.out.println("Reserva atualizada com sucesso");
    }else{
        System.out.println("Reserva com a data " + dataAntiga + "nao encontrada");
    }
}    
    
    public void salvarNoArquivo(String pathFile) throws FileNotFoundException, IOException{
        SerializadorReservasJson serializadorJson = new SerializadorReservasJson();
        String jsonData = serializadorJson.toJson(lista_reservas);
         
        FilePersistence filepersistence = new FilePersistence();
        filepersistence.saveToFile(jsonData, pathFile);
        System.out.println("Reservas salvos com sucesso em " + pathFile);
        
       
        filepersistence.saveToFile(jsonData, "listaReservas.json");
        System.out.println("REservas salvas com sucesso em " + "ListaReservas.json");
    }
    
    public void carregarDoArquivo(String pathFile) throws FileNotFoundException, JsonProcessingException{
        FilePersistence filepersistence = new FilePersistence();
        String jsonData = filepersistence.loadFromFile(pathFile);
        
        SerializadorReservasJson serializadorJson = new SerializadorReservasJson();
        this.lista_reservas = serializadorJson.fromJson(jsonData);
        
        System.out.println("Reservas carregados com sucesso" + pathFile);
    }

    public List<Reservas> getLista_reservas() {
        return lista_reservas;
    }

    public void setLista_reservas(List<Reservas> lista_reservas) {
        this.lista_reservas = lista_reservas;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.lista_reservas);
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
        final GerenciadorDeReservas other = (GerenciadorDeReservas) obj;
        return Objects.equals(this.lista_reservas, other.lista_reservas);
    }

    @Override
    public String toString() {
       StringBuilder sb = new StringBuilder();
        for (Reservas r : lista_reservas) {
            sb.append(r.toString()).append("\n");
        }
        return sb.toString();
    }
}
