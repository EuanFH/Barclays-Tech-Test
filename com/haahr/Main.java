package com.haahr;

import com.haahr.Account.InternalAccount;
import com.haahr.Account.NotEnoughFundsException;
import com.haahr.Account.WholesaleAccount;
import com.haahr.Bank.Bank;
import com.haahr.Product.Product;
import com.haahr.Product.ProductName;
import com.haahr.Product.ProductNotAllowedException;

import java.math.BigDecimal;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
	    Bank bank = new Bank();
	    try {
            ArrayList<Product> products = new ArrayList<>();
            products.add(new Product(ProductName.TIER_1_CAPITAL, new BigDecimal("10000000000")));
            bank.addAccount(
                    new InternalAccount(
                            products
                    )
            );

        } catch(Exception e){
	        System.out.println("There is a bug in my code if this exception occurs");
        }
	    try {
            for (int i = 0; i <= 10; i++) {
                ArrayList<Product> products = new ArrayList<>();
                products.add(new Product(ProductName.COLLATERALISED_LOAN, new BigDecimal((int) (Math.random() * 200000 + 100000))));
                bank.addAccount(
                        new InternalAccount(
                                products
                        )
                );
            }
        } catch(Exception e){
            System.out.println("There is a bug in my code if this exception occurs");
        }

	    for(int i = 0; i <= 10; i++){
	        try{
	            ArrayList<Product> products = new ArrayList<>();
	            products.add(new Product(ProductName.CASH, new BigDecimal((int)(Math.random() * 100000 + 10000))));
                products.add(new Product(ProductName.BOND, new BigDecimal((int)(Math.random() * 100000 + 10000))));
                products.add(new Product(ProductName.BOND, new BigDecimal((int)(Math.random() * 100000 + 10000))));
                bank.addAccount(
                        new WholesaleAccount(
                                products
                        )
                );

            } catch(NotEnoughFundsException e){
                System.out.println("There wasn't enough funds to create this wholesale account");

            } catch(ProductNotAllowedException e){
                System.out.println("You are not allowed to have this product");
            }
        }

	    System.out.printf("Banks Net Worth: \n£%s\n", bank.getNetWorth());
        System.out.printf("Banks Net Worth SRWA: \n£%s\n", bank.getNetWorthSRWA());
    }
}
