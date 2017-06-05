/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fatec.br.projetormi.cliente.servidor.GUI;

import fatec.br.projetormi.servidor.DAO.CadastroVendaDAO;
import fatec.br.projetormi.servidor.DAO.Cadastro_produtosDAO;
import fatec.br.projetormi.servidor.VO.CadastroVenda;
import fatec.br.projetormi.servidor.VO.Cadastro_produtosVO;
import fatec.br.projetormi.servidor.conexao.Conexao;
import java.sql.SQLException;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author Ynhic <ynhic@hotmail.com>
 */
public class ListaProdutosVendidosServidorGUI extends javax.swing.JFrame {

    //atributos
    Conexao conexao = new Conexao();
    Cadastro_produtosDAO cadastro_ProdutosDAO = new Cadastro_produtosDAO(conexao);
    Cadastro_produtosVO cadastro_produtosVO = new Cadastro_produtosVO();
    CadastroVenda vendaVO = new CadastroVenda();
    CadastroVendaDAO vendaDAO = new CadastroVendaDAO(conexao);
    String status;

    private DefaultTableModel tableModelProduto;

    /**
     * Creates new form ListaProdutosGUI
     */
    public ListaProdutosVendidosServidorGUI() {
        initComponents();
    }
    //metodos

    private void preencherTable() {
        Vector colunas = new Vector(4);
        colunas.add("Cod Venda");
        colunas.add("Cod Produto");
        colunas.add("Cod Cliente");
        colunas.add("Nome produto");
        colunas.add("Descrição");
        colunas.add("Lance inicial");
        colunas.add("Lance Final");
        colunas.add("Email Vencedor");

        status = "VEND";

        try {
            Vector<CadastroVenda> dado = (Vector) vendaDAO.listar(status);

            tableModelProduto = new DefaultTableModel();
            tableModelProduto.setColumnIdentifiers(colunas);

            tb_produtos.setModel(tableModelProduto);
            TableColumnModel modeloDaColuna = tb_produtos.getColumnModel();
            modeloDaColuna.getColumn(0).setMaxWidth(75);
            modeloDaColuna.getColumn(1).setMaxWidth(85);
            modeloDaColuna.getColumn(2).setMaxWidth(75);
            modeloDaColuna.getColumn(3).setMaxWidth(100);
            modeloDaColuna.getColumn(4).setMaxWidth(400);
            modeloDaColuna.getColumn(5).setMaxWidth(100);
            modeloDaColuna.getColumn(6).setMaxWidth(100);
            modeloDaColuna.getColumn(7).setMaxWidth(200);
            //for no estilo lambda
            dado.forEach((x) -> {
                tableModelProduto.addRow(x.toVector());
                
            });

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "problema de conexão" + ex, "Erro", JOptionPane.WARNING_MESSAGE);
        }
        tb_produtos.setModel(tableModelProduto);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        bt_voltar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tb_produtos = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Lista de Produtos Vendidos");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Lista produtos"));

        bt_voltar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fatec/br/projetormi/cliente/imagens/left-arrow.png"))); // NOI18N
        bt_voltar.setText("Voltar");
        bt_voltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_voltarActionPerformed(evt);
            }
        });

        tb_produtos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tb_produtos.setCellSelectionEnabled(true);
        tb_produtos.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tb_produtos.setEnabled(false);
        tb_produtos.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tb_produtos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tb_produtosMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tb_produtos);

        jLabel1.setText("Produtos Vendidos");
        jLabel1.setName(""); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 1083, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(bt_voltar, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(23, 23, 23)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(bt_voltar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel5.setFont(new java.awt.Font("Yu Gothic UI Light", 1, 18)); // NOI18N
        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/fatec/br/projetormi/cliente/imagens/auction-hammer-icon (1).png"))); // NOI18N
        jLabel5.setText("      Fatec Leilão");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(434, 434, 434)
                .addComponent(jLabel5)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        /**
         * Este metodo preenche a tabela com os produtos cadastrados após o form
         * ser iniciado
         */
        conexao.setNomeBanco("LEILAOAPP");
        conexao.setPorta(3306);
        conexao.setSenha("");
        conexao.setServidor("localhost");
        conexao.setUsuario("root");
        preencherTable();

    }//GEN-LAST:event_formWindowOpened

    private void tb_produtosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tb_produtosMouseClicked

    }//GEN-LAST:event_tb_produtosMouseClicked

    private void bt_voltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_voltarActionPerformed
        MenuServidorGUI menu = new MenuServidorGUI();
        menu.setVisible(true);
        this.dispose();

    }//GEN-LAST:event_bt_voltarActionPerformed

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
            java.util.logging.Logger.getLogger(ListaProdutosVendidosServidorGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ListaProdutosVendidosServidorGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ListaProdutosVendidosServidorGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ListaProdutosVendidosServidorGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ListaProdutosVendidosServidorGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_voltar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tb_produtos;
    // End of variables declaration//GEN-END:variables
}