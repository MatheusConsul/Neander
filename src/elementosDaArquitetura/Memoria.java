
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

  Registrador8b registrador = new Registrador8b();
  boolean[] umByte = {false,false,false,false,false,false,false,false};
 
  registrador.executar(umByte,true);

  Arrays.fill(memoria, registrador);

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