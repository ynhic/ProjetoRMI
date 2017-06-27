/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fatec.br.projetormi.cliente.GUI;

import fatec.br.projetormi.servidor.VO.AutentificacaoClienteVO;
import fatec.br.projetormi.servidor.VO.Cadastro_produtosVO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import fatec.br.projetormi.servidor.ServidorInter;

/**
 *
 * @author Ynhic <ynhic@hotmail.com>
 */
public class LeilaoClienteGUI extends javax.swing.JFrame {

    /**
     * Creates new form LeilaoGUI
     */
    public LeilaoClienteGUI() {
        initComponents();
    }

    Cadastro_produtosVO produtoVO = new Cadastro_produtosVO();
    AutentificacaoClienteVO clienteVO = new AutentificacaoClienteVO();

    //atributos
    String cod_produto;
    String nome_produto;
    String descricao_prodto;
    String lance_inicial;
    String lance_atual;
    int count = 0;

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txt_nome_produto = new javax.swing.JTextField();
        txt_lanceInicial_produto = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txt_lanceCliente = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        atxt_descricao = new javax.swing.JTextArea();
        lb_tempo = new javax.swing.JLabel();
        txt_lanceAutal = new javax.swing.JTextField();
        bt_voltar = new javax.swing.JButton();
        bt_lance = new javax.swing.JButton();
        br_selecionar = new javax.swing.JToggleButton();
        jLabel6 = new javax.swing.JLabel();
        lb_email = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Leilão"));

        jLabel1.setFont(new java.awt.Font("Sitka Heading", 2, 24)); // NOI18N
        jLabel1.setText("Sala de Leilão");

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel4.setText("Descrição do produto");

        jLabel2.setText("Nome do produto");

        txt_nome_produto.setEditable(false);

        txt_lanceInicial_produto.setEditable(false);

        jLabel3.setText("Lance inicial");

        jLabel5.setText("Lance atual");

