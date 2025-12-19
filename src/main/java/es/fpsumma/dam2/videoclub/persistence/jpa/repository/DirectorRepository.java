package es.fpsumma.dam2.videoclub.persistence.jpa.repository;

import es.fpsumma.dam2.videoclub.persistence.jpa.entity.DirectorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface DirectorRepository extends JpaRepository<DirectorEntity, Long> {
    //Buscar un director por su nombre exacto
    Optional<DirectorEntity> findByNombre(String nombre);

    //Comprobar si existe un director con un determinado nombre
    boolean existsByNombre(String nombre);

    //(Obligatorio con @Query) Consulta JPQL por nombre
    @Query("SELECT d FROM DirectorEntity d WHERE d.nombre = :nombre")
    DirectorEntity buscarPorNombre(@Param("nombre") String nombre);

    //Ordenación: obtener lista de directores ordenados alfabéticamente (asc)
    List<DirectorEntity> findAllByOrderByNombreAsc();
}

