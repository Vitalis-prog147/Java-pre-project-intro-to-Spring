package web.dao;

import web.model.User;
import java.util.List;

public interface UserDao {

    List<User> getAllUsers();
    void save(User user);
    User get(int id);
    void edit(int id, User editUser);
    void delete(int id);
}
