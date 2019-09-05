package dao;

import domain.Admin;
import domain.User;

import java.util.List;
import java.util.Map;

public interface UserDao {
    List<User> findAll();

    Admin login(String username, String password);

    void addUser(User user);

    void delUserById(int id);

    User findById(int parseInt);

    void updateUser(User user);

    int findTotalCount(Map<String, String[]> condition);

    List<User> findByPage(int start, int rows, Map<String, String[]> condition);
}
