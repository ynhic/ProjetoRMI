/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fatec.br.projetormi.servidor.DAO;

import fatec.br.projetormi.servidor.VO.Cadastro_produtosVO;
import viotti.Banco.Conexao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Vector;

/**
 *
 * @author Ynhic <ynhic@hotmail.com>
 */
public class Cadastro_produtosDAO {
    //------------ Atributos ------------   

    private Conexao conexao;
    private PreparedStatement pst;
    private ResultSet rs;
    private Statement st;
    private String sql = null;
    private Cadastro_produtosVO produtosVO = null;

    //------------ Metodos ------------
    public Cadastro_produtosDAO(Conexao conexao) {
        /**
         * @param conexao informacoes sobre o banco
         *
         * Este metodo conecta a classe DAO com o banco de dados
         */
        this.conexao = conexao;
    }

    public void cadastrar_produtos(Cadastro_produtosVO obj) throws SQLException {
        /**
         * @param nome_produto nome a ser inserido na coluna nomeCli da tabela
         * "tabProduto"
         * @param lance_produto cpf a ser inserido na coluna cpfCli da tabela
         * "tabProduto"
         * @param descricao_produto data a ser inserido na coluna dataCli da
         * tabela "tabProduto" Este metodo cadastra na tabela "tabProdutos" do
         * banco de dados "LeilaoRMI" os dados passados por paramentro
         */
        conexao.abrir(); //Abre a conexao com o  banco
        sql = "Insert into tabProduto (nome_produto, lance_produto, descricao_produto, status, LANCE_FINAL, EMAILVENCEDOR) values (?, ?, ?, ?, ?, ?)"; //Comando SQL para cadastro   

        pst = conexao.con().prepareStatement(sql);
        //dados do produto      
        pst.setString(1, obj.getNome_produto());
        pst.setString(2, obj.getLance_produto());
        pst.setString(3, obj.getDescricao_produto());
        pst.setString(4, obj.getStatus());
        pst.setString(5, "0");
        pst.setString(6, "N/E");

        pst.executeUpdate(); //Execulta o comando SQL

        conexao.fechar(); //Fecha a conexao com o banco
    }

    public List<Cadastro_produtosVO> listar(String status) throws SQLException {
        /**
         * Este metodo busca todos os produtos no banco de dados e os armazena
         * em um List
         */

        List<Cadastro_produtosVO> lista_produto = new Vector<>();

        conexao.abrir();//abre conexao com o banco
        sql = "SELECT * FROM TABPRODUTO WHERE STATUS = ?";//comando sql
        System.out.println("busca padrao"+sql);

        
        pst = conexao.con().prepareStatement(sql);
        //dados do produto      
        pst.setString(1, status);
        //pst.setString(2, email);

        rs = pst.executeQuery();//executa comando sql

        while (rs.next()) {//quando encontrado
            Cadastro_produtosVO produtoVO = new Cadastro_produtosVO();//instancia um novo Cadastro_produto
            produtoVO.setNome_produto(rs.getString("NOME_PRODUTO"));
            produtoVO.setDescricao_produto(rs.getString("DESCRICAO_PRODUTO"));
            produtoVO.setLance_produto(rs.getString("LANCE_PRODUTO"));
            produtoVO.setCod_produto(rs.getString("IDPRODUTO"));
            produtoVO.setLance_atual(rs.getString("LANCE_FINAL"));
            produtoVO.setEmailVencedor(rs.getString("EMAILVENCEDOR"));
            

            lista_produto.add(produtoVO);
        }
        conexao.fechar();
        return lista_produto;//retorna o List
    }
    
