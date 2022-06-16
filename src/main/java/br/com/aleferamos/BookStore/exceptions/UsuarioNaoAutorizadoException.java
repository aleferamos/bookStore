package br.com.aleferamos.BookStore.exceptions;

public class UsuarioNaoAutorizadoException extends RuntimeException{

    public UsuarioNaoAutorizadoException() {
        super("usuario.naoAutorizado");
    }

    public UsuarioNaoAutorizadoException(String mensagem) {
        super(mensagem);
    }
}
