package com.example.toolbar.ui.listadestinos;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProviders;

import com.example.toolbar.R;
import com.example.toolbar.model.Destino;
import com.example.toolbar.ui.destino.destinosFragment;

import java.util.ArrayList;

public class ListaDestinosFragment extends Fragment {

    private ArrayList<Destino> destinos;
    private ListView listview;
    private ListaDestinosViewModel listaDestinosViewModel;

    public ListaDestinosFragment(ArrayList<Destino> destinos) {
        this.destinos = destinos;
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        listaDestinosViewModel = ViewModelProviders.of(this).get(ListaDestinosViewModel.class);

        View root = inflater.inflate(R.layout.fragment_listadestinos, container, false);


        this.listview = (ListView) root.findViewById(R.id.listadestinos);
        this.cargarLista();

        this.listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Destino destino = new Destino (destinos.get(position).getId(),destinos.get(position).getNombre(),
                        destinos.get(position).getDescripcion(),destinos.get(position).getUbicacion(),
                        destinos.get(position).getLinkUbicacion(),destinos.get(position).getLinkVideo(),
                        destinos.get(position).getPrecio(),destinos.get(position).getRutaImagen(),
                        destinos.get(position).getProvincia(),destinos.get(position).getTipoPrecio(),
                        destinos.get(position).getTipoTurismos(),destinos.get(position).getTipoVisitas(), destinos.get(position).getTipoTurista());

                Fragment fragment = null;
                fragment = new destinosFragment(destino);
                replaceFragment(fragment);

            }
        });

        return root;
    }


    private void cargarLista(){
        ArrayList<String> nombreDestinos = new ArrayList<>();

        for (int i = 0; i < this.destinos.size(); i++){
            Destino destino = this.destinos.get(i);
            nombreDestinos.add(destino.getNombre());

        }

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this.getContext(), android.R.layout.simple_list_item_1, nombreDestinos);

        this.listview.setAdapter(adapter);
    }

    public void replaceFragment(Fragment someFragment) {
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(this.getId(), someFragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }


}