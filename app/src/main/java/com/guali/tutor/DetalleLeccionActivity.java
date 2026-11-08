package com.guali.tutor;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsCompat;

public class DetalleLeccionActivity extends AppCompatActivity {

    private TextView txtTituloLeccion;
    private TextView txtDescripcionLeccion;
    private TextView txtEjemploLeccion;

    private Button btnCompletarLeccion;
    private Button btnVolverLecciones;

    private SharedPreferences preferencias;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        WindowCompat.enableEdgeToEdge(getWindow());
        setContentView(R.layout.activity_detalle_leccion);

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

        // Conectar los componentes del XML
        txtTituloLeccion = findViewById(R.id.txtTituloLeccion);
        txtDescripcionLeccion = findViewById(R.id.txtDescripcionLeccion);
        txtEjemploLeccion = findViewById(R.id.txtEjemploLeccion);

        btnCompletarLeccion = findViewById(R.id.btnCompletarLeccion);
        btnVolverLecciones = findViewById(R.id.btnVolverLecciones);

        // Inicializar el almacenamiento local
        preferencias = getSharedPreferences(
                "GualiTutorProgreso",
                MODE_PRIVATE
        );

        // Recibir el número de la lección
        int numeroLeccion = getIntent().getIntExtra(
                "numeroLeccion", 1
        );

        mostrarLeccion(numeroLeccion);

        // Comprobar si ya está completada
        boolean completada = preferencias.getBoolean(
                "leccion_" + numeroLeccion,
                false
        );

        if (completada) {
            btnCompletarLeccion.setText("Lección completada ✓");
            btnCompletarLeccion.setEnabled(false);
        }

        // Guardar el progreso de la lección
        btnCompletarLeccion.setOnClickListener(v -> {

            preferencias.edit()
                    .putBoolean("leccion_" + numeroLeccion, true)
                    .apply();

            btnCompletarLeccion.setText("Lección completada ✓");
            btnCompletarLeccion.setEnabled(false);

            Toast.makeText(
                    DetalleLeccionActivity.this,
                    "Lección " + numeroLeccion + " completada y guardada",
                    Toast.LENGTH_SHORT
            ).show();
        });

        // Regresar al listado de lecciones
        btnVolverLecciones.setOnClickListener(v -> finish());
    }

    private void mostrarLeccion(int numeroLeccion) {

        switch (numeroLeccion) {

            case 1:
                txtTituloLeccion.setText(
                        "Lección 1: Introducción a Java"
                );

                txtDescripcionLeccion.setText(
                        "Java es un lenguaje de programación " +
                                "orientado a objetos que permite desarrollar " +
                                "aplicaciones para diferentes plataformas.\n\n" +
                                "En esta lección aprenderás a mostrar " +
                                "mensajes en la consola utilizando Java."
                );

                txtEjemploLeccion.setText(
                        "public class HolaMundo {\n" +
                                "    public static void main(String[] args) {\n" +
                                "        System.out.println(\"Hola Mundo\");\n" +
                                "    }\n" +
                                "}"
                );
                break;

            case 2:
                txtTituloLeccion.setText(
                        "Lección 2: Variables en Java"
                );

                txtDescripcionLeccion.setText(
                        "Las variables permiten almacenar información " +
                                "dentro de un programa.\n\n" +
                                "En Java existen diferentes tipos de datos, " +
                                "como int, double, boolean y String."
                );

                txtEjemploLeccion.setText(
                        "int edad = 20;\n" +
                                "double promedio = 85.5;\n" +
                                "String nombre = \"Estudiante\";\n\n" +
                                "System.out.println(nombre);"
                );
                break;

            case 3:
                txtTituloLeccion.setText(
                        "Lección 3: Condicionales en Java"
                );

                txtDescripcionLeccion.setText(
                        "Las estructuras condicionales permiten " +
                                "tomar decisiones dentro de un programa.\n\n" +
                                "La instrucción if ejecuta un bloque de código " +
                                "cuando se cumple una condición."
                );

                txtEjemploLeccion.setText(
                        "int nota = 75;\n\n" +
                                "if (nota >= 60) {\n" +
                                "    System.out.println(\"Aprobado\");\n" +
                                "} else {\n" +
                                "    System.out.println(\"Reprobado\");\n" +
                                "}"
                );
                break;

            default:
                txtTituloLeccion.setText("Lección no disponible");
                txtDescripcionLeccion.setText(
                        "No se encontró la lección seleccionada."
                );
                txtEjemploLeccion.setText("");
                btnCompletarLeccion.setEnabled(false);
                break;
        }
    }
}
