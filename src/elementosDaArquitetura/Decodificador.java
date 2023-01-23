package elementosDaArquitetura;

public class Decodificador {


    public boolean[] executar(boolean[] vetRDM, boolean cargaRI){
        
        boolean opCode[] = new boolean[4];

        if(cargaRI == true){
          opCode[0] = vetRDM[0];
          opCode[1] = vetRDM[1];
          opCode[2] = vetRDM[2];
          opCode[3] = vetRDM[3];
        }else{
          opCode[0] = false;
          opCode[1] = false;
          opCode[2] = false;
          opCode[3] = false;
        }
    
      return opCode;
       
      } 


    
}
