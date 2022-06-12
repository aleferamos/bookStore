package br.com.aleferamos.BookStore.services;

import br.com.aleferamos.BookStore.exceptions.RegistroNaoEncontradoException;
import br.com.aleferamos.BookStore.models.Usuario;
import br.com.aleferamos.BookStore.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public Usuario buscarPorEmail(String email) {
        return usuarioRepository.findByEmail(email).orElseThrow(() -> new RegistroNaoEncontradoException("usuario.naoEncontrado"));
    }

    public Usuario buscar(Long id) {
        return usuarioRepository.findById(id).orElseThrow(() -> new RegistroNaoEncontradoException("usuario.naoEncontrado"));
    }
}
