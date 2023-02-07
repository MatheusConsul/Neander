
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
        boolean cargaNZ = false;
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
        
        System.out.println("\n >>>>>>> EXECUÇÃO COMPLETA: <<<<<<<< \n");
        
        do{
            
            System.out.println(" ########### INICIO DO DO WHILE ");

            returnPC = pc.executar(cargaPC, incrementaPC,returnRDM);
            returnMux = mux.executar(returnPC, returnRDM, sel);
            returnREM = rem.executar(returnMux,clock,cargaREM);

            contPC = converter.paraInteiro(returnPC);
            System.out.println(" >> PC: " + contPC);
            
            if(write == true){   // escrita na memoria
                returnRDM = rdm.executar(returnAC, clock, cargaRDM);
                returnMemoria = memoria.executar(read, write, returnREM, returnRDM);
            }else{              // leitura na memoria
                returnMemoria = memoria.executar(read, write, returnREM, returnRDM);
                returnRDM = rdm.executar(returnMemoria, clock, cargaRDM);
            }
            
            System.out.println("endereço acessado na memoria:" + converter.paraInteiro(returnREM) +  " dado gravado ou lido: " +converter.paraInteiro(returnRDM));
  
            returnDecod = decodificador.executar(returnRDM,cargaRI);

            returnULA = ula.executar(selUla, cargaNZ, returnAC, returnRDM);
            flagN = ula.getN();
            flagZ = ula.getZ();
            returnAC = ac.executar(returnULA, clock, cargaAC);

            System.out.println(" DADO SALVO NO AC: " + converter.paraInteiro(returnAC));
            System.out.println(" SAIDA DA ULA: " + converter.paraInteiro(returnULA) + "  FLAG N: " + flagN +"  FALG Z: " + flagZ);
            System.out.println("Unidade de controle vai receber o opcode: "+ converter.paraInteiro(returnDecod) );

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
            
            /*System.out.println("selUla : " + selUla[0] + " "+ selUla[1] + " " + selUla[2]);
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
            System.out.println(" hlt : " +  hlt);*/


            System.out.println("\n ########  FINAL while \n");
            
        }while(!hlt && contPC < 255);


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

    public void reset(){
        
        boolean[] zero = {false,false,false,false,false,false,false,false};
        boolean[] ulaSel = {true,false,false};
        boolean[] ret = new boolean[8];

        for(int i = 0; i < 256; i++){
            carregarMemoria(zero, i);
        }

        ret = pc.executar(true, false,zero);
        ret = mux.executar(zero,zero,false);
        ret = rem.executar(zero,true,true);
        ret = rdm.executar(zero, true, true);
        ret = ula.executar(ulaSel, true, ret, zero);
        ret = ac.executar(zero, true, true);
        

    }


}

