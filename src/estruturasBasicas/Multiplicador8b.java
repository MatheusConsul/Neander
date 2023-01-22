package estruturasBasicas;

public class Multiplicador8b{
  
public void executar(boolean[] S1, boolean[] S2, boolean Cin){   
Conversor converter = new Conversor(); 
if(Cin == true){ 
try {
          int foo= converter.paraInteiro(S1);
          int foo2 = converter.paraInteiro(S1);
            int result = foo *foo2;
            char value_char= conveter.paraString(result);
             System.out.println(value_char);
           
        } catch (NumberFormatException e) {
            System.out.println("Error: The binary string is not valid");
        }
}
      
    }
}
  
