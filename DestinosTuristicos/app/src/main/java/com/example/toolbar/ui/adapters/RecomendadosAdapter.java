package com.example.toolbar.ui.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.toolbar.Recomendados;
import com.example.toolbar.model.DestinoUtil;
import com.squareup.picasso.Picasso;
import com.example.toolbar.R;
import java.util.List;

public class RecomendadosAdapter extends RecyclerView.Adapter<RecomendadosAdapter.RecomendadosViewHolder> {
    private List<DestinoUtil> lista;
    private Context context;

    public RecomendadosAdapter(List<DestinoUtil> lista, Context context) {
        this.lista = lista;
        this.context = context;
    }

    @Override
    public RecomendadosViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View listItem = inflater.inflate(R.layout.recomendados_items, parent, false);
        RecomendadosViewHolder viewHolder = new RecomendadosViewHolder(listItem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final RecomendadosViewHolder holder, int position) {
        final DestinoUtil destinos = lista.get(position);
        holder.tw_reco.setText(destinos.tC_Nombre);

        String url = "https://proyecto1expertos.000webhostapp.com/"+destinos.gettC_Ruta_Imagen();

        Picasso.get().load(url).into(holder.iw_reco);

        holder.cl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent intent = new Intent(context, Recomendados.class);
                //context.startActivity(intent);
                Toast.makeText(context, "Ir a "+destinos.gettC_Nombre(), Toast.LENGTH_LONG).show();
                //Activity a la que se va a dirigir
            }
        });
    }

    @Override
    public int getItemCount() {
        return lista.size();
    }

    public static class RecomendadosViewHolder extends RecyclerView.ViewHolder{

        public TextView tw_reco;
        public ImageView iw_reco;
        public ConstraintLayout cl;

        public RecomendadosViewHolder(@NonNull View itemView) {
            super(itemView);
            this.tw_reco = (TextView) itemView.findViewById(R.id.tw_reco);
            this.iw_reco = (ImageView) itemView.findViewById(R.id.iv_reco);
            this.cl = (ConstraintLayout) itemView.findViewById(R.id.cl_reco);
        }
    }
}
