package com.yanco.roomier.model;

import java.util.UUID;

/**
 * Created by Marco on 06/02/2018.
 */

public class Product {

    private UUID productID;
    private String productName;
    private int amount;
    private int minAmount;
    private boolean createTask;

    public Product(UUID productID, String productName) {
        this.productID = productID;
        this.productName = productName;
        this.amount = 0;
        this.minAmount = 0;
        this.createTask = false;
    }

    public Product(UUID productID, String productName, int amount, int minAmount, boolean createTask) {
        this.productID = productID;
        this.productName = productName;
        this.amount = amount;
        this.minAmount = minAmount;
        this.createTask = createTask;
    }

    public Product(){}

    public UUID getProductID() {
        return productID;
    }

    public void setProductID(UUID productID) {
        this.productID = productID;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getMinAmount() {
        return minAmount;
    }

    public void setMinAmount(int minAmount) {
        this.minAmount = minAmount;
    }

    public boolean isCreateTask() {
        return createTask;
    }

    public void setCreateTask(boolean createTask) {
        this.createTask = createTask;
    }

    public void incrementAmount(){
        this.amount++;
    }

    public void decrementAmount(){
        this.amount--;
    }

    public void isBelowMin(){
        if(this.amount <= this.minAmount){
            this.setCreateTask(true);
        }
    }
}
