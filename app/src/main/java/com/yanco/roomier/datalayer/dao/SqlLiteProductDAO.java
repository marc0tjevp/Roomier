package com.yanco.roomier.datalayer.dao;

import android.database.Cursor;

import com.yanco.roomier.datalayer.SQLiteConnection;
import com.yanco.roomier.model.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * Created by ywillems on 15-2-2018.
 */

public class SqlLiteProductDAO implements ProductDAO {

    private SQLiteConnection connection;

    public SqlLiteProductDAO(SQLiteConnection connection){
        this.connection = connection;
    }

    @Override
    public List getAllProducts() {

        Cursor cursor = connection.getWritableDatabase().rawQuery("SELECT * FROM product", null);
        List<Product> products = new ArrayList<>();

        if (cursor.moveToFirst()) {
            while (!cursor.isAfterLast()) {

                // Get Values from DB
                UUID productID = UUID.fromString(cursor.getString(cursor.getColumnIndex("productID")));
                String productName = cursor.getString(cursor.getColumnIndex("productName"));
                int amount = cursor.getInt(cursor.getColumnIndex("amount"));
                int minAmount = cursor.getInt(cursor.getColumnIndex("minAmount"));
                Boolean createTask = cursor.getInt(cursor.getColumnIndex("createTask")) > 0;

                // Make product object
                Product p = new Product(productID, productName, amount, minAmount, createTask);

                // Add Object to ArrayList
                products.add(p);

            }
        }
        return products;
    }

    @Override
    public Product getProduct(UUID productId) {
        return null;
    }

    @Override
    public void insert(Product product) {

    }

    @Override
    public void delete(UUID productId) {

    }

    @Override
    public void setAmount(int amount, UUID productId) {

    }
}
