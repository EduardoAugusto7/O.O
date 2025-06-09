package com.GerenciadorDeCarro;
import Classes.Carro;
import file.FilePersistence;
import file.SerializadorCSV;
import file.SerializadorXML;
import file.SerializadorJson;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
import java.util.Objects;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class GerenciadorDeCarro {
    private List<Carro> lista_carros = new ArrayList<>();
    
    public GerenciadorDeCarro(){
        this.lista_carros = new ArrayList<>();
    }
    public void adicionar(Carro carro){
        this.lista_carros.add(carro);
        System.out.println("Carro adicionada com sucesso");
    }
    
    public boolean remover(String marca){
        for(Carro c: lista_carros){
            if(c.getMarca().trim().equals(marca.trim())){
                lista_carros.remove(c);
            System.out.println("Carro removida com sucesso");
            return true;
            }
        }
        System.out.println("Carro nao encontrado");
        return false;
    }
    
    public Carro buscar(String marca){
        for(Carro c: lista_carros){
        if(c.getMarca().trim().equalsIgnoreCase(marca.trim())){
            return c;
        }
    }
    return null;
    }
    
    public void atualizarCarros(String marcaAntiga, Carro novoCarro){
    Carro carroExistente = buscar(marcaAntiga);
    if(carroExistente != null){
        int indice = lista_carros.indexOf(carroExistente);
        lista_carros.set(indice, novoCarro);
        System.out.println("Carro atualizado com sucesso");
    }else{
        System.out.println("Carro com a marca " + marcaAntiga + "nao encontrado");
    }
}    
    
    public void salvarNoArquivo(String pathFile) throws FileNotFoundException, IOException{
        SerializadorCSV serializador = new SerializadorCSV();
        SerializadorXML serializadorXml = new SerializadorXML();
        SerializadorJson serializadorJson = new SerializadorJson();
        String csvData = serializador.toCSV(lista_carros);
        FilePersistence filepersistence = new FilePersistence();
        filepersistence.saveToFile(csvData, pathFile);
        System.out.println("Carros salvos com sucesso em " + pathFile);
        
         String xmlData = serializadorXml.ToXML(this);   
        filepersistence.saveToFile(xmlData, "ListaCarros.xml"); 
        System.out.println("Carros salvos com sucesso em " + "ListaCarros.xml");
        
        String jsonData = serializadorJson.toJson(lista_carros);
        filepersistence.saveToFile(jsonData, "ListaCarros.json");
        System.out.println("Carros salvos com sucesso em " + "ListaCarros.json");
    }
    
    public void carregarDoArquivo(String pathFile) throws FileNotFoundException{
        FilePersistence filepersistence = new FilePersistence();
        String csvData = filepersistence.loadFromFile(pathFile);
        
        SerializadorCSV serializadorcsv = new SerializadorCSV();
        this.lista_carros = serializadorcsv.fromCSV(csvData);
        
        System.out.println("Carros carregadas com sucesso" + pathFile);
    }
    /*

    public void salvarNoArquivo() throws IOException { 
        FilePersistence filePersistence = new FilePersistence();       
        SerializadorXML serializadorXml = new SerializadorXML();     
        String xmlData = serializadorXml.ToXML(this);   
        filePersistence.saveToFile(xmlData, "ListaCarros.xml"); 
        System.out.println("Carros salvos com sucesso em " + "ListaCarros.xml");
    }
    
    
    public void carregarDoArquivo(String filepath) throws FileNotFoundException {
        FilePersistence filePersistence = new FilePersistence();
        String xmlData = filePersistence.loadFromFile(filepath);

        SerializadorXML desserializadorXML = new SerializadorXML();
        this.lista_carros = desserializadorXML.fromXML(xmlData).lista_carros;

        System.out.println("Carros carregados com sucesso de " + filepath);

    }
   */
    
    public List<Carro> getLista_carros() {
        return lista_carros;
    }

    public void setLista_carros(List<Carro> lista_carros) {
        this.lista_carros = lista_carros;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.lista_carros);
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
        final GerenciadorDeCarro other = (GerenciadorDeCarro) obj;
        return Objects.equals(this.lista_carros, other.lista_carros);
    }
    @Override
    public String toString() {
       StringBuilder sb = new StringBuilder();
        for (Carro c : lista_carros) {
            sb.append(c.toString()).append("\n");
        }
        return sb.toString();
    }
}
