package com.temas.selectos.eefi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class ActivityCentral extends AppCompatActivity {

    RecyclerView rcEventosPrincipalesJ;
    ArrayList<Evento> listaEventos;
    ArrayList<Cedes> listaLugares;
    LinearLayout linearLayoutCedes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_central);

        linearLayoutCedes= findViewById(R.id.llCedes);
        rcEventosPrincipalesJ= findViewById(R.id.rcEventosPricnipales);

        LinearLayoutManager Eventos = new LinearLayoutManager(this);
        Eventos.setOrientation(LinearLayout.HORIZONTAL);
        rcEventosPrincipalesJ.setLayoutManager(Eventos);

        listaEventos = new ArrayList(); iniciarLista();
        listaLugares = new ArrayList();iniciarLugares();

        inicarAdaptador();

    }


    private void iniciarLista()
    {
        listaEventos.add(new Evento("Evento de prueba 1","Evento 1",R.drawable.primerposter));
        listaEventos.add(new Evento("Evento de prueba 2","Evento 2",R.drawable.segundoposter));
    }

    private void inicarAdaptador()
    {
        adaptadorEvento adaptador = new adaptadorEvento(listaEventos, this);
        rcEventosPrincipalesJ.setAdapter(adaptador);
    }

    private void iniciarLugares()
    {
        listaLugares.add(new Cedes("Auditorio Javier Barros",100,100));
        listaLugares.add(new Cedes("Auditorio Marshal",200,100));
        listaLugares.add(new Cedes("Auditorio Del anexo",200,100));
        listaLugares.add(new Cedes("explanada del I",200,100));
        listaLugares.add(new Cedes("Aula magna",200,100));

        for(Cedes c:listaLugares)
        {
            TextView txtvTemp = new TextView(this);
            txtvTemp.setText(c.getNombre());
            txtvTemp.setTextSize(20);
            txtvTemp.setGravity(1);
            linearLayoutCedes.addView(txtvTemp);
        }
    }
}
