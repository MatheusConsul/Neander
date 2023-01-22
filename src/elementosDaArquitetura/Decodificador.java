package elementosDaArquitetura;

public class Decodificador {


    public boolean[] executar(boolean[] vetRDM, boolean cargaRI){
        
        boolean opCode[] = new boolean[4];

        opCode[0] = vetRDM[0];
        opCode[1] = vetRDM[1];
        opCode[2] = vetRDM[2];
        opCode[3] = vetRDM[4];
    
      return opCode;
       
      } 


    
}
