package es.fpsumma.dam2.videoclub.persistence.jpa.repository;


import es.fpsumma.dam2.videoclub.persistence.jpa.entity.AlquilerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface AlquilerRepository extends JpaRepository<AlquilerEntity, Long> {
    //Obtener alquileres de un cliente usando su email
    List<AlquilerEntity> findByClienteEntity_Email(String email);

    //Obtener alquileres de una película usando su título
    List<AlquilerEntity> findByPeliculaEntity_Titulo(String titulo);

    //Obtener alquileres activos (sin fecha de devolución)
    List<AlquilerEntity> findByFechaDevolucionIsNull();

    //(Obligatorio con @Query) Alquileres activos de un cliente por su email
    @Query("SELECT a FROM AlquilerEntity a WHERE a.clienteEntity.email = :email AND a.fechaDevolucion IS NULL")
    List<AlquilerEntity> buscarAlquileresActivosPorEmail(@Param("email") String email);
}
