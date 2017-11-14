package com.example.ana.volunteerwork;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ana on 14/11/2017.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    ArrayList<String> listaDeEventos;
    View view;
    ViewHolder viewHolder;

    public RecyclerViewAdapter ( ArrayList<String> listaDeEventos) {
        this.listaDeEventos = listaDeEventos;
    }

    @Override
    public RecyclerViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_layout, parent, false);
        viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final RecyclerViewAdapter.ViewHolder holder, int position) {

        String var =  listaDeEventos.get(position);
        holder.nomeEventoTV.setText(var);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position, List<Object> payloads) {
        super.onBindViewHolder(holder, position, payloads);
    }

    @Override
    public int getItemCount() {
        return listaDeEventos.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        TextView nomeEventoTV;
        //TextView teste;
        //ImageButton botaoWhats;

        public ViewHolder(View itemView) {
            super(itemView);

            nomeEventoTV = (TextView) itemView.findViewById(R.id.nomeEvento);
            //botaoWhats = (ImageButton) itemView.findViewById(R.id.image_button);
            //teste = (TextView) itemView.findViewById(R.id.teste);
        }

    }
}
