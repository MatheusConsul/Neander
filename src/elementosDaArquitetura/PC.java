

package elementosDaArquitetura;

import java.util.Arrays;
import estruturasBasicas.FullAdder8b;

public class PC{
  
  private boolean[] contador = new boolean[8];
  private boolean umBinario[] = {false,false,false,false,false,false,false,true};
  private FullAdder8b somador = new FullAdder8b();
  
  public PC(){
    Arrays.fill(contador,false); // comando para setar todo o vetor com o valor false
  }
  
  public boolean[] executar(boolean cargaPC, boolean incrementaPC, boolean vetRDM[]){

    if(cargaPC == true){
      contador = vetRDM;
    }
    
    if(incrementaPC == true){
      contador = somador.executar(contador, umBinario);
    }
    
    return contador;
  }

}

