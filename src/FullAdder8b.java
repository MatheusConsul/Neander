public class FullAdder8b{
  private FullAdder2b somador0 =new FullAdder2b();
  
  public boolean[] executar(boolean[] vetA, boolean[] vetB){
    
    boolean Cin = false;
    boolean vetResultante[] = new boolean[8]; 
    boolean vetResultParcial[] = new boolean[2];

    for(int i =7; i >= 0; i--){

      if(i == 7){
        vetResultParcial = somador0.executar(vetA[i],vetB[i],Cin);  
        vetResultante[i] = vetResultParcial[1];
      }else{
        vetResultParcial = somador0.executar(vetA[i],vetB[i],vetResultParcial[0]);  
        vetResultante[i] = vetResultParcial[1];
      }
      
    }
    

    return vetResultante;
  }



}


