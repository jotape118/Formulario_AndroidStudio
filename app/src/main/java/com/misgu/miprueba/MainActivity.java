package com.misgu.miprueba;

import android.content.DialogInterface;
import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.widget.Button;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


import com.misgu.miprueba.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText editTextNombre,editTextApellido,editTextMail,editTextUser,editTextPass;
    Button buttonDell,buttonConfirm;
    int intCount;
    String strNombre,strApellido,strMail,strUser,strPass;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextNombre= (EditText) findViewById(R.id.editTextNombre);
        editTextApellido= (EditText) findViewById(R.id.editTextApellido);
        editTextMail= (EditText) findViewById(R.id.editTextMail);
        editTextUser= (EditText) findViewById(R.id.editTextUser);
        editTextPass= (EditText) findViewById(R.id.editTextPass);
        buttonDell= (Button) findViewById(R.id.buttonDell);
        buttonConfirm= (Button) findViewById(R.id.buttonConfirm);

        //Funcion de borrado de datos de click
        buttonDell.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                editTextNombre.setText("");
                editTextApellido.setText("");
                editTextMail.setText("");
                editTextUser.setText("");
                editTextPass.setText("");

            }});
        buttonConfirm.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                strNombre=editTextNombre.getText().toString();
                strApellido=editTextApellido.getText().toString();
                strMail=editTextMail.getText().toString();
                strUser=editTextUser.getText().toString();
                strPass=editTextPass.getText().toString();
                ShowAlertdialogue();
                }
            });
        // Passing each menu ID as a set of Ids because each
    }

    private void ShowAlertdialogue() {
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setTitle("Alerta");
        builder.setMessage("Datos de usuario:\n"+strNombre+"\n"+strApellido+"\n"+strMail+"\n"+strUser+"\n"+strPass);

        builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(MainActivity.this, "Texto de ejemplo",Toast.LENGTH_SHORT).show();
            }

        });

        AlertDialog alertDialog =builder.create();
        alertDialog.show();
    }

}