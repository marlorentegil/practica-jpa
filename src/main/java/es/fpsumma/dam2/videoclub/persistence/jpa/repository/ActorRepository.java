package es.fpsumma.dam2.videoclub.persistence.jpa.repository;

import es.fpsumma.dam2.videoclub.persistence.jpa.entity.ActorEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.List;
import java.util.Optional;

@Repository
public interface ActorRepository extends JpaRepository<ActorEntity, Long> {

    //Busca un actor por su nombre completo
    Optional<ActorEntity> findByNombre(String nombre);

    //Busca actores que participen en una película con un título específico (Navega la relación ManyToMany)
    List<ActorEntity> findByPeliculas_Titulo(String titulo);

    //Lista de actores ordenada alfabéticamente
    List<ActorEntity> findAllByOrderByNombreAsc();
}
