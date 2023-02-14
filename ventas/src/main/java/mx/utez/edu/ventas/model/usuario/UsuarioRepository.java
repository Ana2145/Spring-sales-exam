package mx.utez.edu.ventas.model.usuario;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository  extends JpaRepository<Usuario,Long> {

    @Query(value = "UPDATE usuarios SET listadeseos = :listadeseos WHERE id = :id", nativeQuery = true)

    boolean updateListadeseosById(@Param("id") Long id, @Param("listadeseos") String listadeseos);

    boolean existsByName(String nombreusu);


}
