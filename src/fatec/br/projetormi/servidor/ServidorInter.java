/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fatec.br.projetormi.servidor;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author ynhic
 */
public interface ServidorInter extends Remote{
    
    
    public boolean validarSenha( String email, String senha ) throws RemoteException; 
    
}
