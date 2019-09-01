package service;

import domain.User;

import java.util.List;

/**
 * 用户管理的业务接口
 */
public interface UserService {
    /**
     * 查询所有用户信息
     * @return
     */
    public List<User> findAll();

    public boolean addUser(User user);

    public User login(User user);

    public void delUser(String id);

    public User findUserById(String id);

    void updateUser(User user);
}
