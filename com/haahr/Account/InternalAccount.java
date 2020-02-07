package com.haahr.Account;

import com.haahr.Product.Product;

import java.util.ArrayList;
import java.util.List;

public class InternalAccount extends Account {
    public InternalAccount(ArrayList<Product> products){
        this.products = products;
    }

    @Override
    public void addProduct(Product product) {
        this.products.add(product);
    }

    @Override
    public void setProducts(List<Product> products){
        this.products = products;
    }
}
