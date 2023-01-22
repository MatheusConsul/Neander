
package elementosDaArquitetura;

import estruturasBasicas.Registrador8b;

public class Ac {

    private Registrador8b registrador = new Registrador8b();

    public boolean[] executar(boolean[] dadoULA, boolean clk, boolean cargaAC) { 

        boolean[] vetValArmazenado = new boolean[8];

        if(cargaAC == true){
            vetValArmazenado = registrador.executar(dadoULA, clk);
        }else{
            vetValArmazenado = registrador.executar(dadoULA, false);
        }
    
    return vetValArmazenado;
    }


    
}
