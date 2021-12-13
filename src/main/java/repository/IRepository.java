package repository;

import java.util.List;
import java.util.Optional;

public interface IRepository<E> { //E é uma letra que eu escolho para representar um objeto quando eu 
    //implementar a interface em um objeto
    //interface só tem métodos abstratos, métodos que serão implementados no UserRepository, service e controller
    public boolean insert(E entity);
    public boolean update(E entity); //propria entidade ja tem o id, dai não precisamos colocar o id agora
    public Optional<E> findById(int id); //vai retornar a entidade em si
    public List<E> findAll();
    public boolean delete(int id);
    //aqui estamos representamos nossos métodos para representar as operações básicas do BD
}
