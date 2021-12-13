package br.com.samuelgaitkoski.introspring.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.samuelgaitkoski.introspring.model.User;
import br.com.samuelgaitkoski.introspring.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/usuarios") //rota do localhost:porta/usuarios
public class UserController {
    
    @Autowired //pedimos para o spring gerenciar o estado do objeto, a criação dele, etc
    private UserService userService;

    @GetMapping
    public List<User> findAll() {
        return userService.findAll();
    }

    //request body diz que o Usuario vai ser alimentada pela requisição, 
    //dai passamos o nome pelo POST no body
    @PostMapping
    public boolean insert(@RequestBody User entity) { 
        return userService.insert(entity);
    }

    //passamos um parâmetro para o GetMapping, um código, para fazer a busca de um registro 
    //requisição via get, e caso eu tenha um get com um parâmetro, 
    //eu uso esse parâmetro para alimentar a minha variável id, por isso anotamos @PathVariable
    //quando eu coloco o @PathVariable, 
    //ele associa o id passadi na url da requisição get com o parâmetro da função findById
    @GetMapping("/{id}")
    public User findById(@PathVariable int id) {
        //tratar um erro que possa acontecer, como um erro de estorar o vetor,
        //caso a pessoa passe um id que não existe na lista
        try {

            var result = userService.findById(id);

            if(result.isPresent()) {
                return result.get();
            }

            return null;
            
        } catch (Exception e) { //se houver algum erro
            //um erro deveria ser salvo em um log, um txt, uma tabela do BD, em algum lugar
            //não devemos mostrar mensagens técnicas para o usuário
            //Simulando um Log
            //podemos mostrar varias coisas do erro e., a classe do erro, mensagem (Usuario), etc
            //se houver algum erro no sistema, eu como programador vou retornar isso no console, no meu log 
            System.out.println(e.getMessage()); 

            return null; //e o meu usuario recebe isso quando houver um erro
            //pro usuario não significa nada que o erro é que o índice 3 inserido está fora do número de índices 
            //possíveis que o meu vetor tem, e que esse número está fora desse índice de posições que o vetor, 
            //a liste tem 

            //quando a aplicação que ta chamando a minha API espera um JSON, 
            //quando ela não recebe um JSON ela gera um erro, então em uma aplicação real ela tem que retornar um JSON
            //com uma chave error, com um erro em JSON, um JSON contendo a informação chave error e uma msg de erro
        }
    }

    //se eu receber uma requisição via PUT, eu tenho que chamar o método editar, update
    @PutMapping//quem vou atualizar vou fazer pela url
    public boolean update(@RequestBody User entity) { 
        //recebendo a informação que veio do corpo (RequestBody), que vai ser uma Usuario
        //dai ele vai alimentar a variavel Usuario chamada entity com a informação enviada no corpo da requisição
        return userService.update(entity); //passamos o id na chamada do método update também dai
        //se quisermos tratar um erro temos que fazer o mesmo que fizemos acima no método findById, 
        //com o try catch
        //mas temos que ter um sistema automatico de reporte de erros, um log, que sempre que tiver um erro vai
        //salvar ele, fazer uma função que faz um insert na tabela log por exemplo, passando o erro, classe do erro, 
        //hora, etc, para que os programadores possam trabalhar na correção do bug

        //AI PASSAMOS JUNTO COM O ID DO ELEMENTO QUE QUEREMOS ATUALIZAR, PARA O QUE QUEREMOS ATUALIZAR O 
        //ELEMENTO QUE QUEREMOS ATUALIZAR, A Usuario QUE QUEREMOS PASSAR PARA O NOME DA PESSOA AGORA

        //Agora, não passamos o id, e o objeto que será atualizado é o que tiver o id igual ao id passado
        //no objeto JSON, da minha entidade, da entity do tipo User, por isso não botamos nada na url 
        //do update
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable int id) {

        //tratando uma exceção caso ocorra alguma
        try {
            return userService.delete(id);
        } catch (Exception e) { 
            System.out.println(e.getMessage()); 
            return false;
        }
    }

}
