package es.fpsumma.dam2.videoclub.persistence.jpa.repository;

import es.fpsumma.dam2.videoclub.persistence.jpa.entity.AlquilerEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@ActiveProfiles("test")
class AlquilerRepositoryTest {

    @Autowired
    private AlquilerRepository alquilerRepository;

    @Test
    void deberiaEncontrarAlquileresActivos() {
        // En data.sql hay 7 alquileres con fecha_devolucion NULL
        List<AlquilerEntity> activos = alquilerRepository.findByFechaDevolucionIsNull();
        assertThat(activos).isNotEmpty();
        assertThat(activos).allMatch(alquiler -> alquiler.getFechaDevolucion() == null);
    }

    @Test
    void deberiaEncontrarAlquileresActivosPorEmail_conQuery() {
        // Ana Perez tiene Interstellar activo
        List<AlquilerEntity> resultado = alquilerRepository.buscarAlquileresActivosPorEmail("ana.perez@example.com");
        assertThat(resultado).isNotEmpty();
        assertThat(resultado.get(0).getPeliculaEntity().getTitulo()).isEqualTo("Interstellar");
    }

    @Test
    void deberiaEncontrarAlquileresPorTituloPelicula() {
        List<AlquilerEntity> alquileres = alquilerRepository.findByPeliculaEntity_Titulo("Inception");
        assertThat(alquileres).isNotEmpty();
    }
}