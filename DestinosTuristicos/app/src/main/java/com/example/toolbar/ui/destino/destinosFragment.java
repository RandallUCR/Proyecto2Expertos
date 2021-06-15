package com.example.toolbar.ui.destino;

import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProviders;

import com.example.toolbar.R;
import com.example.toolbar.model.Destino;


public class destinosFragment extends Fragment {
    private View root;
    private DestinosViewModel destinosViewModel;
    private Destino destino;
    private Button videoBtn;
    private Button mapaBtn;

    public destinosFragment(Destino destino) {
        this.destino = destino;

    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        destinosViewModel= ViewModelProviders.of(this).get(DestinosViewModel.class);

        this.root = inflater.inflate(R.layout.fragment_ruta, container, false);

        LinearLayout layout = (LinearLayout) root.findViewById(R.id.ly_principal);

            //TITULO
            TextView nombre = new TextView(getContext());
            nombre.setWidth(ViewGroup.LayoutParams.MATCH_PARENT);
            nombre.setHeight(100);
            nombre.setGravity(Gravity.CENTER);
            nombre.setText(this.destino.getNombre());

            //IMAGEN
            ImageView imagen = new ImageView(getContext());
            String nombreImagen = "i" + String.valueOf(this.destino.getRutaImagen());
            int imageId = getResources().getIdentifier(nombreImagen, "mipmap", getContext().getPackageName());
            imagen.setImageResource(imageId);
            imagen.setMinimumWidth(ViewGroup.LayoutParams.MATCH_PARENT);
            imagen.setMinimumHeight(ViewGroup.LayoutParams.WRAP_CONTENT);

            //DESCRIPCION
            TextView descripcion = new TextView(getContext());
            descripcion.setWidth(ViewGroup.LayoutParams.MATCH_PARENT);
            descripcion.setHeight(400);
            descripcion.setGravity(Gravity.CENTER);
            descripcion.setText(this.destino.getDescripcion());

            //PRECIO
            TextView precio = new TextView(getContext());
            descripcion.setWidth(ViewGroup.LayoutParams.MATCH_PARENT);
            descripcion.setHeight(400);
            descripcion.setGravity(Gravity.CENTER);
            descripcion.setText(this.destino.getDescripcion());


            layout.addView(nombre);
            layout.addView(imagen);
            layout.addView(descripcion);
            layout.addView(precio);

        videoBtn = (Button) root.findViewById(R.id.videoBtn);
        mapaBtn = (Button) root.findViewById(R.id.mapaBtn);


        mapaBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment = null;
                //fragment = new MapaFragment();
                //replaceFragment(fragment);
            }
        });
        mapaBtn.setVisibility(View.VISIBLE);

        videoBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment = null;
                //fragment = new MapaFragment();
                //replaceFragment(fragment);
            }
        });
        videoBtn.setVisibility(View.VISIBLE);

        return root;
    }


    public void replaceFragment(Fragment someFragment) {
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(this.getId(), someFragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}
