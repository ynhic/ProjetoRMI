/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fatec.br.projetormi.servidor;

import fatec.br.projetormi.servidor.VO.Cadastro_clientesVO;
import fatec.br.projetormi.servidor.VO.Cadastro_produtosVO;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/**
 *
 * @author ynhic
 */
public interface ServidorInter extends Remote{
    
    //fazer o login atraves da tela autentificaçãoGUI
    public boolean validarSenha( String email, String senha ) throws RemoteException; 
    //faz o cadastro atraves da tela cadastro_clienteGUI
    public boolean cadastrarCli(Cadastro_clientesVO obj) throws RemoteException;
    //Faz a busca de cadastro atraves da tela cadastroGUI
    public Cadastro_clientesVO buscarCli(Cadastro_clientesVO clienteVO) throws RemoteException;
    //exclui um cadastro do BD
    public void deletarCli(String cpf) throws RemoteException;
    //edita um cadastro atraves da tela cadastroGUI
    public boolean editarCli(Cadastro_clientesVO obj) throws RemoteException;
    //cadastra produtos atraves da tela produtos
    public boolean cadastrar_produtos(Cadastro_produtosVO obj) throws RemoteException;
    //busca os dados no BD para preencher a table produtos_cliente
    public List<Cadastro_produtosVO> listar(String status) throws RemoteException;
    
    
    
}
