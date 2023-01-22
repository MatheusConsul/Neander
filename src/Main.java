import elementosDaArquitetura.Memoria;
import estruturasBasicas.Conversor;

//import java.util.Arrays;

class Main {
  
  public static void main(final String[] args) {

    // Instanciação do objeto teste, usado para realizar os teste de funcionamento das classes 
    TesteGerais teste = new TesteGerais();  

    System.out.println("\n\n ========== TESTES: TESTES: TESTES: ==========");

    
    //teste.testePortas();
    //teste.testeMux();
    //teste.testeSomador2b();
    //teste.testeSomador8b();
    //teste.testeFlipFlop();
    //teste.testeRegistrado8b();
    //teste.testeREM();
    //teste.testeMemoria();

     
    Conversor converter = new Conversor();

    boolean vet[] = new boolean[8];

    int valor = 2 ;

    vet = converter.paraVetBoolean(valor);
    System.out.println("result: " + converter.paraString(vet) + "\n");
    valor = 3;
    vet = converter.paraVetBoolean(valor);
    System.out.println("result: " + converter.paraString(vet) + "\n");
    valor = 4;
    vet = converter.paraVetBoolean(valor);
    System.out.println("result: " + converter.paraString(vet) + "\n");
    valor = 5;
    vet = converter.paraVetBoolean(valor);
    System.out.println("result: " + converter.paraString(vet) + "\n");
    
    


    //FullSubtrator2b sub = new FullSubtrator2b();
    //boolean[] result = new boolean[2];


    //result = sub.executar(true,true,false);

    //System.out.println("Resultado sub: " + result[0]+" "+ result[1]);

    
    
  }


}