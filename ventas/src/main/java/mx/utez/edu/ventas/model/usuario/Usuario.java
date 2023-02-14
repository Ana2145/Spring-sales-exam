package mx.utez.edu.ventas.model.usuario;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mx.utez.edu.ventas.model.producto.Producto;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "usuarios")
@NoArgsConstructor
@Getter
@Setter
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombreusu", nullable = false, length = 50)
    private String nombreusu;

    @Column (name = "correo", nullable = false, length = 50)
    private String correo;

    @Column (name = "contraseña", nullable = false, length = 50)
    private String contraseña;

    @Column (name = "listadeseos", nullable = false, length = 50)
    private String listadeseos;

    @ManyToMany(mappedBy = "usuarios")
    @JsonIgnore
    private Set<Producto> productos;

}

