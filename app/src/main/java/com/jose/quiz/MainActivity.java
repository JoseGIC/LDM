package com.jose.quiz;

import android.app.AlertDialog;
import android.app.Dialog;
import android.support.v7.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    View layoutMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        layoutMain = findViewById(R.id.layoutMain);
        layoutMain.setOnClickListener(this);
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

            case R.id.layoutMain:
                Intent intent = new Intent(MainActivity.this, Q1Activity.class);
                intent.putExtra("contador", 0);
                startActivity(intent);
                finish();
                break;

            default:
                break;
        }
    }

}
