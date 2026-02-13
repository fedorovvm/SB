package org.skypro.skyshop.model.product;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.UUID;

public class SimpleProduct extends Product {

    private final int price;
    private final UUID id;

    @Override
    public UUID getId() {
        return id;
    }

    public SimpleProduct(String title, int price, UUID id) throws IllegalArgumentException {
        super(title);
        this.price = price;
        this.id = id;


        if (price < 0) {
            throw new IllegalArgumentException("Неверно указана цена товара");
        }
    }

    @Override
    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return title + ": " + price;
    }
    public boolean isSpecial () {
        return false;
    }
    @Override
    @JsonIgnore
    public String gettingContentType() {
        return "SIMPLEPRODUCT";
    }
    @JsonIgnore
    public String gettingSearchTerm() {
        return super.gettingSearchTerm();
    }

    public String getStringRepresentation() {
        return super.getStringRepresentation();
    }

    public void checkPrice(int price) throws IllegalArgumentException {
        if (price < 0) {
            throw new IllegalArgumentException("Неверно указана цена товара");
        }
    }
}
