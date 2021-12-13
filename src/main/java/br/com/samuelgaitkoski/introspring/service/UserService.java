package br.com.samuelgaitkoski.introspring.service;

import java.util.List;
import java.util.Optional;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.samuelgaitkoski.introspring.model.User;
import repository.UserRepository;

@Service
public class UserService implements IService<User>{

    //com o autowired dizemos para o spring que a instância desse objeto vai ser gerenciado pelo Usuario
    //não precismamos dar um new objeto dai
    //@Autowired 
    private UserRepository userRepository = new UserRepository();

    //usamos uma interface para criar um contrato de criação de métodos em uma classe
    //service valida, o controller só recebe e passa os dados para o service
    @Override
    public boolean insert(User entity) {
        if(entity != null) {
            return userRepository.insert(entity);
        }
        return false; 
        //TEMA, SE TENTAR ADICIONAR ALGUEM QUE JA ESTÁ ADICIONADO NA TABELA, NÃO DEIXA E RETORNA FALSE!!!!!!
    }

    @Override
    public boolean update(User entity) {
        if(entity != null) { //se a entidade é diferente de nulo
            return userRepository.update(entity); //atualiza, ou pelo menos tenta atualizar
        }
        return false;
    }

    @Override
    public Optional<User> findById(int id) {
        if(id >= 0) {
            return userRepository.findById(id);
        }
        return null;       
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public boolean delete(int id) {
        if(id >= 0) {
            return userRepository.delete(id);
        }
        return false;    
    }
    
}
