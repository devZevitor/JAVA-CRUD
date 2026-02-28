package repository;

import domain.User;

import java.util.ArrayList;

public class UserRepositoryImplementation implements UserRepository{

    private ArrayList<User> users = new ArrayList<>();

    @Override
    public void salvar_usuario(User user) {
        users.add(user);
        System.out.println("Usuario salvo");
    }

    @Override
    public User buscar_usuario(Long id) {

        return users.stream()
                .filter(u -> u.pegar_Iduser().equals(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public ArrayList<User> listar_usuarios() {
        return users;
    }

    @Override
    public void deletar_usuario(Long id) {
        users.removeIf(u -> u.pegar_Iduser().equals(id));
        System.out.println("Usuario deletado");
    }

    @Override
    public void atualizar_usuario(User user) {
        deletar_usuario(user.pegar_Iduser());
        salvar_usuario(user);
        System.out.println("Usuario atualizado");
    }
}
