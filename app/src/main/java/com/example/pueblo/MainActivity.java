package com.example.pueblo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;


public class MainActivity extends AppCompatActivity {



    TextView informacion;
    TextView nombrecomida1;
    ImageView olaya1;
    ActividadTuristica actividadTuristica;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        informacion=findViewById(R.id.informacion);
        nombrecomida1=findViewById(R.id.nombrecomida1);
        olaya1=findViewById(R.id.olayaMain);

        actividadTuristica =(ActividadTuristica)getIntent().getSerializableExtra("datosPueblo");


        informacion.setText(actividadTuristica.getInformacion());
        nombrecomida1.setText(actividadTuristica.getActividad());
        Picasso.with(MainActivity.this)
                .load(actividadTuristica.getFotosolaya())
                .into(olaya1);

    }

}