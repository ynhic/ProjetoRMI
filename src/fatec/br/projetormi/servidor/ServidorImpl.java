/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fatec.br.projetormi.servidor;

import fatec.br.projetormi.servidor.DAO.AutentificacaoDAO;
import fatec.br.projetormi.servidor.DAO.Cadastro_clientesDAO;
import fatec.br.projetormi.servidor.VO.AutentificacaoVO;
import fatec.br.projetormi.servidor.VO.Cadastro_clientesVO;
import fatec.br.projetormi.servidor.conexao.Conexao;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.SQLException;
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
        AutentificacaoVO autentificacaoVO;
        AutentificacaoDAO autentificacaoDAO = new AutentificacaoDAO(conexao);
        

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
}
    
    