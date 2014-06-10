
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Main;

import Dicionario.Dicionario;
import Diretorio.Diretorio;
import Indexador.Indexador;
import Recuperador.Recuperador;
import java.util.HashMap;
import Usuario.Usuario;

/**
 *
 * @author Geovanni Rocha
 */

public class Main {
    
    public static void main(String[] args){
        long start = System.currentTimeMillis();
 
        Diretorio d = Diretorio.getDiretorio();
         
        Dicionario dic = Dicionario.getDicionario();
        
        Recuperador recuperador = Recuperador.getRecuperador();
        Usuario usuario = new Usuario();
        dic.addStopWord("HH");
        HashMap e;
        Indexador index = Indexador.getIndexador();
        index.index();
        
        e = d.pegaArqIndice();
        
        
        usuario.recuperar("AA");
        
        
        
        long end = System.currentTimeMillis();
        System.out.println(end - start +"ms");
    }   
}
