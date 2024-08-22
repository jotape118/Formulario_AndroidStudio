package com.misgu.miprueba;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Objects;

public class LoginForm extends AppCompatActivity {
    Button buttonReturn,buttonConfirm;
    EditText editTextUser,editTextPass;
    String strUser,strPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login_form);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        buttonReturn  = (Button) findViewById(R.id.buttonReturn);
        buttonConfirm = (Button) findViewById(R.id.buttonConfirm);
        editTextUser = (EditText) findViewById(R.id.editTextUser);
        editTextPass = (EditText) findViewById(R.id.editTextPass);
        Bundle in_DB =getIntent().getExtras();
        String[] DB = in_DB.getStringArray("Key");

        buttonReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Atras();
            }
        });
        buttonConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                strUser= editTextUser.getText().toString();
                strPass= editTextPass.getText().toString();
                if (Objects.equals(strUser, DB[0])&& Objects.equals(strPass, DB[1])){
                    AlertaLogin(DB);
                }else {
                    AlertaErrorLogin();
                }
            }
        });

    }

    public void AlertaErrorLogin() {
        AlertDialog.Builder builder=new AlertDialog.Builder(LoginForm.this);
        builder.setTitle("Credenciales incorrectos");
        builder.setMessage("Credenciales no validos, escriba los correctos");
        builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(LoginForm.this, "Vuelva a intentarlo",Toast.LENGTH_SHORT).show();
            }
        });
        AlertDialog alertDialog =builder.create();
        alertDialog.show();
    }

    public void AlertaLogin(String[] DB) {
        AlertDialog.Builder builder=new AlertDialog.Builder(LoginForm.this);
        builder.setTitle("Login exitoso");
        builder.setMessage("Nombre: "+DB[2]+"\nApellido: "+DB[3]+"\nNumero: "+DB[4]);
        builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(LoginForm.this, "So es todo",Toast.LENGTH_SHORT).show();
            }
        });
        AlertDialog alertDialog =builder.create();
        alertDialog.show();
    }

    private void Atras() {
        Intent i= new Intent(this, MainActivity.class);
        startActivity(i);
    }
}