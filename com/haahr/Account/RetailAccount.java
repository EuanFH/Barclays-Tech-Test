package com.haahr.Account;

import com.haahr.Product.Product;
import com.haahr.Product.ProductNotAllowedException;

import java.util.ArrayList;

public class RetailAccount extends Account {
    public RetailAccount(ArrayList<Product> products) throws NotEnoughFundsException, ProductNotAllowedException {
        super(products);
    }
}
