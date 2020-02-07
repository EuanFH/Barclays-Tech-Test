package com.haahr.Product;

import java.math.BigDecimal;

public class Product {
    private ProductName name;
    private BigDecimal value;
    private int riskRating;
    private ProductType type;

    public Product(ProductName name, BigDecimal value) throws ProductNotAllowedException{
        switch(name) {
            case CASH: {
                GenerateProduct(name, 2, ProductType.ASSET);
                break;
            }
            case BOND: {
                GenerateProduct(name, 1, ProductType.ASSET);
                break;
            }
            case COLLATERALISED_LOAN: {
                GenerateProduct(name, 3, ProductType.LIABILITY);
                break;
            }
            case TIER_1_CAPITAL: {
                GenerateProduct(name, 0, ProductType.ASSET);
                break;
            }
            default: {
                throw new ProductNotAllowedException();
            }
        }
        this.value = value;
    }

    private void GenerateProduct(ProductName name, int riskRating, ProductType type){
        this.name = name;
        this.riskRating = riskRating;
        this.type = type;
    }

    public ProductName getName() {
        return name;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }

    public int getRiskRating() {
        return riskRating;
    }

    public ProductType getType() {
        return type;
    }

    public BigDecimal getSRWA(){
        BigDecimal rating = BigDecimal.valueOf(riskRating);
        BigDecimal constant = BigDecimal.valueOf(0.05);
        return value.subtract(
                rating.multiply(
                        constant.multiply(value)
                )
        );
    }
}
