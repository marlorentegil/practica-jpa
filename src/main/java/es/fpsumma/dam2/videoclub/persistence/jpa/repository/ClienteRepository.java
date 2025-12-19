package es.fpsumma.dam2.videoclub.persistence.jpa.repository;


import es.fpsumma.dam2.videoclub.persistence.jpa.entity.ClienteEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;
import java.util.Optional;

@Repository
public interface ClienteRepository extends JpaRepository<ClienteEntity, Long> {

    //Busca un cliente usando su correo electrónico (campo Unique)
    Optional<ClienteEntity> findByEmail(String email);

    //Verifica si el email ya está registrado en la base de datos
    boolean existsByEmail(String email);

    //Obtiene la lista completa de clientes dividida en páginas
    Page<ClienteEntity> findAll(Pageable pageable);
}
