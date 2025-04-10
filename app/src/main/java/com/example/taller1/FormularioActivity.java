package com.example.taller1;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import androidx.appcompat.app.AppCompatActivity;

public class FormularioActivity extends AppCompatActivity {

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
            String categoria = spinnerCategoria.getSelectedItem().toString();

            Intent intent;
            switch (categoria) {
                case "Deportes":
                    intent = new Intent(FormularioActivity.this, DeportesActivity.class);
                    break;
                case "Música":
                    intent = new Intent(FormularioActivity.this, MusicaActivity.class);
                    break;
                case "Cine":
                    intent = new Intent(FormularioActivity.this, CineActivity.class);
                    break;
                default:
                    return;
            }
            startActivity(intent);
        });
    }
}