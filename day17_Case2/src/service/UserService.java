package service;

import domain.Admin;
import domain.PageBean;
import domain.User;

import java.util.List;
import java.util.Map;

public interface UserService {
    List<User> findAll();

    Admin login(Admin admin);

    void addUser(User user);

    void delUserById(String id);

    User findById(String id);

    void updateUser(User user);

    void delSelectedUser(String[] uids);

    PageBean<User> findUserByPage(String currentPage1, String rows1, Map<String, String[]> condition);
}
