package dao.Impl;

import dao.UserDao;
import domain.Admin;
import domain.User;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import util.JDBCUtils;

import java.util.List;

public class UserDaoImpl implements UserDao {
    private JdbcTemplate template=new JdbcTemplate(JDBCUtils.getDataSource());
    @Override
    public List<User> findAll() {
        try {
            String sql="select * from user";
            List<User> users = template.query(sql, new BeanPropertyRowMapper<User>(User.class));
            return users;
        } catch (DataAccessException e) {
            //e.printStackTrace();
            return null;
        }
    }

    @Override
    public Admin login(String username, String password) {
        try {
            String sql="select * from admin where username=? and password=?";
            Admin admin1 = template.queryForObject(sql, new BeanPropertyRowMapper<Admin>(Admin.class),username,password);
            return admin1;
        } catch (DataAccessException e) {
            //e.printStackTrace();
            return null;
        }
    }

    @Override
    public void addUser(User user) {
        String sql="insert into user values(null,?,?,?,?,?,?)";
        template.update(sql,user.getName(),user.getGender(),user.getAge(),user.getAddress(),user.getQq(),user.getEmail());
    }

    @Override
    public void delUserById(int id) {
        String sql="delete from user where id=?";
        template.update(sql,id);
    }

    @Override
    public User findById(int id) {
        try {
            String sql="select * from user where id=?";
            User user = template.queryForObject(sql, new BeanPropertyRowMapper<>(User.class), id);
            return user;
        } catch (DataAccessException e) {
            //e.printStackTrace();
            return null;
        }
    }

    @Override
    public void updateUser(User user) {
        String sql="update user set name=?,gender=?,age=?,address=?,qq=?,email=? where id=?";
        template.update(sql,user.getName(),user.getGender(),user.getAge(),user.getAddress(),user.getQq(),user.getEmail(),user.getId());
    }

    @Override
    public int findTotalCount() {
        String sql="select count(*) from user";
        Integer integer = template.queryForObject(sql, Integer.class);
        return integer;
    }

    @Override
    public List<User> findByPage(int start, int rows) {
        try {
            String sql="select * from user limit ?,?";
            List<User> users = template.query(sql, new BeanPropertyRowMapper<User>(User.class), start, rows);
            return users;
        } catch (DataAccessException e) {
            //e.printStackTrace();
            return null;
        }
    }
}
