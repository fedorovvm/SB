package org.skypro.skyshop.service;

import org.skypro.skyshop.exception.NoSuchProductException;
import org.skypro.skyshop.model.basket.BasketItem;
import org.skypro.skyshop.model.basket.ProductBasket;
import org.skypro.skyshop.model.basket.UserBasket;
import org.skypro.skyshop.model.product.Product;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class BasketService {
    private final ProductBasket productBasket;
    private final StorageService storageService;

    public BasketService(ProductBasket productBasket, StorageService storageService) {
        this.productBasket = productBasket;
        this.storageService = storageService;
    }

    public void addProductToBasket(UUID id) {
        try {
            storageService.getProductById(id);
            productBasket.addProduct(id);
        } catch (NoSuchProductException e) {
            throw new NoSuchProductException("Product with ID " + id + " not found", e);
        }
    }

    public UserBasket getUserBasket() {
        Map<UUID, Integer> basketMap = productBasket.getProducts();
        List<BasketItem> basketItems = basketMap
                .entrySet()
                .stream()
                .map(entry -> {
                    UUID productId = entry.getKey();
                    int quantity = entry.getValue();
                    try {
                        Product product = storageService.getProductById(productId);
                        return new BasketItem(product, quantity);
                    } catch (NoSuchProductException e) {
                        throw new NoSuchProductException(
                                "Product with ID " + productId + " not found in storage", e);
                    }
                })
                .collect(Collectors.toList());
        return new UserBasket(basketItems);
    }

}