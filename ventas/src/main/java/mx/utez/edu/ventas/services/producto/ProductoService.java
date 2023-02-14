package mx.utez.edu.ventas.services.producto;

import mx.utez.edu.ventas.model.producto.Producto;
import mx.utez.edu.ventas.model.producto.ProductoRepository;
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
public class ProductoService {
    @Autowired
    private ProductoRepository repository;

    @Transactional(readOnly = true)
    public CustomResponse<List<Producto>> getAll(){
        return new CustomResponse<>(
                this.repository.findAll(),
                false,200,"OK"
        );
    }

    @Transactional(readOnly = true)
    public CustomResponse<Producto> getOne(Long id){
        return new CustomResponse<>(
                this.repository.findById(id).get(),
                false,200,"OK"
        );
    }

    @Transactional(rollbackFor = {SQLException.class})
    public CustomResponse<Producto>insert(Producto producto){
        if(this.repository.existsByName(producto.getNombrepro())){
            return new CustomResponse<>(null, true, 400, "OK, The product already exists");
        }
        return new CustomResponse<>(
                this.repository.saveAndFlush(producto), false, 200, "OK"
        );
    }

    @Transactional(rollbackFor = {SQLException.class})
    public CustomResponse<Producto>update(Long id, Producto producto){
        if(!this.repository.existsById(producto.getId())){
            return new CustomResponse<>(null, true, 400, "OK, The product dont exists");
        }
        return new CustomResponse<>(
                this.repository.saveAndFlush(producto), false, 200, "OK"
        );
    }

    @Transactional(rollbackFor = {SQLException.class})
    public CustomResponse<Producto>delete(Long id){

        Optional<Producto> exists = this.repository.findById(id);
        if(!exists.isPresent()){
            return new CustomResponse<>(null, true, 400, "OK, The product dont exists");
        }
        this.repository.deleteById(id);
        return new CustomResponse<>(
                null, false, 200, "OK"
        );
    }
}
