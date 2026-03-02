package service;
import domain.User;
import repository.UserRepository;

import java.util.List;

public class UserService {

    private UserRepository repository;
    public UserService(UserRepository repository){
        this.repository = repository;
    }

    public User createUser(Long id_user, String nome, String data_nascimento){
        verifyData(id_user, nome, data_nascimento);
        if (!verifyData(id_user, nome, data_nascimento)) {
            throw new IllegalArgumentException("Erro ao criar usuario: id, nome e data de nascimento são obrigatórios. O nome deve conter pelo menos 3 caracteres.");
        }

        User user = new User(id_user, nome, data_nascimento);
        repository.save(user);
        return user;
    }

    public List<User> listUser(){
        return repository.list();
    }

    public void updateUser(User user){
        repository.update(user);
    }

    public void deletarUsuario(Long id_user) {
        repository.delete(id_user);
    }

    public User searchUser(Long id) {
        return repository.search(id);
    }

    public boolean verifyData(Long id, String nome, String birthday) {
        if (id == null || nome == null || nome.length() < 3 || birthday == null) {
            return false;
        }
        return true;
    }
}
