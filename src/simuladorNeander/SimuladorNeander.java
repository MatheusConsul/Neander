
package simuladorNeander;

import elementosDaArquitetura.*;
import estruturasBasicas.Conversor;

public class SimuladorNeander {

    private Conversor converter = new Conversor();

    // Elementos da Arquitetura do Neander
    private UnidadeControle uControle = new UnidadeControle();
    private Decodificador decodificador = new Decodificador();
    private Memoria memoria = new Memoria();
    private Mux2p1 mux = new Mux2p1();
    private RDM rdm = new RDM();
    private REM rem = new REM();
    private ULA ula = new ULA();
    private PC pc = new PC();
    private Ac ac = new Ac();

    public boolean executarCompleto(){

        // sinais de controle
        int contPC = 0;
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

        
        System.out.println(" >>>>>>> TESTE DO SIMULADOR COMPLETO: <<<<<<<<");
        
        
        boolean posicaoREM[] = new boolean[8];
        boolean dadoMemoria[] = new boolean[8];
        boolean dadoRDM[] = {true,true,false,false,true,true,false,false};
        
        System.out.println(" >>>MEMORIA COMPLETA ANTES DA EXECUÇÃO: ");
        for(int i =0; i<20;i++){
            posicaoREM = converter.paraVetBoolean(i);
            dadoMemoria = memoria.executar(true,false, posicaoREM,dadoRDM);
            System.out.println(" POSIÇÃO " + i + " : " + converter.paraInteiro(dadoMemoria));
        
        }


        
        System.out.println(" >>>>>>>>>>>>>>> FIM MEMORIA ");
        //int z =0;

        do{
            
            System.out.println(" ########### DENTRO DO DO WHILE HLT>>: "+ hlt);

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
            System.out.println("selUla[0] : " + selUla[0]);
            System.out.println("selUla[1] : " + selUla[1]);
            System.out.println("selUla[2] : " + selUla[2]);
            System.out.println("cargaNZ : " + cargaNZ);
            System.out.println("cargaAC : " + cargaAC);
            System.out.println("cargaRI : " + cargaRI);
            System.out.println("cargaRDM : " + cargaRDM);
            System.out.println("write : " + write);
            System.out.println("read : " + read);
            System.out.println("cargaREM : " + cargaREM);
            System.out.println("sel : " + sel);
            System.out.println("cargaPC : " + cargaPC);
            System.out.println("incrementaPC : " + incrementaPC);
            System.out.println(" hlt : " +  hlt);


            if(read == true){ // carregar dado da memoria

                returnPC = pc.executar(cargaPC, incrementaPC, returnRDM);
                returnMux = mux.executar(returnPC, returnRDM, sel);
                returnREM = rem.executar(returnMux,clock,cargaREM);
                returnMemoria = memoria.executar(read, write, returnREM, returnRDM);
                
                returnRDM = rdm.executar(returnMemoria, clock, cargaRDM);
                returnMux = mux.executar(returnPC, returnRDM, true);
                returnREM = rem.executar(returnMux,clock,cargaREM);
                returnMemoria = memoria.executar(read, write, returnREM, returnRDM);
                returnRDM = rdm.executar(returnMemoria, clock, cargaRDM);

                System.out.println(" ++++++ Leitura na memoria posi: " + converter.paraInteiro(returnREM) +  " dado: " +converter.paraInteiro(returnRDM));

            }else if(write == true){ // salvar dado na memoria

                returnPC = pc.executar(cargaPC, incrementaPC, returnRDM );
                returnMux = mux.executar(returnPC, returnRDM, sel);
                returnREM = rem.executar(returnMux,clock,cargaREM);
                returnMemoria = memoria.executar(true, false, returnREM, returnRDM);
                returnRDM = rdm.executar(returnMemoria, clock, cargaRDM);
                returnMux = mux.executar(returnPC, returnRDM, true);
                returnREM = rem.executar(returnMux,clock,cargaREM);
                returnRDM = rdm.executar(returnAC, clock, cargaRDM);
                System.out.println(" ++++++ Escrita na memoria posi: " + converter.paraInteiro(returnREM) +  " dado: " +converter.paraInteiro(returnRDM));
                returnMemoria = memoria.executar(read, write, returnREM, returnRDM);
                read = true; write =false;

            }else if(selUla[0]==false && selUla[1]== true && selUla[2]== true){ // operação NOT
                // Não incrementa PC para não pular a proxima instrução

            }else{  // condição falsa do JMP 
                returnPC = pc.executar(cargaPC, incrementaPC, returnRDM );
                read = true;
            }

            returnULA = ula.executar(selUla, cargaNZ, returnAC, returnRDM);
            flagN = ula.getN();
            flagZ = ula.getZ();
            returnAC = ac.executar(returnULA, clock, cargaAC);
            System.out.println("VAAAAAlorr do AC: " + converter.paraInteiro(returnAC));
            System.out.println("VAAAAAlorr do ula: " + converter.paraInteiro(returnULA));
            
            contPC = converter.paraInteiro(returnPC);
            System.out.println("contPC: " + contPC);
            
        }while(!hlt && contPC < 255);

        System.out.println(" >>>MEMORIA COMPLETA DDEEPOISSSS DA EXECUÇÃO: ");
        for(int i =0; i<20;i++){
            posicaoREM = converter.paraVetBoolean(i);
            dadoMemoria = memoria.executar(true,false, posicaoREM,dadoRDM);
            System.out.println(" POSIÇÃO " + i + " : " + converter.paraInteiro(dadoMemoria));
        
        }
        System.out.println(" >>>>>>>>>>>>>>> FIM MEMORIA ");

        return true;
    }


    public void carregarMemoria(boolean vetInstrucoesDados[], int posicaoMemoria){

        memoria.inserirDadosUser(vetInstrucoesDados, posicaoMemoria);
    }

    public String getMemoInstr(){

        String txtFormat = "";
        boolean posicaoMemo[] = new boolean[8];
        boolean dadoMemoria[] = new boolean[8];
        boolean dadoRDM[] = {true,true,false,false,true,true,false,false};

        for(int i = 0; i < 128; i++){

            posicaoMemo = converter.paraVetBoolean(i);
            dadoMemoria = memoria.executar(true,false, posicaoMemo,dadoRDM);
            txtFormat += " POSIÇÃO " + i + " : " + converter.paraInteiro(dadoMemoria) + "\n";
        
        }
        return txtFormat;
    }

    public String getMemoDados(){

        String txtFormat = "";
        boolean posicaoMemo[] = new boolean[8];
        boolean dadoMemoria[] = new boolean[8];
        boolean dadoRDM[] = {true,true,false,false,true,true,false,false};

        for(int i = 128; i < 256; i++){

            posicaoMemo = converter.paraVetBoolean(i);
            dadoMemoria = memoria.executar(true,false, posicaoMemo,dadoRDM);
            txtFormat += " POSIÇÃO " + i + " : " + converter.paraInteiro(dadoMemoria) + "\n";
        
        }
        return txtFormat;
    }


}
