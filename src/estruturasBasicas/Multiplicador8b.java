package estruturasBasicas;

public class Multiplicador8b{
  
public void executar(boolean[] S1, boolean[] S2, boolean Cin){   
Conversor converter = new Conversor(); 
if(Cin == true){ 
try {
           
            int foo = Integer.parseInt(valor1, 2);
            int foo2 = Integer.parseInt(valor2, 2);
            int result = foo *foo2;
            char value_char= (char)result;
             System.out.println(value_char);
           
        } catch (NumberFormatException e) {
            System.out.println("Error: The binary string is not valid");
        }
}
      
    }
}
  
