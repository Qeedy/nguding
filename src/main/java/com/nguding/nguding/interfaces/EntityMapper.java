package com.nguding.nguding.interfaces;

public interface EntityMapper<E, M> {
    public M toModel(E entity);
    public E toEntity(M model);

}
