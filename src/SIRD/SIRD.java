/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package SIRD;

import Recuperador.Recuperador;

/**
 *
 * @author Geovanni Rocha
 */
public class SIRD {
    
    static private SIRD sird = null ;
     
    
    private SIRD(){
        
        
    }
    
    public static SIRD getSird(){
        if(sird == null)
            sird = new SIRD();
    
        return sird;
    }
    public String recuperar(String termo){
        return Recuperador.getRecuperador().recuperar(termo);
    }
    
}
