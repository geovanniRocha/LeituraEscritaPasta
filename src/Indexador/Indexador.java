/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Indexador;

import Dicionario.Dicionario;
import Diretorio.Diretorio;
import Estatistica.Estatistica;
import Parser.Parser;
import java.io.File;
import java.util.HashMap;

/**
 *
 * @author Geovanni Rocha
 */


public class Indexador {
    private static Indexador indexador = null;
    private Indexador(){
        
    }
    
    static public Indexador getIndexador(){
        if(indexador == null)
            indexador = new Indexador();
        return indexador;
    
    }
    
    public void index(){
        final File folder = new File("c://POO");
        
        Diretorio d = Diretorio.getDiretorio(folder);
        Parser p = new Parser();
        
        
        Dicionario dic = Dicionario.getDicionario();
        Estatistica est =Estatistica.getEstatistica();
        String texto;
        HashMap termos;
        HashMap termosLimpo;
        HashMap termosOrdenados;
        HashMap termosFreq;
        String string = "";
        
        for(int i = 0;  i < d.getHash().size(); i++){
            d.ProxArqText();
        
           
            texto = d.getTexto();
            termos = p.Split(texto);
            termosLimpo = dic.removeStopWord(termos);
            termosOrdenados = dic.sort(termosLimpo);
            termosFreq = est.contarFrequencia(termosOrdenados);
            
            
            for(int j = 0;  j < termosFreq.size(); j++){
                string +=(termosOrdenados.get(j) + ";" +termosFreq.get(termosOrdenados.get(j))) + ";";
                //System.err.println(string);
                
            }
           d.criaArqIndice(string);
          
        }   
            
        
        /**
        h = dic.removeStopWord(p.Split(d.getTexto()));
        e = est.contarFrequencia(h);
        for(int i = 0;  i < h.size(); i++)
            System.err.println(h.get(i));
        **/
        
        
    }
    
    
}
