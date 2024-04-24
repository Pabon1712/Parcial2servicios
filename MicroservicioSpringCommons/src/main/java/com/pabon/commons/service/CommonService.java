package com.pabon.commons.service;



import java.util.Optional;

public interface CommonService<E> {

    public Iterable<E> findAll();
    public Optional<E> findById( Long id );
    public E save(E enity);
    public void deleteById(Long id);
}