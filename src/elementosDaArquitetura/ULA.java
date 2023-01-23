
package elementosDaArquitetura;

import estruturasBasicas.Conversor;
import estruturasBasicas.FullAdder8b;
import estruturasBasicas.Port_And;
import estruturasBasicas.Port_Not;
import estruturasBasicas.Port_Or;

public class ULA {

    Conversor converter = new Conversor();
    FullAdder8b somador = new FullAdder8b();
    Port_And and = new Port_And();
    Port_Or or = new Port_Or();
    Port_Not not = new Port_Not();


    public boolean[] executar(boolean[] SelULA, boolean vetAC[], boolean[] vetRDM){

        boolean result[] = new boolean[8];


        int sel = converter.paraInteiro(SelULA);

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

        return result; 
    } 

}
