package com.jose.quiz;

import android.support.v7.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button botonInicio;
    Button botonDialogo;
    int contador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        botonInicio = (Button)findViewById(R.id.boton1);
        botonInicio.setOnClickListener(this);
        botonDialogo = (Button)findViewById(R.id.boton2);
        botonDialogo.setOnClickListener(this);

        contador = new Integer(2);
    }


    @Override
    public void onClick(View v) {

        switch(v.getId()) {

            case R.id.boton1:
                Intent intent = new Intent(MainActivity.this, Q1.class);
                intent.putExtra("contador",contador);
                startActivity(intent);
                break;

            case R.id.boton2:
                new Dialogs(this).failDialog();
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
