package file;
import classes.Casa;
import GerenciadorDeCasa.GerenciadorDeCasa;
import java.util.ArrayList;
import java.util.List;

public class SerializadorCSV {
    public String toCSV(List<Casa> casas) {
        String csv = "Tipo;Quartos;Banheiro;Area;Preco;\n";
        for (Casa c : casas) {
            csv += c.getTipo()+ ";"
                + c.getQuartos()+ ";"
                + c.getBanheiros()+ ";"
                + c.getPreco()+ ";\n";
        }
        return csv;
    }
    public List<Casa> fromCSV(String data) {
        List<Casa> c = new ArrayList<>();
        
        String[] linhas = data.split("\n");
        
        for (int i = 1; i < linhas.length; i++) {
            String[] partes = linhas[i].split(";");
            if (partes.length >= 4) {
                Casa casa = new Casa();
                casa.setTipo(partes[0]);
                casa.setQuartos(Integer.parseInt(partes[1].trim()));
                casa.setBanheiros(Integer.parseInt(partes[2].trim()));
                casa.setPreco(Integer.parseInt(partes[3].trim()));
               
                c.add(casa);
            }
        }
        return c;
    }
}
