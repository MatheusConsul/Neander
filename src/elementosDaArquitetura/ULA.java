
package elementosDaArquitetura;

import estruturasBasicas.Conversor;

public class ULA {

    Conversor converter = new Conversor(); // objeto usado para converte de boolean(binario) para inteiro


    public boolean[] executar(boolean[] SelULA, boolean vetAC[], boolean vetRDM){

        boolean result[] = new boolean[4];

        int sel = converter.paraInteiro(SelULA);

            switch(sel){

                case 0:

                    break;
                case 1:

                    break;
                case 2:

                    break;
                case 3:

                    break;
                case 4:

                    break;
                default:

                    break;
            }
        
       





        return result; 
    } 


    
}