    //metodo para mostrar leiloes que o cliente nao cadastrou
    public List<Cadastro_produtosVO> listar(String status, String email) throws SQLException {
        /**
         * Este metodo busca todos os produtos no banco de dados e os armazena
         * em um List
         */

        List<Cadastro_produtosVO> lista_produto = new Vector<>();

        conexao.abrir();//abre conexao com o banco
        sql = "SELECT * FROM TABPRODUTO WHERE STATUS = ? and emailvencedor NOT LIKE ?";//comando sql
        System.out.println("busca n padrao"+sql);

        pst = conexao.con().prepareStatement(sql);
        //dados do produto      
        pst.setString(1, status);
        pst.setString(2, email);

        rs = pst.executeQuery();//executa comando sql

        while (rs.next()) {//quando encontrado
            Cadastro_produtosVO produtoVO = new Cadastro_produtosVO();//instancia um novo Cadastro_produto
            produtoVO.setNome_produto(rs.getString("NOME_PRODUTO"));
            produtoVO.setDescricao_produto(rs.getString("DESCRICAO_PRODUTO"));
            produtoVO.setLance_produto(rs.getString("LANCE_PRODUTO"));
            produtoVO.setCod_produto(rs.getString("IDPRODUTO"));
            produtoVO.setLance_atual(rs.getString("LANCE_FINAL"));
            produtoVO.setEmailVencedor(rs.getString("EMAILVENCEDOR"));
            

            lista_produto.add(produtoVO);
        }
        conexao.fechar();
        return lista_produto;//retorna o List
    }

    public boolean editarCli(Cadastro_produtosVO obj) throws SQLException {
        /**
         * @param status nome a ser alterado na coluna status da tabela
         * "tabProduto"
         *
         * Este metodo altera os dados na tabela "tabProduto" do banco de dados
         * "Leilaoapp" referente aos dados passados por parametro
         */
        conexao.abrir(); //Abre a conexao com o banco
        sql = "UPDATE TABPRODUTO SET STATUS = ?, SENHA_LEILAO = ? WHERE IDPRODUTO = ?";

        pst = conexao.con().prepareStatement(sql);
        if (obj != null) {
            //dados pessoais        
            pst.setString(1, obj.getStatus());//Troca "?" do comando SQL
            pst.setString(2, obj.getSenhaLeilao());
            pst.setString(3, obj.getCod_produto());

            pst.execute(); //Executa o comando SQL
            conexao.fechar(); //Fecha a conexao com o banco 
            
            return true;

        } else {
            
            return false;
        }
    }

    public boolean darLance(Cadastro_produtosVO produtoVO) throws SQLException {

        conexao.abrir();
        sql = "UPDATE TABPRODUTO SET LANCE_FINAL = ?, EMAILVENCEDOR = ? WHERE IDPRODUTO = ?";

        pst = conexao.con().prepareStatement(sql);
        if (produtoVO != null) {
            pst.setString(1, produtoVO.getLance_atual());
            pst.setString(2, produtoVO.getEmailVencedor());
            pst.setString(3, produtoVO.getCod_produto());

            pst.execute();
            conexao.fechar();
            
            return true;
        } else {
            
            return false;
        }
    }

    public String atualizarLance(String idproduto) throws SQLException {

        conexao.abrir(); //Abre a conexao com o banco
        //Cadastro_clientesVO clienteVO = new Cadastro_clientesVO(); //Cria o objeto clienteVO
        String lanceAtual = "";

        sql = "select * from tabproduto where idproduto = ?"; //Comando SQL para busca

        pst = conexao.con().prepareStatement(sql);
        pst.setString(1, idproduto); //Troca "?" do comando SQL
        rs = pst.executeQuery(); //Executa o comando SQL

        if (rs.next()) {

            lanceAtual = (rs.getString("LANCE_FINAL"));

        } else //Se nao encontrar...
        {
            return lanceAtual; //Retorna null
        }
        final String s = lanceAtual;
        conexao.fechar();
        return s;
    }

    public boolean validaLance(String idproduto, String lanceAtual) throws SQLException {

        int atual = 0, anterior = 0, inicial = 0;

        conexao.abrir();

        sql = "select * from tabproduto where idproduto = ?"; //Comando SQL para busca

        pst = conexao.con().prepareStatement(sql);
        pst.setString(1, idproduto);
        rs = pst.executeQuery();

        if (rs.next()) {
            anterior = (rs.getInt("lance_final"));
            inicial = (rs.getInt("lance_produto"));

            atual = Integer.parseInt(lanceAtual);

            if (anterior == 0) {
                return atual > inicial;
            } else {
                return atual > anterior;
            }

        }
        return atual > anterior;

    }
    

}
