package com.jose.quiz;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;


public class Q2Activity extends AppCompatActivity implements View.OnClickListener {

    int contador;
    TextView puntos;
    Button botonConfirmar;
    ImageButton iB1;
    ImageButton iB2;
    ImageButton iB3;
    ImageButton iB4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_q2);

        contador = getIntent().getIntExtra("contador", 0);

        puntos = (TextView)findViewById(R.id.textPuntos);
        puntos.setText(String.valueOf(contador));

        iB1 = (ImageButton)findViewById(R.id.imageB1);
        iB1.setOnClickListener(this);
        iB2 = (ImageButton)findViewById(R.id.imageB2);
        iB2.setOnClickListener(this);
        iB3 = (ImageButton)findViewById(R.id.imageB3); // correcta 3
        iB3.setOnClickListener(this);
        iB4 = (ImageButton)findViewById(R.id.imageB4);
        iB4.setOnClickListener(this);

        botonConfirmar = (Button)findViewById(R.id.botonConfirmar);
        botonConfirmar.setOnClickListener(this);
    }


    @Override
    public void onBackPressed() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("SALIR");
        builder.setMessage("¿Abandonar partida y salir?");
        builder.setPositiveButton("Continuar", null);
        builder.setNegativeButton("Salir", (dialog, id) -> finish());
        Dialog dialog = builder.create();
        dialog.show();
    }


    @Override
    public void onClick(View v) {

        switch(v.getId()) {

            case R.id.botonConfirmar:

                if(iB3.isActivated()) {
                    //contador = contador + 4;
                    contador++;
                    Toast.makeText(this, "Correcto!", Toast.LENGTH_SHORT).show();
                    nextActivity(true);

                } else {
                    if(contador >= 2) {
                        failDialog();
                    } else {
                        Toast.makeText(this, "Has perdido :(", Toast.LENGTH_SHORT).show();
                        nextActivity(false);
                    }
                }
                break;

            case R.id.imageB1:
                desactivar();
                iB1.setActivated(true);
                iB1.setBackgroundResource(android.R.color.background_light);
                break;

            case R.id.imageB2:
                desactivar();
                iB2.setActivated(true);
                iB2.setBackgroundResource(android.R.color.background_light);
                break;

            case R.id.imageB3:
                desactivar();
                iB3.setActivated(true);
                iB3.setBackgroundResource(android.R.color.background_light);
                break;

            case R.id.imageB4:
                desactivar();
                iB4.setActivated(true);
                iB4.setBackgroundResource(android.R.color.background_light);
                break;

            default:
                break;
        }
    }


    private void nextActivity(boolean next) {
        Intent intent;
        if(next) {
            intent = new Intent(this, Q3Activity.class);
            intent.putExtra("contador", contador);
        } else {
            intent = new Intent(this, MainActivity.class);
        }
        startActivity(intent);
        finish();
    }


    private void failDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("HAS FALLADO!");
        builder.setMessage("Puedes continuar si gastas 2 puntos");
        builder.setPositiveButton("Continuar", (dialog, id) -> restarPuntos());
        builder.setNegativeButton("Abandonar", (dialog, id) -> nextActivity(false));
        Dialog dialog = builder.create();
        dialog.show();
    }


    private void restarPuntos() {
        Toast.makeText(this, "-2 puntos", Toast.LENGTH_SHORT).show();
        contador = contador - 2;
        nextActivity(true);
    }


    private void desactivar() {
        iB1.setActivated(false);
        iB2.setActivated(false);
        iB3.setActivated(false);
        iB4.setActivated(false);
        iB1.setBackgroundResource(android.R.color.transparent);
        iB2.setBackgroundResource(android.R.color.transparent);
        iB3.setBackgroundResource(android.R.color.transparent);
        iB4.setBackgroundResource(android.R.color.transparent);
    }

}
