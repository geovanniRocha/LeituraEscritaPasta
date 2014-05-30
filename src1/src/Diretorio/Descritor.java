/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Diretorio;


public class Descritor {
    
    private static Descritor descritor = null;
    String Texto = "";
    String Caminho = "";
    
    private Descritor(){
        int  i = 0;
    
        
    }
    
    public void setPath(String caminho){
        Caminho = caminho;
    }
    
    
    public static Descritor getInstance(){
        if(descritor ==  null)
            descritor = new Descritor();
        return descritor;
    }
    
    Descritor(int i){
        
    }
    
    
    
    
    public String pegaTexto(){
            return Texto;
    } 
    
    
}
