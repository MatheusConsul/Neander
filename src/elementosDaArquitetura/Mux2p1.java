// Classe que vai implementar um mux 2:1
// seleciona atravez da variavel "sel" qual vetor vai recebido (vetPC e vetRDM) qual vai 
// ser repassado para a saida "vetResultante"

package elementosDaArquitetura;

public class Mux2p1{

  public boolean[] executar(boolean vetPC[], boolean vetRDM[], boolean sel){

    boolean vetResultante[] = {false,false,false,false,false,false,false,false};
    
    if(sel == false){

      vetResultante = vetPC;
      
    }else if(sel == true){

      vetResultante = vetRDM;
      
    }else{
      System.out.println("\n\n Erro no mux!!!\n\n");
    }

    return vetResultante;

  }




  

  
  /*Decod(S0,S1);
  /*String op;
  if(S0 == true){
    op = "1";
  }else{
    op="0";
  }
  if(S1 == true ){
    op += 1;
  }else{
    op +=0;
  }*/
  



  
}