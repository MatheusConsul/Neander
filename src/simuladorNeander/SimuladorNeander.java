
package simuladorNeander;

import elementosDaArquitetura.*;
import estruturasBasicas.Conversor;

public class SimuladorNeander {

    Conversor converter = new Conversor();

    UnidadeControle uControle = new UnidadeControle();
    Decodificador decodificador = new Decodificador();
    Memoria memoria = new Memoria();
    Mux2p1 mux = new Mux2p1();
    RDM rdm = new RDM();
    REM rem = new REM();
    ULA ula = new ULA();
    PC pc = new PC();
    Ac ac = new Ac();
    


    public void executar(){

        // sinais de controle
        boolean clock = true;
        boolean hlt = false;
        boolean flagN = ula.getN();
        boolean flagZ = ula.getZ();
        boolean selUla[] = new boolean[3];
        boolean cargaNZ = true;
        boolean cargaAC = false;
        boolean cargaRI = true;
        boolean cargaRDM = true;
        boolean write = false;
        boolean read = true;
        boolean cargaREM = true;
        boolean sel = false;
        boolean cargaPC = false;
        boolean incrementaPC = true;

        // fios/conexões da sainda para a entrada de cada estrutura
        boolean returnPC[] = new boolean[8];
        boolean returnMux[] = new boolean[8];
        boolean returnREM[] = new boolean[8];
        boolean returnMemoria[] = new boolean[8];
        boolean returnRDM[] = new boolean[8];
        boolean returnDecod[] = new boolean[4];
        boolean returnULA[] = new boolean[8];
        boolean returnAC[] = new boolean[8];
        boolean returnUniControle[] = new boolean[13];



        do{

            returnPC = pc.executar(cargaPC, incrementaPC,returnRDM);
            returnMux = mux.executar(returnPC, returnRDM, sel);
            returnREM = rem.executar(returnMux,clock,cargaREM);
            returnMemoria = memoria.executar(read, write, returnREM, returnRDM);
            returnRDM = rdm.executar(returnMemoria, clock, cargaRDM);
  
            returnDecod = decodificador.executar(returnRDM,cargaRI);
            returnUniControle = uControle.executar(returnDecod, flagN, flagZ, clock);
            
            selUla[0] =     returnUniControle[0];
            selUla[1] =     returnUniControle[1];
            selUla[2] =     returnUniControle[2];
            cargaNZ =       returnUniControle[3];
            cargaAC =       returnUniControle[4];
            cargaRI =       returnUniControle[5];
            cargaRDM =      returnUniControle[6];
            write =         returnUniControle[7];
            read =          returnUniControle[8];
            cargaREM =      returnUniControle[9];
            sel =           returnUniControle[10];
            cargaPC =       returnUniControle[11];
            incrementaPC =  returnUniControle[12];
            hlt =           returnUniControle[13];

            if(read == true){ // carregar dado da memoria

                returnPC = pc.executar(cargaPC, incrementaPC, returnRDM);
                returnMux = mux.executar(returnPC, returnRDM, sel);
                returnREM = rem.executar(returnMux,clock,cargaREM);
                returnMemoria = memoria.executar(read, write, returnREM, returnRDM);
                returnRDM = rdm.executar(returnMemoria, clock, cargaRDM);

            }else if(write == true){ // salvar dado na memoria

                returnPC = pc.executar(cargaPC, incrementaPC, returnRDM );
                returnMux = mux.executar(returnPC, returnRDM, sel);
                returnREM = rem.executar(returnMux,clock,cargaREM);
                returnRDM = rdm.executar(returnAC, clock, cargaRDM);
                returnMemoria = memoria.executar(read, write, returnREM, returnRDM);

            }else if(selUla[0]==false && selUla[1]== true && selUla[2]== true){ // operação NOT
                // Não incrementa PC para não pular a proxima instrução

            }else{  // condição falsa do JMP 
                returnPC = pc.executar(cargaPC, incrementaPC, returnRDM );
            }

            returnULA = ula.executar(selUla, cargaNZ, returnAC, returnRDM);
            flagN = ula.getN();
            flagZ = ula.getZ();
            returnAC = ac.executar(returnULA, clock, cargaAC);


        }while(!hlt);




    }



    
}
