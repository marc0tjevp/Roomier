package com.yanco.roomier.datalayer.dao;

import com.yanco.roomier.model.Product;

import java.util.Map;
import java.util.UUID;

/**
 * Created by ywillems on 15-2-2018.
 */

public class SqlLiteProductDAO implements ProductDAO {
    @Override
    public Map getAllProducts() {
        return null;
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
