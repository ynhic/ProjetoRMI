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
 * @author Ynhic <ynhic@hotmail.com>
 */
public interface ServidorInter extends Remote {

    //fazer o login atraves da tela autentificaçãoGUI
    public boolean validarSenha(String email, String senha) throws RemoteException;

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

    //computa o lance no BD
    public boolean darLance(Cadastro_produtosVO produtoVO) throws RemoteException;

    //esse metodo atualiza o lance atual pegando o valor do servidor
    public String atualizarLance(String idproduto) throws RemoteException;

    //esse metodo validaLance faz a validacao do valor inserido pelo cliente
    public boolean validaLance(String idproduto, String lanceAtual) throws RemoteException;

}
