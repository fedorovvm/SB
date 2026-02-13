package org.skypro.skyshop.model.product;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.skypro.skyshop.model.search.Searchable;

import java.util.Objects;
import java.util.UUID;

public abstract class Product implements Searchable {
    final String title;
    private UUID id;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Product product = (Product) o;
        return Objects.equals(title, product.title);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(title);
    }

    @Override
    public UUID getId() {
        return id;
    }

    public Product(String title) throws IllegalArgumentException {
        this.title = title;
        if (title.isBlank()) {
            throw new IllegalArgumentException("Недопустимое наименование товара");
        }

    }

    public String getTitle() {
        return title;
    }

    public abstract int getPrice();

    public abstract boolean isSpecial();
    @JsonIgnore
    @Override
    public abstract String gettingContentType();
    @JsonIgnore
    public String gettingSearchTerm() {
        return getTitle();
    }
    @Override
    public String getStringRepresentation() {
        return gettingSearchTerm() + " - " + gettingContentType();
    }
    public void checkTitle(String title) throws IllegalArgumentException {
        if (title.isBlank()) {
            throw new IllegalArgumentException("Недопустимое наименование товара");
        }

    }

}