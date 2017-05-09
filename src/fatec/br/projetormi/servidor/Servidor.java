/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fatec.br.projetormi.servidor;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
/**
 *
 * @author ynhic
 */
public class Servidor {
    public static void main(String[] args) {
        System.out.println("Server ativo...");
        new Servidor();
    }
    
    public Servidor(){
        
        try{
            ServidorInter objeto1 = new ServidorImpl();
            //registra o servidor  pela porta 9999, evitando de 
            //faze-lo  no console usando RMIC
            
            LocateRegistry.createRegistry(9999);
            Naming.rebind("rmi://localhost:9999/MensageiroService", objeto1);
             
        } catch (MalformedURLException | RemoteException e){
            System.out.println("Erro "+e);
        }
    
    }
}
