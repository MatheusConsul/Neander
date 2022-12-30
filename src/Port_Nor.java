public class Port_Nor{
  private boolean bitResultante;
  
  public boolean executar(boolean bit0, boolean bit1){
   
    
    if(bit0 == false && bit1 == false ){
      bitResultante = true;  
    }else{
      bitResultante = false;
    }
    
    return bitResultante;
  }
  
}
