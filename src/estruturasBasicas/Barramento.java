// classe que converte o vetor de boolean para uma string 

package estruturasBasicas;

public class Barramento{ 
   
  
  public String executar(boolean[] S1){ 
    String cod = "";
    
    for(int i = 0 ; i< 8; i++){ 
      
      if(S1[i] == true){ 
        cod += "1 ";
      }
      if(S1[i] == false){ 
        cod += "0 ";
      }
  
  }
  return cod;
  }
  
}