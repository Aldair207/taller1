package com.example.taller1;

import android.os.Bundle;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MusicaActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deportes);
        SharedPreferences sharedPreferences = getSharedPreferences("FormularioDatos", MODE_PRIVATE);
        String nombre = sharedPreferences.getString("nombre", "Sin nombre");
        String edad = sharedPreferences.getString("edad", "Sin edad");
        String categoria = sharedPreferences.getString("categoria", "Sin categoría");
        TextView textViewDatos = findViewById(R.id.textViewTitulo);
        textViewDatos.setText("Nombre: " + nombre + "\nEdad: " + edad + "\nCategoría: " + categoria);
        Button buttonVolver = findViewById(R.id.buttonVolver);
        buttonVolver.setOnClickListener(view -> {
            finish();
        });
    }
}