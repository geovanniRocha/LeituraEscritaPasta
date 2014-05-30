
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Main;

import Diretorio.Diretorio;
import Indexador.Indexador;
import java.util.HashMap;

/**
 *
 * @author Carlos
 */
public class Main {
    
    public static void main(String[] args){
        long start = System.currentTimeMillis();
 
        Diretorio d = Diretorio.getDiretorio();
         
        Dicionario.Dic dic = Dicionario.Dic.getDicionario();
        HashMap e;
        Indexador index = Indexador.getIndexador();
        index.index();
        
        e = d.pegaArqIndice();
        
        for(int i =0;i < e.size(); i+=2)
            System.out.println(e.get(i) + " - " + e.get(i+1));
        
        
        
        long end = System.currentTimeMillis();
        System.out.println(end - start +"ms");
    }   
}
