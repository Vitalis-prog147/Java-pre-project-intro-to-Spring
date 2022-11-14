package web.dao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import web.model.User;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Component
public class UserDaoImpl implements UserDao {

    @PersistenceContext
    private final EntityManager entityManager;

    @Autowired
    public UserDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<User> getAllUsers() {
        return entityManager.createQuery("select user from User user", User.class).getResultList();
    }

    @Override
    public void saveUser(User user) {
        entityManager.persist(user);
    }

    @Override
    public User displayUser(int id) {
        TypedQuery<User> typedQuery = entityManager.createQuery(
                "select user from User user where user.id = :id", User.class);
        typedQuery.setParameter("id", id);
        return typedQuery.getSingleResult();
    }

    @Override
    public void editUser(int id, User editUser) {
        User user = displayUser(id);
        user.setName(editUser.getName());
        user.setSurname(editUser.getSurname());
        user.setEmail(editUser.getEmail());
        entityManager.merge(user);
    }

    @Override
    public void deleteUser(int id) {
        User user = displayUser(id);
        entityManager.remove(user);
    }

}