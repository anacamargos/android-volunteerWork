package com.example.ana.volunteerwork;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ana.volunteerwork.database.Database;
import com.example.ana.volunteerwork.database.Evento;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class Tab_ParticipandoFragment extends Fragment {

    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    RecyclerViewAdapter recyclerViewAdapter;
    ArrayList<Evento> listaDeEventosParticipando;
    DatabaseReference db;
    Database helper;


    public Tab_ParticipandoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_tab__participando, container, false);

        listaDeEventosParticipando = new ArrayList<Evento>();

        db = FirebaseDatabase.getInstance().getReference();
        helper = new Database(db);

        db.child("Participando").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Iterable<DataSnapshot> children = dataSnapshot.getChildren();
                listaDeEventosParticipando.clear();
                for(DataSnapshot child : children) {
                    Evento evento = child.getValue(Evento.class);
                    //Toast.makeText(getApplicationContext(), evento.getNome(), Toast.LENGTH_SHORT).show();
                    listaDeEventosParticipando.add(evento);
                }
                recyclerViewAdapter.notifyDataSetChanged();
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

//
//        Evento evento = new Evento ("Festa do Miguel", "Muita comida!", "06/12/2017","07/12/2017", "10:00", "10:00", "Rua Pistóia, 325");
//        Evento eventoNovo = new Evento ("Festa do Joaozinho", "Só track boa", "11/12/2017","12/12/2017", "10:00", "10:00", "Rua Gongalves Dias, 2132");
//
//        listaDeEventosParticipando.add(evento);
//        listaDeEventosParticipando.add(eventoNovo);

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
