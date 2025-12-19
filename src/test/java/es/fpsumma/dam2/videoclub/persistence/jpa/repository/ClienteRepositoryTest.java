package es.fpsumma.dam2.videoclub.persistence.jpa.repository;

import es.fpsumma.dam2.videoclub.persistence.jpa.entity.ClienteEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.ActiveProfiles;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@ActiveProfiles("test")
class ClienteRepositoryTest {

    @Autowired
    private ClienteRepository clienteRepository;

    @Test
    void deberiaEncontrarClientePorEmail() {
        Optional<ClienteEntity> resultado = clienteRepository.findByEmail("ana.perez@example.com");
        assertThat(resultado).isPresent();
        assertThat(resultado.get().getNombre()).isEqualTo("Ana Perez");
    }

    @Test
    void deberiaConfirmarSiExisteEmail() {
        boolean existe = clienteRepository.existsByEmail("ana.perez@example.com");
        boolean noExiste = clienteRepository.existsByEmail("inventado@error.com");

        assertThat(existe).isTrue();
        assertThat(noExiste).isFalse();
    }

    @Test
    void deberiaRetornarClientesPaginados() {
        Page<ClienteEntity> pagina = clienteRepository.findAll(PageRequest.of(0, 3));
        assertThat(pagina.getContent()).hasSize(3);
    }
}