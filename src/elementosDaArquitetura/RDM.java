
package elementosDaArquitetura;

import estruturasBasicas.Registrador8b;

public class RDM {

    private Registrador8b registrador = new Registrador8b();

    public boolean[] executar(boolean[] dadoMemOuAC, boolean clk, boolean cargaRDM) { 

        boolean[] vetValArmazenado = new boolean[8];

        if(cargaRDM == true){
            vetValArmazenado = registrador.executar(dadoMemOuAC, clk);
        }else{
            vetValArmazenado = registrador.executar(dadoMemOuAC, false);
        }
    
    return vetValArmazenado;
    }

    
}
