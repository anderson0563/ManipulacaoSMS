package br.edu.unicarioca.informatica.anderson.manipulacaosms;

import android.Manifest;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.security.Permission;

import static android.Manifest.*;
import static android.content.pm.PackageManager.*;

public class Principal extends AppCompatActivity {
    public int autorizado;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        // Here, thisActivity is the current activity
        if (ContextCompat.checkSelfPermission(Principal.this,
                Manifest.permission.RECEIVE_SMS)
                != PackageManager.PERMISSION_GRANTED) {

            // Should we show an explanation?
            if (ActivityCompat.shouldShowRequestPermissionRationale(Principal.this,
                    Manifest.permission.RECEIVE_SMS)) {

                // Show an expanation to the user *asynchronously* -- don't block
                // this thread waiting for the user's response! After the user
                // sees the explanation, try again to request the permission.

            } else {

                // No explanation needed, we can request the permission.

                ActivityCompat.requestPermissions(Principal.this,
                        new String[]{Manifest.permission.RECEIVE_SMS},
                        autorizado);
                TextView texto = (TextView) findViewById(R.id.texto);
                texto.setText(String.valueOf(autorizado));

            }
        }
    }
}
