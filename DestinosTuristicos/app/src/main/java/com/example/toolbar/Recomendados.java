package com.example.toolbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.toolbar.interfaces.DestinosInterface;
import com.example.toolbar.model.DestinoCriterio;
import com.example.toolbar.model.DestinoUtil;
import com.example.toolbar.ui.adapters.RecomendadosAdapter;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Recomendados extends AppCompatActivity {
    private RecyclerView recycler;

    private List<DestinoCriterio> criterios = new ArrayList<>();
    private List<DestinoUtil> destinos = new ArrayList<>();
    List<Integer> results;

    private String tipoProvincia,precio, tipoVisitas, tipoTurismo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recomendados);
        setTitle("Destinos Recomendados");
        tipoProvincia = getIntent().getStringExtra("tipoProvincia");
        precio = getIntent().getStringExtra("precio");
        tipoVisitas = getIntent().getStringExtra("tipoVisitas");
        tipoTurismo = getIntent().getStringExtra("tipoTurismo");

        results = new ArrayList<>();
        results.add(Integer.parseInt(tipoProvincia));
        results.add(Integer.parseInt(precio));
        results.add(Integer.parseInt(tipoVisitas));
        results.add(Integer.parseInt(tipoTurismo));

        recycler = findViewById(R.id.recycler_reco);

        getDestinosCriterio();

    }

    public void getDestinosCriterio(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://apiproyecto2.azurewebsites.net/api/principal/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        DestinosInterface i = retrofit.create(DestinosInterface.class);
        Call<List<DestinoCriterio>> call = i.getDestinosCriterio();

        call.enqueue(new Callback<List<DestinoCriterio>>() {
            @Override
            public void onResponse(Call<List<DestinoCriterio>> call, Response<List<DestinoCriterio>> response) {
                if(response.isSuccessful()){
                    criterios = response.body();
                    getDestinosUtil();
                    //Toast.makeText(getContext(), "Success", Toast.LENGTH_LONG).show();
                }else{
                    //Toast.makeText(getContext(), "Sin exito", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<List<DestinoCriterio>> call, Throwable t) {
                //Toast.makeText(getContext(), "Fail: "+t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }

    public void getDestinosUtil(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://apiproyecto2.azurewebsites.net/api/principal/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        DestinosInterface i = retrofit.create(DestinosInterface.class);
        Call<List<DestinoUtil>> call = i.getDestinos();

        call.enqueue(new Callback<List<DestinoUtil>>() {
            @Override
            public void onResponse(Call<List<DestinoUtil>> call, Response<List<DestinoUtil>> response) {
                if(response.isSuccessful()){
                    destinos = response.body();
                    Bayes b = new Bayes(criterios, destinos, results);
                    List<DestinoUtil> recomendados = b.productos();
                    RecomendadosAdapter adapter = new RecomendadosAdapter(recomendados, getApplicationContext());
                    recycler.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                    recycler.setAdapter(adapter);
                    // Toast.makeText(getContext(), "Succes", Toast.LENGTH_LONG).show();
                }else{
                    //Toast.makeText(getContext(), "Sin exito", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<List<DestinoUtil>> call, Throwable t) {
                //Toast.makeText(getContext(), "Fail: "+t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }
}