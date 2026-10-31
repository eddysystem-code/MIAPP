package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText nombreGasto, valorGasto;
    Button botonAgregar;
    TextView listaGastos, totalGastos;

    int total = 0;
    String lista = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nombreGasto = findViewById(R.id.nombreGasto);
        valorGasto = findViewById(R.id.valorGasto);
        botonAgregar = findViewById(R.id.botonAgregar);
        listaGastos = findViewById(R.id.listaGastos);
        totalGastos = findViewById(R.id.totalGastos);

        botonAgregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String nombre = nombreGasto.getText().toString();
                String valorTexto = valorGasto.getText().toString();

                if (nombre.isEmpty() || valorTexto.isEmpty()) {
                    Toast.makeText(MainActivity.this,
                            "Completa los dos campos",
                            Toast.LENGTH_SHORT).show();
                } else {
                    int valor = Integer.parseInt(valorTexto);

                    total = total + valor;

                    lista = lista + nombre + ": $" + valor + "\n";

                    listaGastos.setText(lista);
                    totalGastos.setText("Total gastado: $" + total);

                    nombreGasto.setText("");
                    valorGasto.setText("");
                }
            }
        });
    }
}