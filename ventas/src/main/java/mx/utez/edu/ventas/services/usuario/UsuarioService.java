package mx.utez.edu.ventas.services.usuario;

import mx.utez.edu.ventas.model.usuario.Usuario;
import mx.utez.edu.ventas.model.usuario.UsuarioRepository;
import mx.utez.edu.ventas.utils.CustomResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UsuarioService {
    @Autowired
    private UsuarioRepository repository;

    @Transactional(readOnly = true)
    public CustomResponse<List<Usuario>> getAll(){
        return new CustomResponse<>(
                this.repository.findAll(),
                false,200,"OK"
        );
    }

    @Transactional(readOnly = true)
    public CustomResponse<Usuario> getOne(Long id){
        return new CustomResponse<>(
                this.repository.findById(id).get(),
                false,200,"OK"
        );
    }

    @Transactional(rollbackFor = {SQLException.class})
    public CustomResponse<Usuario>insert(Usuario usuario){
        if(this.repository.existsByName(usuario.getNombreusu())){
            return new CustomResponse<>(null, true, 400, "OK, The user already exists");
        }
        return new CustomResponse<>(
                this.repository.saveAndFlush(usuario), false, 200, "OK"
        );
    }

    @Transactional(rollbackFor = {SQLException.class})
    public CustomResponse<Usuario>update(Long id, Usuario usuario){
        if(!this.repository.existsById(usuario.getId())){
            return new CustomResponse<>(null, true, 400, "OK, The user dont exists");
        }
        return new CustomResponse<>(
                this.repository.saveAndFlush(usuario), false, 200, "OK"
        );
    }

    @Transactional(rollbackFor = {SQLException.class})
    public CustomResponse<Usuario>delete(Long id){

        Optional<Usuario> exists = this.repository.findById(id);
        if(!exists.isPresent()){
            return new CustomResponse<>(null, true, 400, "OK, The user dont exists");
        }
        this.repository.deleteById(id);
        return new CustomResponse<>(
                null, false, 200, "OK"
        );
    }

}
