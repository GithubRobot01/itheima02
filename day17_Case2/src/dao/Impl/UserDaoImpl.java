package dao.Impl;

import dao.UserDao;
import domain.Admin;
import domain.User;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import util.JDBCUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

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
    public int findTotalCount(Map<String, String[]> condition) {
        String sql="select count(*) from user where 1=1";
        StringBuilder sb=new StringBuilder(sql);
        Set<String> set = condition.keySet();
        List<Object> params=new ArrayList<Object>();
        for (String key : set) {
            if ("currentPage".equals(key)||"rows".equals(key)){
                continue;
            }
            String value = condition.get(key)[0];
            if (value!=null&&!"".equals(value)){
                sb.append(" and "+key+" like ? ");
                params.add("%"+value+"%");
            }
        }

        Integer integer = template.queryForObject(sb.toString(), Integer.class,params.toArray());
        return integer;
    }

    @Override
    public List<User> findByPage(int start, int rows, Map<String, String[]> condition) {
        String sql="select * from user where 1=1";
        StringBuilder sb=new StringBuilder(sql);
        Set<String> set = condition.keySet();
        List<Object> params=new ArrayList<Object>();
        for (String key : set) {
            if ("currentPage".equals(key)||"rows".equals(key)){
                continue;
            }
            String value = condition.get(key)[0];
            if (value!=null&&!"".equals(value)){
                sb.append(" and "+key+" like ? ");
                params.add("%"+value+"%");
            }
        }
        params.add(start);
        params.add(rows);
        sb.append(" limit ?,?");

        List<User> users = template.query(sb.toString(), new BeanPropertyRowMapper<>(User.class), params.toArray());
        return users;
    }

}
