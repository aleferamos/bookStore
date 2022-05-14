package br.com.aleferamos.BookStore.exceptions;

public class RegistroNaoEncontradoException extends RuntimeException{

    public RegistroNaoEncontradoException() {
        super("erro.naoEncontrado");
    }

    public RegistroNaoEncontradoException(String mensagem) {
        super(mensagem);
    }
}