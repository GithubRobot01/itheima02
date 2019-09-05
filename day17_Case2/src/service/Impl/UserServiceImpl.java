package service.Impl;

import dao.Impl.UserDaoImpl;
import dao.UserDao;
import domain.Admin;
import domain.PageBean;
import domain.User;
import service.UserService;

import java.util.List;
import java.util.Map;

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
    public PageBean<User> findUserByPage(String currentPage1, String rows1, Map<String, String[]> condition) {
        //当前页码
        int currentPage=Integer.parseInt(currentPage1);
        //每页的记录数
        int rows=Integer.parseInt(rows1);
        PageBean<User> pb=new PageBean<>();
        pb.setCurrentPage(currentPage);
        pb.setRows(rows);
        //总记录数
        int totalCount = dao.findTotalCount(condition);
        pb.setTotalCount(totalCount);
        //总页数
        int totalPage=(totalCount%rows)==0?(totalCount/rows):(totalCount/rows+1);
        pb.setTotalPage(totalPage);
        //每页的开始索引
        int start=(currentPage-1)*rows;
        List<User> users = dao.findByPage(start, rows,condition);
        pb.setList(users);

        return pb;
    }
}
