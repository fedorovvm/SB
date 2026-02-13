package org.skypro.skyshop.model.search.result;

import org.skypro.skyshop.model.search.Searchable;

public final class SearchResult {

    private final String id;
    private final String name;
    private final String contentType;

    private SearchResult(String id, String name, String contentType) {
        this.id = id;
        this.name = name;
        this.contentType = contentType;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getContentType() {
        return contentType;
    }
    @Override
    public String toString() {
        return "SearchResult{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", contentType='" + contentType + '\'' +
                '}';
    }
    public static SearchResult fromSearchable(Searchable searchable) {
        return new SearchResult(
                searchable.getId().toString(),
                searchable.getTitle(),
                searchable.gettingContentType()
        );
    }
}
