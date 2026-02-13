package org.skypro.skyshop.model.product;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.UUID;

public class DiscountedProduct extends Product {

    private final double basicPrice;
    private final int percentDiscount;
    private final UUID id;

    public double getBasicPrice() {
        return basicPrice;
    }
    public int getPercentDiscount() {
        return percentDiscount;
    }

    @Override
    public UUID getId() {
        return id;
    }

    public DiscountedProduct(String title, double basicPrice, int percentDiscount, UUID id) throws IllegalArgumentException {
        super(title);
        this.basicPrice = basicPrice;
        this.percentDiscount = percentDiscount;
        this.id = id;

        if (basicPrice < 0) {
            throw new IllegalArgumentException("Неверно указана базовая цена товара");
        }
        if (percentDiscount < 0 || percentDiscount > 100) {
            throw new IllegalArgumentException("Неверно указан процент скидки товара");
        }

    }
    @Override
    public int getPrice() {
        return (int)(basicPrice-basicPrice*percentDiscount/100);
    }

    @Override
    public String toString() {
        return title + " со скидкой: " + getPrice() + " ( " + percentDiscount + "% )";
    }

    public boolean isSpecial () {
        return true;
    }

    @JsonIgnore
    public String gettingSearchTerm() {
        return super.getTitle();
    }
    @Override
    @JsonIgnore
    public String gettingContentType() {
        return "DISCOUNTPRODUCT";
    }


    public String getStringRepresentation() {
        return super.getStringRepresentation();
    }

    public void checkBasicPrice(double basicPrice) throws IllegalArgumentException {
        if (basicPrice < 0) {
            throw new IllegalArgumentException("Неверно указана базовая цена товара");
        }
    }

    public void checkPercentDiscount(int percentDiscount) throws IllegalArgumentException {
        if (percentDiscount < 0 || percentDiscount > 100) {
            throw new IllegalArgumentException("Неверно указан процент скидки товара");
        }
    }

}
