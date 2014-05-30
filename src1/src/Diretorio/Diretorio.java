/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Diretorio;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.util.*;
import java.util.HashMap;
import static leituraescritapasta.LeituraEscritaPasta.listFilesForFolder;

public class Diretorio{
    
    final private File pasta;
    private Integer selecaoArquivo, Contador = 0;
    private HashMap<Integer, File> Indices;
    String Texto;
    
    Diretorio(final File folder){        
        pasta = folder;
        selecaoArquivo = 0;
        Indices = new HashMap<>();
        for (final File fileEntry : pasta.listFiles()) {
            if (fileEntry.isDirectory()) {
                listFilesForFolder(fileEntry);
            } else {
                String s = pasta.getPath() +"\\" +fileEntry.getName();
                Indices.put(selecaoArquivo, new File(s));
                selecaoArquivo++;
             }
        }        
    }
    
    public HashMap<Integer, File> getHash(){
        return Indices;
    }
    
    public boolean criaArqIndice(HashMap Hash){
       String Caminho = pasta.getPath() +"/Log/Indice.txt";
       
       PrintStream writer = null; 
       try {
            writer = new PrintStream(Caminho);
            for(int i = 0; i < Hash.size(); i++){
                writer.print(i + ";");
                writer.println(Hash.get(i) + ";");
               }
            
        } catch (Exception ex) {
           //System.out.println(ex.getMessage());
           return false;
        } finally {
           writer.close();           
        }     
        
        return true;
    }
    
    public String ProxArqText(){
        Texto = "";
        String temp = "";
        try{
            BufferedReader bf = new BufferedReader(new FileReader(Indices.get(Contador).getPath()));

            while(bf.ready()){            
                temp =  bf.readLine();
                //System.out.println(temp);
                Texto += temp  + " ";
            }
        }catch(Exception e){           
            
        }finally{
         
        } 
        Contador++;
        return temp;
    }
    
    public HashMap pegaArqIndice(){
        HashMap<Integer, File> h = new HashMap<>();
        String Caminho = pasta.getPath() +"/Log/" + "Indice.txt";
        String[] Tokens; 
        Integer ContArquivo = 0;
        try{
        BufferedReader bf = new BufferedReader(new FileReader(Caminho));
        while(bf.ready()){
           Tokens = bf.readLine().split(";" , 0);
           h.put(Integer.parseInt(Tokens[0]), new File(Tokens[1]));        
        }
        }catch(Exception e){

        } 
        return h;
    }
    
    //Dont Work Yet
    public boolean criaArqTexto(String d, String Nome){
       String Caminho = pasta.getPath() +"//" + Nome + ".txt";
       PrintStream writer = null; 
       
        try {
            writer = new PrintStream(Caminho, "UTF-08");
            writer.append(d);
            
        } catch (FileNotFoundException | UnsupportedEncodingException ex) {
           //System.out.println(ex.getMessage());
        } finally{
            try{
            writer.close();
            }catch(Exception e){
                System.err.println(e.getMessage());
            }
        }
        
        return true;
    }
        
     //Dont Work Yet
    public boolean insereIndice(HashMap Hash){
        Contador ++;
        
        return true;
    }
    
    
    
        
}
