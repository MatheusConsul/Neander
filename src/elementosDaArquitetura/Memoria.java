
package elementosDaArquitetura;

import java.util.Arrays;

import estruturasBasicas.Conversor;
import estruturasBasicas.Registrador8b;

public class Memoria{

// vetor de 256 posições para simular a memoria, cada posição
// é um registrador de 8 bits
private Registrador8b memoria[] = new Registrador8b[256]; 
Conversor converter = new Conversor(); // objeto usado para converte de boolean(binario) para inteiro


public Memoria(){

  // Construtor garante a inicialização da memoria com todas as 
  // posições zeradas

  Registrador8b registradorGeral = new Registrador8b();
  Registrador8b registrador1 = new Registrador8b();
  Registrador8b registrador2 = new Registrador8b();
  Registrador8b registrador3 = new Registrador8b();
  Registrador8b registrador4 = new Registrador8b();
  Registrador8b registrador5 = new Registrador8b();
  Registrador8b registrador6 = new Registrador8b();
  Registrador8b registrador7 = new Registrador8b();
  Registrador8b registrador8 = new Registrador8b();
  Registrador8b registrador9 = new Registrador8b();
  Registrador8b registrador10 = new Registrador8b();

  boolean[] umByte = {false,false,false,false,false,false,false,false};
 
  registradorGeral.executar(umByte,true);

  Arrays.fill(memoria, registradorGeral);

  // PARA TESTES PREENCHER A MEMORIA:
  

  boolean[] dadoInstru = {false,false,true,false,false,false,false,false};  //lda
  registrador1.executar(dadoInstru,true);
  memoria[0] = registrador1; 

  boolean[] dadoInstru1 = {false,false,false,true,false,false,false,false}; // pos. 16
  registrador2.executar(dadoInstru1,true);
  memoria[1] = registrador2; 

  boolean[] dadoInstru2 = {false,false,true,true,false,false,false,false}; //add
  registrador3.executar(dadoInstru2,true);
  memoria[2] = registrador3; 

  boolean[] dadoInstru3 = {false,false,false,true,false,false,false,true}; // pos. 17
  registrador4.executar(dadoInstru3,true);
  memoria[3] = registrador4; 

  boolean[] dadoInstru4 = {false,false,false,true,false,false,false,false}; // sta
  registrador5.executar(dadoInstru4,true);
  memoria[4] = registrador5; 

  boolean[] dadoInstru5 = {false,false,false,true,false,false,true,false}; // pos. 18
  registrador6.executar(dadoInstru5,true);
  memoria[5] = registrador6; 

  boolean[] dadoInstru6 = {true,true,true,true,false,false,true,true}; // hlt
  registrador7.executar(dadoInstru6,true);
  memoria[6] = registrador7; 

  boolean[] dado =  {false,false,false,false,false,true,false,false}; // salvado dado na pos 16
  registrador8.executar(dado,true);
  memoria[16] = registrador8; 

  boolean[] dado2 =  {false,false,false,false,false,false,true,false}; // salvado dado na pos 17
  registrador9.executar(dado2,true);
  memoria[17] = registrador9; 


}



public boolean[] executar(boolean read, boolean write, boolean posicaoREM[], boolean dadoRDM[]){
  Registrador8b resgistrador = new Registrador8b();
  boolean vetDado[] = {false,false,false,false,false,false,false,false};

  if(read == true){

    int posicao = converter.paraInteiro(posicaoREM); // converte para inteiro a posição da memoria a ser acessada
    resgistrador = memoria[posicao]; // vai retorna o registrador da posição solicitada
    vetDado = resgistrador.executar(vetDado, false); // clock em false retorna o conteudo do registrador

  }else if(write == true){

    int posicao = converter.paraInteiro(posicaoREM); // converte para inteiro a posição da memoria a ser escrita
    resgistrador.executar(dadoRDM, true); // clock em true grava os dados no registrador e o retorno pode ser despresado
    memoria[posicao] = resgistrador; // agora grava o registrador na memoria 

  }else{
    System.out.println("\n\n opreração not");
  }


  return vetDado;
}



// para receber o codigo e os dados escritos pelo usuario
public void inserirDadosUser(){




}




}