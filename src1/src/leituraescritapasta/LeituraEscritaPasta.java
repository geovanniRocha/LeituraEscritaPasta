package leituraescritapasta;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;

public class LeituraEscritaPasta {

    public static void INICIOA(String[] args) {
        HashMap<Integer, String> path; // = new HashMap<>() ;
        final File folder = new File("c:/POO");
        path = listFilesForFolder(folder);
        for(int i = 0; i < path.size(); i++)
            System.out.println(path.get(i));
        
        
        CreateToFolder(folder, "er");
        ReadForFolder(path);       
    }
    
    public static HashMap<Integer, String> listFilesForFolder(final File folder) {
        Integer i = 0;
        HashMap<Integer, String> caminhos = new HashMap<>() ;
        for (final File fileEntry : folder.listFiles()) {
            if (fileEntry.isDirectory()) {
                listFilesForFolder(fileEntry);
            } else {
                String s = folder.getPath() +"\\" +fileEntry.getName();
                caminhos.put(i, s);
                i++;
                 }
            }
        return caminhos;
    }
    
    public static void CreateToFolder(File folder, String NomeArquivo) {
       String Caminho = folder.getPath() +"/" + NomeArquivo + ".txt";
       PrintWriter writer = null; 
       
        try {
            writer = new PrintWriter(Caminho, "UTF-8");
            writer.flush();
            writer.println("FelipeViado");
            writer.println("Larsete Gay");
            writer.close(); 
        } catch (FileNotFoundException | UnsupportedEncodingException ex) {
           System.out.println(ex.getMessage());
        }       
    }
    
    public static void ReadForFolder(HashMap path) {
       for(int i = 0; i < path.size(); i++){
        String Caminho = (String)path.get(i);
        FileInputStream  fstream = null;
         try{           
             fstream = new FileInputStream(Caminho);
             BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
             while(br.ready())
                 System.out.println(br.readLine());
         }catch(Exception e){
             System.out.println(e.getMessage());
             }
        }
    }
    
    
}
