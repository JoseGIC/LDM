package com.jose.quiz;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;


public class Q5Activity extends AppCompatActivity implements View.OnClickListener {

    int contador;
    TextView puntos;
    Button botonConfirmar;
    CheckBox cB1, cB2, cB3, cB4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_q5);

        contador = getIntent().getIntExtra("contador", 0);

        puntos = (TextView)findViewById(R.id.textPuntos);
        puntos.setText(String.valueOf(contador));

        cB1 = (CheckBox)findViewById(R.id.cB1);
        cB2 = (CheckBox)findViewById(R.id.cB2);
        cB3 = (CheckBox)findViewById(R.id.cB3);
        cB4 = (CheckBox)findViewById(R.id.cB4);
        cB1.setOnClickListener(this);
        cB2.setOnClickListener(this);
        cB3.setOnClickListener(this);
        cB4.setOnClickListener(this);

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

                if(cB4.isChecked()) {
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

            case R.id.cB1:
                desactivar();
                cB1.setChecked(true);
                break;

            case R.id.cB2:
                desactivar();
                cB2.setChecked(true);
                break;

            case R.id.cB3:
                desactivar();
                cB3.setChecked(true);
                break;

            case R.id.cB4:
                desactivar();
                cB4.setChecked(true);
                break;

            default:
                break;
        }
    }


    private void nextActivity(boolean next) {
        Intent intent;
        if(next) {
            intent = new Intent(this, FinalActivity.class);
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
        cB1.setChecked(false);
        cB2.setChecked(false);
        cB3.setChecked(false);
        cB4.setChecked(false);
    }

}
