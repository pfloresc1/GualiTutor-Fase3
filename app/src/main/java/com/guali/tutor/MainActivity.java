package com.guali.tutor;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private Button btnLecciones;
    private Button btnHistorial;
    private Button btnConfiguracion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        WindowCompat.enableEdgeToEdge(getWindow());
        setContentView(R.layout.activity_main);

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

        // Conectar los botones con el diseño XML
        btnLecciones = findViewById(R.id.btnLecciones);
        btnHistorial = findViewById(R.id.btnHistorial);
        btnConfiguracion = findViewById(R.id.btnConfiguracion);

        // Abrir la pantalla de lecciones
        btnLecciones.setOnClickListener(v -> {
            Intent intent = new Intent(
                    MainActivity.this,
                    LeccionesActivity.class
            );
            startActivity(intent);
        });

        // Abrir la pantalla de historial
        btnHistorial.setOnClickListener(v -> {
            Intent intent = new Intent(
                    MainActivity.this,
                    HistorialActivity.class
            );
            startActivity(intent);
        });

        // Abrir la pantalla de configuración
        btnConfiguracion.setOnClickListener(v -> {
            Intent intent = new Intent(
                    MainActivity.this,
                    ConfiguracionActivity.class
            );
            startActivity(intent);
        });
    }
}
