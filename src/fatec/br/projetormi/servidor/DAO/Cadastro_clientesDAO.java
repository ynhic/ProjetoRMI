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


public class Cadastro_clientesDAO 
{
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
    
    public void cadastrarCli(String nome,
    String rg,
    String cpf,
    Date datanasc,
    String sexo,
    String endereco_cliente,
    String endereco_cliente_numero,
    String endereco_cliente_complemento,
    String endereco_cliente_cep,
    String endereco_cliente_cidade,
    String endereco_cliente_uf,
    String endereco_cliente_pais,
    String email_cliente,
    String celular_cliente,
    String telefone_cliente) throws SQLException 
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
                + " email_cliente, celular_cliente, telefone_cliente) values (?, ?, ?, ?, ?,?, ?, ?, ?, ?,?, ?, ?, ?, ?)"; //Comando SQL para cadastro   
        
        pst = conexao.con().prepareStatement(sql);       
        //dados pessoais        
        pst.setString(1, nome);//Troca "?" do comando SQL
        pst.setString(2,rg);//Troca "?" do comando SQL
        pst.setString(3,cpf);//Troca "?" do comando SQL
        pst.setDate(4,datanasc);//Troca "?" do comando SQL
        pst.setString(5,sexo);//Troca "?" do comando SQL
        //endereco
        pst.setString(6,endereco_cliente);//Troca "?" do comando SQL
        pst.setString(7,endereco_cliente_numero);//Troca "?" do comando SQL
        pst.setString(8,endereco_cliente_complemento);//Troca "?" do comando SQL
        pst.setString(9,endereco_cliente_cep);//Troca "?" do comando SQL
        pst.setString(10,endereco_cliente_cidade);//Troca "?" do comando SQL
        pst.setString(11,endereco_cliente_uf);//Troca "?" do comando SQL
        pst.setString(12,endereco_cliente_pais);//Troca "?" do comando SQL
        //contato
        pst.setString(13,email_cliente);//Troca "?" do comando SQL
        pst.setString(14,celular_cliente);//Troca "?" do comando SQL
        pst.setString(15,telefone_cliente);//Troca "?" do comando SQL
        
        
        pst.executeUpdate(); //Execulta o comando SQL
        
        conexao.fechar(); //Fecha a conexao com o banco
    }        
    
    public Cadastro_clientesVO buscarCli(String cpf) throws SQLException 
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
        Cadastro_clientesVO clienteVO = new Cadastro_clientesVO(); //Cria o objeto clienteVO
        
        sql = "select * from tabCliente where cpf_cliente = ?"; //Comando SQL para busca
        
        pst = conexao.con().prepareStatement(sql); 
        pst.setString(1, cpf); //Troca "?" do comando SQL
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

        } 
        else //Se nao encontrar...
        {
            return null; //Retorna null
        }
        
        conexao.fechar(); //Fecha a conexao com o banco
        return clienteVO; //Retorna o objeto clienteVO           
    }
    
    public void editarCli(String nome,
    String rg,
    String cpf,
    Date datanasc,
    String sexo,
    String endereco_cliente,
    String endereco_cliente_numero,
    String endereco_cliente_complemento,
    String endereco_cliente_cep,
    String endereco_cliente_cidade,
    String endereco_cliente_uf,
    String endereco_cliente_pais,
    String email_cliente,
    String celular_cliente,
    String telefone_cliente) throws SQLException  
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
                + " email_cliente = ?, celular_cliente = ?, telefone_cliente = ? WHERE cpf_cliente = ?"; //Comando SQL para editarCli            
                
        pst = conexao.con().prepareStatement(sql);
        
        pst.setString(1, nome);//Troca "?" do comando SQL
        pst.setString(2,rg);//Troca "?" do comando SQL
        pst.setString(15,cpf);//Troca "?" do comando SQL
        pst.setDate(3,datanasc);//Troca "?" do comando SQL
        pst.setString(4,sexo);//Troca "?" do comando SQL
        //endereco
        pst.setString(5,endereco_cliente);//Troca "?" do comando SQL
        pst.setString(6,endereco_cliente_numero);//Troca "?" do comando SQL
        pst.setString(7,endereco_cliente_complemento);//Troca "?" do comando SQL
        pst.setString(8,endereco_cliente_cep);//Troca "?" do comando SQL
        pst.setString(9,endereco_cliente_cidade);//Troca "?" do comando SQL
        pst.setString(10,endereco_cliente_uf);//Troca "?" do comando SQL
        pst.setString(11,endereco_cliente_pais);//Troca "?" do comando SQL
        //contato
        pst.setString(12,email_cliente);//Troca "?" do comando SQL
        pst.setString(13,celular_cliente);//Troca "?" do comando SQL
        pst.setString(14,telefone_cliente);//Troca "?" do comando SQL        

        pst.execute(); //Executa o comando SQL
        conexao.fechar(); //Fecha a conexao com o banco   
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
    
   /* public List<Cadastro_clientesVO> listar() throws SQLException 
    {
    /**
     * @return List lista_cliente
     * 
     * Este metodo busca todos clientes no banco de dados e os armazena em um List  
     */ 
        /*List <Cadastro_clientesVO> lista_cliente = new Vector<Cadastro_clientesVO>();
   
        conexao.abrir(); //Abre conexao com banco
        sql = "select * from tabCliente"; //Comando SQL para listagem
        
        st = conexao.con().createStatement();
        rs = st.executeQuery(sql); //Executa o comando SQL
        
        while(rs.next()) //Quando encontrado...
        {
            clienteVO = new Cadastro_clientesVO(); //Instacia um novo ProdutoVO
            clienteVO.setIdCLi(rs.getInt("idCli"));
            clienteVO.setCpf(rs.getString("cpfCli"));
            clienteVO.setNome(rs.getString("nomeCli"));
            clienteVO.setData(rs.getString("DataCli"));
            clienteVO.setTelefone(rs.getString("telCli"));
            clienteVO.setAposentado(rs.getString("statusCli"));
            
            lista_cliente.add(clienteVO); //Adicona o produtoVO criado no List
        }
        conexao.fechar(); //Fecha conexao com o banco
        return lista_cliente; //Retorna o List 
    }*/
}

