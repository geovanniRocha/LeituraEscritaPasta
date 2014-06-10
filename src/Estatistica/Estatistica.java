/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Estatistica;

import java.util.HashMap;

/**
 *
 * @author Geovanni Rocha
 */

public class Estatistica {
    
    static private Estatistica estatistica = null;
    private HashMap<String, Integer> hashMap;
    
    Estatistica(){
        hashMap = new HashMap<>();
    }
        
    static public Estatistica getEstatistica(){
        if(estatistica == null)
            estatistica = new Estatistica();
        return estatistica;
    }
    
    //return the string and the number of timer of repetitions
    public HashMap<String, Integer> contarFrequencia(HashMap<Integer, String> tolkenMap){
        HashMap<String, Integer> freqMap = new HashMap<>();
        //HashMap<Integer, HashMap> indices = new HashMap<>();
        Integer i = 0, c;
        String x;
        while(i < tolkenMap.size()){
            x = tolkenMap.get(i);
            c = 0;
            while(i < tolkenMap.size() && x.equals(tolkenMap.get(i))){
                c++;
                i++;
            }
            
            freqMap.put(x, c);
            
        }
        
        return freqMap;
    }
   
    
    
}
