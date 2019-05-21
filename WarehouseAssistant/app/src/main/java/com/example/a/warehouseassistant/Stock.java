package com.example.a.warehouseassistant;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity
public class Stock {

    @PrimaryKey
    @ColumnInfo(name= "Kod kreskowy produktu")
    private long barcodeProduct;

    @ColumnInfo(name = "Kod kreskowy półki")
    private long barcodeShelf;

    @ColumnInfo(name= "Nazwa produktu")
    private String name;

    @ColumnInfo(name= "Ilosc produktu")
    private int quantity;

    public long getBarcodeProduct() {
        return barcodeProduct;
    }

    public void setBarcodeProduct(long barcodeProduct) {
        this.barcodeProduct = barcodeProduct;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public long getBarcodeShelf() {
        return barcodeShelf;
    }

    public void setBarcodeShelf(long barcodeShelf) {
        this.barcodeShelf = barcodeShelf;
    }

    public Stock() {
    }
}
