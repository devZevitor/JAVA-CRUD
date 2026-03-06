package repository;

import domain.User;

import java.util.ArrayList;
import java.util.List;

public class UserRepositoryImplementation implements UserRepository{

    private List<User> users = new ArrayList<>();

    @Override
    public void save(User user) {
        users.add(user);
        System.out.println("Usuario salvo");
    }

    @Override
    public User search(Long id) {
        return users.stream()
                .filter(u -> u.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<User> list() {
        return users;
    }

    @Override
    public void delete(Long id) {
        users.removeIf(u -> u.getId().equals(id));
        System.out.println("Usuario deletado");
    }

    @Override
    public User update(User user) {
        delete(user.getId());
        save(user);
        System.out.println("Usuario atualizado");
        return user;
    }

    @Override
    public boolean userExists(Long id) {
        return users.stream().anyMatch(u -> u.getId().equals(id));
    }
}
