/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Diretorio;

import Parser.Parser;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;

public class Diretorio{
    
    private static Diretorio dir = null;
    final private File pasta;
    private Integer selecaoArquivo, Contador = 0;
    private HashMap<Integer, File> Indices;
    private String Texto;
    PrintStream writer = null; 
    
    private Diretorio(final File folder){        
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
        String caminho = pasta.getPath() +"/Log/" + "Indice.txt";
        try{writer = new PrintStream(caminho);}
        catch(Exception e){ System.err.println(e.getMessage());}
    }
    
    static public Diretorio getDiretorio(final File folder)
    {
     if(dir == null)
         dir = new Diretorio(folder);
     
     return dir;
    }
    
    static public Diretorio getDiretorio()
    {
     if(dir == null)
         dir = new Diretorio(new File("c://POO"));
     
     return dir;
    }
    
    
    public HashMap<Integer, File> getHash(){
        return Indices;
    }
    
    public boolean criaArqIndice(String string){
       
       
       try {
            //PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter(caminho, true)));
            //out.println(string);
           
           writer.append(string);
                //writer.println(Hash.get(i) + ";");
               
            
        } catch (Exception ex) {
           //System.out.println(ex.getMessage());
           return false;
        } finally {
           /**
           try{
           out.close();
           }catch(Exception e){
               System.err.println(e.getMessage());
           }
           **/
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
        //HashMap<Integer, File> h = new HashMap<>();
        String Caminho = pasta.getPath() +"/Log/" + "Indice.txt";
        String Tokens = ""; 
         BufferedReader bf = null;
        Integer ContArquivo = 0, i = 0;
        try{
        bf = new BufferedReader(new FileReader(Caminho));
 
            while(bf.ready()){               
               Tokens += bf.readLine();


            }
        }catch(Exception e){
            System.out.println("Error");
        } finally{
            try{
            bf.close();
            }catch(Exception e){
                System.err.println("FailClose");
            }
            
        }
        
        Parser p = new Parser();
        HashMap h = p.Split(Tokens, ";");
        
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
        
    public String getTexto(){
        return Texto;
    }

    private  HashMap<Integer, String> listFilesForFolder(final File folder) {
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
    
    
    
        
}
