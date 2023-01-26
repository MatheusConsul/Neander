
package elementosDaArquitetura;

import estruturasBasicas.Conversor;
import estruturasBasicas.FullAdder8b;
import estruturasBasicas.Port_And;
import estruturasBasicas.Port_Not;
import estruturasBasicas.Port_Or;
import estruturasBasicas.Flip_Flop_d;

public class ULA {

    Conversor converter = new Conversor();
    FullAdder8b somador = new FullAdder8b();
    Port_And and = new Port_And();
    Port_Or or = new Port_Or();
    Port_Not not = new Port_Not();
    Flip_Flop_d flagN = new Flip_Flop_d();
    Flip_Flop_d flagZ = new Flip_Flop_d();


    public boolean[] executar(boolean[] selULA, boolean cargaNZ, boolean vetAC[], boolean[] vetRDM){

        boolean result[] = {false,false,false,false,false,false,false,false};

        int sel = converter.paraInteiro(selULA);

            switch(sel){

                case 0:
                    result = somador.executar(vetAC, vetRDM);
                    break;
                case 1:
                    for(int i = 0; i < 8; i++){
                        result[i] = and.executar(vetAC[i],vetRDM[i]);
                    }
                    break;
                case 2:
                    for(int i = 0; i < 8; i++){
                    result[i] = or.executar(vetAC[i],vetRDM[i]);
                    }
                    break;
                case 3:
                    for(int i = 0; i < 8; i++){
                    result[i] = not.executar(vetAC[i]);
                    }
                    break;
                case 4:
                    result = vetRDM;
                    break;
                default:
                    System.out.println("Erro na seleção da operação da ula");
                    break;
            }
            
            if(cargaNZ == true){

                int res = converter.paraInteiro(result);

                if(res == 0){
                    flagZ.executar(true,true);
                }else{
                    flagZ.executar(false,true);
                }

                if(result[0] == true){
                    flagN.executar(true,true);
                }else{
                    flagN.executar(false,true);
                }

            }
            

        return result; 
    }

    public boolean getN(){
        boolean n = flagN.executar(false,false);
        return n;
    }

    public boolean getZ(){
        boolean z = flagZ.executar(false,false);
        return z;
    }

}
