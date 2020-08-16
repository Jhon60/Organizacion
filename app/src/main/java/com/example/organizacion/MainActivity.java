package com.example.organizacion;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText txtUsuario;
    EditText txtContraseña;
    Button btnIniciar;
    TextView lbtCrearCuenta;
    String NombreUs;
    String Contraseña;
    ArrayList<Usuarios> usuarios = new ArrayList<>();
    private DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Conexion();
        databaseReference = FirebaseDatabase.getInstance().getReference();

        databaseReference.child("Usuarios").child("-M7Jtt-MWRozTDXCjeaz").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()){
                    NombreUs = dataSnapshot.child("Email:").getValue().toString();
                    Contraseña = dataSnapshot.child("Contraseña:").getValue().toString();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        btnIniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (txtUsuario.getText().toString().equalsIgnoreCase(NombreUs) && txtContraseña.getText().toString().equals(Contraseña)){
                    Intent intent = new Intent(getApplicationContext(), InformacionGT.class);
                    startActivity(intent);
                }

                else{
                    Toast.makeText(getApplicationContext(), "ERROR, por favor verificar los datos",  Toast.LENGTH_LONG).show();
                }

                Limpiar();
            }
        });

        lbtCrearCuenta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("Lista" + usuarios.size());
                Intent intent = new Intent(getApplicationContext(), CrearCuenta.class);
                startActivity(intent);
            }
        });

    }

    private void Limpiar() {
        txtUsuario.setText("");
        txtContraseña.setText("");
    }


    private void Conexion() {
        txtUsuario = findViewById(R.id.txtUsuario);
        txtContraseña = findViewById(R.id.txtContraseña);
        btnIniciar = findViewById(R.id.btnIniciar);
        lbtCrearCuenta = findViewById(R.id.lbtCrearCuenta);
    }
}
