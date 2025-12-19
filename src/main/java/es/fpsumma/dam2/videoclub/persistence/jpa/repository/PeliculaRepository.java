package es.fpsumma.dam2.videoclub.persistence.jpa.repository;

import es.fpsumma.dam2.videoclub.persistence.jpa.entity.PeliculaEntity;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import java.awt.print.Pageable;
import java.util.List;

@Repository
public interface PeliculaRepository extends JpaRepository<PeliculaEntity, Long> {

    //Navega a la entidad director y busca por su atributo nombre
    List<PeliculaEntity> findByDirectorEntity_Nombre(String nombre);

    //Filtra películas por el campo género
    List<PeliculaEntity> findByGenero(String genero);

    //Busca películas con puntuación igual o superior al parámetro (>=)
    List<PeliculaEntity> findByPuntuacionGreaterThanEqual(Double puntuacion);

    //CONSULTA PERSONALIZADA: une película con actores y filtra por el nombre del actor
    @Query("SELECT p FROM PeliculaEntity p JOIN p.actores a WHERE a.nombre = :nombreActor")
    List<PeliculaEntity> buscarPorNombreActor(@Param("nombreActor") String nombreActor);

    //Devuelve una lista limitada (página) de películas de un género
    Page<PeliculaEntity> findByGenero(String genero, Pageable pageable);

    //Obtiene todas las películas empezando por las más recientes
    List<PeliculaEntity> findAllByOrderByAnioEstrenoDesc();
}
