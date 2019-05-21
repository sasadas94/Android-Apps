package com.example.a.warehouseassistant;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

@Dao
public interface DAO {
    @Insert
    public void addProduct(Stock stock);

    @Query("SELECT * FROM Stock")
    public List<Stock> getStock();

    @Delete
    public void deleteProduct(Stock stock);
}
