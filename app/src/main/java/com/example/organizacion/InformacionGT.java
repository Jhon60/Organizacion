package com.example.organizacion;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class InformacionGT extends AppCompatActivity {

    ImageView imgPerfil;
    TextView  lbtFrase, lbtInformacion, lbtInfoImportante;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_informacion_g_t);

        Conexion();

    }

    private void Conexion() {

        imgPerfil = findViewById(R.id.imgPerfil);
        lbtFrase = findViewById(R.id.lbtBienvenida);
        lbtInformacion = findViewById(R.id.lbtInformacion);
        lbtInfoImportante = findViewById(R.id.lbtImportante);

    }
}
