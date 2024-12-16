package com.programacionRestFront.repository;

import java.util.List;

public interface IDAO <T>{

    public T create(T t);
    public T getByID(Long id);
    public List<T> getAll();
    public void delete(Long id);
    public T update(T t);

}
