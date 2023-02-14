package mx.utez.edu.ventas.model.producto;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoRepository extends JpaRepository<Producto,Long> {
    @Query(value = "UPDATE productos SET disponibilidad = :disponibilidad WHERE id = :id", nativeQuery = true)

    boolean updateDisponibilidadById(@Param("id") Long id, @Param("disponibilidad") String disponibilidad);

    boolean existsByName(String nombrepro);

}
