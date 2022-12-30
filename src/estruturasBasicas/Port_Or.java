
package estruturasBasicas;

public class Port_Or{
  private boolean bitResultante;
  
  public boolean executar(boolean bit0, boolean bit1){
 
    if(bit0 == false && bit1 == false ){
      bitResultante = false;  
    }else{
      bitResultante = true;
    }
  
    return bitResultante;
  }
  
  
}
