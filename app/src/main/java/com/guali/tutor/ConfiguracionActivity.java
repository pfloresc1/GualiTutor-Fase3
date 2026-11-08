package com.guali.tutor;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsCompat;

public class ConfiguracionActivity extends AppCompatActivity {

    private EditText edtNombreEstudiante;
    private Button btnGuardarConfiguracion;
    private Button btnVolverConfiguracion;

    private SharedPreferences preferencias;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        WindowCompat.enableEdgeToEdge(getWindow());
        setContentView(R.layout.activity_configuracion);

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
        edtNombreEstudiante = findViewById(R.id.edtNombreEstudiante);
        btnGuardarConfiguracion = findViewById(R.id.btnGuardarConfiguracion);
        btnVolverConfiguracion = findViewById(R.id.btnVolverConfiguracion);

        // Utilizar almacenamiento local
        preferencias = getSharedPreferences(
                "GualiTutorProgreso",
                MODE_PRIVATE
        );

        // Recuperar el nombre guardado anteriormente
        String nombreGuardado = preferencias.getString(
                "nombreEstudiante",
                ""
        );

        edtNombreEstudiante.setText(nombreGuardado);

        // Guardar el nombre del estudiante
        btnGuardarConfiguracion.setOnClickListener(v -> {

            String nombre = edtNombreEstudiante.getText()
                    .toString()
                    .trim();

            if (nombre.isEmpty()) {
                edtNombreEstudiante.setError("Ingresa tu nombre");
                return;
            }

            preferencias.edit()
                    .putString("nombreEstudiante", nombre)
                    .apply();

            Toast.makeText(
                    ConfiguracionActivity.this,
                    "Configuración guardada correctamente",
                    Toast.LENGTH_SHORT
            ).show();
        });

        // Regresar al menú principal
        btnVolverConfiguracion.setOnClickListener(v -> finish());
    }
}
