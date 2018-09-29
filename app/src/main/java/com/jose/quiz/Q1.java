package com.jose.quiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class Q1 extends AppCompatActivity implements View.OnClickListener {

    int contador;
    private TextView puntuacion;
    Button botonSalir;
    Button botonSiguiente;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_q1);

        contador = getIntent().getIntExtra("contador",0);

        puntuacion= (TextView) findViewById(R.id.textv);
        puntuacion.setText(String.valueOf(contador));

        botonSalir = (Button)findViewById(R.id.boton2);
        botonSalir.setOnClickListener(this);




    }


    @Override
    public void onClick(View v) {

        switch(v.getId()) {


            case R.id.boton2:
                Intent intent = new Intent(Q1.this, MainActivity.class);
                contador++;
                Toast.makeText(this, "Puntuacion " + contador , Toast.LENGTH_SHORT).show();
                startActivity(intent);
                finish();
                break;

            default:
                break;
        }
    }


    @Override
    public void onBackPressed() {
        new Dialogs(this).exitDialog();
    }
}
