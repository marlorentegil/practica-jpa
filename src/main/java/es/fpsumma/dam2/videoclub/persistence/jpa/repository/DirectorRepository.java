package es.fpsumma.dam2.videoclub.persistence.jpa.repository;

import es.fpsumma.dam2.videoclub.persistence.jpa.entity.DirectorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface DirectorRepository extends JpaRepository<DirectorEntity, Long> {

    //Metodo de consulta por convencion: busqueda exacta
    Optional<DirectorEntity> findByNombre(String nombre);

    //Metodo de consulta por convencion: busqueda parcieal e insensible a mayúsculas
    List<DirectorEntity> findByNombreContainingIgnoreCase(String nombre);

    //Metodo de consulta explicita
    @Query("SELECT d FROM DirectorEntity d WHERE d.nombre = :nombre")
    List<DirectorEntity> buscarPorNombre(@Param("nombre") String nombre);

}

