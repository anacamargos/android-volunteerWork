package com.example.ana.volunteerwork;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class Tab_OrganizandoFragment extends Fragment {

    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    RecyclerViewAdapter recyclerViewAdapter;
    ArrayList<String> listaDeEventos;
    public static final int RESULT_OK = 0;


    public Tab_OrganizandoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_tab__organizando, container, false);

        listaDeEventos = new ArrayList<String>();
        listaDeEventos.add("Evento na casa da Ana");
        listaDeEventos.add("Festa do Gabriel");

        recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
        layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);
        recyclerViewAdapter = new RecyclerViewAdapter(listaDeEventos);
        recyclerView.setAdapter(recyclerViewAdapter);

        recyclerView.addOnItemTouchListener(new RecyclerItemClickListener(getContext(), recyclerView ,new RecyclerItemClickListener.OnItemClickListener() {
            @Override public void onItemClick(View view, int position) {
                // do whatever
                Bundle params = new Bundle();
                params.putString("nomeEvento", listaDeEventos.get(position));
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

        FloatingActionButton fab = (FloatingActionButton) view.findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();*/

                /*Intent intent = new Intent(getContext(), EventActivity.class);
                intent.putExtras(params);
                startActivity(intent); FOR RESULT*/

                Intent intent = new Intent(getContext(), CadastroEventoActivity.class);
                startActivityForResult(intent,RESULT_OK);
            }
        });

        return view;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        // ATUALIZAR O ARRAYLIST DE EVENTOS
        // GERAR NOVA RECYCLER VIEW
        //recyclerViewAdapter = new RecyclerViewAdapter(this, listaDeConvidados);
        //recyclerView.setAdapter(recyclerViewAdapter);
    }
}
