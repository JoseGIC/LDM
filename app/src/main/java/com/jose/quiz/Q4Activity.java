package com.jose.quiz;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;


public class Q4Activity extends AppCompatActivity implements View.OnClickListener {

    int contador;
    TextView puntos;
    Button botonConfirmar;
    Switch switch1, switch2, switch3, switch4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_q4);

        contador = getIntent().getIntExtra("contador", 0);

        puntos = (TextView)findViewById(R.id.textPuntos);
        puntos.setText(String.valueOf(contador));

        switch1 = (Switch) findViewById(R.id.switch1); // correctas 3 y 4
        switch2 = (Switch) findViewById(R.id.switch2);
        switch3 = (Switch) findViewById(R.id.switch3);
        switch4 = (Switch) findViewById(R.id.switch4);

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

                if(!switch1.isChecked() && !switch2.isChecked() && switch3.isChecked() && switch4.isChecked()) {
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

            default:
                break;
        }
    }


    private void nextActivity(boolean next) {
        Intent intent;
        if(next) {
            intent = new Intent(this, MainActivity.class);
            //intent.putExtra("contador", contador);
            Toast.makeText(this, "HAS GANADO! Puntos = " + contador, Toast.LENGTH_SHORT).show();
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

}