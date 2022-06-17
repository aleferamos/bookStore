package br.com.aleferamos.BookStore.services;

import br.com.aleferamos.BookStore.exceptions.RegistroNaoEncontradoException;
import br.com.aleferamos.BookStore.models.ResetPasswordToken;
import br.com.aleferamos.BookStore.models.Usuario;
import br.com.aleferamos.BookStore.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.UUID;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    ResetPasswordTokenService resetPasswordService;

    @Autowired
    private PasswordEncoder encoder;

    public Usuario buscarPorEmail(String email) {
        return usuarioRepository.findByEmail(email).orElseThrow(() -> new RegistroNaoEncontradoException("usuario.naoEncontrado"));
    }

    public Usuario buscar(Long id) {
        return usuarioRepository.findById(id).orElseThrow(() -> new RegistroNaoEncontradoException("usuario.naoEncontrado"));
    }

    public ResetPasswordToken generateResetPasswordToken(Usuario obj) {
        Usuario user = this.buscar(obj.getId());
        ResetPasswordToken resetToken = new ResetPasswordToken();

        if(user != null) {
            resetToken.setUser(user);
            Date createdDate = new Date();
            resetToken.setToken(UUID.randomUUID().toString());
            resetToken.setCreatedDate(createdDate);
            resetPasswordService.insert(resetToken);
        }
        return resetToken;
    }

    public void updatePassword(Usuario usuario){
        Usuario usuarioFind = buscar(usuario.getId());
        usuarioFind.setSenha(encoder.encode(usuario.getSenha()));
        usuarioRepository.save(usuarioFind);
    }
}
