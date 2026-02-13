package org.skypro.skyshop.service;

import org.skypro.skyshop.model.article.Article;
import org.skypro.skyshop.model.product.DiscountedProduct;
import org.skypro.skyshop.model.product.FixPriceProduct;
import org.skypro.skyshop.model.product.Product;
import org.skypro.skyshop.model.product.SimpleProduct;
import org.skypro.skyshop.model.search.Searchable;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class StorageService {
    private final Map<UUID, Product> productStorage;
    private final Map<UUID, Article> articleStorage;

    public StorageService() {
        this.productStorage = new HashMap<>();
        this.articleStorage = new HashMap<>();
        initializeTestData();
    }

    private void initializeTestData() {
        addTestProducts();
        addTestArticles();
    }

    private void addTestArticles() {
        Article article1 = new Article("Ноутбук", "Китайский Ноутбук", UUID.randomUUID());
        articleStorage.put(article1.getId(), article1);

        Article article2 = new Article("Часы 'Rolex'", "Швейцарские Часы", UUID.randomUUID());
        articleStorage.put(article2.getId(), article2);

        Article article3 = new Article("Часы 'Casio'", "Японские Часы", UUID.randomUUID());
        articleStorage.put(article3.getId(), article3);

        Article article4 = new Article("Книга 'Тихий Дон'", "Занимательная книга", UUID.randomUUID());
        articleStorage.put(article4.getId(), article4);

        Article article5 = new Article("Книга 'Война и мир'", "Всем книгам книга", UUID.randomUUID());
        articleStorage.put(article5.getId(), article5);
    }

    private void addTestProducts() {
        Product product1 = new SimpleProduct("Ноутбук", 50000, UUID.randomUUID());
        productStorage.put(product1.getId(), product1);

        Product product2 = new DiscountedProduct("Рубашка", 1000, 100, UUID.randomUUID());
        productStorage.put(product2.getId(), product2);

        Product product3 = new FixPriceProduct("Чехол для смартфона",UUID.randomUUID());
        productStorage.put(product3.getId(), product3);

        Product product4 = new SimpleProduct("Часы", 5000, UUID.randomUUID());
        productStorage.put(product4.getId(), product4);

        Product product5 = new DiscountedProduct("Книга", 900, 10, UUID.randomUUID());
        productStorage.put(product5.getId(), product5);

        Product product6 = new FixPriceProduct("Чехол для смартфона", UUID.randomUUID());
        productStorage.put(product6.getId(), product6);
    }

    public Collection<Article> getAllArticles() {
        return articleStorage.values();
    }

    public Collection<Product> getAllProducts() {
        return productStorage.values();
    }
    public List<Searchable> getAllSearchableItems() {
        List<Searchable> searchableItems = new ArrayList<>();
        searchableItems.addAll(articleStorage.values());
        searchableItems.addAll(productStorage.values());
        return searchableItems;
    }
}
