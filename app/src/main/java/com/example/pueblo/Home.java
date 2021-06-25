package com.example.pueblo;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Home extends AppCompatActivity
{
    ArrayList<ActividadTuristica> Olaya=new ArrayList<>();
    RecyclerView lista;
    FirebaseFirestore baseDatos = FirebaseFirestore.getInstance();
    @Override
    protected void onCreate (Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        lista=findViewById(R.id.listado);
        lista.setHasFixedSize(true);
        lista.setLayoutManager(new LinearLayoutManager( this,LinearLayoutManager.VERTICAL, false));

        listado();

    }

    public void  Cambiaridioma(String lenguaje){

        Locale idioma=new Locale(lenguaje);
        Locale.setDefault(idioma);

        Configuration configuraciontelefono=getResources().getConfiguration();
        configuraciontelefono.locale=idioma;
        getBaseContext().getResources().updateConfiguration(configuraciontelefono,getBaseContext().getResources().getDisplayMetrics());

    }


    public boolean  onCreateOptionsMenu(Menu menu){

        getMenuInflater().inflate(R.menu.menu,menu);

        return true;

}

    public boolean  onOptionsItemSelected(MenuItem item){

        int id=item.getItemId();

        switch (id){
            case (R.id.opcion1):

               Intent intent1=new Intent(Home.this,Acercade.class);
               startActivity(intent1);
                break;

            case (R.id.opcion2):
               Cambiaridioma("en");
                Intent intent2=new Intent(Home.this,Home.class);
                startActivity(intent2);

                break;

            case (R.id.opcion3):

                Cambiaridioma("es");
                Intent intent3=new Intent(Home.this,Home.class);
                startActivity(intent3);


                break;


        }
        return  super.onOptionsItemSelected(item);


    }



    private void listado()
    {
        baseDatos.collection("Olaya")
                .get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {

                        if (task.isSuccessful()) {
                            for (QueryDocumentSnapshot document : task.getResult()) {

                                String informacion=document.get("informacion").toString();
                                String actividad=document.get("actividad").toString();
                                String fotosolaya=document.get("foto").toString();

                                Olaya.add(new ActividadTuristica(informacion,actividad,fotosolaya));
                            }
                            ListaAdaptador adaptador=new ListaAdaptador(Olaya);
                            lista.setAdapter(adaptador);
                            



                        } else {

                            Toast.makeText(Home.this, "Error en la consulta", Toast.LENGTH_SHORT).show();

                        }

                    }
                });

    }


}
