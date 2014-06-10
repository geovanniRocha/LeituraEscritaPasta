

package Recuperador;

import Dicionario.Dicionario;
import Diretorio.Diretorio;
import Estatistica.Estatistica;
import java.util.HashMap;

/**
 *
 * @author Geovanni Rocha
 */


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
        double i = 0;
        Dicionario dic = Dicionario.getDicionario();
        hash = dic.sort(hash);
        Estatistica es = Estatistica.getEstatistica();
        hash = es.contarFrequencia(hash);
        
        i = log()/log(2);
        if(hash.containsKey(termo)){
            System.out.println(" " + hash.get(termo));
            System.out.println(" " + termo);
            System.out.println("Indice de Frequencia do termo: " + );
            //System.out.println(" In file: " + d.getCorrentFileName());
        }
        return "Correto";
        
    }
    
    
}
