package br.com.aleferamos.BookStore.controllers.dto.endereco;

import br.com.aleferamos.BookStore.models.Endereco;

public class EnderecoAuthenticadDto {

    private Long id;
    private String endereco;
    private String cep;
    private String complemento;
    private int numero;
    private String cidade;
    private String estado;

    public EnderecoAuthenticadDto(Long id, String endereco, String cep, String complemento, int numero, String cidade, String estado) {
        this.id = id;
        this.endereco = endereco;
        this.cep = cep;
        this.complemento = complemento;
        this.numero = numero;
        this.cidade = cidade;
        this.estado = estado;
    }

    public EnderecoAuthenticadDto(Endereco endereco) {
        this.id = endereco.getId();
        this.endereco = endereco.getEndereco();
        this.cep = endereco.getCep();
        this.complemento = endereco.getComplemento();
        this.numero = endereco.getNumero();
        this.cidade = endereco.getCidade();
        this.estado = endereco.getEstado();
    }

    public EnderecoAuthenticadDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
