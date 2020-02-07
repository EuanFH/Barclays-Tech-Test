package com.haahr.Account;

import com.haahr.Product.Product;
import com.haahr.Product.ProductName;
import com.haahr.Product.ProductNotAllowedException;

import java.math.BigDecimal;
import java.util.List;

public abstract class Account {
    protected List<Product> products;

    public Account(){}
    public Account(List<Product> products) throws ProductNotAllowedException {
        setProducts(products);
    }

    public List<Product> getProducts() {
        return products;
    }

    public void addProduct(Product product) throws ProductNotAllowedException{
        if(isTier1Capital(product.getName())){
            throw new ProductNotAllowedException();
        }
        this.products.add(product);
    }

    public void setProducts(List<Product> products) throws ProductNotAllowedException{
        for(Product product: products) {
            if(isTier1Capital(product.getName())) {
                throw new ProductNotAllowedException();
            }
        }
        this.products = products;
    }

    private boolean isTier1Capital(ProductName productName){
        if(productName == ProductName.TIER_1_CAPITAL) {
            return true;
        }
        return false;
    }

    public BigDecimal getBalance(){
        BigDecimal total = BigDecimal.valueOf(0);
        for(Product product: products) {
            total = total.add(product.getValue());
        }
        return total;
    }
}
