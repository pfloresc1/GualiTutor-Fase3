package com.guali.tutor;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsCompat;

public class HistorialActivity extends AppCompatActivity {

    private Button btnVolverHistorial;

    private TextView txtHistorial1;
    private TextView txtHistorial2;
    private TextView txtHistorial3;

    private SharedPreferences preferencias;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        WindowCompat.enableEdgeToEdge(getWindow());
        setContentView(R.layout.activity_historial);

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

        // Conectar componentes del XML
        btnVolverHistorial = findViewById(R.id.btnVolverHistorial);

        txtHistorial1 = findViewById(R.id.txtHistorial1);
        txtHistorial2 = findViewById(R.id.txtHistorial2);
        txtHistorial3 = findViewById(R.id.txtHistorial3);

        // Acceder al progreso guardado
        preferencias = getSharedPreferences(
                "GualiTutorProgreso",
                MODE_PRIVATE
        );

        // Regresar al menú principal
        btnVolverHistorial.setOnClickListener(v -> finish());
    }

    @Override
    protected void onResume() {
        super.onResume();
        actualizarHistorial();
    }

    private void actualizarHistorial() {

        boolean leccion1 = preferencias.getBoolean("leccion_1", false);
        boolean leccion2 = preferencias.getBoolean("leccion_2", false);
        boolean leccion3 = preferencias.getBoolean("leccion_3", false);

        txtHistorial1.setText(
                "Lección 1: " + (leccion1 ? "Completada ✓" : "Pendiente")
        );

        txtHistorial2.setText(
                "Lección 2: " + (leccion2 ? "Completada ✓" : "Pendiente")
        );

        txtHistorial3.setText(
                "Lección 3: " + (leccion3 ? "Completada ✓" : "Pendiente")
        );
    }
}
