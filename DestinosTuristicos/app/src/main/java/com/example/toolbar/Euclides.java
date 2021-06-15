package com.example.toolbar;

import com.example.toolbar.model.Destino;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Euclides {


    private int provincia;
    private int tipoPrecio;
    private int tipoVisitas;
    private int tipoTurismo;
    private int tipoTurista;
    private ArrayList<Destino> destino;

    public Euclides(int tipoPrecio, int provincia, int tipoTurista, int tipoTurismo, int tipoVisitas, String destinosJson ) {
        this.provincia = provincia;
        this.tipoPrecio = tipoPrecio;
        this.tipoVisitas = tipoVisitas;
        this.tipoTurismo = tipoTurismo;
        this.tipoTurista = tipoTurista;

        destino= new ArrayList<>();
        try {
            //aqui lo debemos tomar del API
            JSONArray destinosArray = new JSONArray(destinosJson);
            Gson gson = new Gson();

            for (int i = 0; i < destinosArray.length(); i++){
                JSONObject destinoJSON = destinosArray.getJSONObject(i);
                Destino destinos = gson.fromJson(destinoJSON.toString(), Destino.class);
                this.destino.add(destinos);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Destino> calcularDistancias() {
        ArrayList<Destino> destinosFiltrados = new ArrayList<>();

        double resultado1 = 100000;
        double resultado2 = 100000;
        double resultado3 = 100000;
        double resultado4 = 100000;
        double resultado5 = 100000;

        int Destino1 = 0;
        int Destino2 = 0;
        int Destino3 = 0;
        int Destino4 = 0;
        int Destino5 = 0;

        for (int i=0; i < destino.size(); i++){
            Destino destinosAux= destino.get(i);
            double sumatoria = (Math.pow(destinosAux.getProvincia() - this.provincia, 2)) + (Math.pow(destinosAux.getTipoPrecio() - this.tipoPrecio, 2)) + (Math.pow(destinosAux.getTipoVisitas() - this.tipoTurismo, 2)) + (Math.pow(destinosAux.getTipoVisitas() - this.tipoTurismo, 2));
            double distancia = Math.sqrt(sumatoria);

            if(distancia < resultado1){
                resultado5 = resultado4;
                resultado4 = resultado3;
                resultado3 = resultado2;
                resultado2 = resultado1;
                resultado1 = distancia;

                Destino5 = Destino4;
                Destino4 = Destino3;
                Destino3 = Destino2;
                Destino2 = Destino1;
                Destino1 = i;
            }else if(distancia < resultado2){
                resultado5 = resultado4;
                resultado4 = resultado3;
                resultado3 = resultado2;
                resultado2 = distancia;

                Destino5 = Destino4;
                Destino4 = Destino3;
                Destino3 = Destino2;
                Destino2 = i;
            }else if(distancia < resultado3){
                resultado5 = resultado4;
                resultado4 = resultado3;
                resultado3 = distancia;

                Destino5 = Destino4;
                Destino4 = Destino3;
                Destino3 = i;
            }else if(distancia < resultado4){
                resultado5 = resultado4;
                resultado4 = distancia;

                Destino5 = Destino4;
                Destino4 = i;
            }else if(distancia < resultado5){
                resultado5 = distancia;

                Destino5 = i;
            }
        }

        destinosFiltrados.add(destino.get(Destino1));
        destinosFiltrados.add(destino.get(Destino2));
        destinosFiltrados.add(destino.get(Destino3));
        destinosFiltrados.add(destino.get(Destino4));
        destinosFiltrados.add(destino.get(Destino5));

        return destinosFiltrados;
    }
}
