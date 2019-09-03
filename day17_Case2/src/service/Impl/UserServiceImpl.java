package service.Impl;

import dao.Impl.UserDaoImpl;
import dao.UserDao;
import domain.Admin;
import domain.PageBean;
import domain.User;
import service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {
    private UserDao dao=new UserDaoImpl();

    @Override
    public List<User> findAll() {
        return dao.findAll();
    }

    @Override
    public Admin login(Admin admin) {
        return dao.login(admin.getUsername(),admin.getPassword());
    }

    @Override
    public void addUser(User user) {
        dao.addUser(user);
    }

    @Override
    public void delUserById(String id) {
        dao.delUserById(Integer.parseInt(id));
    }

    @Override
    public User findById(String id) {
        return dao.findById(Integer.parseInt(id));
    }

    @Override
    public void updateUser(User user) {
        dao.updateUser(user);
    }

    @Override
    public void delSelectedUser(String[] uids) {
        if (uids!=null&&uids.length>0){
            for (String uid : uids) {
                dao.delUserById(Integer.parseInt(uid));
            }
        }
    }

    @Override
    public PageBean<User> findUserByPage(String currentPage1, String rows1) {
        int currentPage=Integer.parseInt(currentPage1);
        int rows=Integer.parseInt(rows1);
        PageBean<User> pb=new PageBean<>();
        int totalCount = dao.findTotalCount();

        return null;
    }
}
