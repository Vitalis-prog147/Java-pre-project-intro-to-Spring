package web.service;

import web.model.User;
import java.util.List;

public interface UserService {

    List<User> getAllUsers();
    void saveUser(User user);
    User displayUser(int id);
    void editUser(int id, User EditUser);
    void deleteUser(int id);

}
