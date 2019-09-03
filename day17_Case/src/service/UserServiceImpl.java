package service;

import dao.UserDao;
import dao.UserDaoImpl;
import domain.PageBean;
import domain.User;

import java.util.List;
import java.util.Map;

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

    @Override
    public void delSelectedUser(String[] uids) {
        if (uids!=null&&uids.length>0){
            for (String uid : uids) {
                dao.delUser(Integer.valueOf(uid));
            }
        }
    }

    @Override
    public PageBean<User> findUserByPage(String currentPage1, String rows1, Map<String, String[]> condition) {
        int currentPage = Integer.parseInt(currentPage1);
        int rows = Integer.parseInt(rows1);
        /*//解决第一页的上一页问题
        if (currentPage<=1){
            currentPage=1;
        }*/
        //创建PageBean对象
        PageBean<User> pb=new PageBean<User>();
        //设置参数
        pb.setRows(rows);
        pb.setCurrentPage(currentPage);
        //调用dao查询List集合
        int totalCount = dao.findTotalCount(condition);
        pb.setTotalCount(totalCount);
        //调用dao查询List集合
        //计算开始记录索引
        int start=(currentPage-1)*rows;
        List<User> list=dao.findByPage(start,rows,condition);
        pb.setList(list);
        //计算总页码
        int totalPage=(totalCount%rows)==0?(totalCount/rows):(totalCount/rows+1);
        pb.setTotalPage(totalPage);

        return pb;
    }

}
