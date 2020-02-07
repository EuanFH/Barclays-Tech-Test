package com.haahr.Account;

import com.haahr.Product.Product;
import com.haahr.Product.ProductNotAllowedException;

import java.math.BigDecimal;
import java.util.ArrayList;

public class WholesaleAccount extends Account {
    public WholesaleAccount(ArrayList<Product> products) throws NotEnoughFundsException, ProductNotAllowedException {
        super(products);
        if(getBalance().compareTo(BigDecimal.valueOf(35000)) < 0) {
            throw new NotEnoughFundsException();
        }
    }
}
