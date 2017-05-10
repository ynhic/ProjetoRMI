/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fatec.br.projetormi.servidor;

import fatec.br.projetormi.servidor.VO.Cadastro_clientesVO;
import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author ynhic
 */
public interface ServidorInter extends Remote{
    
    //fazer o login atraves da tela autentificaçãoGUI
    public boolean validarSenha( String email, String senha ) throws RemoteException; 
    //faz o cadastro atraves da tela cadastro_clienteGUI
    public boolean cadastrarCli(Cadastro_clientesVO obj) throws RemoteException;
    //Faz a busca de cadastro atraves da tela cadastroGI
    public Cadastro_clientesVO buscarCli(Cadastro_clientesVO clienteVO) throws RemoteException;
    //exclui um cadastro do BD
    public void deletarCli(String cpf) throws RemoteException;
    
    
    
}
