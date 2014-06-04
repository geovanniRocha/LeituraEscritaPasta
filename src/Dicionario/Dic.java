/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Dicionario;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Dic{
    
    private static Dic dicionario = null;
    
    private List<String> stopWordMap = null ;
    //HashMap<Integer, String> hashTemp;
    private Integer posicaoAtualHash;
    
    public Dic(){
        stopWordMap = new ArrayList<>();
        
        posicaoAtualHash = 0;
       
        //hashTemp = new HashMap<>();
    }
    
    static public Dic getDicionario(){
        if(dicionario == null){
            dicionario = new Dic();
        }     
        return dicionario;
    }
    
    //tolkenMap, é o mapa de tolken
    //stopWordMap, é o hashMap de StopWord
    
    public HashMap removeStopWord(HashMap<Integer, String> tolkenMap){
        Integer i , pos = 0;
        boolean finded;
        HashMap<Integer, String> hashTemp = new HashMap<>();
        
        for(i = 0; i <tolkenMap.size(); i++){
           finded = isStopWord(tolkenMap.get(i));
           if(!finded){
               hashTemp.put(pos, tolkenMap.get(i));
               pos++;
           }
        }
        
        return hashTemp;        
    }
    
    public boolean isStopWord(String word){
        Integer i = 0;
        boolean find = false;
        while(!find && i < stopWordMap.size()){
            //if(word.compareTo(stopWordMap.get(i)) == 0)
            if(word.compareToIgnoreCase(stopWordMap.get(i)) == 0)
                find = true;
            i++;
        }   
        return find;
    }
    
    public void addStopWord(String word){
      stopWordMap.add(word);
      
    }
    
     public void addStopWord(int Ascii){
      stopWordMap.add(String.copyValueOf(Character.toChars(Ascii)));
         System.err.println(String.copyValueOf(Character.toChars(Ascii)));
    }
    
    
    public HashMap<Integer,String> sort(HashMap<Integer, String> tolkenMap){
        HashMap<Integer,String> tempHash = new HashMap<>();
        
       String Hue[] = new String[tolkenMap.size()];
        for(int i = 0; i < tolkenMap.size(); i++){
        Hue[i] = (String)tolkenMap.get(i);

        }
        Arrays.sort(Hue);
        for(int i = 0; i < tolkenMap.size(); i++){
           tempHash.put(i, Hue[i]);
        }
        return tempHash;
        
        
    }
    
}
