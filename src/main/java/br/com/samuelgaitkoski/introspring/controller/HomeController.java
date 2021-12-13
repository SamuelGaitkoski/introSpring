package br.com.samuelgaitkoski.introspring.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

//anotar que a classe é um controlador, se não ela não será um controllador

@RestController
@RequestMapping("/") //qualquer requisição feita para rota /, é esse controlador que vai responder por essa rota
public class HomeController {

    //metodo home vai responder pelas requisições via Get
    //3 anotações chave do spring: restController, requestMapping, getmapping, postmapping, putmapping, deletemapping
    //Requisição rest tradicional usando JSON traz o máximo de informações possíveis, com todas informações da tabela
    @GetMapping
    public String home() { 
        return "Bem vindo ao meu site";
    }

    //cada uma das anotações Mapping tem um significado, são anotações para fazer as requisições HTTP
}
