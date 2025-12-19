package es.fpsumma.dam2.videoclub.persistence.jpa.repository;


import es.fpsumma.dam2.videoclub.persistence.jpa.entity.AlquilerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AlquilerRepository extends JpaRepository<AlquilerEntity, Long> {

    //Obtiene el historial de alquileres de un cliente mediante su email
    List<AlquilerEntity> findByClienteEntity_Email(String email);

    //Busca qué personas han alquilado una película concreta por su título
    List<AlquilerEntity> findByPeliculaEntity_Titulo(String titulo);

    //Busca registros donde la fecha de devolución es null (alquileres todavía en curso)
    List<AlquilerEntity> findByFechaDevolucionIsNull();

    //CONSULTA PERSONALIZADA: busca solo alquileres sin devolver de un cliente específico
    @Query("SELECT a FROM AlquilerEntity a WHERE a.clienteEntity.email = :email AND a.fechaDevolucion IS NULL")
    List<AlquilerEntity> buscarAlquileresActivosPorEmail(@Param("email") String email);
}