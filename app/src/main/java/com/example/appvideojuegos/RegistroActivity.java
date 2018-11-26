package com.example.appvideojuegos;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class RegistroActivity extends AppCompatActivity {
    EditText etNombre, etEmail, etContraseña, etContraseña2;
    Button botonCrear;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
        etNombre = (EditText) findViewById(R.id.etNombre);
        etEmail = (EditText) findViewById(R.id.etEmailLogin);
        etContraseña = (EditText) findViewById(R.id.etContraseñaLogin);
        etContraseña2 = (EditText) findViewById(R.id.etContraseñaLogin2);
        botonCrear = (Button) findViewById(R.id.botonLogin2);

        botonCrear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}
