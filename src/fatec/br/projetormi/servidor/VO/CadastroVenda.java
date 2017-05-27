/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fatec.br.projetormi.servidor.VO;

/**
 *
 * @author Ynhic <ynhic@hotmail.com>
 */
public class CadastroVenda {

    private String idVenda;
    private String idProduto;
    private String idCliente;
    private String nomeProduto;
    private String descricaoProduto;
    private String lanceInicial;
    private String lanceFinal;
    private String emailCliente;
    private String senhaLeilao;

    public String getSenhaLeilao() {
        return senhaLeilao;
    }

    public void setSenhaLeilao(String senhaLeilao) {
        this.senhaLeilao = senhaLeilao;
    }

    public String getIdVenda() {
        return idVenda;
    }

    public void setIdVenda(String idVenda) {
        this.idVenda = idVenda;
    }

    public String getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(String idProduto) {
        this.idProduto = idProduto;
    }

    public String getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(String idCliente) {
        this.idCliente = idCliente;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public String getDescricaoProduto() {
        return descricaoProduto;
    }

    public void setDescricaoProduto(String descricaoProduto) {
        this.descricaoProduto = descricaoProduto;
    }

    public String getLanceInicial() {
        return lanceInicial;
    }

    public void setLanceInicial(String lanceInicial) {
        this.lanceInicial = lanceInicial;
    }

    public String getLanceFinal() {
        return lanceFinal;
    }

    public void setLanceFinal(String lanceFinal) {
        this.lanceFinal = lanceFinal;
    }

    public String getEmailCliente() {
        return emailCliente;
    }

    public void setEmailCliente(String emailCliente) {
        this.emailCliente = emailCliente;
    }

}
