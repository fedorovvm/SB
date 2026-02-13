package org.skypro.skyshop.model.article;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.skypro.skyshop.model.search.Searchable;

import java.util.Objects;
import java.util.UUID;

public final class Article implements Searchable {
    String titleArticle;
    String textArticle;
    private final UUID id;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Article article = (Article) o;
        return Objects.equals(titleArticle, article.titleArticle) && Objects.equals(textArticle, article.textArticle);
    }

    @Override
    public int hashCode() {
        return Objects.hash(titleArticle, textArticle);
    }

    public Article(String titleArticle, String textArticle, UUID id) {
        this.titleArticle = titleArticle;
        this.textArticle = textArticle;
        this.id = id;
    }

    public String getTitleArticle() {
        return titleArticle;
    }

    public String getTextArticle() {
        return textArticle;
    }
    @Override
    public String toString() {
        return getTitleArticle() + "\n" + getTextArticle();
    }
    @JsonIgnore
    public String gettingContentType() {
        return "ARTICLE";
    }

    @Override
    public String getTitle() {
        return titleArticle;
    }

    @Override
    public UUID getId() {
        return id;
    }
    @JsonIgnore
    public String gettingSearchTerm() {
        return this.titleArticle + " " + this.textArticle;
    }

}
