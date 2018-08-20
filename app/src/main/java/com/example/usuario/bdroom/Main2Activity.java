package com.example.usuario.bdroom;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class Main2Activity extends AppCompatActivity {

    @BindView(R.id.tv_titulo)
    TextView tvTitulo;
    @BindView(R.id.et_nombre)
    EditText etNombre;
    @BindView(R.id.et_especie)
    EditText etEspecie;
    @BindView(R.id.et_edad)
    EditText etEdad;
    @BindView(R.id.et_sexo)
    EditText etSexo;
    @BindView(R.id.et_descripcion)
    EditText etDescripcion;
    @BindView(R.id.btn_aceptar)
    Button btnAceptar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btn_aceptar)
    public void onViewClicked() {
    }
}
