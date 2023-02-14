package mx.utez.edu.ventas.controller.usuario;


import mx.utez.edu.ventas.model.usuario.Usuario;
import mx.utez.edu.ventas.services.usuario.UsuarioService;
import mx.utez.edu.ventas.utils.CustomResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ventas/usuario")
@CrossOrigin(origins = {"*"})   //desde cualquier lugar se pueden consumir los servicios
public class UsuarioController {
    @Autowired
    private UsuarioService service;

    @GetMapping("/")
    public ResponseEntity<CustomResponse<List<Usuario>>> getAll(){
        return new ResponseEntity<>(this.service.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomResponse<Usuario>> getOne(@PathVariable Long id){
        return new ResponseEntity<>(this.service.getOne(id), HttpStatus.OK);
    }



}