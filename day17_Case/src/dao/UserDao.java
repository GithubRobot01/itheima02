package dao;

import domain.User;

import java.util.List;
import java.util.Map;

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

    //查询总记录数
    int findTotalCount(Map<String, String[]> condition);
    //分页查询每页记录
    List<User> findByPage(int start, int rows, Map<String, String[]> condition);
}
