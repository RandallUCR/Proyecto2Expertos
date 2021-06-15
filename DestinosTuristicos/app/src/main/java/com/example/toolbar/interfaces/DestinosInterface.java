package com.example.toolbar.interfaces;

import com.example.toolbar.model.Destino;
import com.example.toolbar.model.DestinoCriterio;
import com.example.toolbar.model.DestinoUtil;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface DestinosInterface {

    @GET("GetDestinos")
        Call<List<DestinoUtil>> getDestinos();

    @GET("GetDestinosCriterio")
    Call<List<DestinoCriterio>> getDestinosCriterio();

}
