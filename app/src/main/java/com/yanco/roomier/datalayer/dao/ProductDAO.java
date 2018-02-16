package com.yanco.roomier.datalayer.dao;

import com.yanco.roomier.model.Product;

import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * Created by ywillems on 7-2-2018.
 */

public interface ProductDAO {
    List<Product> getAllProducts();
    Product getProduct(UUID productId);
    void insert(Product product);
    void delete(UUID productId);
    void setAmount(int amount, UUID productId);
}
