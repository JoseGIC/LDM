package com.jose.quiz;

import android.support.v7.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button botonInicio;
    int contador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        botonInicio = (Button)findViewById(R.id.boton1);
        botonInicio.setOnClickListener(this);

        contador=new Integer(2);
    }


    @Override
    public void onClick(View v) {

        switch(v.getId()) {

            case R.id.boton1:
                Intent intent = new Intent(MainActivity.this, Q1.class);
                //intent.putExtra(EXTRA_DEVICE_ADDRESS, address);
                intent.putExtra("contador",contador);
                startActivity(intent);
                break;

            default:
                break;
        }
    }
}
