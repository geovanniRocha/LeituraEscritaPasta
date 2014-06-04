
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Main;

import Diretorio.Diretorio;
import Indexador.Indexador;
import Recuperador.Recuperador;
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
        
        Recuperador recuperador = Recuperador.getRecuperador();
        dic.addStopWord("Aa");
        HashMap e;
        Indexador index = Indexador.getIndexador();
        index.index();
        
        e = d.pegaArqIndice();
        
        
        recuperador.recuperar("HK416");
        
        
        
        long end = System.currentTimeMillis();
        System.out.println(end - start +"ms");
    }   
}
