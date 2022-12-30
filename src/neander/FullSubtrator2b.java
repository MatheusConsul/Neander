
package neander;

public class FullSubtrator2b {

  private Port_Xor xor = new Port_Xor();
  private Port_And and = new Port_And();
  private Port_Or   or = new Port_Or();
  private Port_Not not = new Port_Not();
  
  public boolean[] executar(boolean bit0, boolean bit1, boolean Cin){
  
    boolean vetResultante[] = new boolean[2]; 
    vetResultante[1] = xor.executar(xor.executar(bit0,bit1),Cin);

    vetResultante[0] = or.executar(or.executar(and.executar(not.executar(bit0),Cin),and.executar(not.executar(bit1),Cin)),and.executar(bit0,bit1));

     return vetResultante;
  }
}