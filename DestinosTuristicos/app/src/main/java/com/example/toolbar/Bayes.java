package com.example.toolbar;

import com.example.toolbar.model.DestinoCriterio;
import com.example.toolbar.model.DestinoUtil;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class Bayes {
    private List<DestinoCriterio> criterios;
    private List<DestinoUtil> destinos;
    private int m;
    private List<Integer> resultados;
    private List<Double> probCaract, productos;
    private double[][] matriz;

    public Bayes(List<DestinoCriterio> criterios, List<DestinoUtil> destinos, List<Integer>resultados) {
        this.criterios = criterios;
        this.destinos = destinos;
        this.resultados = resultados;
        this.productos = new ArrayList<>();
        m = 4;
        this.probCaract = new ArrayList<>();
        probCaract.add(1.000000/7.000000);
        probCaract.add(1.000000/3.000000);
        probCaract.add(1.000000/2.000000);
        probCaract.add(1.000000/3.000000);
        matriz = new double[destinos.size()][4];
        this.llenarNumInstancias();
        this.probabilidadFrecs();
        //this.productos();

    }

    public void llenarNumInstancias(){
        for(int i = 0; i < criterios.size(); i++){
            if(resultados.get(0) == criterios.get(i).tN_Provincia){
                matriz[i][0] += 1;
            }
            if(resultados.get(1) == criterios.get(i).tN_Precio){
                matriz[i][1] += 1;
            }
            if(resultados.get(2) == criterios.get(i).tN_Tipo_Visitas){
                matriz[i][2] += 1;
            }
            if(resultados.get(3) == criterios.get(i).tN_Tipo_Turismo){
                matriz[i][3] += 1;
            }
        }
    }

    public void probabilidadFrecs(){
        for(int i = 0; i < matriz.length; i++){
            matriz[i][0] = (matriz[i][0]+this.m*this.probCaract.get(0))/(1+this.m);
            matriz[i][1] = (matriz[i][1]+this.m*this.probCaract.get(1))/(1+this.m);
            matriz[i][2] = (matriz[i][2]+this.m*this.probCaract.get(2))/(1+this.m);
            matriz[i][3] = (matriz[i][3]+this.m*this.probCaract.get(3))/(1+this.m);
        }
    }

    public List<DestinoUtil> productos(){
        List<Integer> ids = new ArrayList<>();
        for(int i = 0; i < matriz.length; i++){
            productos.add(matriz[i][0]*matriz[i][1]*matriz[i][2]*matriz[i][3]);
            ids.add(i);
        }

       double auxValor;
        int auxPos;
        for (int i = 0; i < productos.size(); i++) {
            for (int j = i+1; j < productos.size(); j++) {
                if(productos.get(i)<productos.get(j)) {
                    auxValor=productos.get(i);
                    auxPos = i;
                    productos.set(i, productos.get(j));
                    ids.set(i,j);
                    productos.set(j, auxValor);
                    ids.set(j, auxPos);
                }//if
            }//for j
        }//for i

        List<DestinoUtil> resultados = new ArrayList<>();
        resultados.add(destinos.get(ids.get(0)));
        resultados.add(destinos.get(ids.get(1)));
        resultados.add(destinos.get(ids.get(2)));
        resultados.add(destinos.get(ids.get(3)));
        resultados.add(destinos.get(ids.get(4)));

        return resultados;
    }



    public String imprimir(){
        /*String salida = "";
        for(int i = 0; i < matriz.length; i++){
            for(int j = 0; j < matriz[i].length; j++){
                salida+=matriz[i][j]+"/";
            }
            salida+="\n";
        }*/
        return productos.toString();
    }
}
