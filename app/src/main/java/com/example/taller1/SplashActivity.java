package com.example.taller1;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Handler;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import androidx.appcompat.app.AppCompatActivity;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText editTextNombre = findViewById(R.id.editTextNombre);
        EditText editTextEdad = findViewById(R.id.editTextEdad);
        Spinner spinnerCategoria = findViewById(R.id.spinnerCategoria);
        Button buttonGuardar = findViewById(R.id.buttonGuardar);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item,
                new String[]{"Deportes", "Música", "Cine"});
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerCategoria.setAdapter(adapter);

        buttonGuardar.setOnClickListener(view -> {
            String nombre = editTextNombre.getText().toString();
            String edad = editTextEdad.getText().toString();
            String categoria = spinnerCategoria.getSelectedItem().toString();

            SharedPreferences sharedPreferences = getSharedPreferences("FormularioDatos", MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString("nombre", nombre);
            editor.putString("edad", edad);
            editor.putString("categoria", categoria);
            editor.apply();
            Intent intent;
            switch (categoria) {
                case "Deportes":
                    intent = new Intent(SplashActivity.this, DeportesActivity.class);
                    break;
                case "Música":
                    intent = new Intent(SplashActivity.this, MusicaActivity.class);
                    break;
                case "Cine":
                    intent = new Intent(SplashActivity.this, CineActivity.class);
                    break;
                default:
                    return;
            }
            startActivity(intent);
        });
    }
}