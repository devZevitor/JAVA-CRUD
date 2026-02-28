package service;
import domain.User;
import repository.UserRepository;

import java.util.ArrayList;

public class UserService {

    private UserRepository repository;
    public UserService(UserRepository repository){
        this.repository = repository;
    }

    public void criar_usuario(Long id_user, String nome, String data_nascimento){
        if(repository.buscar_usuario(id_user) != null){
            throw new Error("ID já usado");
        }

        User user = new User(id_user, nome, data_nascimento);
        repository.salvar_usuario(user);
    }

    public ArrayList<User> listar_usuario(){
        return repository.listar_usuarios();
    }

    public void atualizar_usuario(User user){
        repository.atualizar_usuario(user);
    }
    public void deletar_usuario(Long id_user) {
        repository.deletar_usuario(id_user);
    }
}
