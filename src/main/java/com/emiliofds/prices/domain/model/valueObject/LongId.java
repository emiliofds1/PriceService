package com.emiliofds.prices.domain.model.valueObject;

public abstract class LongId {

    protected final Long value;

    public LongId(Long value) {
        this.value = value;
    }

    public Long getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LongId longId = (LongId) o;
        return value.equals(longId.value);
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }
}
