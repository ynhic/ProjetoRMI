/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fatec.br.projetormi.servidor;

import fatec.br.projetormi.servidor.DAO.AutentificacaoClienteDAO;
import fatec.br.projetormi.servidor.DAO.Cadastro_clientesDAO;
import fatec.br.projetormi.servidor.DAO.Cadastro_produtosDAO;
import fatec.br.projetormi.servidor.VO.AutentificacaoClienteVO;
import fatec.br.projetormi.servidor.VO.Cadastro_clientesVO;
import fatec.br.projetormi.servidor.VO.Cadastro_produtosVO;
import fatec.br.projetormi.servidor.conexao.Conexao;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ynhic
 */
public class ServidorImpl extends UnicastRemoteObject implements ServidorInter {

    public ServidorImpl() throws RemoteException {
        super();
    }
    
    

    /**
     *
     * @param email
     * @param senha
     * @return
     * @throws RemoteException
     * @throws SQLException
     */
    @Override
    public boolean validarSenha(String email, String senha) throws RemoteException {
         //dados para realizar conexao com o BD
        Conexao conexao = new Conexao();
        conexao.setNomeBanco("leilaoapp");
        conexao.setPorta(3306);
        conexao.setSenha("");
        conexao.setServidor("localhost");
        conexao.setUsuario("root");
        //boolean para validar se encontrou o registro
        boolean valida = false;
        
        //cria obj AutentificacaoVO e AutentificacaoDAO
        AutentificacaoClienteVO autentificacaoVO;
        AutentificacaoClienteDAO autentificacaoDAO = new AutentificacaoClienteDAO(conexao);
        

        try {
            autentificacaoVO = autentificacaoDAO.validarSenha(email, senha);
            System.out.println(autentificacaoVO.getEmail() + autentificacaoVO.getSenha());

            if (autentificacaoVO.getEmail().equals(email) && autentificacaoVO.getSenha().equals(senha)) {
                valida = true;
            } else {
                valida = false;
            }

        } catch (SQLException ex) {
            System.out.println("Erro " + ex);
        }

        return valida;
        
    }
    
    /**
     *
     * @param obj
     * @return
     * @throws RemoteException
     */
    @Override
    public boolean cadastrarCli(Cadastro_clientesVO obj) throws RemoteException{
        //dados para realizar conexao com o BD
        Conexao conexao = new Conexao();
        conexao.setNomeBanco("leilaoapp");
        conexao.setPorta(3306);
        conexao.setSenha("");
        conexao.setServidor("localhost");
        conexao.setUsuario("root");
        //boolean para validar se encontrou o registro
        boolean valida = false;
        
        //cria obj cadastroVO e cadastroDAO
        //Cadastro_clientesVO cadastro_clientesVO;
        Cadastro_clientesDAO cadastro_clientesDAO = new Cadastro_clientesDAO(conexao);
        
        try{
            
            valida = cadastro_clientesDAO.cadastrarCli(obj);
            
        } catch (SQLException ex) {
            System.out.println("Erro " + ex);
        }
        
        
        
        return valida;
    }
    
    public Cadastro_clientesVO buscarCli(Cadastro_clientesVO clienteVO) throws RemoteException{
        
        Conexao conexao = new Conexao();
        conexao.setNomeBanco("leilaoapp");
        conexao.setPorta(3306);
        conexao.setSenha("");
        conexao.setServidor("localhost");
        conexao.setUsuario("root");
        
        Cadastro_clientesDAO cadastro_clientesDAO = new Cadastro_clientesDAO(conexao);
        
        Cadastro_clientesVO cliente = new Cadastro_clientesVO();
        
        try {
            cliente = cadastro_clientesDAO.buscarCli(clienteVO);
            
        } catch (SQLException ex) {
            System.out.println("Erro " + ex);
        }
      
        
        return cliente;
        
    }
    
    /**
     *
     * @param cpf
     * @throws RemoteException
     */
    @Override
    public void deletarCli(String cpf) throws RemoteException{
        
        Conexao conexao = new Conexao();
        conexao.setNomeBanco("leilaoapp");
        conexao.setPorta(3306);
        conexao.setSenha("");
        conexao.setServidor("localhost");
        conexao.setUsuario("root");
        
        Cadastro_clientesDAO cadastro_clientesDAO = new Cadastro_clientesDAO(conexao);
        
        try{
            
            cadastro_clientesDAO.deletarCli(cpf);
            
        } catch (SQLException ex) {
            System.out.println("Erro " + ex);
        }
        
    }
    
    /**************************************************************
    *Essa metodo faz a alteração nos dados cadastrados no BD      *
     * @param obj
     * @return 
     * @throws java.rmi.RemoteException
    **************************************************************/
    @Override
    public boolean editarCli(Cadastro_clientesVO obj) throws RemoteException{
        
        Conexao conexao = new Conexao();
        conexao.setNomeBanco("leilaoapp");
        conexao.setPorta(3306);
        conexao.setSenha("");
        conexao.setServidor("localhost");
        conexao.setUsuario("root");
        
        Cadastro_clientesDAO cadastro_clientesDAO = new Cadastro_clientesDAO(conexao);
        boolean valida=false;
        
        try{
            valida = cadastro_clientesDAO.editarCli(obj);
        } catch (SQLException ex) {
            System.out.println("Erro " + ex);
        }
        
        return valida;
    }
    
    
    
    /**************************************************************
    *Essa metodo faz a cadastro de dados sobre produtos no BD     *
     * @param obj
     * @return 
     * @throws java.rmi.RemoteException
    **************************************************************/
    @Override
    public boolean cadastrar_produtos(Cadastro_produtosVO obj) throws RemoteException{
        Conexao conexao = new Conexao();
        conexao.setNomeBanco("leilaoapp");
        conexao.setPorta(3306);
        conexao.setSenha("");
        conexao.setServidor("localhost");
        conexao.setUsuario("root");
        
        Cadastro_produtosDAO cadastro_produtosDAO = new Cadastro_produtosDAO(conexao);
        
        
        try{
            cadastro_produtosDAO.cadastrar_produtos(obj);
            return true;
        } catch (SQLException ex) {
            System.out.println("Erro " + ex);
            return false;
        }
        
    }
    @Override
    public List<Cadastro_produtosVO> listar(String status) throws RemoteException{
        Conexao conexao = new Conexao();
        conexao.setNomeBanco("leilaoapp");
        conexao.setPorta(3306);
        conexao.setSenha("");
        conexao.setServidor("localhost");
        conexao.setUsuario("root");
        
        Cadastro_produtosDAO cadastro_produtosDAO = new Cadastro_produtosDAO(conexao);
        
        List <Cadastro_produtosVO> lista_produto = new Vector<>();
        
        try {
            lista_produto = cadastro_produtosDAO.listar(status);
        } catch (SQLException ex) {
            Logger.getLogger(ServidorImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
                
                
        return lista_produto;        
        
        
    }
    
}
    
    