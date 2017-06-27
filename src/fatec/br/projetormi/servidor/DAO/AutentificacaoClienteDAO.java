/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fatec.br.projetormi.servidor.DAO;

import fatec.br.projetormi.servidor.VO.AutentificacaoClienteVO;
import viotti.Banco.Conexao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Ynhic <ynhic@hotmail.com>
 */
public class AutentificacaoClienteDAO {
    //------------ Atributos ------------   

    private Conexao conexao;
    private PreparedStatement pst;
    private ResultSet rs;
    private Statement st;
    private String sql = null;
    private AutentificacaoClienteVO autentificacaoVO = null;

    public AutentificacaoClienteDAO(Conexao conexao) {
        /**
         * @param conexao informacoes sobre o banco
         *
         * Este metodo conecta a classe DAO com o banco de dados
         */
        this.conexao = conexao;
    }

    public AutentificacaoClienteVO validarSenha(String email, String senha) throws SQLException {
        /**
         * @param cpf sera procurado na coluna de cpfCli na tabela "tabCliente"
         *
         * @return ClienteVO clienteVO
         * @return null
         *
         * Este metodo busca os dados referente ao String cpf, passado por
         * paramentro, na tabela de "tabCliente" do banco de dados "LeilaoRMI"
         */
        conexao.abrir(); //Abre a conexao com o banco
        //Cadastro_clientesVO clienteVO = new Cadastro_clientesVO(); //Cria o objeto clienteVO

        sql = "select * from tabCliente where email_cliente = ? and senha_cliente = ?"; //Comando SQL para busca

        pst = conexao.con().prepareStatement(sql);
        pst.setString(1, email); //Troca "?" do comando SQL
        pst.setString(2, senha); //Troca "?" do comando SQL
        rs = pst.executeQuery(); //Executa o comando SQL

        if (rs.next()) //Quando encontrado...
        {
            autentificacaoVO = new AutentificacaoClienteVO(); //Instancia um novo objeto ClienteVO 
            //dados pessoais
            autentificacaoVO.setEmail(rs.getString("email_cliente")); //Armazena o conteudo da coluna "nome_cliente" na variavel nome do objeto clienteVO
            autentificacaoVO.setSenha(rs.getString("senha_cliente"));

        } else //Se nao encontrar...
        {
            return null; //Retorna null
        }
        conexao.fechar(); //Fecha a conexao com o banco
        return autentificacaoVO; //Retorna o objeto clienteVO 

    }

}
