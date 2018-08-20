package com.example.usuario.bdroom.DB;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.RoomDatabase;

@Database(entities = {Animal.class},version = 1)
public abstract class AnimalDataBase extends RoomDatabase {

    public abstract MyDao daoAnimal();
}
