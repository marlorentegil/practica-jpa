package es.fpsumma.dam2.videoclub.persistence.jpa.repository;

import es.fpsumma.dam2.videoclub.persistence.jpa.entity.DirectorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface DirectorRepository extends JpaRepository<DirectorEntity, Long> {

    //Ejemplo de método de consulta por nombre
    Optional<DirectorEntity> findByNombre(String nombre);

    List<DirectorEntity> findByNombreContainingIgnoreCase(String nombre);

    // 2) Mismo efecto pero usando @Query con parámetro nombrado
    @Query("SELECT d FROM DirectorEntity d WHERE d.nombre = :nombre")
    Optional<DirectorEntity> buscarPorNombre(@Param("nombre") String nombre);

}
