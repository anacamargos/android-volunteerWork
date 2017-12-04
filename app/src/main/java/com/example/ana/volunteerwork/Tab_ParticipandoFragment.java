package com.example.ana.volunteerwork;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ana.volunteerwork.database.Evento;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class Tab_ParticipandoFragment extends Fragment {

    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    RecyclerViewAdapter recyclerViewAdapter;
    ArrayList<Evento> listaDeEventosParticipando;


    public Tab_ParticipandoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_tab__participando, container, false);

        listaDeEventosParticipando = new ArrayList<Evento>();

        Evento evento = new Evento ("Festa do Miguel", "Muita comida!", "06/12/2017","07/12/2017", "10:00", "10:00", "Rua Pistóia, 325");
        Evento eventoNovo = new Evento ("Festa do Joaozinho", "Só track boa", "11/12/2017","12/12/2017", "10:00", "10:00", "Rua Gongalves Dias, 2132");

        listaDeEventosParticipando.add(evento);
        listaDeEventosParticipando.add(eventoNovo);

        recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
        layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        recyclerViewAdapter = new RecyclerViewAdapter(listaDeEventosParticipando);
        recyclerView.setAdapter(recyclerViewAdapter);

        recyclerView.addOnItemTouchListener(new RecyclerItemClickListener(getContext(), recyclerView ,new RecyclerItemClickListener.OnItemClickListener() {
            @Override public void onItemClick(View view, int position) {
                // do whatever
                Bundle params = new Bundle();
                params.putSerializable("evento",listaDeEventosParticipando.get(position));
                //params.putString("nomeEvento", listaDeEventosParticipando.get(position));
                //params.putString("dataEventoIni", nDataEditText.getText().toString());
                //params.putString("dataEventoFim", nDataEndEditText.getText().toString());
                //params.putString("horaIniEvento", nTimeEditText.getText().toString());
                //params.putString("horaEndEvento", nTimeEndEditText.getText().toString());


                Intent intent = new Intent(getContext(), EventActivity.class);
                intent.putExtras(params);
                startActivity(intent);
            }

            @Override public void onLongItemClick(View view, int position) {
                // do whatever
            }
        }));

        return view;
    }



}
