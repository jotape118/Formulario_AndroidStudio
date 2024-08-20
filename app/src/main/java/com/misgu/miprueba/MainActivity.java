package com.misgu.miprueba;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.widget.Button;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import com.misgu.miprueba.databinding.ActivityMainBinding;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {
    EditText editTextNombre,editTextApellido,editTextMail,editTextUser,editTextPass;
    Button buttonDell,buttonConfirm;
    String strNombre,strApellido,strMail,strUser,strPass, TAG="Test";
    Boolean boolCamposVacios;
    Bundle enviardatos=new Bundle();
    String[] DB= new String[5];

    TextView textViewonCreate,textViewonStart,textViewonResume,textViewonPause,textViewonStop,textViewonRestart,textViewonDestroy;
    int intonCreate=0,intonStart=0,intonResume=0,intonPause=0,intonStop=0,intonRestart=0,intonDestroy=0;
    private ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d(TAG,"Estoy en onCreate");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewonCreate= (TextView) findViewById(R.id.textViewonCreate);
        intonCreate+=1;

        textViewonCreate.setText("onCreate #"+intonCreate);

        editTextNombre= (EditText) findViewById(R.id.editTextNombre);
        editTextApellido= (EditText) findViewById(R.id.editTextApellido);
        editTextMail= (EditText) findViewById(R.id.editTextMail);
        editTextUser= (EditText) findViewById(R.id.editTextUser);
        editTextPass= (EditText) findViewById(R.id.editTextPass);
        buttonDell= (Button) findViewById(R.id.buttonDell);
        buttonConfirm= (Button) findViewById(R.id.buttonConfirm);


    }

    @Override
    protected void onStart() {
        super.onStart();

        textViewonStart= (TextView) findViewById(R.id.textViewonStart);
        intonStart+=1;

        textViewonStart.setText("onStart #"+intonStart);
        Log.d(TAG,"Estoy en onStart");
        //Funcion de borrado de datos de click
        buttonDell.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                BorrarDatos();
            }});
        buttonConfirm.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                strNombre = editTextNombre.getText().toString();
                strApellido = editTextApellido.getText().toString();
                strMail = editTextMail.getText().toString();
                strUser = editTextUser.getText().toString();
                strPass = editTextPass.getText().toString();
                Emptyitems(boolCamposVacios);
                if (boolCamposVacios==Boolean.FALSE){
                    DB[0]=strUser;
                    DB[1]=strPass;
                    DB[2]=strNombre;
                    DB[3]=strApellido;
                    DB[4]=strMail;
                    //ShowAlertDatos();
                    login();
                }else {
                    ShowAlertErrorDatos();
                }
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();

        textViewonResume= (TextView) findViewById(R.id.textViewonResume);
        intonResume+=1;

        textViewonResume.setText("onResume #"+intonResume);
        Log.d(TAG,"Estoy en onResume");
        Toast.makeText(MainActivity.this, "Estoy en onResume",Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onPause() {
        super.onPause();

        textViewonPause= (TextView) findViewById(R.id.textViewonPause);
        intonPause+=1;

        textViewonPause.setText("onPause #"+intonPause);
        Log.d(TAG,"Estoy en onPause");
        Toast.makeText(MainActivity.this, "Estoy en onPause",Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStop() {
        super.onStop();

        textViewonStop= (TextView) findViewById(R.id.textViewonStop);
        intonStop+=1;

        textViewonStop.setText("onStop #"+intonStop);
        Log.d(TAG,"Estoy en onStop");
        Toast.makeText(MainActivity.this, "Estoy en onStop",Toast.LENGTH_SHORT).show();

    }

    @Override
    protected void onRestart() {
        super.onRestart();

        textViewonRestart= (TextView) findViewById(R.id.textViewonRestart);
        intonRestart+=1;

        textViewonRestart.setText("onRestart #"+intonRestart);
        Log.d(TAG,"Estoy en onRestart");
        Toast.makeText(MainActivity.this, "Estoy en onRestart",Toast.LENGTH_SHORT).show();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        textViewonCreate= (TextView) findViewById(R.id.textViewonDestroy);
        intonDestroy+=1;

        textViewonDestroy.setText("onDestroy #"+intonDestroy);
        Log.d(TAG,"Estoy en onDestroy");
        Toast.makeText(MainActivity.this, "Estoy en onDestroy",Toast.LENGTH_SHORT).show();
    }


    public void login() {
        Intent i =new Intent(MainActivity.this, LoginForm.class);
        enviardatos.putStringArray("Key",DB);
        i.putExtras(enviardatos);
        startActivity(i);
    }

    private void BorrarDatos() {
        editTextNombre.setText("");
        editTextApellido.setText("");
        editTextMail.setText("");
        editTextUser.setText("");
        editTextPass.setText("");
    }


    private boolean Emptyitems(Boolean boolCamposVacios) {
        this.boolCamposVacios=Boolean.FALSE;
        if (Objects.equals(strNombre, "")){
            this.boolCamposVacios =Boolean.TRUE;
        }
        if (Objects.equals(strApellido, "")) {
            this.boolCamposVacios =Boolean.TRUE;
        }
        if (Objects.equals(strMail, "")) {
            this.boolCamposVacios =Boolean.TRUE;
        }
        if (Objects.equals(strUser, "")) {
            this.boolCamposVacios =Boolean.TRUE;
        }
        if (Objects.equals(strPass, "")) {
            this.boolCamposVacios =Boolean.TRUE;
        }
        return this.boolCamposVacios;
    }


    private void ShowAlertErrorDatos() {
        if (Objects.equals(strNombre, "")){
            strNombre="Nombre ";
        }else {
            strNombre = "";
        }
        if (Objects.equals(strApellido, "")){
            strApellido="Apellido ";
        }else {
            strApellido = "";
        }
        if (Objects.equals(strMail, "")) {
            strMail="Correo ";
        }else{
            strMail = "";
        }
        if (Objects.equals(strUser, "")){
            strUser ="Usuario ";
        }else {
            strUser ="";
        }
        if (Objects.equals(strPass, "")){
            strPass = "Contraseña";
        }else {
            strPass="";
        }
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setTitle("Alerta");
        builder.setMessage("Han faltado los siguientes datos:\n"+strNombre+strApellido+strMail+strUser+strPass);

        builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(MainActivity.this, "Por favor ingresar los datos faltantes",Toast.LENGTH_SHORT).show();
            }

        });

        AlertDialog alertDialog =builder.create();
        alertDialog.show();
    }

    private void ShowAlertDatos() {
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setTitle("Datos de usuario");
        builder.setMessage(DB[0]+"\n"+DB[1]+"\n"+DB[2]+"\n"+DB[3]+"\n"+DB[4]);

        builder.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(MainActivity.this, "Registro Completado",Toast.LENGTH_SHORT).show();
            }

        });

        AlertDialog alertDialog =builder.create();
        alertDialog.show();
    }

}