package com.example.appvideojuegos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText etEmail, etContraseña;
    Button botonLogin, botonRegistro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etEmail = (EditText) findViewById(R.id.etEmail);
        etContraseña = (EditText) findViewById(R.id.etContraseña);
        botonLogin = (Button) findViewById(R.id.botonLogin);
        botonRegistro = (Button) findViewById(R.id.botonRegistro);

        botonRegistro.setOnClickListener(new View.OnClickListener(){
             @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), RegistroActivity.class);
                startActivity(i);
            }
        });

        botonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = etEmail.getText().toString();
                String contraseña = etContraseña.getText().toString();

                if(TextUtils.isEmpty(email) | TextUtils.isEmpty(contraseña)){
                    Toast.makeText(MainActivity.this, R.string.validacionMain, Toast.LENGTH_SHORT).show();
                }
            }
        });
    }


}
