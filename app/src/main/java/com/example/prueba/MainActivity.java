package com.example.prueba;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    EditText usuario, pass;
    Button login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        usuario = findViewById(R.id.Txt_Usuario);
        pass = findViewById(R.id.Txt_Pass);
        login = findViewById(R.id.Btn_Login);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


    }
    public void ValidarLogin(View view){
        String Usuario = usuario.getText().toString();
        String Pass = pass.getText().toString();

        if(Usuario.equals("admin") && Pass.equals("nico")){
            Intent inicio = new Intent(this, com.example.prueba.MainActivity.class);
            inicio.putExtra("Usuario", Usuario);
            startActivity(inicio);

        }else {
            Toast.makeText(this, "Ingrese credenciales correctas", Toast.LENGTH_SHORT).show();
        }
    }
}