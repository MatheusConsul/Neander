
package estruturasBasicas;

public class Flip_Flop_d{

  private boolean valArmazenado;

  /*
    Tentativa da implementação do flipFlop utilizando as portas
    porém travei nas duas ultimas portas pois uma depende 
    da saida da outra e vise versa  sendo impossivel implementar 
    de forma sequencial;

    Port_And and1 = new Port_And();
    Port_And and2 = new Port_And();
    Port_And and3 = new Port_And();
    Port_And and4 = new Port_And();
    Port_Not not1 = new Port_Not();
    Port_Not not2 = new Port_Not();
    Port_Not not3 = new Port_Not();
    Port_Not not4 = new Port_Not();
    Port_Not not5 = new Port_Not();
  */

  public Flip_Flop_d(){
    valArmazenado = false;
  }

  
  public boolean executar(boolean d, boolean clk){

    /* if garante que o valor de valArmazenado seja alterado
      apenas quando o clk(clock) for um/true, caso contrario vai
      vai retorna o valor que ja estava armazenado
    */
    if(clk == true){
      valArmazenado = d;
    }
   
    /*
      Tentativa da implementação do flipFlop utilizando as portas
      porém travei nas duas ultimas portas pois uma depende 
      da saida da outra e vise versa  sendo impossivel implementar 
      de forma sequencial; 

      s1 e s2 são as saidas das duas primeiras portas
      outra tentativa foi usar o qNegado, porem não funciona
      em teste pelo logisim não funcionou.  

      boolean s1, s2, q, qNegado;
      qNegado = not1.executar(d);

      s1 = not1.executar(and1.executar(d, clk));
      s2 = not2.executar(and2.executar(not5.executar(d),clk));

      q = not3.executar(and3.executar(s1, qNegado));

      valArmazenado = q;
    
    */
  
  return valArmazenado;
  }

}

