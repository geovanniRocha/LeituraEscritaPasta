
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Diretorio;

import Dicionario.Dic;
import Parser.Parser;
import java.io.File;
import java.util.HashMap;

/**
 *
 * @author Carlos
 */
public class Main {
    
    public static void main(String[] args){
        long start = System.currentTimeMillis();
        
        final File folder = new File("c://POO");
        Diretorio d = new Diretorio(folder);
        String[] Hue = null;
        Dic dic = Dic.getDicionario();
        
        /**
        d.ProxArqText();
        Hue = d.Texto.split(" ");
        Arrays.sort(Hue);
        for(int i = 0; i < Hue.length ; i++)
        System.out.println(Hue[i]);
        **/
       
       
       
        //d.criaArqTexto("HUte", "Nome");
        //d.criaArqTexto("HUte Hueueu", "Nome");
        
        Parser p = new Parser();
        HashMap h = d.getHash();
        HashMap h1, h2;
        for(int i = 0;  i < h.size(); i++){
            d.ProxArqText();
        }
        dic.addStopWord("HH");
        h1 = p.Split(d.Texto);

        h2 = dic.removeStopWord(h1);
        
        for(int i = 0;  i < h2.size(); i++)
            System.err.println(h2.get(i) + " " + i);
   
         
        
        long end = System.currentTimeMillis();
        System.out.println(end - start +"ms");
    }   
}
