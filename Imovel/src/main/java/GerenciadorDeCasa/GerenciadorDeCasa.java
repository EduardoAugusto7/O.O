
package GerenciadorDeCasa;
import classes.Casa;
import file.FilePersistence;
import file.SerializadorCSV;
import file.SerializadorJson;
import file.SerializadorXML;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
import java.util.Objects;
import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement
public class GerenciadorDeCasa {
    private List<Casa> lista_casa = new ArrayList<>();
    
    public GerenciadorDeCasa(){
        this.lista_casa = new ArrayList<>();
    }
  public void adicionar(Casa casa){
        this.lista_casa.add(casa);
        System.out.println("Casa adicionada com sucesso");
    }
    
    public boolean remover(String tipo){
        for(Casa c: lista_casa){
            if(c.getTipo().trim().equals(tipo.trim())){
                lista_casa.remove(c);
            System.out.println("Casa removida com sucesso");
            return true;
            }
        }
        System.out.println("Casa nao encontrado");
        return false;
    }
    
    public Casa buscar(String tipo){
        for(Casa c: lista_casa){
        if(c.getTipo().trim().equalsIgnoreCase(tipo.trim())){
            return c;
        }
    }
    return null;
    }
    
    public void atualizarCasas(String tipoAntigo, Casa novaCasa){
    Casa casaExistente = buscar(tipoAntigo);
    if(casaExistente != null){
        int indice = lista_casa.indexOf(casaExistente);
        lista_casa.set(indice, novaCasa);
        System.out.println("Casa atualizado com sucesso");
    }else{
        System.out.println("Casa com a marca " + tipoAntigo + "nao encontrado");
    }
}    
    
    public void salvarNoArquivo(String pathFile) throws FileNotFoundException, IOException{
        SerializadorCSV serializador = new SerializadorCSV();
        SerializadorXML serializadorXml = new SerializadorXML();
        SerializadorJson serializadorJson = new SerializadorJson();
        String csvData = serializador.toCSV(lista_casa);
        
        FilePersistence filepersistence = new FilePersistence();
        filepersistence.saveToFile(csvData, pathFile);
        System.out.println("Casas salvas com sucesso em " + pathFile);
        
        String xmlData = serializadorXml.ToXML(this);   
        filepersistence.saveToFile(xmlData, "ListaCasas.xml"); 
        System.out.println("Carros salvos com sucesso em " + "ListaCasas.xml");
        
        String jsonData = serializadorJson.toJson(lista_casa);
        filepersistence.saveToFile(jsonData, "ListaCasas.json");
        System.out.println("Carros salvos com sucesso em " + "ListaCasas.json");
    }
    
    public void carregarDoArquivo(String pathFile) throws FileNotFoundException{
        FilePersistence filepersistence = new FilePersistence();
        String csvData = filepersistence.loadFromFile(pathFile);
        
        SerializadorCSV serializadorcsv = new SerializadorCSV();
        this.lista_casa = serializadorcsv.fromCSV(csvData);
        
        System.out.println("Casas carregadas com sucesso" + pathFile);
    }

    public List<Casa> getLista_casa() {
        return lista_casa;
    }

    public void setLista_casa(List<Casa> lista_casa) {
        this.lista_casa = lista_casa;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.lista_casa);
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
        final GerenciadorDeCasa other = (GerenciadorDeCasa) obj;
        return Objects.equals(this.lista_casa, other.lista_casa);
    }
    @Override
    public String toString() {
       StringBuilder sb = new StringBuilder();
        for (Casa c : lista_casa) {
            sb.append(c.toString()).append("\n");
        }
        return sb.toString();
    }
}
