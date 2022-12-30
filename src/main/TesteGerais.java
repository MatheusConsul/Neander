// classe usada para realizar testes das outras classes.

package main;

import java.util.Arrays;

import elementosDaArquitetura.*;
import estruturasBasicas.*;

public class TesteGerais{

  // teste das portas logicas, imprime tabela verdade das portas 
  public void testePortas(){ 

    // Instanciação das variaveis de cada porta logica
    Port_And and = new Port_And();
    Port_Nor nor = new Port_Nor();
    Port_Not not = new Port_Not();
    Port_Or or = new Port_Or();
    Port_Xor xor = new Port_Xor();

    boolean bit0False = false;  //variavel para representar o ZERO/FALSE
    boolean bit1True = true;    // variavel para representar o UM/TRUE

    // Execução de cada porta logica enviando as 4 combinações possiveis e assim formando a tabela verdae 
    System.out.println("\nTabela verdade AND:");
    System.out.println("bit0: bit1 resultado" );
    System.out.println("  0    0   " + and.executar(bit0False, bit0False));
    System.out.println("  0    1   " + and.executar(bit0False, bit1True));
    System.out.println("  1    0   " + and.executar(bit1True, bit0False));
    System.out.println("  1    1   " + and.executar(bit1True, bit1True));

    System.out.println("\nTabela verdade Nor:");
    System.out.println("bit0: bit1 resultado" );
    System.out.println("  0    0   " + nor.executar(bit0False, bit0False));
    System.out.println("  0    1   " + nor.executar(bit0False, bit1True));
    System.out.println("  1    0   " + nor.executar(bit1True, bit0False));
    System.out.println("  1    1   " + nor.executar(bit1True, bit1True));

    System.out.println("\nTabela verdade Or:");
    System.out.println("bit0: bit1 resultado" );
    System.out.println("  0    0   " + or.executar(bit0False, bit0False));
    System.out.println("  0    1   " + or.executar(bit0False, bit1True));
    System.out.println("  1    0   " + or.executar(bit1True, bit0False));
    System.out.println("  1    1   " + or.executar(bit1True, bit1True));

    System.out.println("\nTabela verdade xor:");
    System.out.println("bit0: bit1 resultado" );
    System.out.println("  0    0   " + xor.executar(bit0False, bit0False));
    System.out.println("  0    1   " + xor.executar(bit0False, bit1True));
    System.out.println("  1    0   " + xor.executar(bit1True, bit0False));
    System.out.println("  1    1   " + xor.executar(bit1True, bit1True));

    System.out.println("\nPORTA NOT " );
    System.out.println("bit0: bit1 resultado" );
    System.out.println("  0   " + not.executar(bit0False));
    System.out.println("  1   " + not.executar(bit1True));
    System.out.println("\n ============= FIM DO TESTE DE PORTAS =============" );      
  }

  // Teste do mux, onde recebe 2 vetores do tipo boolean e deacordo com o "sel" ele retorna um dos vetores.
  public void testeMux(){

    Mux2p1 mux = new Mux2p1();  // instanciação do mux
    
    boolean vetPCteste[] = new boolean[8];  // vetor de 8 bits representando o endereço vindo do PC
    boolean vetRDMteste[] = new boolean[8]; // vetor de 8 bits representando o endereço vindo do RDM
    // RDM -> Resgistrador de Dados da Memoria
    
    Arrays.fill(vetPCteste,true);   // comando para setar todo o vetor com o valor true
    Arrays.fill(vetRDMteste,false); // comando para setar todo o vetor com o valor false
    
    boolean sel = true;    // variavel do tipo boolean que representa o sinal vindo da Unidade de Controle 
                            // para selecionar de onde deve ser carregado o proximo endereço 
    
    boolean vetResultado[] = new boolean[8]; // Vetor que vai conter o vetor escolhido de acordo com a variavel "sel"

    System.out.println("=========== CONTEUDO VETPCTESTE: ==========");
    for(int x = 0; x<8;x++){
      System.out.println("Posição " + x + " : " + vetPCteste[x]);
    }
    System.out.println("=========== CONTEUDO VETRDMTESTE: ==========");
    for(int i = 0; i<8;i++){
      System.out.println("Posição " + i + " : " + vetRDMteste[i]);
    }

    // execução do mux onde recebe as duas opções de entradas PC e RDM e atraves do "sel" seleciona uma delas
    // para ser carregada no REM (Registrador de Endereço de Memoria)
    vetResultado = mux.executar(vetPCteste,vetRDMteste,sel);

    // impressão do vetor escolhido que vai ser enviado para o RDM 
    System.out.println("=========== CONTEUDO VETRESULADO MUX: =========="); 
    for(int z = 0; z<8;z++){
      System.out.println("Posição " + z + " : " + vetResultado[z]);
    }


    System.out.println("\n ============= FIM DO TESTE DO MUX =============" );
  }


