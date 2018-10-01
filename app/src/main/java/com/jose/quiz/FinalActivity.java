package com.jose.quiz;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class FinalActivity extends AppCompatActivity implements View.OnClickListener {

    int contador;
    TextView puntos;
    Button botonInicio;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final);

        contador = getIntent().getIntExtra("contador", 0);

        puntos = (TextView)findViewById(R.id.textPuntos);
        puntos.setText(String.valueOf(contador));

        botonInicio = (Button)findViewById(R.id.botonInicio);
        botonInicio.setOnClickListener(this);
    }


    @Override
    public void onBackPressed() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("SALIR");
        builder.setMessage("¿Quieres salir del juego?");
        builder.setPositiveButton("Continuar :D", null);
        builder.setNegativeButton("Salir :(", (dialog, id) -> finish());
        Dialog dialog = builder.create();
        dialog.show();
    }


    @Override
    public void onClick(View v) {

        switch(v.getId()) {

            case R.id.botonInicio:
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
                finish();

            default:
                break;
        }
    }

}
