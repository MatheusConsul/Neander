
package simuladorNeander;

import estruturasBasicas.Conversor;

public class TelaSimulador extends javax.swing.JFrame {

    private SimuladorNeander simuladorNeander = new SimuladorNeander();
    private Conversor converter = new Conversor();
    private int posMemoInstru = 0;
    private int posMemoDados = 128;
    private String atualizaTxtInstrucao = "";
    private String atualizaTxtDados = "";


    public TelaSimulador() {
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        lblTitulo = new javax.swing.JLabel();
        lblMemIns = new javax.swing.JLabel();
        lblMemDados = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDados = new javax.swing.JTextArea();
        btnRodar = new javax.swing.JButton();
        btnRodarPasso = new javax.swing.JButton();
        txtFieldInstru = new java.awt.TextField();
        lblPosIns = new javax.swing.JLabel();
        lblInformacao1 = new javax.swing.JLabel();
        lblPosDados = new javax.swing.JLabel();
        txtFieldDados = new java.awt.TextField();
        lblInformacao2 = new javax.swing.JLabel();
        lblInformcao3 = new javax.swing.JLabel();
        btnReiniciar = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        txtCodInstrucoes = new javax.swing.JTextArea();
        btnZerarPc = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtInstrucao = new javax.swing.JTextArea();
        lblAC = new javax.swing.JLabel();
        lblPC = new javax.swing.JLabel();
        lblN = new javax.swing.JLabel();
        lblZ = new javax.swing.JLabel();
        lblAcValor = new javax.swing.JLabel();
        lblNValor = new javax.swing.JLabel();
        lblPcValor = new javax.swing.JLabel();
        lblZValor = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(535, 510));
        setResizable(false);

        lblTitulo.setFont(new java.awt.Font("Stencil", 0, 18)); // NOI18N
        lblTitulo.setText("Simulador Neander em Java");

        lblMemIns.setText("Memoria Instruções");

        lblMemDados.setText("Memoria Dados");

        txtDados.setEditable(false);
        txtDados.setColumns(10);
        txtDados.setRows(5);
        txtDados.setText("    ");
        jScrollPane1.setViewportView(txtDados);

