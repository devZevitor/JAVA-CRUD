package repository;
import domain.User;

import java.util.ArrayList;

public interface UserRepository {

    void salvar_usuario(User user);
    User buscar_usuario(Long id_user);
    ArrayList<User> listar_usuarios();
    void deletar_usuario(Long id);
    void atualizar_usuario(User user);
}
