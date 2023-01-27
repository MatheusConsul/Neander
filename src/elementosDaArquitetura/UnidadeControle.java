
package elementosDaArquitetura;

import estruturasBasicas.Conversor;

public class UnidadeControle {

  Conversor converter = new Conversor();

  public boolean[] executar(boolean opCode[], boolean flagN, boolean flagZ,boolean clock){
    boolean[] flagsDeControle = {false,false,false,false,false,false,false,false,false,false,false,false,false,false};



    int op_code = converter.paraInteiro(opCode);

    switch(op_code){

      case 0:   //NOP
        flagsDeControle[0]  = false;    // selUla[0]
        flagsDeControle[1]  = false;    // selUla[1]
        flagsDeControle[2]  = false;    // selUla[2]
        flagsDeControle[3]  = false;    // cargaNZ
        flagsDeControle[4]  = false;    // CargaAC
        flagsDeControle[5]  = false;    // CargaRI
        flagsDeControle[6]  = false;    // cargaRDM
        flagsDeControle[7]  = false;    // write (memoria)
        flagsDeControle[8]  = true;     // read (memoria)
        flagsDeControle[9]  = true;     // cargaREM
        flagsDeControle[10] = false;    // sel (Mux)
        flagsDeControle[11] = false;    // cargaPC
        flagsDeControle[12] = true;     // incrementaPC
        flagsDeControle[13] = false;    // hlt

        break;
      case 1:   //STA
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

        break;
      case 2:   //LDA
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

        break;
      case 3:   //ADD
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

        break;
      case 4:   //OR
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

        break;
      case 5:   //AND
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

        break;
      case 6:   //NOT
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

        break;
      case 8:   //JMP
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

        break;
      case 9:   //JN
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

        break;
      case 10:  //JZ
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


}  




