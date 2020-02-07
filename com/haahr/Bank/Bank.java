package com.haahr.Bank;

import com.haahr.Account.Account;
import com.haahr.Product.Product;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Bank {
    List<Account> accounts;

    public Bank(){
        accounts = new ArrayList<Account>();
    }

    public Bank(List<Account> accounts) {
        this.accounts = accounts;
    }

    public void addAccount(Account account){
        accounts.add(account);
    }

    public boolean removeAccount(Account account){
        return accounts.remove(account);
    }

    public BigDecimal getNetWorth(){
        BigDecimal assetsSum = new BigDecimal(0);
        BigDecimal liabilitiesSum = new BigDecimal(0);
        //this could be improved by using multiple threads
        //it isn't efficient
        for(Account account: accounts) {
            for (Product product : account.getProducts()) {
                switch (product.getType()) {
                    case ASSET: {
                        assetsSum = assetsSum.add(product.getValue());
                        continue;
                    }
                    case LIABILITY: {
                        liabilitiesSum = liabilitiesSum.add(product.getValue());
                        continue;
                    }
                    default: {
                        continue;
                    }
                }
            }
        }
        return assetsSum.subtract(liabilitiesSum);
    }

    public BigDecimal getNetWorthSRWA(){
        BigDecimal SRWA = new BigDecimal(0);
        for (Account account : accounts) {
            for (Product product : account.getProducts()) {
                SRWA = SRWA.add(product.getSRWA());
            }
        }
        return SRWA;

    }
}
