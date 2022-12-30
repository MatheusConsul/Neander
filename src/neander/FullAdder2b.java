// Classe que implementa um somador completo para 2 bits

package neander;

public class FullAdder2b{

  // Instanciação das portas a serem utilizadas para o somador completo de 2 bit.
  private Port_Xor xor = new Port_Xor();
  private Port_And and = new Port_And();
  private Port_Or   or = new Port_Or();
  
  // Recebe os 2 bit para a soma e o possivel Carry In 
  public boolean[] executar(boolean bit0, boolean bit1, boolean Cin){

    // Vetor que vai guarda o resultado, na posição 0 do vetor vai ser o valor de Carry In e posição 1 o valor da soma
    // vetor Conteudo: [Carry In] [ Soma ]
    // Vetor Posição:  [Posi: 0]  [Posi: 1]

    boolean vetResultante[] = new boolean[2];  

    // é guardado na posição 1 do vetor o valor da operação de soma => ((bit0 xor bit1) xor Cin)
    vetResultante[1] = xor.executar(xor.executar(bit0,bit1),Cin);

    // é guardado na posição 0 do vetor o valor de Carry In => { [ (bit0 and Cin) or (bit1 and Cin) ] or (bit0 and bit1) }
    vetResultante[0] = or.executar(or.executar(and.executar(bit0,Cin),and.executar(bit1,Cin)),and.executar(bit0,bit1));
      
    return vetResultante;
  }



}


