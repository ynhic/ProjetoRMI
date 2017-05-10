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
    
    
    public boolean validarSenha( String email, String senha ) throws RemoteException; 
    
    public boolean cadastrarCli(Cadastro_clientesVO obj) throws RemoteException;
    
    
}
