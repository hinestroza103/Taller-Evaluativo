package com.example.pueblo;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class Home extends AppCompatActivity
{
    ArrayList<ActividadTuristica> Olaya=new ArrayList<>();
    RecyclerView lista;
    @Override
    protected void onCreate (Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        lista=findViewById(R.id.listado);
        lista.setHasFixedSize(true);
        lista.setLayoutManager(new LinearLayoutManager( this,LinearLayoutManager.VERTICAL, false));

        listado();
        ListaAdaptador adaptador=new ListaAdaptador(Olaya);
        lista.setAdapter(adaptador);
    }

    private void listado()
    {
        Olaya.add(new ActividadTuristica(getString(R.string.Olaya), "Municipio de Olaya", R.drawable.calle));
        Olaya.add(new ActividadTuristica(getString(R.string.Bandejapaisa), "Bandeja paisa",R.drawable.comida2));
        Olaya.add(new ActividadTuristica(getString(R.string.Quebrada), "Quebrada el salto", R.drawable.lugar));
        Olaya.add(new ActividadTuristica(getString(R.string.Iglesia),"Iglesia municipal", R.drawable.lugar2));
        Olaya.add(new ActividadTuristica(getString(R.string.Fiestasdelverano),"Fiestas del verano",R.drawable.descarga));
        Olaya.add(new ActividadTuristica(getString(R.string.virgen),"Virgen de las nieves",R.drawable.virgen));

    }


}
