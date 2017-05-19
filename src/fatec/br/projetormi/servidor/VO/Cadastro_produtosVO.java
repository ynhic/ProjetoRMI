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
 * @author ynhic
 */
public class Cadastro_produtosVO implements Serializable{
    String nome_produto;
    String lance_produto;
    String descricao_produto; 
    String Cod_produto;

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
    
    public Vector toVector() 
    {
        Vector retorno = new Vector(4);
        retorno.add(Cod_produto);
        retorno.add(nome_produto); 
        retorno.add(descricao_produto);
        retorno.add(lance_produto);
        return retorno;
    }
}
