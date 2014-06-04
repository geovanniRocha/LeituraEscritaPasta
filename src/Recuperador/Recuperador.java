/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Recuperador;

import Diretorio.Diretorio;
import java.util.HashMap;


public class Recuperador {
    
    private static Recuperador recuperador = null;
    
    
    private Recuperador(){
        
   
    }
    static public Recuperador getRecuperador(){
        if(recuperador == null)
            recuperador = new Recuperador();
        return recuperador;
    }
    
    public String recuperar(String termo){
        Diretorio d = Diretorio.getDiretorio();
        HashMap hash = d.pegaArqIndice();
        Integer i = 0;
//        while(hash.get(i) != termo){
//          i++;
//        }
//        
        if(hash.containsKey(termo)){
            System.out.println(" " + hash.get(termo));
            System.out.println(" " + termo);
            System.out.println(" In file: " + d.getCorrentFileName());
        }
        return "Correto";
        
    }
    
    
}
