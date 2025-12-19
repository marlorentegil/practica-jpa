package es.fpsumma.dam2.videoclub.persistence.jpa.repository;

import es.fpsumma.dam2.videoclub.persistence.jpa.entity.PeliculaEntity;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import java.awt.print.Pageable;
import java.util.List;

public interface PeliculaRepository extends JpaRepository<PeliculaEntity, Long> {
    //Obtener todas las películas de un determinado director (por nombre)
    List<PeliculaEntity> findByDirectorEntity_Nombre(String nombre);

    //Obtener todas las películas de un determinado género
    List<PeliculaEntity> findByGenero(String genero);

    //Obtener películas con puntuación mínima
    List<PeliculaEntity> findByPuntuacionGreaterThanEqual(Double puntuacion);

    //(Obligatorio con @Query) Películas donde participe un actor por nombre
    @Query("SELECT p FROM PeliculaEntity p JOIN p.actores a WHERE a.nombre = :nombreActor")
    List<PeliculaEntity> buscarPorNombreActor(@Param("nombreActor") String nombreActor);

    //Paginación por género
    Page<PeliculaEntity> findByGenero(String genero, Pageable pageable);

    //Ordenación por año o puntuación
    List<PeliculaEntity> findAllByOrderByAnioEstrenoDesc();
    List<PeliculaEntity> findAllByOrderByPuntuacionDesc();
}
