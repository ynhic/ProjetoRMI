/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package fatec.br.projetormi.servidor.DAO;

import fatec.br.projetormi.servidor.VO.CadastroVenda;
import fatec.br.projetormi.servidor.conexao.Conexao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Ynhic <ynhic@hotmail.com>
 */


public class CadastroVendaDAO {
    
    //------------ Atributos ------------   

    private Conexao conexao;
    private PreparedStatement pst;
    private ResultSet rs;
    private Statement st;
    private String sql = null;
    private CadastroVenda vendaVO = null;
    
     //------------ Metodos ------------
    public CadastroVendaDAO(Conexao conexao) {
        /**
         * @param conexao informacoes sobre o banco
         *
         * Este metodo conecta a classe DAO com o banco de dados
         */
        this.conexao = conexao;
    }
    
    public void cadastrarVenda(CadastroVenda obj) throws SQLException {
        conexao.abrir(); //Abre a conexao com o  banco
        sql = "Insert into tabvenda (idproduto, idcliente, nome_produto, descricao_produto, lance_inicial, lance_final,"
                + " email_cliente , senha_leilao) values (?, ?, ?, ?, ?, ?, ?, ?)"; //Comando SQL para cadastro   

        pst = conexao.con().prepareStatement(sql);

        //dados do produto  
        pst.setString(1, obj.getIdProduto());
        pst.setString(2, obj.getIdCliente());
        pst.setString(3, obj.getNomeProduto());
        pst.setString(4, obj.getDescricaoProduto());
        pst.setString(5, obj.getLanceInicial());
        pst.setString(6, obj.getLanceFinal());
        pst.setString(7, obj.getEmailCliente());
        pst.setString(8, obj.getSenhaLeilao());

        pst.executeUpdate(); //Execulta o comando SQL

        conexao.fechar(); //Fecha a conexao com o banco
    }
    
    public CadastroVenda buscaIdCliente(CadastroVenda obj) throws SQLException {

        
        conexao.abrir(); //Abre a conexao com o banco
        

        sql = "select * from tabCliente where EMAIL_CLIENTE = ?"; //Comando SQL para busca

        pst = conexao.con().prepareStatement(sql);
        pst.setString(1, obj.getEmailCliente()); //Troca "?" do comando SQL
        rs = pst.executeQuery(); //Executa o comando SQL

        if (rs.next()) //Quando encontrado...
        {

            obj.setIdCliente(rs.getString("IDCLI"));

        } else //Se nao encontrar...
        {
            obj.setIdCliente("666");
            
        }

        System.out.println(obj.getEmailCliente());
        //obj.setIdCliente("N/E");
        return obj;

    }

    public boolean alterarStatus(CadastroVenda obj) throws SQLException{
        conexao.abrir();
        sql = "UPDATE TABPRODUTO SET STATUS = ? WHERE IDPRODUTO = ?";
        
        pst = conexao.con().prepareStatement(sql);
        
        if (obj != null) {
            pst.setString(1, "VEND");
            pst.setString(2, obj.getIdProduto());
            
            pst.execute();
            conexao.fechar();
            
            return true;
        } else {
            
            return false;
        }
    }
    
    public boolean validaSenha(CadastroVenda obj) throws SQLException{
        conexao.abrir(); //Abre a conexao com o banco
        

        sql = "select * from tabproduto where senha_leilao = ?"; //Comando SQL para busca
        
        pst = conexao.con().prepareStatement(sql);
        pst.setString(1, obj.getSenhaLeilao()); //Troca "?" do comando SQL
        System.out.println(obj.getSenhaLeilao());
        rs = pst.executeQuery(); //Executa o comando SQL
        return rs.next(); //Quando encontrado...
        
        
    }

    
    
    

}
