package estruturasBasicas;

public class Multiplicador8b{
  /// acho que é assim que fica a multiplicação faltou só a questão do estouro 
public void executar(boolean[] S1, boolean[] S2, boolean Cin){   
Conversor converter = new Conversor(); 
boolean value_char[] = new boolean [8];
if(Cin == true){ 

          int foo= converter.paraInteiro(S1);
          int foo2 = converter.paraInteiro(S1);
            int result = foo *foo2;
            value_char[]=paraVetBoolean(result);
          
}
      
    }
}
  
