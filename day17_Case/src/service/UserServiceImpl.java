package service;

import dao.UserDao;
import dao.UserDaoImpl;
import domain.User;

import java.util.List;

public class UserServiceImpl implements UserService {
    private UserDao dao=new UserDaoImpl();

    @Override
    public List<User> findAll() {
        //调用dao完成查询
        return dao.findAll();
    }

    @Override
    public boolean addUser(User user) {
        return dao.addUser(user);
    }


    @Override
    public User login(User user) {
        return dao.login(user.getUsername(),user.getPassword());
    }

    @Override
    public void delUser(String id) {
        dao.delUser(Integer.valueOf(id));
    }

    @Override
    public User findUserById(String id) {
        return dao.findById(Integer.parseInt(id));
    }

    @Override
    public void updateUser(User user) {
        dao.updateUser(user);
    }

}
