/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Usuario;

import SIRD.SIRD;

/**
 *
 * @author Felipe Hunas
 */
public class Usuario {
  public Usuario (){
    
}
  public void recuperar(String consulta){
      System.out.println("Recuperando texto reerente a consulta");
      SIRD.getSird().recuperar(consulta);    
  }
  
}
