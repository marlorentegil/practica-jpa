package es.fpsumma.dam2.videoclub.persistence.jpa.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "pelicula")
public class PeliculaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 200)
    private String titulo;

    @Column(nullable = true, length = 50)
    private String genero;

    @Column(name = "anio_estreno",nullable = true)
    private Integer anioEstreno;

    @Column(nullable = true)
    private Double puntuacion;

    @Column(nullable = false, name = "director_id")
    private Long directorId;

    // fk_pelicula_director


    public PeliculaEntity() {
    }

    public PeliculaEntity(Long id, String titulo, String genero, Integer anioEstreno, Double puntuacion, Long directorId) {
        this.id = id;
        this.titulo = titulo;
        this.genero = genero;
        this.anioEstreno = anioEstreno;
        this.puntuacion = puntuacion;
        this.directorId = directorId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public Integer getAnioEstreno() {
        return anioEstreno;
    }

    public void setAnioEstreno(Integer anioEstreno) {
        this.anioEstreno = anioEstreno;
    }

    public Double getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(Double puntuacion) {
        this.puntuacion = puntuacion;
    }

    public Long getDirectorId() {
        return directorId;
    }

    public void setDirectorId(Long directorId) {
        this.directorId = directorId;
    }
}
