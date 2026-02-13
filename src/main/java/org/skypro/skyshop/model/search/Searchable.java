package org.skypro.skyshop.model.search;

import java.util.UUID;

public interface Searchable {

    String gettingSearchTerm();
    String gettingContentType();
    default String getStringRepresentation() {
        return this.gettingSearchTerm() + " - " + this.gettingContentType();
    }

    String getTitle();
    UUID getId();
}
