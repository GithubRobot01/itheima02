package dao;

import domain.User;

import java.util.List;

/**
 * 用户操作的DAO
 */
public interface UserDao {
    public List<User> findAll();

    public User login(String username,String password);

    public boolean addUser(User user);

    public void delUser(int id);

    public void updateUser(User user);

    public User findById(int id);
}
