package es.fpsumma.dam2.videoclub.persistence.jpa.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "director")
public class DirectorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String nombre;

    // Añadir relación con Lista de películas



    // ===== Constructores =====
    public DirectorEntity(Long id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public DirectorEntity() {
    }


    // ===== Getters y setters =====

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}
