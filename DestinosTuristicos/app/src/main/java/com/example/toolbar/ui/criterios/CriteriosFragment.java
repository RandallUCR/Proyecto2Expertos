package com.example.toolbar.ui.criterios;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.toolbar.Bayes;
import com.example.toolbar.Euclides;
import com.example.toolbar.IOHelper;
import com.example.toolbar.R;
import com.example.toolbar.Recomendados;
import com.example.toolbar.interfaces.DestinosInterface;
import com.example.toolbar.model.Destino;
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

public class CriteriosFragment extends Fragment{

    private CriteriosViewModel galleryViewModel;
    private Button buscarBtn;
    private RadioGroup precios;

    private int precio;
    private int tipoTurista;
    private int tipoTurismo;
    private int tipoProvincia;
    private int tipoVisitas;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        galleryViewModel =
                ViewModelProviders.of(this).get(CriteriosViewModel.class);
        View root = inflater.inflate(R.layout.fragment_criterios, container, false);


        Spinner spinnerTT = root.findViewById (R.id.spinner_tipo_turista);
        ArrayAdapter<CharSequence> adapter =  ArrayAdapter.createFromResource(this.getContext(), R.array.tipo_turista, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerTT.setAdapter(adapter);

        Spinner spinnerTA = root.findViewById(R.id.spinner_tipo_turismo);
        ArrayAdapter<CharSequence> adapterA =  ArrayAdapter.createFromResource(this.getContext(), R.array.tipo_turismo, android.R.layout.simple_spinner_item);
        adapterA.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerTA.setAdapter(adapterA);

        final Spinner spinnerTP = root.findViewById(R.id.spinner_tipo_provincia);
        ArrayAdapter<CharSequence> adapterP =  ArrayAdapter.createFromResource(this.getContext(), R.array.tipo_provincia, android.R.layout.simple_spinner_item);
        adapterP.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerTP.setAdapter(adapterP);

        Spinner spinnerTV = root.findViewById(R.id.spinner_tipo_visitas);
        ArrayAdapter<CharSequence> adapterTV =  ArrayAdapter.createFromResource(this.getContext(), R.array.tipo_visitas, android.R.layout.simple_spinner_item);
        adapterTV.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerTV.setAdapter(adapterTV);

        spinnerTT.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                tipoTurista = position+1;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        spinnerTA.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                tipoTurismo= position+1;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        spinnerTP.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                tipoProvincia = position+1;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        spinnerTV.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                tipoVisitas = position+1;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        precios = (RadioGroup) root.findViewById(R.id.rgPrecios);
        buscarBtn = root.findViewById(R.id.buscarBtn);

        buscarBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (precios.getCheckedRadioButtonId() == R.id.rbEconomico) {
                    precio = 1;
                }else if (precios.getCheckedRadioButtonId() == R.id.rbRegular) {
                    precio = 2;
                }else{
                    precio = 3;
                }

                List<Integer> results = new ArrayList<>();
                results.add(tipoProvincia);
                results.add(precio);
                results.add(tipoVisitas);
                results.add(tipoTurismo);


                Intent intent = new Intent(getActivity(), Recomendados.class);
                intent.putExtra("tipoProvincia",tipoProvincia+"");
                intent.putExtra("precio",precio+"");
                intent.putExtra("tipoVisitas",tipoVisitas+"");
                intent.putExtra("tipoTurismo",tipoTurismo+"");
                startActivity(intent);
            }
        });

        return root;
    }
    public void replaceFragment(Fragment someFragment) {
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(this.getId(), someFragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }



}
