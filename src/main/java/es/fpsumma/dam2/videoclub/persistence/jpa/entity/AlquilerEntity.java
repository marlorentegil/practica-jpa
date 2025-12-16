package es.fpsumma.dam2.videoclub.persistence.jpa.entity;

import jakarta.persistence.*;

import java.sql.Date;

public class AlquilerEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //La entidad que tiene el @ManyToOne casi siempre es la que tiene la FK real en la tabla
    @ManyToOne
    @JoinColumn( name = "cliente_id")
    private ClienteEntity clienteEntity;

    //La entidad que tiene el @ManyToOne casi siempre es la que tiene la FK real en la tabla
    @ManyToOne
    @JoinColumn( name = "pelicula_id")
    private PeliculaEntity peliculaEntity;

    @Column( name = "fecha_alquiler")
    private Date fechaAlquiler;

    @Column( name = "fecha_devolucion")
    private Date fechaDevolucion;


    public AlquilerEntity() {
    }

    public AlquilerEntity(Long id, ClienteEntity clienteEntity, PeliculaEntity peliculaEntity, Date fechaAlquiler, Date fechaDevolucion) {
        this.id = id;
        this.clienteEntity = clienteEntity;
        this.peliculaEntity = peliculaEntity;
        this.fechaAlquiler = fechaAlquiler;
        this.fechaDevolucion = fechaDevolucion;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ClienteEntity getClienteEntity() {
        return clienteEntity;
    }

    public void setClienteEntity(ClienteEntity clienteEntity) {
        this.clienteEntity = clienteEntity;
    }

    public PeliculaEntity getPeliculaEntity() {
        return peliculaEntity;
    }

    public void setPeliculaEntity(PeliculaEntity peliculaEntity) {
        this.peliculaEntity = peliculaEntity;
    }

    public Date getFechaAlquiler() {
        return fechaAlquiler;
    }

    public void setFechaAlquiler(Date fechaAlquiler) {
        this.fechaAlquiler = fechaAlquiler;
    }

    public Date getFechaDevolucion() {
        return fechaDevolucion;
    }

    public void setFechaDevolucion(Date fechaDevolucion) {
        this.fechaDevolucion = fechaDevolucion;
    }
}
