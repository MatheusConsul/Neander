
package elementosDaArquitetura;

import estruturasBasicas.Registrador8b;

public class REM {

    private Registrador8b registrador = new Registrador8b();

    public boolean[] executar(boolean[] dadoMux, boolean clk, boolean cargaREM) { 

        boolean[] vetValArmazenado = new boolean[8];

        if(cargaREM == true){
            vetValArmazenado = registrador.executar(dadoMux, clk);
        }else{
            vetValArmazenado = registrador.executar(dadoMux, false);
        }
    
    return vetValArmazenado;
    }

    
}
