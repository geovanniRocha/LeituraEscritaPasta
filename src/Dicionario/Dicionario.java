/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Dicionario;
/**
 *
 * @author Geovanni Rocha
 */


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Dicionario implements IDicionario{
    
    private static Dicionario dicionario = null;
    
    private List<String> stopWordMap = null ;
    //HashMap<Integer, String> hashTemp;
    private Integer posicaoAtualHash;
    
    public Dicionario(){
        stopWordMap = new ArrayList<>();
        
        posicaoAtualHash = 0;
       
        //hashTemp = new HashMap<>();
    }
    
    static public Dicionario getDicionario(){
        if(dicionario == null){
            dicionario = new Dicionario();
        }     
        return dicionario;
    }
    
    //tolkenMap, é o mapa de tolken
    //stopWordMap, é o hashMap de StopWord
    
    @Override
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
    
    @Override
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
    
    @Override
    public void addStopWord(String word){
      stopWordMap.add(word);
      
    } 
    
    
    @Override
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
