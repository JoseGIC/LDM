package com.jose.quiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class QuestionsActivity extends AppCompatActivity implements View.OnClickListener {

    int contador;
    Button botonSalir;
    Button botonSiguiente;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions);

        contador= getIntent().getIntExtra("contador",0);

        botonSiguiente= (Button) findViewById(R.id.botonS);
        botonSiguiente.setOnClickListener(this);

        botonSalir = (Button)findViewById(R.id.boton2);
        botonSalir.setOnClickListener(this);


    }


    @Override


    public void onClick(View v) {

        switch(v.getId()) {

            case R.id.botonS:

                contador++;
                Toast.makeText(this, "Puntucacion " + contador , Toast.LENGTH_SHORT).show();

            case R.id.boton2:
                Intent intent = new Intent(QuestionsActivity.this, MainActivity.class);
                //intent.putExtra(EXTRA_DEVICE_ADDRESS, address);
                startActivity(intent);
                break;

            default:
                break;
        }
    }
}
