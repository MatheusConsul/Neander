
package estruturasBasicas;

public class Port_Not {
  private boolean bitResultante;
  
  public boolean executar(boolean bit0){
    
   if(bit0 == false){
      bitResultante = true;  
    }else{
      bitResultante = false;
    }
    return bitResultante;
   }
  
}
