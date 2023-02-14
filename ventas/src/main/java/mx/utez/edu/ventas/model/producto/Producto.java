package mx.utez.edu.ventas.model.producto;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mx.utez.edu.ventas.model.usuario.Usuario;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "productos")
@NoArgsConstructor
@Getter
@Setter
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column (name = "nombrepro", nullable = false, length = 50)
    private String nombrepro;

    @Column (name = "categoria", nullable = false, length = 50)
    private String categoria;

    @Column (name = "precio", nullable = false)
    private double precio;

    @Column (name = "disponibilidad", nullable = false,  columnDefinition = "TINYINT DEFAULT 1")
    private boolean disponibilidad;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "transaccion",
            joinColumns = @JoinColumn(name = "producto_id"),
            inverseJoinColumns = @JoinColumn(name = "usuario_id")
    )

    @JsonIgnore
    private Set<Usuario> usuarios;



}
