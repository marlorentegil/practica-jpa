package es.fpsumma.dam2.videoclub.persistence.jpa.repository;

import es.fpsumma.dam2.videoclub.persistence.jpa.entity.ActorEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@ActiveProfiles("test")
class ActorRepositoryTest {

    @Autowired
    private ActorRepository actorRepository;

    @Test
    void deberiaEncontrarActorPorNombre() {
        Optional<ActorEntity> resultado = actorRepository.findByNombre("Leonardo DiCaprio");
        assertThat(resultado).isPresent();
        assertThat(resultado.get().getNombre()).isEqualTo("Leonardo DiCaprio");
    }

    @Test
    void deberiaEncontrarActoresPorTituloPelicula() {
        // En Inception actúa DiCaprio
        List<ActorEntity> actores = actorRepository.findByPeliculas_Titulo("Inception");
        assertThat(actores).isNotEmpty();
        assertThat(actores).extracting(ActorEntity::getNombre).contains("Leonardo DiCaprio");
    }

    @Test
    void deberiaRetornarActoresOrdenadosAlfabeticamente() {
        List<ActorEntity> actores = actorRepository.findAllByOrderByNombreAsc();
        assertThat(actores).isSortedAccordingTo((a1, a2) -> a1.getNombre().compareTo(a2.getNombre()));
    }
}