        txt_lanceCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_lanceClienteActionPerformed(evt);
            }
        });

        atxt_descricao.setEditable(false);
        atxt_descricao.setColumns(20);
        atxt_descricao.setLineWrap(true);
        atxt_descricao.setRows(5);
        jScrollPane1.setViewportView(atxt_descricao);

        lb_tempo.setText("Lance atual");

        txt_lanceAutal.setEditable(false);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_nome_produto, javax.swing.GroupLayout.DEFAULT_SIZE, 20, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(103, 103, 103)
                        .addComponent(txt_lanceAutal))
                    .addComponent(lb_tempo)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_lanceCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txt_lanceInicial_produto, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(34, 34, 34)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(66, 66, 66)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 84, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );

        jPanel2Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {jLabel2, jLabel3, jLabel5, lb_tempo, txt_lanceAutal, txt_lanceCliente, txt_lanceInicial_produto, txt_nome_produto});

        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(7, 7, 7)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txt_lanceInicial_produto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txt_nome_produto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txt_lanceAutal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lb_tempo))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txt_lanceCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        bt_voltar.setIcon(new javax.swing.ImageIcon("C:\\Users\\ynhic\\Downloads\\left-arrow.png")); // NOI18N
        bt_voltar.setText("Voltar");
        bt_voltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_voltarActionPerformed(evt);
            }
        });

        bt_lance.setIcon(new javax.swing.ImageIcon("C:\\Users\\ynhic\\Downloads\\law.png")); // NOI18N
        bt_lance.setText("Dar lance");
        bt_lance.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_lanceActionPerformed(evt);
            }
        });

        br_selecionar.setIcon(new javax.swing.ImageIcon("C:\\Users\\ynhic\\Downloads\\table.png")); // NOI18N
        br_selecionar.setText("Selecionar Produto");
        br_selecionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                br_selecionarActionPerformed(evt);
            }
        });

        jLabel6.setText("Usuário:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(br_selecionar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(bt_lance)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(bt_voltar))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lb_email, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel1))
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 10, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {br_selecionar, bt_lance, bt_voltar});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel6)
                        .addComponent(lb_email))
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bt_voltar)
                    .addComponent(bt_lance)
                    .addComponent(br_selecionar))
                .addContainerGap())
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.VERTICAL, new java.awt.Component[] {jLabel6, lb_email});

        jLabel7.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 18)); // NOI18N
        jLabel7.setIcon(new javax.swing.ImageIcon("C:\\Users\\ynhic\\Desktop\\auction-hammer-icon (1).png")); // NOI18N
        jLabel7.setText("              Fatec Leilão");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(83, 83, 83)
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 413, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(12, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        if (!"".equals(nome_produto) || !"".equals(lance_inicial) || !"".equals(descricao_prodto)) {
            txt_nome_produto.setText(nome_produto);
            txt_lanceInicial_produto.setText(lance_inicial);
            atxt_descricao.setText(descricao_prodto);

            produtoVO.setCod_produto(cod_produto);
            produtoVO.setDescricao_produto(descricao_prodto);
            produtoVO.setLance_produto(lance_inicial);
            produtoVO.setNome_produto(nome_produto);
            txt_lanceAutal.setText(cod_produto);

            //teste temporizador
            Timer t;

            t = new Timer(2000, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String lanceAtual;
                    ServidorInter objeto1 = null;

                    try {
                        LocateRegistry.getRegistry("192.168.0.102");
                        objeto1 = (ServidorInter) Naming.lookup("rmi://localhost:9999/MensageiroService");
                        lanceAtual = objeto1.atualizarLance(cod_produto);
                        txt_lanceAutal.setText(lanceAtual);
                    } catch (RemoteException | NotBoundException | MalformedURLException ex) {
                        Logger.getLogger(LeilaoClienteGUI.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            });
            t.start();
        }
        lb_email.setText(clienteVO.getEmail());

    }//GEN-LAST:event_formWindowOpened

    private void bt_voltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_voltarActionPerformed
        MenuClienteGUI menu = new MenuClienteGUI();
        menu.clienteVO.setEmail(clienteVO.getEmail());
        menu.clienteVO.setSenha(clienteVO.getSenha());
        menu.setVisible(true);
        this.dispose();

    }//GEN-LAST:event_bt_voltarActionPerformed

    private void br_selecionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_br_selecionarActionPerformed
        ListaProdutosClienteGUI lista = new ListaProdutosClienteGUI();
        lista.clienteVO.setEmail(clienteVO.getEmail());
        lista.clienteVO.setSenha(clienteVO.getSenha());
        lista.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_br_selecionarActionPerformed

    private void bt_lanceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_lanceActionPerformed

        boolean valida;
        ServidorInter objeto1 = null;
        produtoVO.setLance_atual(txt_lanceCliente.getText());
        produtoVO.setEmailVencedor(clienteVO.getEmail());
        lance_atual = txt_lanceCliente.getText();
        
        if (lance_atual.equals("") != true) {
            try {
                LocateRegistry.getRegistry("192.168.0.102");
                objeto1 = (ServidorInter) Naming.lookup("rmi://localhost:9999/MensageiroService");
                
                valida = objeto1.validaLance(cod_produto, lance_atual);
                
                if (valida != false) {
                    
                    valida = objeto1.darLance(produtoVO);
                    
                    if (valida == true) {
                        JOptionPane.showMessageDialog(rootPane, "Lance feito com sucesso",
                                "Mensagem ao Usuário", JOptionPane.INFORMATION_MESSAGE);
                    }
                } else {
                    
                    JOptionPane.showMessageDialog(rootPane, "Lance incorreto, valor não pode ser menor que o lance atual ou lance inicial",
                            "Mensagem ao Usuário", JOptionPane.INFORMATION_MESSAGE);
                    
                }
            } catch (RemoteException | NotBoundException | MalformedURLException ex) {
                Logger.getLogger(LeilaoClienteGUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Digite um lance",
                    "Mensagem ao Usuário", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_bt_lanceActionPerformed

    private void txt_lanceClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_lanceClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_lanceClienteActionPerformed

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
            java.util.logging.Logger.getLogger(LeilaoClienteGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LeilaoClienteGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LeilaoClienteGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LeilaoClienteGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LeilaoClienteGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea atxt_descricao;
    private javax.swing.JToggleButton br_selecionar;
    private javax.swing.JButton bt_lance;
    private javax.swing.JButton bt_voltar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lb_email;
    private javax.swing.JLabel lb_tempo;
    private javax.swing.JTextField txt_lanceAutal;
    private javax.swing.JTextField txt_lanceCliente;
    private javax.swing.JTextField txt_lanceInicial_produto;
    private javax.swing.JTextField txt_nome_produto;
    // End of variables declaration//GEN-END:variables
}
