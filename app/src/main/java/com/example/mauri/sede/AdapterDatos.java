package com.example.mauri.sede;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class AdapterDatos extends RecyclerView.Adapter<AdapterDatos.ViewHolderDatos> implements View.OnClickListener {
    ArrayList<Usuarios> listDatos;
    private  View.OnClickListener listener;
    public AdapterDatos(ArrayList<Usuarios> listDatos) {
        this.listDatos = listDatos;
    }

    @NonNull
    @Override
    public AdapterDatos.ViewHolderDatos onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.lista_items,null,false);
        view.setOnClickListener(this);
        return new ViewHolderDatos(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterDatos.ViewHolderDatos holder, int position) {
        holder.nombre.setText(listDatos.get(position).getNombre());
        holder.fecha.setText(listDatos.get(position).getFecha());
        holder.hora.setText(listDatos.get(position).getHora());
        holder.area.setText(listDatos.get(position).getArea());
        holder.status.setText(listDatos.get(position).getStatus());
    }

    @Override
    public int getItemCount() {
        return listDatos.size();
    }
public void setOnClickListener(View.OnClickListener listener){
        this.listener=listener;
}
    @Override
    public void onClick(View view) {
        if(listener!=null){
            listener.onClick(view);
        }
    }

    public class ViewHolderDatos extends RecyclerView.ViewHolder {
            TextView nombre,fecha,hora,area,status;

        public ViewHolderDatos(@NonNull View itemView) {
            super(itemView);
            nombre=(TextView) itemView.findViewById(R.id.idNombre);
            fecha=(TextView) itemView.findViewById(R.id.idFecha);
            hora=(TextView) itemView.findViewById(R.id.idHora);
            area=(TextView) itemView.findViewById(R.id.idArea);
            status=(TextView) itemView.findViewById(R.id.idPendiente);
        }



    }
}
