package org.skypro.skyshop.model.product;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.UUID;

public class FixPriceProduct extends Product {

    private static final int fixPrice = 300;
    private final UUID id;

    @Override
    public UUID getId() {
        return id;
    }

    public FixPriceProduct(String title, UUID id) {
        super(title);
        this.id = id;
    }

    @Override
    public int getPrice() {
        return fixPrice;
    }
    @Override
    public String toString() {
        return title + " c фиксированной ценой: " + "Фиксированная цена " + fixPrice;
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
        return "FIXPRICEPRODUCT";
    }

    public String getStringRepresentation() {
        return super.getStringRepresentation();
    }

}