        btnRodar.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        btnRodar.setText("Rodar");
        btnRodar.setPreferredSize(new java.awt.Dimension(140, 22));
        btnRodar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRodarActionPerformed(evt);
            }
        });

        btnRodarPasso.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        btnRodarPasso.setText("Rodar Passo a Passo");
        btnRodarPasso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRodarPassoActionPerformed(evt);
            }
        });

        btnReiniciar.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        btnReiniciar.setText("Reiniciar Simulador");
        btnReiniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReiniciarActionPerformed(evt);
            }
        });

        txtFieldInstru.setText("00");
        txtFieldInstru.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFieldInstruActionPerformed(evt);
            }
        });

        lblPosIns.setText("Posição : 000");

        lblInformacao1.setText("Digite o codigo de cada instrução:");

        lblPosDados.setText("Posição : 128");

        txtFieldDados.setText("00");
        txtFieldDados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFieldDadosActionPerformed(evt);
            }
        });

        lblInformacao2.setText("Digite os dados:");

        lblInformcao3.setText("Para pular uma posição de memoria apenas aperte enter  ");

        

        txtCodInstrucoes.setEditable(false);
        txtCodInstrucoes.setColumns(20);
        txtCodInstrucoes.setFont(new java.awt.Font("Arial", 0, 10)); // NOI18N
        txtCodInstrucoes.setRows(5);
        txtCodInstrucoes.setText("                 INSTRUÇÕES:\n    NOP - 00              NOT - 96  \n    STA - 16 end        JMP - 128 end\n    LDA - 32 end        JN  - 144 end\n    ADD - 48 end        JZ  - 160 end\n    OR   - 64 end        HLT - 240\n    AND - 80 end    ");
        jScrollPane3.setViewportView(txtCodInstrucoes);

        btnZerarPc.setFont(new java.awt.Font("Arial", 1, 11)); // NOI18N
        btnZerarPc.setText("Zerar PC");
        btnZerarPc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnZerarPcActionPerformed(evt);
            }
        });

        

        txtInstrucao.setEditable(false);
        txtInstrucao.setColumns(10);
        txtInstrucao.setRows(5);
        txtInstrucao.setText("    ");
        txtInstrucao.setAutoscrolls(false);
        jScrollPane2.setViewportView(txtInstrucao);

        lblAC.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        lblAC.setText("AC:");

        lblPC.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        lblPC.setText("PC:");

        lblN.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        lblN.setText("N:");

        lblZ.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        lblZ.setText("Z:");

        lblAcValor.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        lblAcValor.setText("00");

        lblNValor.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        lblNValor.setText("0");

        lblPcValor.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        lblPcValor.setText("00");

        lblZValor.setFont(new java.awt.Font("Arial Black", 0, 12)); // NOI18N
        lblZValor.setText("1");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(lblMemIns)
                        .addGap(289, 289, 289)
                        .addComponent(lblMemDados)
                        .addGap(93, 93, 93))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblInformacao1)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblPosIns, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtFieldInstru, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(123, 123, 123)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblInformacao2)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblPosDados, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtFieldDados, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(9, 9, 9)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(btnRodar, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnRodarPasso, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnZerarPc, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnReiniciar, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(lblAC, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(lblPC, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(lblAcValor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(lblPcValor, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(lblN, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(lblZ, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(lblNValor, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(lblZValor, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(11, 11, 11)))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(119, 119, 119)
                        .addComponent(lblInformcao3))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(136, 136, 136)
                        .addComponent(lblTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitulo)
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblMemIns)
                    .addComponent(lblMemDados))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblAC)
                            .addComponent(lblN)
                            .addComponent(lblAcValor)
                            .addComponent(lblNValor))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblPC)
                            .addComponent(lblZ)
                            .addComponent(lblZValor)
                            .addComponent(lblPcValor))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnRodar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnRodarPasso)
                        .addGap(14, 14, 14)
                        .addComponent(btnZerarPc)
                        .addGap(18, 18, 18)
                        .addComponent(btnReiniciar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblInformacao1)
                    .addComponent(lblInformacao2, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(lblPosIns, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtFieldInstru, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(txtFieldDados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblPosDados, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblInformcao3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>                        

    





    
    
    
    private void txtFieldInstruActionPerformed(java.awt.event.ActionEvent evt) {                                               
        
        String instrucao = txtFieldInstru.getText();
        int inst = Integer.parseInt(instrucao);
        boolean vetInst[] = new boolean[8];
        vetInst = converter.paraVetBoolean(inst);
        simuladorNeander.carregarMemoria(vetInst, posMemoInstru);
        
        txtFieldInstru.setText("");

        atualizaTxtInstrucao += "Posição "+ posMemoInstru + ": "+ instrucao + "\n";
        
        txtInstrucao.setText(atualizaTxtInstrucao);
        posMemoInstru++;
        
        lblPosIns.setText("Posição: "+posMemoInstru); 
    }                                              

    private void txtFieldDadosActionPerformed(java.awt.event.ActionEvent evt) {                                              
       

        String dados = txtFieldDados.getText();
        int dado = Integer.parseInt(dados);
        boolean vetDado[] = new boolean[8];
        vetDado = converter.paraVetBoolean(dado);
        simuladorNeander.carregarMemoria(vetDado, posMemoDados);
        
        txtFieldDados.setText("");

        atualizaTxtDados += "Posição "+ posMemoDados + ": "+ dados + "\n";
        
        txtDados.setText(atualizaTxtDados);
        posMemoDados++;
        
        lblPosDados.setText("Posição: "+posMemoDados); 

    }                                             

    private void btnRodarPassoActionPerformed(java.awt.event.ActionEvent evt) {                                              
        if(simuladorNeander.executarPassoAPasso()){
            txtInstrucao.setText(simuladorNeander.getMemoInstr());
            txtDados.setText(simuladorNeander.getMemoDados());
        }  

    }          
    
    private void btnReiniciarActionPerformed(java.awt.event.ActionEvent evt) {
        simuladorNeander.reset();
        posMemoInstru = 0;
        posMemoDados = 128;
        atualizaTxtInstrucao = "";
        atualizaTxtDados = "";
        lblPosDados.setText("Posição: "+posMemoDados); 
        lblPosIns.setText("Posição: "+posMemoInstru);
        txtInstrucao.setText(simuladorNeander.getMemoInstr());
        txtDados.setText(simuladorNeander.getMemoDados());
    }      

    private void btnRodarActionPerformed(java.awt.event.ActionEvent evt) {                                         
        if(simuladorNeander.executarCompleto()){
            txtInstrucao.setText(simuladorNeander.getMemoInstr());
            txtDados.setText(simuladorNeander.getMemoDados());
        }
    }   
    
    private void btnZerarPcActionPerformed(java.awt.event.ActionEvent evt) {                                         
        simuladorNeander.zeraPC();
    }   

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaSimulador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaSimulador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaSimulador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaSimulador.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaSimulador().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JButton btnReiniciar;
    private javax.swing.JButton btnRodar;
    private javax.swing.JButton btnRodarPasso;
    private javax.swing.JButton btnZerarPc;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lblAC;
    private javax.swing.JLabel lblAcValor;
    private javax.swing.JLabel lblInformacao1;
    private javax.swing.JLabel lblInformacao2;
    private javax.swing.JLabel lblInformcao3;
    private javax.swing.JLabel lblMemDados;
    private javax.swing.JLabel lblMemIns;
    private javax.swing.JLabel lblN;
    private javax.swing.JLabel lblNValor;
    private javax.swing.JLabel lblPC;
    private javax.swing.JLabel lblPcValor;
    private javax.swing.JLabel lblPosDados;
    private javax.swing.JLabel lblPosIns;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JLabel lblZ;
    private javax.swing.JLabel lblZValor;
    private javax.swing.JTextArea txtCodInstrucoes;
    private javax.swing.JTextArea txtDados;
    private java.awt.TextField txtFieldDados;
    private java.awt.TextField txtFieldInstru;
    private javax.swing.JTextArea txtInstrucao;
    // End of variables declaration                   
}
