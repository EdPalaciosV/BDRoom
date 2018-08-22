package com.example.usuario.bdroom;

import android.arch.persistence.room.Room;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.usuario.bdroom.DB.Animal;
import com.example.usuario.bdroom.DB.AnimalDataBase;

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

    AnimalDataBase dataBase;
    Bundle bundle;
    String mostrar;
    String actualizar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        ButterKnife.bind(this);
        dataBase= Room.databaseBuilder(getApplicationContext(),AnimalDataBase.class,"animalDb").allowMainThreadQueries().build();

        bundle= getIntent().getExtras();


        if(bundle!=null)
        {
            mostrar=bundle.getString("Mostrar");
            actualizar=bundle.getString("Actualizar");

            if(mostrar!=null && mostrar.equalsIgnoreCase("mostrar"))
            {
                setValuesET();
            }
             if(actualizar!=null  && actualizar.equalsIgnoreCase("actualizar")) {

                 Log.d("tags",actualizar
                 );
                setUpdateValuesET();
            }

        }
    }

    public void setValuesET()
    {
        etNombre.setText("Nombre: "+bundle.getString("Nombre"));
        etNombre.setEnabled(false);

        etEspecie.setText("Especie: "+bundle.getString("Especie"));
        etEspecie.setEnabled(false);

        etEdad.setText("Edad: "+String.valueOf(bundle.getInt("Edad")));
        etEdad.setEnabled(false);

        etSexo.setText("Sexo: "+bundle.getString("Sexo"));
        etSexo.setEnabled(false);

        etDescripcion.setText("Descripcion: "+bundle.getString("Descripcion"));
        etDescripcion.setEnabled(false);
    }

    public void setUpdateValuesET()
    {
        etNombre.setText(bundle.getString("Nombre"));
        etEspecie.setText(bundle.getString("Especie"));
        etEdad.setText(String.valueOf(bundle.getInt("Edad")));
        etSexo.setText(bundle.getString("Sexo"));
        etDescripcion.setText(bundle.getString("Descripcion"));
    }
    @OnClick(R.id.btn_aceptar)
    public void onViewClicked() {

        Animal animal = new Animal();

        animal.setNombre(etNombre.getText().toString());
        animal.setEspecie(etEspecie.getText().toString());
        animal.setEdad(Integer.parseInt(etEdad.getText().toString()));
        animal.setSexo(etSexo.getText().toString());
        animal.setDescripcion(etDescripcion.getText().toString());


        if (actualizar!=null && actualizar.equalsIgnoreCase("actualizar")){
            animal.setId(bundle.getInt("Id"));
            dataBase.daoAnimal().updateAnimal(animal);
        }
        else {

            dataBase.daoAnimal().InsertAnimal(animal);
        }
    }
}
