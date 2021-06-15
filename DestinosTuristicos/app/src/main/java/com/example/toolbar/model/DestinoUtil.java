package com.example.toolbar.model;

public class DestinoUtil {
    public int tN_Id;
    public String tC_Nombre;
    public String tC_Tipo_Precio;
    public String tC_Tipo_Visitas;
    public String tC_Tipo_Turismo;
    public String tC_Ubicacion;
    public int tN_Precio;
    public String tC_Ruta_Imagen;

    public DestinoUtil(int tN_Id, String tC_Nombre, String tC_Tipo_Precio, String tC_Tipo_Visitas, String tC_Tipo_Turismo, String tC_Ubicacion, int tN_Precio, String tC_Ruta_Imagen) {
        this.tN_Id = tN_Id;
        this.tC_Nombre = tC_Nombre;
        this.tC_Tipo_Precio = tC_Tipo_Precio;
        this.tC_Tipo_Visitas = tC_Tipo_Visitas;
        this.tC_Tipo_Turismo = tC_Tipo_Turismo;
        this.tC_Ubicacion = tC_Ubicacion;
        this.tN_Precio = tN_Precio;
        this.tC_Ruta_Imagen = tC_Ruta_Imagen;
    }

    public int gettN_Id() {
        return tN_Id;
    }

    public void settN_Id(int tN_Id) {
        this.tN_Id = tN_Id;
    }

    public String gettC_Nombre() {
        return tC_Nombre;
    }

    public void settC_Nombre(String tC_Nombre) {
        this.tC_Nombre = tC_Nombre;
    }

    public String gettC_Tipo_Precio() {
        return tC_Tipo_Precio;
    }

    public void settC_Tipo_Precio(String tC_Tipo_Precio) {
        this.tC_Tipo_Precio = tC_Tipo_Precio;
    }

    public String gettC_Tipo_Visitas() {
        return tC_Tipo_Visitas;
    }

    public void settC_Tipo_Visitas(String tC_Tipo_Visitas) {
        this.tC_Tipo_Visitas = tC_Tipo_Visitas;
    }

    public String gettC_Tipo_Turismo() {
        return tC_Tipo_Turismo;
    }

    public void settC_Tipo_Turismo(String tC_Tipo_Turismo) {
        this.tC_Tipo_Turismo = tC_Tipo_Turismo;
    }

    public String gettC_Ubicacion() {
        return tC_Ubicacion;
    }

    public void settC_Ubicacion(String tC_Ubicacion) {
        this.tC_Ubicacion = tC_Ubicacion;
    }

    public int gettN_Precio() {
        return tN_Precio;
    }

    public void settN_Precio(int tN_Precio) {
        this.tN_Precio = tN_Precio;
    }

    public String gettC_Ruta_Imagen() {
        return tC_Ruta_Imagen;
    }

    public void settC_Ruta_Imagen(String tC_Ruta_Imagen) {
        this.tC_Ruta_Imagen = tC_Ruta_Imagen;
    }
}
