package com.misgu.miprueba;

import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import android.widget.Button;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;


import com.misgu.miprueba.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    TextView tv_Nombre;
    EditText et_Nombre;
    Button btn_Borrar;
    String Nom_Usu;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_Nombre= (EditText) findViewById(R.id.EditTextNombre);
        tv_Nombre= (TextView) findViewById(R.id.textViewNombre);
        btn_Borrar= (Button) findViewById(R.id.buttonDel);

        btn_Borrar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                tv_Nombre.setText("Pulso el boton de borrar");
                Nom_Usu=String.valueOf(et_Nombre.getText());
            }});
        // Passing each menu ID as a set of Ids because each
    }

}