package com.example.usuario.bdroom.DB;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

@Dao
public interface MyDao {

    @Insert
    void InsertAnimal(Animal animal);

    @Query("Select *from Animales")
    List<Animal> getAllAnimals();

    @Query("Select * from Animales where animal_nombre = (:nombre) and animal_sexo = (:sexo)")
    Animal getAnimal(String nombre,String sexo);

    @Delete
    void DeleteAnimal(Animal animal);

    @Query("Delete from Animales where animal_nombre=(:nombre) and animal_sexo=(:sexo)")
    void DeleteAnimal2(String nombre,String sexo);

    @Update
    void updateAnimal(Animal animal);
}
