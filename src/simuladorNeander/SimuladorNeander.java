
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
    
    // Variaveis de auxilio pare execução do simulador no modo passo a passo
    boolean returnUniControlePassoAPasso[] = new boolean[13];
    boolean returnPCPassoAPasso[] = new boolean[8];
    boolean returnMuxPassoAPasso[] = new boolean[8];
    boolean returnREMPassoAPasso[] = new boolean[8];
    boolean returnMemoriaPassoAPasso[] = new boolean[8];
    boolean returnRDMPassoAPasso[] = new boolean[8];
    boolean returnDecodPassoAPasso[] = new boolean[4];
    boolean returnULAPassoAPasso[] = new boolean[8];
    boolean returnACPassoAPasso[] = new boolean[8];


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
            
            System.out.println("\n ########  FINAL while \n");
            
        }while(!hlt && contPC < 255);


        return true;
    }


    public boolean executarPassoAPasso(){

        System.out.println(" \n============= Botão Rodar Passo a Passo ============\n");

        boolean clock;
        boolean hlt;
        boolean flagN;
        boolean flagZ;
        boolean selUla[] = new boolean[3];
        boolean cargaNZ;
        boolean cargaAC;
        boolean cargaRI;
        boolean cargaRDM;
        boolean write;
        boolean read;
        boolean cargaREM;
        boolean sel;
        boolean cargaPC;
        boolean incrementaPC;

        boolean zero[] = {false,false,false,false,false,false,false,false};

        int contPC = converter.paraInteiro(pc.executar(false, false,zero));
       
        if(contPC == 0){
            System.out.println(" %%%%%%%%%%% Passo a Passo if contPC = 0");

            clock = true;
            hlt = false;
            flagN = ula.getN();
            flagZ = ula.getZ();
            //selUla[] = new boolean[3];
            cargaNZ = false;
            cargaAC = false;
            cargaRI = true;
            cargaRDM = true;
            write = false;
            read = true;
            cargaREM = true;
            sel = false;
            cargaPC = false;
            incrementaPC = true;

            returnPCPassoAPasso = pc.executar(cargaPC, incrementaPC,returnRDMPassoAPasso);
            returnMuxPassoAPasso = mux.executar(returnPCPassoAPasso, returnRDMPassoAPasso, sel);
            returnREMPassoAPasso = rem.executar(returnMuxPassoAPasso,clock,cargaREM);

            contPC = converter.paraInteiro(returnPCPassoAPasso);
            System.out.println(" >> PC: " + contPC);
            
            returnMemoriaPassoAPasso = memoria.executar(read, write, returnREMPassoAPasso, returnRDMPassoAPasso);
            returnRDMPassoAPasso = rdm.executar(returnMemoriaPassoAPasso, clock, cargaRDM);
            
            System.out.println("endereço acessado na memoria:" + converter.paraInteiro(returnREMPassoAPasso) +  " dado gravado ou lido: " +converter.paraInteiro(returnRDMPassoAPasso));
  
            returnDecodPassoAPasso = decodificador.executar(returnRDMPassoAPasso,cargaRI);
            
            returnULAPassoAPasso = ula.executar(selUla, cargaNZ, returnACPassoAPasso, returnRDMPassoAPasso);
            flagN = ula.getN();
            flagZ = ula.getZ();
            returnACPassoAPasso = ac.executar(returnULAPassoAPasso, clock, cargaAC);

            System.out.println(" DADO SALVO NO AC: " + converter.paraInteiro(returnACPassoAPasso));
            System.out.println(" SAIDA DA ULA: " + converter.paraInteiro(returnULAPassoAPasso) + "  FLAG N: " + flagN +"  FALG Z: " + flagZ);
            System.out.println("Unidade de controle vai receber o opcode: "+ converter.paraInteiro(returnDecodPassoAPasso) );

            returnUniControlePassoAPasso = uControle.executar(returnDecodPassoAPasso, flagN, flagZ, clock);

        }else if(contPC > 0 && contPC < 255){
            
            System.out.println(" %%%%%%%%%%% Passo a Passo if contPC > 0");

            selUla[0] =     returnUniControlePassoAPasso[0];
            selUla[1] =     returnUniControlePassoAPasso[1];
            selUla[2] =     returnUniControlePassoAPasso[2];
            cargaNZ =       returnUniControlePassoAPasso[3];
            cargaAC =       returnUniControlePassoAPasso[4];
            cargaRI =       returnUniControlePassoAPasso[5];
            cargaRDM =      returnUniControlePassoAPasso[6];
            write =         returnUniControlePassoAPasso[7];
            read =          returnUniControlePassoAPasso[8];
            cargaREM =      returnUniControlePassoAPasso[9];
            sel =           returnUniControlePassoAPasso[10];
            cargaPC =       returnUniControlePassoAPasso[11];
            incrementaPC =  returnUniControlePassoAPasso[12];
            hlt =           returnUniControlePassoAPasso[13];

            returnPCPassoAPasso = pc.executar(cargaPC, incrementaPC,returnRDMPassoAPasso);
            returnMuxPassoAPasso = mux.executar(returnPCPassoAPasso, returnRDMPassoAPasso, sel);
            returnREMPassoAPasso = rem.executar(returnMuxPassoAPasso,true,cargaREM);

            contPC = converter.paraInteiro(returnPCPassoAPasso);
            System.out.println(" >> PC: " + contPC);
            
            if(write == true){   // escrita na memoria
                returnRDMPassoAPasso = rdm.executar(returnACPassoAPasso, true, cargaRDM);
                returnMemoriaPassoAPasso = memoria.executar(read, write, returnREMPassoAPasso, returnRDMPassoAPasso);
            }else{              // leitura na memoria
                returnMemoriaPassoAPasso = memoria.executar(read, write, returnREMPassoAPasso, returnRDMPassoAPasso);
                returnRDMPassoAPasso = rdm.executar(returnMemoriaPassoAPasso, true, cargaRDM);
            }
            
            System.out.println("endereço acessado na memoria:" + converter.paraInteiro(returnREMPassoAPasso) +  " dado gravado ou lido: " +converter.paraInteiro(returnRDMPassoAPasso));
  
            returnDecodPassoAPasso = decodificador.executar(returnRDMPassoAPasso,cargaRI);
            
            returnULAPassoAPasso = ula.executar(selUla, cargaNZ, returnACPassoAPasso, returnRDMPassoAPasso);
            flagN = ula.getN();
            flagZ = ula.getZ();
            returnACPassoAPasso = ac.executar(returnULAPassoAPasso, true, cargaAC);

            System.out.println(" DADO SALVO NO AC: " + converter.paraInteiro(returnACPassoAPasso));
            System.out.println(" SAIDA DA ULA: " + converter.paraInteiro(returnULAPassoAPasso) + "  FLAG N: " + flagN +"  FALG Z: " + flagZ);
            System.out.println("Unidade de controle vai receber o opcode: "+ converter.paraInteiro(returnDecodPassoAPasso) );

            returnUniControlePassoAPasso = uControle.executar(returnDecodPassoAPasso, flagN, flagZ, true);

        }
      
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
    public void zeraPC(){
        
        boolean[] zero = {false,false,false,false,false,false,false,false};
        boolean[] ulaSel = {true,false,false};
        boolean[] ret = new boolean[8];
        ret = pc.executar(true, false,zero);
        /*ret = mux.executar(zero,zero,false);
        ret = rem.executar(zero,true,true);
        ret = rdm.executar(zero, true, true);
        ret = ula.executar(ulaSel, true, ret, zero);
        ret = ac.executar(zero, true, true);*/

    }

}

