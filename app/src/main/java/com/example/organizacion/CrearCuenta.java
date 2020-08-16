package com.example.organizacion;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.nio.file.Files;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CrearCuenta extends AppCompatActivity {

    EditText txtNombre, txtApellido, txtCorreoElectronico, txtContraseña, txtConfirmarContraseña;
    Button btnCrear, btnVolveer;
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference();
    ArrayList<Usuarios> usuarios = new ArrayList<>();

    String Nombre, Apellido, Email, Contraseña, ConfirContraseña;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_cuenta);

        Conexion();

        btnCrear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CreaCuenta();
            }
        });

        btnVolveer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });

    }

    private void CreaCuenta() {
        ObtenerTextos();
        Map<String, Object> datos = new HashMap<>();

        if (txtNombre.getText().toString().equals("") || txtApellido.getText().toString().equals("") || txtCorreoElectronico.getText().toString().equals("") ||
            txtContraseña.getText().toString().equals("") || txtConfirmarContraseña.getText().toString().equals("")){
            Toast.makeText(getApplicationContext(), "Completar todos los camplos", Toast.LENGTH_LONG).show();
        }
        else if (!txtContraseña.getText().toString().equals(txtConfirmarContraseña.getText().toString())){
            Toast.makeText(getApplicationContext(), "Las contraseñas no coinciden", Toast.LENGTH_LONG).show();
        }

        else{

            datos.put("Nombre:", Nombre);
            datos.put("Apellido:", Apellido);
            datos.put("Email:", Email);
            datos.put("Contraseña:", Contraseña);
            datos.put("ConfContraseña:", ConfirContraseña);
            myRef.child("Usuarios").push().setValue(datos);
            Toast.makeText(getApplicationContext(), "Cuenta creada", Toast.LENGTH_LONG).show();
            Limpiar();
        }
    }

    private void Limpiar(){
        txtNombre.setText("");
        txtApellido.setText("");
        txtCorreoElectronico.setText("");
        txtContraseña.setText("");
        txtConfirmarContraseña.setText("");
    }

    private void ObtenerTextos(){
        Nombre = txtNombre.getText().toString();
        Apellido = txtApellido.getText().toString();
        Email = txtCorreoElectronico.getText().toString();
        Contraseña = txtContraseña.getText().toString();
        ConfirContraseña = txtConfirmarContraseña.getText().toString();
    }


    private void Conexion() {
        txtNombre = findViewById(R.id.txtNombre);
        txtApellido = findViewById(R.id.txtApellido);
        txtCorreoElectronico = findViewById(R.id.txtCorreoElec);
        txtContraseña = findViewById(R.id.txtContraseñaC);
        txtConfirmarContraseña = findViewById(R.id.txtConfirContrasC);
        btnCrear = findViewById(R.id.btnCrearCuenta);
        btnVolveer = findViewById(R.id.btnVolver);
    }
}
