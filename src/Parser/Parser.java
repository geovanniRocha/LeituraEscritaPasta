/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Parser;

import java.util.HashMap;
import java.util.StringTokenizer;

/**
 *
 * @author Carlos
 */
public class Parser {
    private String texto;
    
    public Parser(){
        
    }
    
    public HashMap<Integer, String> Split(String s){
        
        Integer quantidadeTolken = 0;
        HashMap<Integer, String> v = new HashMap<>();
        StringTokenizer stt = new StringTokenizer(s," .,;:");

            while (stt.hasMoreTokens()){
                String token = stt.nextToken();
                v.put(quantidadeTolken, token);
                quantidadeTolken++;
                
            }
        
        return v;
    }    
    
    public HashMap<Integer, String> Split(String s, String delimitador){
        
        Integer quantidadeTolken = 0;
        HashMap<Integer, String> v = new HashMap<>();
        StringTokenizer stt = new StringTokenizer(s,delimitador);

            while (stt.hasMoreTokens()){
                String token = stt.nextToken();
                v.put(quantidadeTolken, token);
                quantidadeTolken++;
                
            }
        
        return v;
    }
    
}
