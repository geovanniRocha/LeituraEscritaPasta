/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Dicionario;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.TreeSet;

public class Dic{
    
    private static Dic dicionario = null;
    
    List<String> stopWordMap = null ;
    //HashMap<Integer, String> hashTemp;
    Integer posicaoAtualHash;
    
    public Dic(){
        stopWordMap = new ArrayList<>();
        stopWordMap.add("AA");
        stopWordMap.add("BB");
        
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
        Integer i = 0, pos = 0;
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
    Integer i =0;
    boolean find = false;
        while(!find && i < stopWordMap.size()){
            if(word.compareTo(stopWordMap.get(i)) == 0)
                find = true;
            i++;
        }   
        return find;
    }
    
    public void addStopWord(String word){
      stopWordMap.add(word);
      
    }
    
}
