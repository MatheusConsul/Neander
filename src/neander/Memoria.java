
package neander;

import java.util.ArrayList;

public class Memoria{
//private ArrayList<String> instrucao = new ArrayList<String>(); 
private ArrayList<String> dados = new ArrayList<String>();

private String inst;
private String val;
private boolean instru;
//private int cont = 0;
  
 Memoria(String instrucao, String valor){
  inst = instrucao; 
  val = valor; 
  setinst(inst);
  setvalor(val);
   //cont++;
  
}
  
  protected void setinst(String a) {
  // adicionar até a metade da memoria 
    inst = a;
  } 
  
	protected void setvalor(String val) { 
    // adicionar apartir da metade da memoria 
     dados.add(val);
  } 
  
  public boolean getinst() { 
    
    
    return instru; 
  } 

  public boolean setinst2(String inst){
    if(inst != "00")
    instru = true;
    else
    instru = false; 
    
    return instru;
  }
  
	public String getvalor(){ 
   
    return val; 
    
  }
}