package br.com.aleferamos.BookStore.exceptions;

public class RegraDeNegocioException extends RuntimeException{

    public RegraDeNegocioException() {
        super("erro.naoEncontrado");
    }
    public RegraDeNegocioException(String mensagem) {
        super(mensagem);
    }
}