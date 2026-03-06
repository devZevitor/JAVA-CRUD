package service;
import domain.User;
import repository.UserRepository;

import java.util.List;

public class UserService {

    private UserRepository repository;
    public UserService(UserRepository repository){
        this.repository = repository;
    }

    public User createUser(String nome, String data_nascimento){
        Long idUser = System.currentTimeMillis();
        if (!verifyData(idUser, nome, data_nascimento)) {
            throw new IllegalArgumentException("Erro ao criar usuario: id, nome e data de nascimento são obrigatórios. O nome deve conter pelo menos 3 caracteres.");
        }

        User user = new User(idUser, nome, data_nascimento);
        repository.save(user);
        return user;
    }

    public List<User> listUser(){
        return repository.list();
    }

    public User updateUser(User user){

        User currentUser = repository.search(user.getId());
        if (currentUser == null) {
            throw new IllegalArgumentException("Usuario nao encontrado");
        }

        User updatedUser = new User(currentUser.getId(), user.getName(), user.getBirthday());
        return repository.update(updatedUser);
    }

    public void deletarUsuario(Long idUser) {
        repository.delete(idUser);
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
