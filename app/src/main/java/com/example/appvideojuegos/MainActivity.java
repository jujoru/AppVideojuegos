package com.example.appvideojuegos;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {
    EditText etEmail, etContraseña;
    Button botonLogin, botonRegistro;
    private FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mAuth = FirebaseAuth.getInstance();
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
                }else{
                    loginFirebase(email, contraseña);
                }
            }
        });
    }
    private void loginFirebase(String email,String password){
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        Log.d("tag1", "signInWithEmail:onComplete:" + task.isSuccessful());
                        Toast.makeText(getApplicationContext(), "siiiiii",
                                Toast.LENGTH_SHORT).show();
                        // If sign in fails, display a message to the user. If sign in succeeds
                        // the auth state listener will be notified and logic to handle the
                        // signed in uvser can be handled in the listener.
                        if (!task.isSuccessful()) {
                            Log.w("tag2", "signInWithEmail:failed", task.getException());
                            Toast.makeText(getApplicationContext(), "error al insertar",
                                    Toast.LENGTH_SHORT).show();
                        }

                        // ...
                    }
                });
    }
    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if (currentUser != null) {

            Toast.makeText(getApplicationContext(), "Usuario current: " + currentUser.getUid(),
                    Toast.LENGTH_SHORT).show();
        }
    }


}
