package com.dh.backendIntegrador.security;

import com.dh.backendIntegrador.entity.Usuario;
import com.dh.backendIntegrador.entity.UsuarioRole;
import com.dh.backendIntegrador.respository.UsuarioRepository;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class CargarDatosIniciales implements ApplicationRunner {
    private UsuarioRepository usuarioRepository;
    public CargarDatosIniciales(UsuarioRepository usuarioRepository){
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public void run(ApplicationArguments args){
        BCryptPasswordEncoder cifrador = new BCryptPasswordEncoder();
        String passCifrada = cifrador.encode("admin");
        Usuario usuario =  new Usuario("Lionel", "messi", "messi@gmail.com", passCifrada, UsuarioRole.ROLE_USER);
        usuarioRepository.save(usuario);
        passCifrada = cifrador.encode("admin");
        usuario =  new Usuario("Diego", "maradona", "maradona@gmail.com", passCifrada, UsuarioRole.ROLE_ADMIN);
        usuarioRepository.save(usuario);

    }
}