  public void testeSomador2b(){

     
    FullAdder2b somador = new FullAdder2b();

    boolean[] vet0 = new boolean[2];
    boolean[] vet1 = new boolean[2];
    boolean[] vet2 = new boolean[2];
    boolean[] vet3 = new boolean[2];
    boolean[] vet4 = new boolean[2];
    boolean[] vet5 = new boolean[2];
    boolean[] vet6 = new boolean[2];
    boolean[] vet7 = new boolean[2];
    vet0 = somador.executar(false,false,false);
    vet1 = somador.executar(false,false,true);
    vet2 = somador.executar(false,true,false);
    vet3 = somador.executar(false,true,true);
    vet4 = somador.executar(true,false,false);
    vet5 = somador.executar(true,false,true);
    vet6 = somador.executar(true,true,false);
    vet7 = somador.executar(true,true,true);
    
    System.out.println("\nTabela verdade SOMADOR:");
    System.out.println("bit0: bit1: Cin: ResulCin: ResulSoma:" );
    System.out.println("  0    0     0  |  " + vet0[0] + "  |  " + vet0[1]);
    System.out.println("  0    0     1  |  " + vet1[0] + "  |  " + vet1[1]);
    System.out.println("  0    1     0  |  " + vet2[0] + "  |  " + vet2[1]);
    System.out.println("  0    1     1  |  " + vet3[0] + "  |  " + vet3[1]);
    System.out.println("  1    0     0  |  " + vet4[0] + "  |  " + vet4[1]);
    System.out.println("  1    0     1  |  " + vet5[0] + "  |  " + vet5[1]);
    System.out.println("  1    1     0  |  " + vet6[0] + "  |  " + vet6[1]);
    System.out.println("  1    1     1  |  " + vet7[0] + "  |  " + vet7[1]);
  
      System.out.println("\n =========== FIM DO TESTE DO SOMADOR 2 BITS ===========" );
  }

  public void testeSomador8b(){

    FullAdder8b somador = new FullAdder8b();

    //   vetA posição:  0     1     2     3     4     5     6     7
    boolean[] vetA = {false,false,false,false,false,false,true,false};
    
    //   vetB posição:  0     1     2     3     4     5     6     7
    boolean[] vetB = {false,false,false,false,false,false,false,true};
    
    boolean[] resultado = new boolean[8];
    Arrays.fill(resultado,false); // comando para setar todo o vetor com o valor false

    resultado = somador.executar(vetA,vetB);
    Barramento barramento = new Barramento();

    
    System.out.println("\n\n=========== CONTEUDO SOMADOR: ==========");
    System.out.println("Resultado da soma em binario: ");
    System.out.println("vetA =   " + barramento.executar(vetA));
    System.out.println("vetB = + " + barramento.executar(vetB));
    System.out.println("-----------------------");
    System.out.println("result = " + barramento.executar(resultado));
    
  }

  public void testeFlipFlop(){

    Flip_Flop_d flip = new Flip_Flop_d();


    System.out.println("\n\n====== TESTE DO FLIP FLOP ========\n");

    System.out.println("Valor inicial do flipflop antes de qualquer alteração ");
    System.out.println("enviado os seguintes parametros true/1 mas o clock em 0/false: " + flip.executar(true,false));
    System.out.println("Valor do flipflop ao grava 1/true e clk em 1/true: " + flip.executar(true,true));
    System.out.print("Valor do flipflop depois da alteração anterior parametros enviados: 0/false e clk em 0/false: ");
    System.out.println(flip.executar(true,false));



    System.out.println("\n====== FIM DO TESTE DO FLIP FLOP ========\n\n");

  }

  public void testeRegistrado8b(){

    Registrador8b registrador = new Registrador8b();
    boolean[] vetTeste = new boolean[8];
    Barramento barramento = new Barramento();
    Arrays.fill(vetTeste,true); // comando para setar todo o vetor com o valor false



    System.out.println("\n\n====== TESTE DO REGISTRADOR ========\n");

    System.out.println("Valor inicial do REGISTRADOR antes de qualquer alteração ");
    System.out.println("parametro: vetor todo em true e clock em false: " + barramento.executar(registrador.executar(vetTeste,false)));

    vetTeste[1] = false; vetTeste[3] = false; vetTeste[5] = false;vetTeste[7] = false;
    System.out.println("\n Valor do vetor alternado e clk em 1/true: " + barramento.executar(registrador.executar(vetTeste,true)));

    Arrays.fill(vetTeste,false);
    System.out.print("\nRegistrado depois da alteração anterior parametros vetor todo em false e clk em 0/false: ");
    System.out.println(barramento.executar(registrador.executar(vetTeste,false)));



    System.out.println("\n====== FIM DO TESTE DO REGISTRADOR ========\n\n");





  }



}




