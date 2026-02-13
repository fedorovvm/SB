package org.skypro.skyshop.service;

import org.skypro.skyshop.model.search.result.SearchResult;
import org.skypro.skyshop.model.search.Searchable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SearchService {
    private final StorageService storageService;

    SearchService(StorageService storageService) {
        this.storageService = storageService;
    }

    public List<SearchResult> search(String pattern) {
        return storageService.getAllSearchableItems().stream()
                .filter(item -> item.gettingSearchTerm().toLowerCase().contains(pattern.toLowerCase()))
                .map(SearchResult::fromSearchable)
                .collect(Collectors.toList());
    }
}
