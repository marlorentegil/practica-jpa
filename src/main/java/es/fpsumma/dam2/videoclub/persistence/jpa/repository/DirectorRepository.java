package es.fpsumma.dam2.videoclub.persistence.jpa.repository;

import es.fpsumma.dam2.videoclub.persistence.jpa.entity.DirectorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DirectorRepository extends JpaRepository<DirectorEntity, Long> {

    //Busca un director comparando el nombre exacto (devuelve optional para manejar nulos)
    Optional<DirectorEntity> findByNombre(String nombre);

    //Devuelve true si existe al menos un registro con ese nombre
    boolean existsByNombre(String nombre);

    //Busca directores cuyo nombre contenga el texto ignorando mayúsculas/minúsculas
    List<DirectorEntity> findByNombreContainingIgnoreCase(String nombre);

    //CONSULTA PERSONALIZADA: busca director por nombre usando lenguaje JPQL
    @Query("SELECT d FROM DirectorEntity d WHERE d.nombre = :nombre")
    Optional<DirectorEntity> buscarPorNombre(@Param("nombre") String nombre);

    //Obtiene todos los directores ordenados de la A a la Z
    List<DirectorEntity> findAllByOrderByNombreAsc();
}
