package file;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class FilePersistence {
public void saveToFile(String texto, String filePath) throws IOException {        
         try (FileWriter arq = new FileWriter(filePath)) {
             PrintWriter gravarArq = new PrintWriter(arq);
             gravarArq.print(texto);
         }
    }

    public String loadFromFile(String filePath) throws FileNotFoundException {
        String conteudoLido = "";
        
        File file = new File(filePath);
       if(!file.exists()){
           try(FileWriter writer = new FileWriter(file)){
               writer.write("[]");
           }catch(IOException e){
               e.printStackTrace();
           }
           return "[]";
       }
       
        Scanner scanner = new Scanner(file); 
        scanner.useDelimiter("\\Z"); 
        while (scanner.hasNext()) {
            conteudoLido += scanner.next();
        }
        scanner.close();
        if(conteudoLido.trim().isEmpty()){
            return "[]";
        }
        return conteudoLido;
    }
}    
