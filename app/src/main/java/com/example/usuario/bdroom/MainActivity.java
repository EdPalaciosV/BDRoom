package com.example.usuario.bdroom;

import android.arch.persistence.room.Room;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.usuario.bdroom.DB.Animal;
import com.example.usuario.bdroom.DB.AnimalDataBase;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements ValuesDialog {

    @BindView(R.id.btn_mostrar)
    Button btnMostrar;
    @BindView(R.id.btn_agregar)
    Button btnAgregar;
    @BindView(R.id.btn_editar)
    Button btnEditar;
    @BindView(R.id.btn_eliminar)
    Button btnEliminar;
    public static AnimalDataBase dataBase;
    DialogoBusqueda dialogoBusqueda;

    boolean mostrar=false;
    boolean editar=false;
    boolean eliminar=false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        dialogoBusqueda =new DialogoBusqueda(this);
        dataBase=Room.databaseBuilder(getApplicationContext(),AnimalDataBase.class,"animalDb").allowMainThreadQueries().build();

    }

    @OnClick({R.id.btn_mostrar, R.id.btn_agregar, R.id.btn_editar, R.id.btn_eliminar})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_mostrar:
                mostrar=true;
                dialogoBusqueda.show();
                break;

            case R.id.btn_agregar:
                startActivity(instanceIntent());
                break;

            case R.id.btn_editar:
                editar=true;
                dialogoBusqueda.show();
                break;

            case R.id.btn_eliminar:
                eliminar=true;
                dialogoBusqueda.show();


                break;
        }
    }

    @Override
    public void valuesDialog(String nombre, String sexo) {

        dialogoBusqueda.dismiss();
        //List<Animal> animals= dataBase.daoAnimal().getAllAnimals();
        //Log.d("tag",animals.get(0).getNombre());
        if(mostrar)
        {
            mostrar=false;
            Animal animal= dataBase.daoAnimal().getAnimal(nombre,sexo);
            if (animal!=null) {

                Bundle bundle = new Bundle();
                bundle.putString("Mostrar","mostrar");
                bundle.putString("Nombre", animal.getNombre());
                bundle.putString("Especie", animal.getEspecie());
                bundle.putInt("Edad", animal.getEdad());
                bundle.putString("Sexo", animal.getSexo());
                bundle.putString("Descripcion", animal.getDescripcion());

                startActivity(instanceIntent().putExtras(bundle));
            }
        }
        if(eliminar)
        {
            eliminar=false;
            dataBase.daoAnimal().DeleteAnimal2(nombre,sexo);
        }

        if(editar)
        {
            editar=false;
            Animal animal= dataBase.daoAnimal().getAnimal(nombre,sexo);

            if (animal!=null) {

                Bundle bundle = new Bundle();
                bundle.putString("Actualizar","actualizar");
                bundle.putInt("Id",animal.getId());
                bundle.putString("Nombre", animal.getNombre());
                bundle.putString("Especie", animal.getEspecie());
                bundle.putInt("Edad", animal.getEdad());
                bundle.putString("Sexo", animal.getSexo());
                bundle.putString("Descripcion", animal.getDescripcion());

                startActivity(instanceIntent().putExtras(bundle));
            }
        }


    }

    public  Intent instanceIntent()
    {
        return new Intent(this,Main2Activity.class);
    }
}
