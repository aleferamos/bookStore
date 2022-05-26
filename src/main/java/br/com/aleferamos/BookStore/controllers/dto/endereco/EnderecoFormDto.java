package br.com.aleferamos.BookStore.controllers.dto.endereco;

import br.com.aleferamos.BookStore.exceptions.RegraDeNegocioException;
import br.com.aleferamos.BookStore.models.Endereco;
import lombok.Getter;
import lombok.NoArgsConstructor;

public class EnderecoFormDto {

    private String endereco;

    private String cep;

    private String complemento;

    private Integer numero;

    private String cidade;

    private String estado;

    public EnderecoFormDto(String endereco, String cep, String complemento, int numero, String cidade, String estado) {
        this.endereco = endereco;
        this.cep = cep;
        this.complemento = complemento;
        this.numero = numero;
        this.cidade = cidade;
        this.estado = estado;
    }

    public EnderecoFormDto() {
    }

    public EnderecoFormDto(Endereco endereco) {
        this.endereco = endereco.getEndereco();
        this.cep = endereco.getCep();
        this.complemento = endereco.getComplemento();
        this.numero = endereco.getNumero();
        this.cidade = endereco.getCidade();
        this.estado = endereco.getEstado();
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        if(endereco.isEmpty()){
            throw new RegraDeNegocioException("endereco.IsEmpty");
        }
        this.endereco = endereco;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        if(cep.isEmpty()){
            throw new RegraDeNegocioException("cep.isEmpty");
        }
        this.cep = cep;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        if(complemento.isEmpty()){
            throw new RegraDeNegocioException("complemento.isEmpty");
        }
        this.complemento = complemento;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        if(numero == null){
            throw new RegraDeNegocioException("numero.isEmpty");
        }
        this.numero = numero;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        if(cidade.isEmpty()){
            throw new RegraDeNegocioException("cidade.isEmpty");
        }
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        if(estado.isEmpty()){
            throw new RegraDeNegocioException("estado.isEmpty");
        }
        this.estado = estado;
    }
}
