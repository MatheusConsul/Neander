
package elementosDaArquitetura;

import estruturasBasicas.Conversor;

public class UnidadeControle {

  Conversor converter = new Conversor();
  int ciclo = 1;


  public boolean[] executar(boolean opCode[], boolean flagN, boolean flagZ, boolean clock){
    boolean[] flagsDeControle = {false,false,false,false,false,false,false,false,false,false,false,false,false,false};

    int op_code = converter.paraInteiro(opCode);
    System.out.println(" ########### OPCODE DA UC boolean: "+ opCode[0]+opCode[1]+opCode[2]+opCode[3]);
    System.out.println(" ########### OPCODE DA UC: "+ op_code);

    switch(op_code){

      case 0:   //NOP

        System.out.println(" ########### nop");
        flagsDeControle = leitura_NOP_3ciclo();

      break;
      case 1:   //STA

        if( ciclo == 1){

          System.out.println(" ########### STA ciclo 1 = " + ciclo);
          flagsDeControle = buscaMemoria_1ciclo();

        }else if(ciclo == 2){
          System.out.println(" ########### STA ciclo 2 = " + ciclo);
          flagsDeControle[0]  = false;    // selUla[0]
          flagsDeControle[1]  = false;    // selUla[1]
          flagsDeControle[2]  = false;    // selUla[2]
          flagsDeControle[3]  = false;    // cargaNZ
          flagsDeControle[4]  = false;    // CargaAC
          flagsDeControle[5]  = false;    // CargaRI
          flagsDeControle[6]  = true;     // cargaRDM
          flagsDeControle[7]  = true;     // write (memoria)
          flagsDeControle[8]  = false;    // read (memoria)
          flagsDeControle[9]  = true;     // cargaREM
          flagsDeControle[10] = true;     // sel (Mux)
          flagsDeControle[11] = false;    // cargaPC
          flagsDeControle[12] = false;    // incrementaPC
          flagsDeControle[13] = false;    // hlt
          ciclo++;

        }else{

          System.out.println(" ########### STA ciclo 3 = " + ciclo);
          flagsDeControle = leitura_NOP_3ciclo();

        }

      break;
      case 2:   //LDA

        if( ciclo == 1){

          System.out.println(" ########### LDA ciclo 1 = " + ciclo);
          flagsDeControle = buscaMemoria_1ciclo();

        }else if(ciclo == 2){
          System.out.println(" ########### LDA ciclo 2 = " + ciclo);
          flagsDeControle[0]  = true;    // selUla[0]
          flagsDeControle[1]  = false;    // selUla[1]
          flagsDeControle[2]  = false;    // selUla[2]
          flagsDeControle[3]  = true;    // cargaNZ
          flagsDeControle[4]  = true;    // CargaAC
          flagsDeControle[5]  = false;    // CargaRI
          flagsDeControle[6]  = true;    // cargaRDM
          flagsDeControle[7]  = false;    // write (memoria)
          flagsDeControle[8]  = true;    // read (memoria)
          flagsDeControle[9]  = true;    // cargaREM
          flagsDeControle[10] = true;    // sel (Mux)
          flagsDeControle[11] = false;    // cargaPC
          flagsDeControle[12] = false;    // incrementaPC
          flagsDeControle[13] = false;    // hlt
          ciclo++;

        }else{

          System.out.println(" ########### LDA ciclo 3 = " + ciclo);
          flagsDeControle = leitura_NOP_3ciclo();

        }

        break;
      case 3:   //ADD
        
        if( ciclo == 1){

          System.out.println(" ########### ADD ciclo 1 = " + ciclo);
          flagsDeControle = buscaMemoria_1ciclo();

        }else if(ciclo == 2){
          System.out.println(" ########### ADD ciclo 2 = " + ciclo);
          flagsDeControle[0]  = false;    // selUla[0]
          flagsDeControle[1]  = false;    // selUla[1]
          flagsDeControle[2]  = false;    // selUla[2]
          flagsDeControle[3]  = true;     // cargaNZ
          flagsDeControle[4]  = true;     // CargaAC
          flagsDeControle[5]  = false;    // CargaRI
          flagsDeControle[6]  = true;     // cargaRDM
          flagsDeControle[7]  = false;    // write (memoria)
          flagsDeControle[8]  = true;     // read (memoria)
          flagsDeControle[9]  = true;     // cargaREM
          flagsDeControle[10] = true;     // sel (Mux)
          flagsDeControle[11] = false;    // cargaPC
          flagsDeControle[12] = false;    // incrementaPC
          flagsDeControle[13] = false;    // hlt
          ciclo++;

        }else{

          System.out.println(" ########### ADD ciclo 3 = " + ciclo);
          flagsDeControle = leitura_NOP_3ciclo();

        }

      break;
      case 4:   //OR
              
        if( ciclo == 1){

          System.out.println(" ########### OR ciclo 1 = " + ciclo);
          flagsDeControle = buscaMemoria_1ciclo();

        }else if(ciclo == 2){
          System.out.println(" ########### OR ciclo 2 = " + ciclo);
          flagsDeControle[0]  = false;    // selUla[0]
          flagsDeControle[1]  = true;     // selUla[1]
          flagsDeControle[2]  = false;    // selUla[2]
          flagsDeControle[3]  = true;     // cargaNZ
          flagsDeControle[4]  = true;     // CargaAC
          flagsDeControle[5]  = false;    // CargaRI
          flagsDeControle[6]  = true;     // cargaRDM
          flagsDeControle[7]  = false;    // write (memoria)
          flagsDeControle[8]  = true;     // read (memoria)
          flagsDeControle[9]  = true;     // cargaREM
          flagsDeControle[10] = true;     // sel (Mux)
          flagsDeControle[11] = false;    // cargaPC
          flagsDeControle[12] = false;    // incrementaPC
          flagsDeControle[13] = false;    // hlt
          ciclo++;

        }else{

          System.out.println(" ########### OR ciclo 3 = " + ciclo);
          flagsDeControle = leitura_NOP_3ciclo();

        }

      break;
      case 5:   //AND
              
        if( ciclo == 1){

          System.out.println(" ########### AND ciclo 1 = " + ciclo);
          flagsDeControle = buscaMemoria_1ciclo();

        }else if(ciclo == 2){
          System.out.println(" ########### AND ciclo 2 = " + ciclo);
          flagsDeControle[0]  = false;    // selUla[0]
          flagsDeControle[1]  = false;    // selUla[1]
          flagsDeControle[2]  = true;     // selUla[2]
          flagsDeControle[3]  = true;     // cargaNZ
          flagsDeControle[4]  = true;     // CargaAC
          flagsDeControle[5]  = false;    // CargaRI
          flagsDeControle[6]  = true;     // cargaRDM
          flagsDeControle[7]  = false;    // write (memoria)
          flagsDeControle[8]  = true;     // read (memoria)
          flagsDeControle[9]  = true;     // cargaREM
          flagsDeControle[10] = true;     // sel (Mux)
          flagsDeControle[11] = false;    // cargaPC
          flagsDeControle[12] = false;    // incrementaPC
          flagsDeControle[13] = false;    // hlt
          ciclo++;

        }else{

          System.out.println(" ########### AND ciclo 3 = " + ciclo);
          flagsDeControle = leitura_NOP_3ciclo();

        }
      break;
      case 6:   //NOT
        flagsDeControle[0]  = false;    // selUla[0]
        flagsDeControle[1]  = true;     // selUla[1]
        flagsDeControle[2]  = true;     // selUla[2]
        flagsDeControle[3]  = true;     // cargaNZ
        flagsDeControle[4]  = true;     // CargaAC
        flagsDeControle[5]  = true;     // CargaRI
        flagsDeControle[6]  = true;     // cargaRDM
        flagsDeControle[7]  = false;    // write (memoria)
        flagsDeControle[8]  = true;     // read (memoria)
        flagsDeControle[9]  = true;     // cargaREM
        flagsDeControle[10] = false;    // sel (Mux)
        flagsDeControle[11] = false;    // cargaPC
        flagsDeControle[12] = true;     // incrementaPC
        flagsDeControle[13] = false;    // hlt

        break;
      case 8:   //JMP
              
        if( ciclo == 1){

          System.out.println(" ########### JMP ciclo 1 = " + ciclo);
          flagsDeControle = buscaMemoria_1ciclo();

        }else if(ciclo == 2){
          System.out.println(" ########### JMP ciclo 2 = " + ciclo);
          flagsDeControle[0]  = false;    // selUla[0]
          flagsDeControle[1]  = false;    // selUla[1]
          flagsDeControle[2]  = false;    // selUla[2]
          flagsDeControle[3]  = false;    // cargaNZ
          flagsDeControle[4]  = false;    // CargaAC
          flagsDeControle[5]  = false;    // CargaRI
          flagsDeControle[6]  = false;    // cargaRDM
          flagsDeControle[7]  = false;    // write (memoria)
          flagsDeControle[8]  = false;    // read (memoria)
          flagsDeControle[9]  = false;    // cargaREM
          flagsDeControle[10] = false;    // sel (Mux)
          flagsDeControle[11] = true;     // cargaPC
          flagsDeControle[12] = false;    // incrementaPC
          flagsDeControle[13] = false;    // hlt
          ciclo++;

        }else{

          System.out.println(" ########### JMP ciclo 3 = " + ciclo);
          flagsDeControle = leitura_NOP_3ciclo();

        }

      break;
      case 9:   //JN

        if( ciclo == 1){

          System.out.println(" ########### JMP N ciclo 1 = " + ciclo);
          flagsDeControle = buscaMemoria_1ciclo();

        }else if(ciclo == 2){
          System.out.println(" ########### JMP N ciclo 2 = " + ciclo + " Flag N = " + flagN);
          if(flagN == true){
            flagsDeControle[0]  = false;    // selUla[0]
            flagsDeControle[1]  = false;    // selUla[1]
            flagsDeControle[2]  = false;    // selUla[2]
            flagsDeControle[3]  = false;    // cargaNZ
            flagsDeControle[4]  = false;    // CargaAC
            flagsDeControle[5]  = false;    // CargaRI
            flagsDeControle[6]  = false;    // cargaRDM
            flagsDeControle[7]  = false;    // write (memoria)
            flagsDeControle[8]  = false;    // read (memoria)
            flagsDeControle[9]  = false;    // cargaREM
            flagsDeControle[10] = false;    // sel (Mux)
            flagsDeControle[11] = true;     // cargaPC
            flagsDeControle[12] = false;    // incrementaPC
            flagsDeControle[13] = false;    // hlt
            ciclo++;

          }else{
            flagsDeControle[0]  = false;    // selUla[0]
            flagsDeControle[1]  = false;    // selUla[1]
            flagsDeControle[2]  = false;    // selUla[2]
            flagsDeControle[3]  = false;    // cargaNZ
            flagsDeControle[4]  = false;    // CargaAC
            flagsDeControle[5]  = false;    // CargaRI
            flagsDeControle[6]  = false;    // cargaRDM
            flagsDeControle[7]  = false;    // write (memoria)
            flagsDeControle[8]  = false;    // read (memoria)
            flagsDeControle[9]  = false;    // cargaREM
            flagsDeControle[10] = false;    // sel (Mux)
            flagsDeControle[11] = false;    // cargaPC
            flagsDeControle[12] = false;    // incrementaPC
            flagsDeControle[13] = false;    // hlt
            ciclo++;
          }
          
        }else{

          System.out.println(" ########### JMP N ciclo 3 = " + ciclo);
          flagsDeControle = leitura_NOP_3ciclo();

        }

        break;
      case 10:  //JZ
        
      if( ciclo == 1){

        System.out.println(" ########### JMP Z ciclo 1 = " + ciclo);
        flagsDeControle = buscaMemoria_1ciclo();

      }else if(ciclo == 2){
        System.out.println(" ########### JMP Z ciclo 2 = " + ciclo + " Flag Z = " + flagZ);
        if(flagZ == true){
          flagsDeControle[0]  = false;    // selUla[0]
          flagsDeControle[1]  = false;    // selUla[1]
          flagsDeControle[2]  = false;    // selUla[2]
          flagsDeControle[3]  = false;    // cargaNZ
          flagsDeControle[4]  = false;    // CargaAC
          flagsDeControle[5]  = false;    // CargaRI
          flagsDeControle[6]  = false;    // cargaRDM
          flagsDeControle[7]  = false;    // write (memoria)
          flagsDeControle[8]  = false;    // read (memoria)
          flagsDeControle[9]  = false;    // cargaREM
          flagsDeControle[10] = false;    // sel (Mux)
          flagsDeControle[11] = true;     // cargaPC
          flagsDeControle[12] = false;    // incrementaPC
          flagsDeControle[13] = false;    // hlt
          ciclo++;

        }else{
          flagsDeControle[0]  = false;    // selUla[0]
          flagsDeControle[1]  = false;    // selUla[1]
          flagsDeControle[2]  = false;    // selUla[2]
          flagsDeControle[3]  = false;    // cargaNZ
          flagsDeControle[4]  = false;    // CargaAC
          flagsDeControle[5]  = false;    // CargaRI
          flagsDeControle[6]  = false;    // cargaRDM
          flagsDeControle[7]  = false;    // write (memoria)
          flagsDeControle[8]  = false;    // read (memoria)
          flagsDeControle[9]  = false;    // cargaREM
          flagsDeControle[10] = false;    // sel (Mux)
          flagsDeControle[11] = false;    // cargaPC
          flagsDeControle[12] = false;    // incrementaPC
          flagsDeControle[13] = false;    // hlt
          ciclo++;
        }
        
      }else{

        System.out.println(" ########### JMP Z ciclo 3 = " + ciclo);
        flagsDeControle = leitura_NOP_3ciclo();

      }

        break;
      case 15:  //HLT
        flagsDeControle[0]  = false;    // selUla[0]
        flagsDeControle[1]  = false;    // selUla[1]
        flagsDeControle[2]  = false;    // selUla[2]
        flagsDeControle[3]  = false;    // cargaNZ
        flagsDeControle[4]  = false;    // CargaAC
        flagsDeControle[5]  = false;    // CargaRI
        flagsDeControle[6]  = false;    // cargaRDM
        flagsDeControle[7]  = false;    // write (memoria)
        flagsDeControle[8]  = false;    // read (memoria)
        flagsDeControle[9]  = false;    // cargaREM
        flagsDeControle[10] = false;    // sel (Mux)
        flagsDeControle[11] = false;    // cargaPC
        flagsDeControle[12] = false;    // incrementaPC
        flagsDeControle[13] = true;     // hlt

        break;
      default:
        System.out.println("Erro na Unidade de Controle operação não encontrada");
      break;
    }

    
  return flagsDeControle;
  }

