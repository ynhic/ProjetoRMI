/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fatec.br.projetormi.servidor.DAO;

import fatec.br.projetormi.servidor.VO.Cadastro_clientesVO;
import fatec.br.projetormi.servidor.VO.Cadastro_produtosVO;
import fatec.br.projetormi.servidor.conexao.Conexao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Vector;

/**
 *
 * @author ynhic
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
    
    public Cadastro_produtosDAO(Conexao conexao) 
    {
    /**
     * @param conexao informacoes sobre o banco
     * 
     * Este metodo conecta a classe DAO com o banco de dados
     */      
        this.conexao = conexao;
    }
    
    
    public void cadastrar_produtos(Cadastro_produtosVO obj) throws SQLException 
    {
    /**
     * @param nome_produto nome a ser inserido na coluna nomeCli da tabela "tabProduto"
     * @param lance_produto cpf a ser inserido na coluna cpfCli da tabela "tabProduto"
     * @param descricao_produto data a ser inserido na coluna dataCli da tabela "tabProduto"
     *Este metodo cadastra na tabela "tabProdutos" do banco de dados "LeilaoRMI" os dados passados por paramentro    
     */     
        conexao.abrir(); //Abre a conexao com o  banco
        sql = "Insert into tabProduto (nome_produto, lance_produto, descricao_produto) values (?, ?, ?)"; //Comando SQL para cadastro   
        
        pst = conexao.con().prepareStatement(sql);       
        //dados do produto      
        pst.setString(1, obj.getNome_produto());
        pst.setString(2, obj.getLance_produto());
        pst.setString(3, obj.getDescricao_produto()); 
        
        pst.executeUpdate(); //Execulta o comando SQL
        
        conexao.fechar(); //Fecha a conexao com o banco
    }
    
    public List<Cadastro_produtosVO> listar() throws SQLException{
        /**
         * Este metodo busca todos os produtos no banco de dados e os armazena em um List
         */
        
        List <Cadastro_produtosVO> lista_produto = new Vector<>();
        
        conexao.abrir();//abre conexao com o banco
        sql = "SELECT * FROM TABPRODUTO";//comando sql
        
        st = conexao.con().createStatement();
        rs = st.executeQuery(sql);//executa comando sql
        
        while (rs.next()) {//quando encontrado
            Cadastro_produtosVO produtoVO = new Cadastro_produtosVO();//instancia um novo Cadastro_produto
            produtoVO.setNome_produto(rs.getString("NOME_PRODUTO"));
            produtoVO.setDescricao_produto(rs.getString("DESCRICAO_PRODUTO"));
            produtoVO.setLance_produto(rs.getString("LANCE_PRODUTO"));
            produtoVO.setCod_produto(rs.getString("IDPRODUTO"));
            
            lista_produto.add(produtoVO);
        }
        conexao.fechar();
        return lista_produto;//retorna o List
    }
    
    
    
    
}
