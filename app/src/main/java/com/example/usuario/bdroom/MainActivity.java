package com.example.usuario.bdroom;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.btn_mostrar)
    Button btnMostrar;
    @BindView(R.id.btn_agregar)
    Button btnAgregar;
    @BindView(R.id.btn_editar)
    Button btnEditar;
    @BindView(R.id.btn_eliminar)
    Button btnEliminar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.btn_mostrar, R.id.btn_agregar, R.id.btn_editar, R.id.btn_eliminar})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_mostrar:
                Toast.makeText(getApplicationContext(),"mostrar",Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_agregar:
                break;
            case R.id.btn_editar:
                break;
            case R.id.btn_eliminar:
                break;
        }
    }
}
