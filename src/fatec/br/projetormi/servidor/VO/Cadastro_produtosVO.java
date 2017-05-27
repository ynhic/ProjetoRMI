/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fatec.br.projetormi.servidor.VO;

import java.io.Serializable;
import java.util.Vector;

/**
 *
 * @author Ynhic <ynhic@hotmail.com>
 */
public class Cadastro_produtosVO implements Serializable {

    private String nome_produto;
    private String lance_produto;
    private String lance_atual;
    private String descricao_produto;
    private String Cod_produto;
    private String status;
    private String emailVencedor;
    private String senhaLeilao;

    public String getSenhaLeilao() {
        return senhaLeilao;
    }

    public void setSenhaLeilao(String senhaLeilao) {
        this.senhaLeilao = senhaLeilao;
    }

    public String getEmailVencedor() {
        return emailVencedor;
    }

    public void setEmailVencedor(String emailVencedor) {
        this.emailVencedor = emailVencedor;
    }

    public String getLance_atual() {
        return lance_atual;
    }

    public void setLance_atual(String lance_atual) {
        this.lance_atual = lance_atual;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCod_produto() {
        return Cod_produto;
    }

    public void setCod_produto(String Cod_produto) {
        this.Cod_produto = Cod_produto;
    }

    public String getNome_produto() {
        return nome_produto;
    }

    public void setNome_produto(String nome_produto) {
        this.nome_produto = nome_produto;
    }

    public String getLance_produto() {
        return lance_produto;
    }

    public void setLance_produto(String lance_produto) {
        this.lance_produto = lance_produto;
    }

    public String getDescricao_produto() {
        return descricao_produto;
    }

    public void setDescricao_produto(String descricao_produto) {
        this.descricao_produto = descricao_produto;
    }

    public Vector toVector() {
        Vector retorno = new Vector(4);
        retorno.add(Cod_produto);
        retorno.add(nome_produto);
        retorno.add(descricao_produto);
        retorno.add(lance_produto);
        retorno.add(lance_atual);
        retorno.add(emailVencedor);       
        return retorno;
    }
}
