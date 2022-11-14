package web.dao;

import web.model.User;
import java.util.List;

public interface UserDao {

    List<User> getAllUsers();
    void saveUser(User user);
    User displayUser(int id);
    void editUser(int id, User editUser);
    void deleteUser(int id);
}
