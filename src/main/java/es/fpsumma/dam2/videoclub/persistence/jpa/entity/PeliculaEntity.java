package es.fpsumma.dam2.videoclub.persistence.jpa.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

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

    //La entidad que tiene el @ManyToOne casi siempre es la que tiene la FK real en la tabla
    @ManyToOne
    @JoinColumn( name = "director_id")
    private DirectorEntity directorEntity;

    //Una peli la pueden hacer muchos actores
    //Un actor puede participar en muchas peliculas
    @ManyToMany
    @JoinTable(
            name = "pelicula_actor",
            joinColumns = @JoinColumn(name = "pelicula_id"),
            inverseJoinColumns = @JoinColumn(name = "actor_id")
    )
    private List<ActorEntity> actores = new ArrayList<>();


    public PeliculaEntity() {
    }

    public PeliculaEntity(Long id, String titulo, String genero, Integer anioEstreno, Double puntuacion, DirectorEntity directorEntity, List<ActorEntity> actores) {
        this.id = id;
        this.titulo = titulo;
        this.genero = genero;
        this.anioEstreno = anioEstreno;
        this.puntuacion = puntuacion;
        this.directorEntity = directorEntity;
        this.actores = actores;
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

    public DirectorEntity getDirectorEntity() {
        return directorEntity;
    }

    public void setDirectorEntity(DirectorEntity directorEntity) {
        this.directorEntity = directorEntity;
    }

    public List<ActorEntity> getActores() {
        return actores;
    }

    public void setActores(List<ActorEntity> actores) {
        this.actores = actores;
    }
}
