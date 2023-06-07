package com.example.BackTecVagas.services;

import com.example.BackTecVagas.exceptions.CriptoException;
import com.example.BackTecVagas.exceptions.EmailException;
import com.example.BackTecVagas.models.Usuario;
import com.example.BackTecVagas.models.UsuarioDTO;
import com.example.BackTecVagas.repositories.UsuarioRepository;
import jakarta.persistence.EntityNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService implements UserDetailsService {
    private final UsuarioRepository usuarioRepository;
    private final ModelMapper mapper;

    public UsuarioService(UsuarioRepository usuarioRepository, ModelMapper mapper) {
        this.usuarioRepository = usuarioRepository;
        this.mapper = mapper;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return buscarUsuarioPorEmail(username);
    }

    public List<Usuario> buscarTodosOsUsuarios(){
        return usuarioRepository.findAll();
    }

    public Usuario buscarUsuarioPorEmail(String email) {

        Optional<Usuario> optional = usuarioRepository.findByEmail(email);

        if(optional.isEmpty()) {
            throw new UsernameNotFoundException("Usuário não encontrado");
        }

        return optional.get();
    }

    public Usuario buscarUsuarioPorId(Long idUsuario) {
        return usuarioRepository.findById(idUsuario).orElseThrow(() -> new EntityNotFoundException("Usuario não encontrado"));
    }

    public UsuarioDTO salvarUsuario(Usuario usuario) throws Exception{
        try {
            if(usuarioRepository.findByEmail(usuario.getEmail()).isPresent()) {
                throw  new EmailException("Já existe um email cadastrado: " + usuario.getUsername());
            }

            usuario.setSenha(new BCryptPasswordEncoder().encode(usuario.getSenha()));
        } catch (Exception e){
            throw new CriptoException("Erro na criptofrafia da senha");
        }

        return mapper.map(usuarioRepository.save(usuario), UsuarioDTO.class);
    }

    public UsuarioDTO atualizarUsuario(Usuario usuario, Long id) throws Exception {
        Usuario usuarioOriginal = buscarUsuarioPorId(id);

        usuario.setId(usuarioOriginal.getId());

        return mapper.map(salvarUsuario(usuario), UsuarioDTO.class);
    }

    public void excluirUsuario(Long id) {
        Usuario usuario = buscarUsuarioPorId(id);
        usuarioRepository.delete(usuario);
    }
}
