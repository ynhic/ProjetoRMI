package fatec.br.projetormi.servidor.DAO;

 

import fatec.br.projetormi.servidor.VO.Cadastro_clientesVO;
import java.sql.Date;
import fatec.br.projetormi.servidor.conexao.Conexao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.Vector;
import javax.swing.JOptionPane;


public class Cadastro_clientesDAO {
//------------ Atributos ------------   
    
    private Conexao conexao;
    private PreparedStatement pst;
    private ResultSet rs;
    private Statement st;
    private String sql = null;
    private Cadastro_clientesVO clienteVO = null;
    
//------------ Metodos ------------
    
    public Cadastro_clientesDAO(Conexao conexao) 
    {
    /**
     * @param conexao informacoes sobre o banco
     * 
     * Este metodo conecta a classe DAO com o banco de dados
     */      
        this.conexao = conexao;
    }
    
    public boolean cadastrarCli(Cadastro_clientesVO obj) throws SQLException 
    {
    /**
     * @param nome nome a ser inserido na coluna nomeCli da tabela "tabCliente"
     * @param cpf cpf a ser inserido na coluna cpfCli da tabela "tabCliente"
     * @param data data a ser inserido na coluna dataCli da tabela "tabCliente"
     * @param telefone telefone a ser inserido na coluna telCli da tabela "tabCliente"
     * @param status status a ser inserido na coluna statusCli da tabela "tabCliente"
     * 
     *Este metodo cadastra na tabela "tabCliente" do banco de dados "LeilaoRMI" os dados passados por paramentro    
     */     
        conexao.abrir(); //Abre a conexao com o  banco
        sql = "Insert into tabCliente (nome_cliente, rg_cliente, cpf_cliente, datanasc_cliente, sexo_cliente,"
                + " endereco_cliente, endereco_cliente_numero, endereco_cliente_complemento, "
                + "endereco_cliente_cep, endereco_cliente_cidade, endereco_cliente_uf, endereco_cliente_pais,"
                + " email_cliente, celular_cliente, telefone_cliente, senha_cliente) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)"; //Comando SQL para cadastro   
        
        pst = conexao.con().prepareStatement(sql);       
        //dados pessoais        
        pst.setString(1, obj.getNome());//Troca "?" do comando SQL
        pst.setString(2,obj.getRg());//Troca "?" do comando SQL
        pst.setString(3,obj.getCpf());//Troca "?" do comando SQL
        pst.setDate(4,obj.getDatanasc());//Troca "?" do comando SQL
        pst.setString(5,obj.getSexo());//Troca "?" do comando SQL
        //endereco
        pst.setString(6,obj.getEndereco_cliente());//Troca "?" do comando SQL
        pst.setString(7,obj.getEndereco_cliente_numero());//Troca "?" do comando SQL
        pst.setString(8,obj.getEndereco_cliente_complemento());//Troca "?" do comando SQL
        pst.setString(9,obj.getEndereco_cliente_cep());//Troca "?" do comando SQL
        pst.setString(10,obj.getEndereco_cliente_cidade());//Troca "?" do comando SQL
        pst.setString(11,obj.getEndereco_cliente_uf());//Troca "?" do comando SQL
        pst.setString(12,obj.getEndereco_cliente_pais());//Troca "?" do comando SQL
        //contato
        pst.setString(13,obj.getEmail_cliente());//Troca "?" do comando SQL
        pst.setString(14,obj.getCelular_cliente());//Troca "?" do comando SQL
        pst.setString(15,obj.getTelefone_cliente());//Troca "?" do comando SQL
        pst.setString(16, obj.getSenha_cliente());
        
        
        pst.executeUpdate(); //Execulta o comando SQL
        
        conexao.fechar(); //Fecha a conexao com o banco
        return true;
        
    }        
    
