
package neander;

public class Port_Xor{
  private boolean bitResultante;
  
  public boolean executar(boolean bit0, boolean bit1){
    
    if(bit0 != bit1 ){
      bitResultante = true;  
    }else{
       bitResultante = false;
    }
    return bitResultante;
  }
  
 
}
