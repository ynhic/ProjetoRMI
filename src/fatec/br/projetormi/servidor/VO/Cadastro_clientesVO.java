/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fatec.br.projetormi.servidor.VO;

import java.sql.Date;

/**
 *
 * @author ynhic
 */
public class Cadastro_clientesVO {
    private String nome;
    private String rg;
    private String cpf;
    private Date datanasc;
    private String sexo;
    private String endereco_cliente;
    private String endereco_cliente_numero;
    private String endereco_cliente_complemento;
    private String endereco_cliente_cep;
    private String endereco_cliente_cidade;
    private String endereco_cliente_uf;
    private String endereco_cliente_pais;
    private String email_cliente;
    private String celular_cliente;
    private String telefone_cliente;
    private String senha_cliente;

    public String getSenha_cliente() {
        return senha_cliente;
    }

    public void setSenha_cliente(String senha_cliente) {
        this.senha_cliente = senha_cliente;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Date getDatanasc() {
        return datanasc;
    }

    public void setDatanasc(Date datanasc) {
        this.datanasc = datanasc;
    }


    public String getEndereco_cliente() {
        return endereco_cliente;
    }

    public void setEndereco_cliente(String endereco_cliente) {
        this.endereco_cliente = endereco_cliente;
    }

    public String getEndereco_cliente_numero() {
        return endereco_cliente_numero;
    }

    public void setEndereco_cliente_numero(String endereco_cliente_numero) {
        this.endereco_cliente_numero = endereco_cliente_numero;
    }

    public String getEndereco_cliente_complemento() {
        return endereco_cliente_complemento;
    }

    public void setEndereco_cliente_complemento(String endereco_cliente_complemento) {
        this.endereco_cliente_complemento = endereco_cliente_complemento;
    }

    public String getEndereco_cliente_cep() {
        return endereco_cliente_cep;
    }

    public void setEndereco_cliente_cep(String endereco_cliente_cep) {
        this.endereco_cliente_cep = endereco_cliente_cep;
    }

    public String getEndereco_cliente_cidade() {
        return endereco_cliente_cidade;
    }

    public void setEndereco_cliente_cidade(String endereco_cliente_cidade) {
        this.endereco_cliente_cidade = endereco_cliente_cidade;
    }

    public String getEndereco_cliente_uf() {
        return endereco_cliente_uf;
    }

    public void setEndereco_cliente_uf(String endereco_cliente_uf) {
        this.endereco_cliente_uf = endereco_cliente_uf;
    }

    public String getEndereco_cliente_pais() {
        return endereco_cliente_pais;
    }

    public void setEndereco_cliente_pais(String endereco_cliente_pais) {
        this.endereco_cliente_pais = endereco_cliente_pais;
    }

    public String getEmail_cliente() {
        return email_cliente;
    }

    public void setEmail_cliente(String email_cliente) {
        this.email_cliente = email_cliente;
    }

    public String getCelular_cliente() {
        return celular_cliente;
    }

    public void setCelular_cliente(String celular_cliente) {
        this.celular_cliente = celular_cliente;
    }

    public String getTelefone_cliente() {
        return telefone_cliente;
    }

    public void setTelefone_cliente(String telefone_cliente) {
        this.telefone_cliente = telefone_cliente;
    }
    
    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }
    
}