    public Cadastro_clientesVO buscarCli(Cadastro_clientesVO clienteVO) throws SQLException 
    {
    /**
     * @param cpf sera procurado na coluna de cpfCli na tabela "tabCliente"
     * 
     * @return ClienteVO clienteVO 
     * @return null 
     * 
     * Este metodo busca os dados referente ao String cpf, passado por paramentro, na tabela de "tabCliente" do banco de dados "LeilaoRMI" 
     */     
        conexao.abrir(); //Abre a conexao com o banco
        //Cadastro_clientesVO clienteVO = new Cadastro_clientesVO(); //Cria o objeto clienteVO
        
        sql = "select * from tabCliente where cpf_cliente = ?"; //Comando SQL para busca
        
        pst = conexao.con().prepareStatement(sql); 
        pst.setString(1, clienteVO.getCpf()); //Troca "?" do comando SQL
        rs = pst.executeQuery(); //Executa o comando SQL

        if (rs.next()) //Quando encontrado...
        {
            clienteVO = new Cadastro_clientesVO(); //Instancia um novo objeto ClienteVO 
            //dados pessoais
            clienteVO.setNome(rs.getString("nome_cliente")); //Armazena o conteudo da coluna "nome_cliente" na variavel nome do objeto clienteVO
            clienteVO.setRg(rs.getString("rg_cliente")); //Armazena o conteudo da coluna "rg_cliente" na variavel rg do objeto clienteVO
            clienteVO.setCpf(rs.getString("cpf_cliente")); //Armazena o conteudo da coluna "cpf_cliente" na variavel cpf do objeto clienteVO
            clienteVO.setDatanasc(rs.getDate("datanasc_cliente")); //Armazena o conteudo da coluna "datanasc_cliente" na variavel data do objeto clienteVO
            clienteVO.setSexo(rs.getString("sexo_cliente")); //Armazena o conteudo da coluna "sexo_cliente" na variavel sexo do objeto clienteVO
            //endereco
            clienteVO.setEndereco_cliente(rs.getString("endereco_cliente")); //Armazena o conteudo da coluna "endereco_cliente" na variavel endereco_cliente do objeto clienteVO
            clienteVO.setEndereco_cliente_numero(rs.getString("endereco_cliente_numero")); //Armazena o conteudo da coluna "endereco_cliente_numero" na variavel endereco_cliente_numero do objeto clienteVO
            clienteVO.setEndereco_cliente_complemento(rs.getString("endereco_cliente_complemento")); //Armazena o conteudo da coluna "endereco_cliente_complemento" na variavel endereco_cliente_complemento do objeto clienteVO
            clienteVO.setEndereco_cliente_cep(rs.getString("endereco_cliente_cep")); //Armazena o conteudo da coluna "endereco_cliente_cep" na variavel endereco_cliente_cep do objeto clienteVO
            clienteVO.setEndereco_cliente_cidade(rs.getString("endereco_cliente_cidade")); //Armazena o conteudo da coluna "endereco_cliente_cidade" na variavel endereco_cliente_cidade do objeto clienteVO
            clienteVO.setEndereco_cliente_uf(rs.getString("endereco_cliente_uf")); //Armazena o conteudo da coluna "endereco_cliente_uf" na variavel endereco_cliente_uf do objeto clienteVO
            clienteVO.setEndereco_cliente_pais(rs.getString("endereco_cliente_pais")); //Armazena o conteudo da coluna "endereco_cliente_pais" na variavel endereco_cliente_pais do objeto clienteVO
            //contatos
            clienteVO.setEmail_cliente(rs.getString("email_cliente")); //Armazena o conteudo da coluna "email_cliente" na variavel email_cliente do objeto clienteVO
            clienteVO.setCelular_cliente(rs.getString("celular_cliente")); //Armazena o conteudo da coluna "celular_cliente" na variavel celular_cliente do objeto clienteVO
            clienteVO.setTelefone_cliente(rs.getString("telefone_cliente")); //Armazena o conteudo da coluna "telefone_cliente" na variavel telefone_cliente do objeto clienteVO
            clienteVO.setSenha_cliente((rs.getString("senha_cliente")));
            
        } 
        else //Se nao encontrar...
        {
            return null; //Retorna null
        }
        
        conexao.fechar(); //Fecha a conexao com o banco
        return clienteVO; //Retorna o objeto clienteVO           
    }
    
