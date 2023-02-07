package main;

import simuladorNeander.TelaSimulador;
import testes.TesteGerais;
import testes.TesteNeander;

class Main {
  
  public static void main(final String[] args) {

    TesteGerais teste = new TesteGerais();  
    TesteNeander testeGeral = new TesteNeander();

    System.out.println("\n\n ========== TESTES: TESTES: TESTES: ==========");

    //teste.testePortas();
    //teste.testeMux();
    //teste.testeSomador2b();
    //teste.testeSomador8b();
    //teste.testeFlipFlop();
    //teste.testeRegistrado8b();
    //teste.testeREM();
    //teste.testeMemoria();
    //teste.testeDecodificador();
    //teste.testeULA();
    //testeGeral.testeNeander();

    java.awt.EventQueue.invokeLater(new Runnable() {
      public void run() {
          new TelaSimulador().setVisible(true);
      }
    });



    
  }


}