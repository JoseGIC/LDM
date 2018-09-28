package com.jose.quiz;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.widget.Toast;

public class Dialogs {

    private Activity activity;

    Dialogs(Activity activity) {
        this.activity = activity;
    }

    public void failDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        builder.setTitle("HAS FALLADO!");
        builder.setMessage("Puedes continuar si gastas 2 puntos");
        builder.setPositiveButton("Continuar", (dialog, id) -> Toast.makeText(activity, "-2 pts", Toast.LENGTH_SHORT).show());
        builder.setNegativeButton("Salir", (dialog, id) -> Toast.makeText(activity, "Chau", Toast.LENGTH_SHORT).show());
        Dialog dialog = builder.create();
        dialog.show();
    }


    public void exitDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        builder.setTitle("SALIR");
        builder.setMessage("¿Abandonar partida y salir?");
        builder.setPositiveButton("Continuar", null);
        builder.setNegativeButton("Salir", (dialog, id) -> activity.finish());
        Dialog dialog = builder.create();
        dialog.show();
    }
}