    public boolean editarCli(Cadastro_clientesVO obj) throws SQLException  
    {
    /**
     * @param nome nome a ser alterado na coluna nomeCli da tabela "tabCliente"
     * @param cpf cpf a ser alterado na coluna cpfCli da tabela "tabCliente"
     * @param data data a ser alterado na coluna dataCli da tabela "tabCliente"
     * @param telefone telefone a ser alterado na coluna telCli da tabela "tabCliente"
     * @param status status a ser alterado na coluna statusCli da tabela "tabCliente"
     * 
     * Este metodo altera os dados na tabela "tabCliente" do banco de dados "LeilaoRMI" referente aos dados passados por parametro
     */    
        conexao.abrir(); //Abre a conexao com o banco
        sql = "update tabcliente set nome_cliente = ?, rg_cliente = ?, datanasc_cliente = ?, sexo_cliente = ?,"
                + " endereco_cliente = ?, endereco_cliente_numero = ?, endereco_cliente_complemento = ?, "
                + "endereco_cliente_cep = ?, endereco_cliente_cidade = ?, endereco_cliente_uf = ?, endereco_cliente_pais = ?,"
                + " email_cliente = ?, celular_cliente = ?, telefone_cliente = ?, senha_cliente = ? WHERE cpf_cliente = ?"; //Comando SQL para editarCli            
                
        pst = conexao.con().prepareStatement(sql);
        
        //dados pessoais        
        pst.setString(1, obj.getNome());//Troca "?" do comando SQL
        pst.setString(2,obj.getRg());//Troca "?" do comando SQL
        pst.setString(15,obj.getCpf());//Troca "?" do comando SQL
        pst.setDate(3,obj.getDatanasc());//Troca "?" do comando SQL
        pst.setString(4,obj.getSexo());//Troca "?" do comando SQL
        //endereco
        pst.setString(5,obj.getEndereco_cliente());//Troca "?" do comando SQL
        pst.setString(6,obj.getEndereco_cliente_numero());//Troca "?" do comando SQL
        pst.setString(7,obj.getEndereco_cliente_complemento());//Troca "?" do comando SQL
        pst.setString(8,obj.getEndereco_cliente_cep());//Troca "?" do comando SQL
        pst.setString(9,obj.getEndereco_cliente_cidade());//Troca "?" do comando SQL
        pst.setString(10,obj.getEndereco_cliente_uf());//Troca "?" do comando SQL
        pst.setString(11,obj.getEndereco_cliente_pais());//Troca "?" do comando SQL
        //contato
        pst.setString(12,obj.getEmail_cliente());//Troca "?" do comando SQL
        pst.setString(13,obj.getCelular_cliente());//Troca "?" do comando SQL
        pst.setString(14,obj.getTelefone_cliente());//Troca "?" do comando SQL
        pst.setString(16, obj.getSenha_cliente());
 
        pst.execute(); //Executa o comando SQL
        conexao.fechar(); //Fecha a conexao com o banco 
        return true;
       
    }
    
    public void deletarCli(String cpf) throws SQLException
    {
    /**
     * @param cpf sera procurado na coluna dataCli da tabela "tabCliente"
     * 
     * Este metodo deleta o conteudo da tabela "tabCliente" no banco de dados "LeilaoRMI" referente ao String digitado em txtCpf
     */    
        conexao.abrir(); //Abre a conexao com o banco
        sql = "delete from tabCliente where cpf_cliente = ?"; //Comando SQL para editarCli   
        
        pst = conexao.con().prepareStatement(sql);
        pst.setString(1, cpf); //Troca "?" do comando SQL
        
        pst.execute(); //Executa o comando SQL
        conexao.fechar(); //Fecha a conexao com o banco
    }        
    
}

