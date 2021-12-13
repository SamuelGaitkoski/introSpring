package br.com.samuelgaitkoski.introspring.model;


//a classe UsuarioDTO é a nossa classe de resposta para as requisições
//pois na classe usuario serão os dados completos, nome, login, senha
//quando for uma listagem para a API publica, eu quero retornar só o nome dela, não o login ou senha
//então o usuarioDTO é o que eu vou expor publicamente, e o usuario é o que eu recebo no cadastro
//então eles serão muito parecidos, mas o usuarioDTO terá somente as informações que eu vou tornar pública
//no usuarioDTO eu não tenho a password, a senha do usuario, pois não vou expor ela


//tem uma API DO gitgub que lista todos os usuários do github, dai quando usamos essa API publica,
//temos acesso ao nickname dos usuarios, idade, bio, informações que não são sigilosas, nunca a senha,
//isso ele não expoe



//La no body do insert do Thunder Client, quando passamos os dados para a criação de um User
/*{
    "id": 1,
    "fullName": "Samuel Gaitkoski",
    "nickName": "samu0101",
    "password": "1234",
    "age": 20
}
agora eu estou enviando um JSON, pois por baixo dos panos ele transforma isso em um objeto do tipo Usuario, 
chamando o setter de cada propriedade para botar os valores passados para cada campo para as propriedades 
daquele objeto do tipo Usuario. Então agora, essa notação de objeto JavaScript vai ser convertida para a 
notação de objeto Usuario

Então eu pego meu objeto JSON no body da requisição POST do thunder Client, e o spring internamente converte
ele para um objeto User, então agora, no nosso findAll temos um array de objetos JSON onde o spring fez 
o contrário, ele pegou os objetos Java User nesse caso, e converteu para objetos JSON, por isso vemos os 
dados no formato JSON, onde os [] (colchetes) significam array e as {}(chaves) significam objeto
um array de objetos que tem uma posição, ou muitas
Agora, em vez de passarmos para o array uma simples string, estamos passando um objeto JavaScript (um JSON)
*/


public class User {
    private int id;
    private String fullName;
    private String nickName;
    private String password; 
    //como não vamos fazer o DTO aqui, deixamos o password como nulo quando formos retornar os dados do usuario,
    //não retornamos o password do usuario
    private byte age;

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullName() {
        return this.fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getNickName() {
        return this.nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public byte getAge() {
        return this.age;
    }

    public void setAge(byte age) {
        this.age = age;
    }
}
