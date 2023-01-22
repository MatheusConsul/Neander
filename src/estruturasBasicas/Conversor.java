// classe que converte o vetor de boolean para uma string e outros formatos

package estruturasBasicas;

import java.util.Arrays;

public class Conversor{ 
   
  
  public String paraString(boolean[] S1){ 
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

  public int paraInteiro(boolean[] S1){
    int valor = 0;

      if(S1[7] == true){
        valor += 1;
      }
      if(S1[6] == true){
        valor += 2;
      }
      if(S1[5] == true){
        valor += 4;
      }
      if(S1[4] == true){
        valor += 8;
      }
      if(S1[3] == true){
        valor += 16;
      }
      if(S1[2] == true){
        valor += 32;
      }
      if(S1[1] == true){
        valor += 64;
      }
      if(S1[0] == true){
        valor += 128;
      }

    return valor;
  }

  public boolean[] paraVetBoolean(int valor){
    boolean vetResult[] = {false,false,false,false,false,false,false,false};
    boolean vetAux[] = {false,false,false,false,false,false,false,false};

    if(valor < 256 && valor > 0){
      int resulDivi = 0;
      int restoDivi = 0;
      

      for(int i = 0; i < 8; i++){

        resulDivi = (int)valor/2;
        restoDivi = valor%2;

        if(resulDivi > 0){
          if(restoDivi == 1){
            vetAux[i] = true;
            valor = resulDivi;
          }else{
            vetAux[i] = false;
            valor = resulDivi;
          }

        }else if(resulDivi == 0){
          vetAux[i] = true;
          i = 10;
        }

      }

      int j = 7;
      for(int x = 0; x < 8; x++){
        vetResult[j] = vetAux[x];
        j--;
      }

    }else if(valor == 0){
      Arrays.fill(vetResult, false);
    }else{
      System.out.println("\n\n ERRO NA CONVERSOR VALOR MAIOR QUE A REPRESENTAÇÃO");
    }


    return vetResult;
  }


  
}