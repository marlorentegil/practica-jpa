package es.fpsumma.dam2.videoclub.persistence.jpa.repository;

import es.fpsumma.dam2.videoclub.persistence.jpa.entity.ActorEntity;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.List;
import java.util.Optional;

public interface ActorRepository extends JpaRepository<ActorEntity, Long> {
    //Buscar un actor por nombre
    Optional<ActorEntity> findByNombre(String nombre);

    //Actores que han participado en una película cuyo título se pasa como parámetro
    List<ActorEntity> findByPeliculas_Titulo(String titulo);

    //Ordenación alfabética por nombre
    List<ActorEntity> findAllByOrderByNombreAsc();
}
