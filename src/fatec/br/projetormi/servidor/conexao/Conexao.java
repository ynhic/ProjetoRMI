/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fatec.br.projetormi.servidor.conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author ynhic
 */
public class Conexao {
    private String usuario;
    private String senha;
    private String servidor;
    private String nomeBanco;
    private int porta;
    private Connection conexao;
    
    
    public boolean abrir() 
    {
    /**
     * Este metodo abre a conexao com o banco de dados informado pelos atribultos
     */    
        try 
        {
            Class.forName("com.mysql.jdbc.Driver");
            String url = "jdbc:mysql://" + getServidor() + ":" + getPorta() + "/" + getNomeBanco();
            setConexao(DriverManager.getConnection(url, getUsuario(), getSenha()));
            System.out.println("abriu");
            return true;
            
        } 
        catch (SQLException ex) 
        {
            JOptionPane.showMessageDialog(null, "Erro SQL:" + ex.getMessage());
        } 
        catch (ClassNotFoundException ex) 
        {
            JOptionPane.showMessageDialog(null, "Erro Class:" + ex.getMessage());
        }
        return false;
    }
    
    
    public void fechar() 
    {
    /**
     * Este metodo fecha a conexao com o banco de dados informado pelos atribultos
     */     
        try 
        {
            conexao.close();
        } 
        catch (SQLException ex) 
        {
            JOptionPane.showMessageDialog(null, "Erro:" + ex.getMessage());
        }
    }
    
    public Connection con() 
    {
        return conexao;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getServidor() {
        return servidor;
    }

    public void setServidor(String servidor) {
        this.servidor = servidor;
    }

    public String getNomeBanco() {
        return nomeBanco;
    }

    public void setNomeBanco(String nomeBanco) {
        this.nomeBanco = nomeBanco;
    }

    public int getPorta() {
        return porta;
    }

    public void setPorta(int porta) {
        this.porta = porta;
    }

    public Connection getConexao() {
        return conexao;
    }

    public void setConexao(Connection conexao) {
        this.conexao = conexao;
    }
    
}
