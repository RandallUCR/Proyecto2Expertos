package com.example.toolbar.model;

public class Destino {

    private int id;
    private String nombre;
    private String descripcion;
    private String ubicacion;
    private String linkUbicacion;
    private String linkVideo;
    private int precio;
    private String rutaImagen;
    private int provincia;
    private int tipoPrecio;
    private int tipoVisitas;
    private int tipoTurismos;
    private int tipoTurista;

    public Destino() {
    }

    public Destino(int id, String nombre, String descripcion , String ubicacion, String linkUbicacion ,
                   String linkVideo, int precio, String rutaImagen, int provincia,int tipoPrecio,
                   int tipoVisitas, int tipoTurismos, int tipoTurista) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.ubicacion = ubicacion;
        this.linkUbicacion = linkUbicacion;
        this.linkVideo = linkVideo;
        this.precio = precio;
        this.rutaImagen = rutaImagen;
        this.provincia = provincia;
        this.tipoPrecio = tipoPrecio;
        this.tipoVisitas = tipoVisitas;
        this.tipoTurismos = tipoTurismos;
        this.tipoTurista = tipoTurista;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getLinkUbicacion() {
        return linkUbicacion;
    }

    public void setLinkUbicacion(String linkUbicacion) {
        this.linkUbicacion = linkUbicacion;
    }

    public String getLinkVideo() {
        return linkVideo;
    }

    public void setLinkVideo(String linkVideo) {
        this.linkVideo = linkVideo;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public String getRutaImagen() {
        return rutaImagen;
    }

    public void setRutaImagen(String rutaImagen) {
        this.rutaImagen = rutaImagen;
    }

    public int getProvincia() {
        return provincia;
    }

    public void setProvincia(int provincia) {
        this.provincia = provincia;
    }

    public int getTipoPrecio() {
        return tipoPrecio;
    }

    public void setTipoPrecio(int tipoPrecio) {
        this.tipoPrecio = tipoPrecio;
    }

    public int getTipoVisitas() {
        return tipoVisitas;
    }

    public void setTipoVisitas(int tipoVisitas) {
        this.tipoVisitas = tipoVisitas;
    }

    public int getTipoTurismos() {
        return tipoTurismos;
    }

    public void setTipoTurismos(int tipoTurismos) {
        this.tipoTurismos = tipoTurismos;
    }

    public int getTipoTurista() {
        return tipoTurista;
    }

    public void setTipoTurista(int tipoTurista) {
        this.tipoTurista=tipoTurista;
    }
}