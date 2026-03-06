package repository;
import domain.User;

import java.util.List;

public interface UserRepository {

    void save(User user);
    User search(Long id_user);
    List<User> list();
    void delete(Long id);
    User update(User user);
    boolean userExists(Long id);
}
