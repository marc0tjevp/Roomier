package com.yanco.roomier.datalayer.dao;

import android.content.ContentValues;
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

        Cursor cursor = connection.getReadableDatabase().query("product", new String[]{"productID", "productName", "amount", "minAmount", "createTask"}, null, null, null, null, null);
        List<Product> products = new ArrayList<>();

            while (cursor.moveToNext()) {

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
        return products;
    }

    @Override
    public Product getProduct(UUID productId) {
        Cursor cursor = connection.getReadableDatabase().query("product", new String[]{"productID", "productName", "amount", "minAmount", "createTask"}, "productID=?", new String[]{productId.toString()}, null, null, null);
        Product product = new Product();

        while(cursor.moveToNext()) {

            // Get Values from DB
            UUID productID = UUID.fromString(cursor.getString(cursor.getColumnIndex("productID")));
            String productName = cursor.getString(cursor.getColumnIndex("productName"));
            int amount = cursor.getInt(cursor.getColumnIndex("amount"));
            int minAmount = cursor.getInt(cursor.getColumnIndex("minAmount"));
            Boolean createTask = cursor.getInt(cursor.getColumnIndex("createTask")) > 0;

            // Make product object
            product = new Product(productID, productName, amount, minAmount, createTask);
        }
        return product;
    }

    @Override
    public void insert(Product product) {
        ContentValues insertValues = new ContentValues();

        insertValues.put("productID", product.getProductID().toString());
        insertValues.put("productName", product.getProductName());
        connection.getWritableDatabase().insert("product", null, insertValues);
    }

    @Override
    public void delete(UUID productId) {
        connection.getWritableDatabase().delete("product", "productID=?", new String[]{productId.toString()});
    }

    @Override
    public void setAmount(int amount, UUID productId) {
        ContentValues updateValues = new ContentValues();
        updateValues.put("amount", amount);
        connection.getWritableDatabase().update("product", updateValues, "productID=?", new String[]{productId.toString()});
    }
}
