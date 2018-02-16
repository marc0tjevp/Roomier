package com.yanco.roomier.datalayer.dao;

import com.yanco.roomier.model.Product;

import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * Created by ywillems on 7-2-2018.
 */

public class MySqlProductDAO implements ProductDAO {
    @Override
    public List getAllProducts() {
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
