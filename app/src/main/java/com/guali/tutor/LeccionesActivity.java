package com.guali.tutor;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsCompat;

public class LeccionesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        WindowCompat.enableEdgeToEdge(getWindow());
        setContentView(R.layout.activity_lecciones);

        ViewCompat.setOnApplyWindowInsetsListener(
                findViewById(R.id.main),
                (v, insets) -> {
                    Insets systemBars = insets.getInsets(
                            WindowInsetsCompat.Type.systemBars()
                    );

                    v.setPadding(
                            systemBars.left,
                            systemBars.top,
                            systemBars.right,
                            systemBars.bottom
                    );

                    return insets;
                }
        );

        // Identificar los botones
        Button btnLeccion1 = findViewById(R.id.btnLeccion1);
        Button btnLeccion2 = findViewById(R.id.btnLeccion2);
        Button btnLeccion3 = findViewById(R.id.btnLeccion3);
        Button btnVolver = findViewById(R.id.btnVolverInicio);

        // Abrir Lección 1
        btnLeccion1.setOnClickListener(v -> abrirLeccion(1));

        // Abrir Lección 2
        btnLeccion2.setOnClickListener(v -> abrirLeccion(2));

        // Abrir Lección 3
        btnLeccion3.setOnClickListener(v -> abrirLeccion(3));

        // Regresar al inicio
        btnVolver.setOnClickListener(v -> finish());
    }

    private void abrirLeccion(int numeroLeccion) {

        Intent intent = new Intent(
                LeccionesActivity.this,
                DetalleLeccionActivity.class
        );

        intent.putExtra("numeroLeccion", numeroLeccion);

        startActivity(intent);
    }
}
