package file;
import Classes.Carro;
import com.GerenciadorDeCarro.GerenciadorDeCarro;
import java.util.ArrayList;
import java.util.List;

public class SerializadorCSV {
    public String toCSV(List<Carro> carros) {
        String csv = "Marca;Modelo;Ano;Preco;\n";
        for (Carro c : carros) {
            csv += c.getMarca()+ ";"
                + c.getModelo()+ ";"
                + c.getAno()+ ";"
                + c.getPreco()+ ";\n";
        }
        return csv;
    }
    public List<Carro> fromCSV(String data) {
        List<Carro> c = new ArrayList<>();
        
        String[] linhas = data.split("\n");
        
        for (int i = 1; i < linhas.length; i++) {
            String[] partes = linhas[i].split(";");
            if (partes.length >= 4) {
                Carro carro = new Carro();
                carro.setMarca(partes[0]);
                carro.setModelo(partes[1]);
                carro.setAno(Integer.parseInt(partes[3].trim()));
                carro.setPreco(Integer.parseInt(partes[2].trim()));
                
                //apos montar um produto, adiciono na lista
                c.add(carro);
            }
        }
        return c;
    }
}

