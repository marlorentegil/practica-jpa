package es.fpsumma.dam2.videoclub.persistence.jpa.repository;

import es.fpsumma.dam2.videoclub.persistence.jpa.entity.PeliculaEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.ActiveProfiles;

import java.awt.print.Pageable;
import java.util.List;


import static org.assertj.core.api.Assertions.assertThat;


@DataJpaTest
@ActiveProfiles("test")
class PeliculaRepositoryTest {

    @Autowired
    private PeliculaRepository peliculaRepository;

    @Test
    void deberiaEncontrarPeliculasPorNombreDirector() {
        // Christopher Nolan tiene 7 películas en el SQL
        List<PeliculaEntity> peliculas = peliculaRepository.findByDirectorEntity_Nombre("Christopher Nolan");
        assertThat(peliculas).hasSize(7);
        assertThat(peliculas).extracting(PeliculaEntity::getTitulo).contains("Inception", "Interstellar");
    }

    @Test
    void deberiaEncontrarPeliculasPorGenero() {
        List<PeliculaEntity> peliculas = peliculaRepository.findByGenero("Ciencia ficcion");
        assertThat(peliculas).isNotEmpty();
    }

    @Test
    void deberiaEncontrarPeliculasPorPuntuacionMinima() {
        // "The Dark Knight" tiene un 9.0
        List<PeliculaEntity> peliculas = peliculaRepository.findByPuntuacionGreaterThanEqual(9.0);
        assertThat(peliculas).isNotEmpty();
        assertThat(peliculas.get(0).getTitulo()).isEqualTo("The Dark Knight");
    }

    @Test
    void deberiaEncontrarPeliculasPorNombreActor_conQuery() {
        // Leonardo DiCaprio actúa en Inception (ID 1) entre otras
        List<PeliculaEntity> peliculas = peliculaRepository.buscarPorNombreActor("Leonardo DiCaprio");
        assertThat(peliculas).isNotEmpty();
        assertThat(peliculas).extracting(PeliculaEntity::getTitulo).contains("Inception");
    }

    @Test
    void deberiaRetornarPaginaDePeliculasPorGenero() {
        PageRequest paginacion = PageRequest.of(0, 5);
        Page<PeliculaEntity> pagina = peliculaRepository.findByGenero("Ciencia ficcion", (Pageable) paginacion);
        assertThat(pagina.getContent()).hasSizeLessThanOrEqualTo(5);
    }
}
