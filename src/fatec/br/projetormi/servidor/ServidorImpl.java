/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fatec.br.projetormi.servidor;

import fatec.br.projetormi.servidor.DAO.AutentificacaoDAO;
import fatec.br.projetormi.servidor.VO.AutentificacaoVO;
import fatec.br.projetormi.servidor.conexao.Conexao;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.SQLException;

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
        Conexao conexao = new Conexao();
        conexao.setNomeBanco("leilaoapp");
        conexao.setPorta(3306);
        conexao.setSenha("");
        conexao.setServidor("localhost");
        conexao.setUsuario("root"); 
        
        
        //
    
        AutentificacaoVO autentificacaoVO;
        AutentificacaoDAO autentificacaoDAO = new AutentificacaoDAO(conexao);
        boolean valida = false;

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
}
    
    