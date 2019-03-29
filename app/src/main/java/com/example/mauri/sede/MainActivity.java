package com.example.mauri.sede;

import android.content.Intent;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    conexion cn= new conexion();
    EditText txt1,txt2;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        StrictMode.ThreadPolicy p = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(p);
        btn = (Button) findViewById(R.id.entrar);
        txt1 = (EditText) findViewById(R.id.txtu);
        txt2 = (EditText) findViewById(R.id.txtc);
        getSupportActionBar().hide();
    }

    public void validar(View v) {
        String u=txt1.getText().toString();
        String p=txt2.getText().toString();
        if(txt1.getText().toString().equals("")  || txt2.getText().toString().equals(""))
        {
            Toast.makeText(getApplicationContext(), "Ingrese todos los datos", Toast.LENGTH_SHORT).show();

        }
        else {
            String texto2 = cn.validar("https://neuroexpansion.000webhostapp.com/validarlogin.php", u, p);
            String[] dato = texto2.split(",");
            int cont = Integer.parseInt(dato[0]);
            if (cont == 1) {
                Intent i = new Intent(getApplicationContext(), menufragment.class);
                startActivity(i);
                finish();
            } else {
                Toast.makeText(getApplicationContext(), "Usuario o contraseña incorrecto", Toast.LENGTH_SHORT).show();
            }
        }

    }
}
