package br.com.samuelgaitkoski.introspring.service;

import java.util.List;
import java.util.Optional;

public interface IService<E> {

    //mesmos métodos que temos no IRepository
    public boolean insert(E entity);
    public boolean update(E entity);
    public Optional<E> findById(int id);
    public List<E> findAll();
    public boolean delete(int id);
}
