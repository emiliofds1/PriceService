package com.emiliofds.prices.domain.model;

import com.emiliofds.prices.domain.exception.InvalidSearchCriteriaException;

import java.time.LocalDateTime;
import java.util.Objects;

public class SearchCriteria {

    private final Long productId;
    private final Long brandId;
    private final LocalDateTime date;

    private SearchCriteria(Long productId, Long brandId, LocalDateTime date) {
        validate(productId, brandId, date);
        this.productId = productId;
        this.brandId = brandId;
        this.date = date;
    }

    public static SearchCriteria of(Long productId, Long brandId, LocalDateTime date) {
        return new SearchCriteria(productId, brandId, date);
    }

    private void validate(Long productId, Long brandId, LocalDateTime date) {
        if (productId == null) throw new InvalidSearchCriteriaException("Product ID cannot be null");
        if (brandId == null) throw new InvalidSearchCriteriaException("Brand ID cannot be null");
        if (date == null) throw new InvalidSearchCriteriaException("Date cannot be null");
    }

    public Long getProductId() {
        return productId;
    }

    public Long getBrandId() {
        return brandId;
    }

    public LocalDateTime getDate() {
        return date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SearchCriteria that = (SearchCriteria) o;
        return productId.equals(that.productId) &&
                brandId.equals(that.brandId) &&
                date.equals(that.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productId, brandId, date);
    }
}
