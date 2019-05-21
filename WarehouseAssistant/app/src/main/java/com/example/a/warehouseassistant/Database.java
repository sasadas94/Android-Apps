package com.example.a.warehouseassistant;

import android.arch.persistence.room.RoomDatabase;

@android.arch.persistence.room.Database(entities = {Stock.class},version=1)
public abstract class Database extends RoomDatabase {
    public abstract DAO dao();
}
