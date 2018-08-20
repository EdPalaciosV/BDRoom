package com.example.usuario.bdroom.DB;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity(tableName = "Animales")
public class Animal {

    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "animal_nombre")
    private String nombre;

    @ColumnInfo(name = "animal_especie")
    private String especie;

    @ColumnInfo(name = "animal_edad")
    private int edad;

    @ColumnInfo(name = "animal_sexo")
    private String sexo;

    @ColumnInfo(name = "animal_descripcion")
    private String descripcion;

    public int getId(){
        return id;
    }
    public String getNombre() {
        return nombre;
    }

    public String getEspecie() {
        return especie;
    }

    public int getEdad() {
        return edad;
    }

    public String getSexo() {
        return sexo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
