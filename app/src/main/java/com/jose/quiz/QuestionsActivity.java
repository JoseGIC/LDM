package com.jose.quiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class QuestionsActivity extends AppCompatActivity implements View.OnClickListener {

    Button botonSalir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions);

        botonSalir = (Button)findViewById(R.id.boton2);
        botonSalir.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {

        switch(v.getId()) {

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
