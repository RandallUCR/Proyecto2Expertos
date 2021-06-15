package com.example.toolbar.model;

public class DestinoCriterio {
    public int tN_Id_Cb;
    public int tN_Id_Dt;
    public int tN_Provincia;
    public int tN_Precio;
    public int tN_Tipo_Visitas;
    public int tN_Tipo_Turismo;

    public DestinoCriterio(int tN_Id_Cb, int tN_Id_Dt, int tN_Provincia, int tN_Precio, int tN_Tipo_Visitas, int tN_Tipo_Turismo) {
        this.tN_Id_Cb = tN_Id_Cb;
        this.tN_Id_Dt = tN_Id_Dt;
        this.tN_Provincia = tN_Provincia;
        this.tN_Precio = tN_Precio;
        this.tN_Tipo_Visitas = tN_Tipo_Visitas;
        this.tN_Tipo_Turismo = tN_Tipo_Turismo;
    }

    public int gettN_Id_Cb() {
        return tN_Id_Cb;
    }

    public void settN_Id_Cb(int tN_Id_Cb) {
        this.tN_Id_Cb = tN_Id_Cb;
    }

    public int gettN_Id_Dt() {
        return tN_Id_Dt;
    }

    public void settN_Id_Dt(int tN_Id_Dt) {
        this.tN_Id_Dt = tN_Id_Dt;
    }

    public int gettN_Provincia() {
        return tN_Provincia;
    }

    public void settN_Provincia(int tN_Provincia) {
        this.tN_Provincia = tN_Provincia;
    }

    public int gettN_Precio() {
        return tN_Precio;
    }

    public void settN_Precio(int tN_Precio) {
        this.tN_Precio = tN_Precio;
    }

    public int gettN_Tipo_Visitas() {
        return tN_Tipo_Visitas;
    }

    public void settN_Tipo_Visitas(int tN_Tipo_Visitas) {
        this.tN_Tipo_Visitas = tN_Tipo_Visitas;
    }

    public int gettN_Tipo_Turismo() {
        return tN_Tipo_Turismo;
    }

    public void settN_Tipo_Turismo(int tN_Tipo_Turismo) {
        this.tN_Tipo_Turismo = tN_Tipo_Turismo;
    }
}