  private boolean[] buscaMemoria_1ciclo(){

    boolean[] flagsDeControle = new boolean[14];
    flagsDeControle[0]  = false;    // selUla[0]
    flagsDeControle[1]  = false;    // selUla[1]
    flagsDeControle[2]  = false;    // selUla[2]
    flagsDeControle[3]  = false;    // cargaNZ
    flagsDeControle[4]  = false;    // CargaAC
    flagsDeControle[5]  = false;    // CargaRI
    flagsDeControle[6]  = true;     // cargaRDM
    flagsDeControle[7]  = false;    // write (memoria)
    flagsDeControle[8]  = true;     // read (memoria)
    flagsDeControle[9]  = true;     // cargaREM
    flagsDeControle[10] = false;    // sel (Mux)
    flagsDeControle[11] = false;    // cargaPC
    flagsDeControle[12] = true;     // incrementaPC
    flagsDeControle[13] = false;    // hlt
    ciclo++;
    return flagsDeControle;
  }

  private boolean[] leitura_NOP_3ciclo(){

    boolean[] flagsDeControle = new boolean[14];

    flagsDeControle[0]  = false;    // selUla[0]
    flagsDeControle[1]  = false;    // selUla[1]
    flagsDeControle[2]  = false;    // selUla[2]
    flagsDeControle[3]  = false;    // cargaNZ ------------------------
    flagsDeControle[4]  = false;    // CargaAC
    flagsDeControle[5]  = true;    // CargaRI
    flagsDeControle[6]  = true;    // cargaRDM
    flagsDeControle[7]  = false;    // write (memoria)
    flagsDeControle[8]  = true;    // read (memoria)
    flagsDeControle[9]  = true;    // cargaREM
    flagsDeControle[10] = false;    // sel (Mux)
    flagsDeControle[11] = false;    // cargaPC
    flagsDeControle[12] = true;    // incrementaPC
    flagsDeControle[13] = false;    // hlt
    ciclo = 1;
    return flagsDeControle;
  }



}  




