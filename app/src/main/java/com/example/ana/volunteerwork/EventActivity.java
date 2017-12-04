package com.example.ana.volunteerwork;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

public class EventActivity extends AppCompatActivity {

    TextView nomeEventoTV;
    TextView dataEventoTV;
    TextView horaEventoTV;


    String nomeEvento,
            dataEventoIni,
            dataEventoFim,
            horaIniEvento,
            horaEndEvento;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);

        nomeEventoTV = (TextView) findViewById(R.id.textViewNomeEvento);
        dataEventoTV = (TextView) findViewById(R.id.textViewDataEvento);
        horaEventoTV = (TextView) findViewById(R.id.textViewHoraEvento);

        Intent intent = getIntent();
        if ( intent != null ) {
            Bundle params = intent.getExtras();
            if (params != null ) {
                nomeEvento = params.getString("nomeEvento");
                nomeEventoTV.setText(nomeEvento);
                /*dataEventoIni = params.getString("dataEventoIni");
                dataEventoFim = params.getString("dataEventoFim");
                horaIniEvento = params.getString("horaIniEvento");
                horaEndEvento = params.getString("horaEndEvento");

                nomeEventoTV.setText(nomeEvento);
                String [] dataIni = dataEventoIni.split("/");
                String [] dataFim = dataEventoFim.split("/");
                String mesIni = retornaMes(Integer.parseInt(dataIni[1]));
                String mesFim = retornaMes(Integer.parseInt(dataFim[1]));

                horaEventoTV.setText(dataIni[0] + " de " + mesIni + " às "+ horaIniEvento+ " a " + dataFim[0] + " de " + mesFim + " às " + horaEndEvento);
            */
            }
        }

    }

    public String retornaMes ( int mes ) {
        String retorno = "";
        if ( mes == 1 ) {
            retorno = "janeiro";
        } else if ( mes == 2 ) {
            retorno = "fevereiro";
        } else if ( mes == 3 ) {
            retorno = "março";
        } else if ( mes == 4 ) {
            retorno = "abril";
        } else if ( mes == 5 ) {
            retorno = "maio";
        } else if ( mes == 6 ) {
            retorno = "junho";
        } else if ( mes == 7 ) {
            retorno = "julho";
        } else if ( mes == 8 ) {
            retorno = "agosto";
        } else if ( mes == 9 ){
            retorno = "setembro";
        } else if ( mes == 10 ) {
            retorno = "outubro";
        } else if ( mes == 11 ) {
            retorno = "novembro";
        } else  {
            retorno = "dezembro";
        }
        return retorno;
    }
}
