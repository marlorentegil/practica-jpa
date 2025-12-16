package es.fpsumma.dam2.videoclub.persistence.jpa.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

public class ClienteEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String nombre;

    @Column(nullable = false, length = 150, unique = true)
    private String email;

    //Un cliente puede alquilar varias veces
    @OneToMany(mappedBy = "cliente")
    private List<AlquilerEntity> alquiler = new ArrayList<>();

    public ClienteEntity() {
    }

    public ClienteEntity(Long id, String nombre, String email, List<AlquilerEntity> alquiler) {
        this.id = id;
        this.nombre = nombre;
        this.email = email;
        this.alquiler = alquiler;
    }

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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<AlquilerEntity> getAlquiler() {
        return alquiler;
    }

    public void setAlquiler(List<AlquilerEntity> alquiler) {
        this.alquiler = alquiler;
    }
}
