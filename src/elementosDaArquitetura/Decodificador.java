package elementosDaArquitetura;

public class Decodificador {

    private boolean opCode[] = {false,false,false,false};


    public boolean[] executar(boolean[] vetRDM, boolean cargaRI){

      if(cargaRI == true){
        opCode[0] = vetRDM[0];
        opCode[1] = vetRDM[1];
        opCode[2] = vetRDM[2];
        opCode[3] = vetRDM[3];
      }
    
      return opCode; 
    } 
    
}
