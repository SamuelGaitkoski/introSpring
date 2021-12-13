package repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import br.com.samuelgaitkoski.introspring.model.User;

//essa anotação serve para identificar como repositorio esse repositorio para o spring
@Repository 
public class UserRepository implements IRepository<User>{
    
    private List<User> database = new ArrayList<>();

    @Override
    public boolean insert(User entity) {
        return database.add(entity); //pegar o dado e adicionar ele na nossa base de dados
    }

    @Override
    public boolean update(User entity) {    
        if(entity.getId() < 0) { //id menor que 0, não posso atualizar
            return false;
        }

        //se sim, vou buscar o id do elemento e atualizar com a entidade que eu recebi
        database.set(entity.getId(), entity); //método set recebe o índice do elemento e o elemento
        //no índice do elemento ele vai substituir o valor passado de entity para elemento no índice dele
        return true;
    }

    @Override
    public Optional<User> findById(int id) {

        //FAZER BUSCAR PELO ID DO OBJETO, NÃO PELO ÍNDICE DO VETOR, PELO ÍNDICE DO ARRAY
        //VER PROJETO DO HOSPITAL, NA PARTE DO MÉDICO, POIS LA FIZEMOS ISSO
        return this.database.stream().filter((obj) -> obj.getId() == id).findFirst();

        //return database.get(id); retorna o elemento cujo id é igual ao informado
        //quando eu chamar o método do repositorio, esse valor ja tem que estar validado
        //ele já deve ser validado antes de chegar no repository
    }

    @Override
    public List<User> findAll() {
        return database; //retorna todo mundo, a coleção inteira
    }

    @Override
    public boolean delete(int id) { 
        
        //FAZER DELETAR PELO ID DO OBJETO, NÃO PELO ÍNDICE DO VETOR, PELO ÍNDICE DO ARRAY
        //VER PROJETO DO HOSPITAL, NA PARTE DO MÉDICO, POIS LA FIZEMOS ISSO
        var resultado = this.findById(id); //acha o objeto com id igual ao passado e armazena em resultado

        if(resultado.isPresent()) { //se ele achar algo na variavel resultado

            //coloca o que ele achou em result, removendo o objeto pelo índice da lista do objeto que ele achou,
            //pois uma lista só apaga com base no índice, então precisamos disso, então ele pega o índice
            //do objeto que o resultado encontrou, e exclui com base no índice dele
            var result = database.remove(database.indexOf(resultado.get())); 
            return result != null; //return true ou false
        }

        return false;

        //var result = database.remove(id); salva na variavel result o elemento removido pelo id dele
        //return result != null; //diferente retorna um booleano, então é só retornar isso, 
        //que vai retornar true ou false no fim, se o resultado for diferente de nulo ou nulo
    }

   
}
