package dao;

import domain.User;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import util.JDBCUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class UserDaoImpl implements UserDao{
    private JdbcTemplate template=new JdbcTemplate(JDBCUtils.getDataSource());;

    @Override
    public List<User> findAll() {
        //使用JDBC操作数据库

        try {
            String sql="select * from user";
            List<User> users = template.query(sql, new BeanPropertyRowMapper<>(User.class));
            return users;
        } catch (DataAccessException e) {
            //e.printStackTrace();
            return null;
        }
    }

    @Override
    public User login(String username, String password) {
        try {
            String sql="select * from user where username = ? and password =?";
            User user = template.queryForObject(sql, new BeanPropertyRowMapper<>(User.class), username, password);
            return user;
        } catch (DataAccessException e) {
            //e.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean addUser(User user) {
        //(2,'李四','女',15,'北京','88888','ls@itcast.cn')
        //user`(`id`,`name`,`gender`,`age`,`address`,`qq`,`email``) VALUES (1,'张三','男',13,'陕西','12345','zhangsan@itcast.cn')
        String sql="insert into user values(null,?,?,?,?,?,?,null,null )";
        int count = template.update(sql,
                user.getName(),
                user.getGender(),
                user.getAge(),
                user.getAddress(),
                user.getQq(),
                user.getEmail()
        );
        if (count>0){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public void delUser(int id) {
        String sql="delete from user where id=?";
        template.update(sql, id);
    }

    @Override
    public void updateUser(User user) {
        String sql="update user set name=?,gender=?,age=?,address=?,qq=?,email=? where id=?";
        template.update(sql, user.getName(), user.getGender(), user.getAge(), user.getAddress(), user.getQq(), user.getEmail(), user.getId());
    }

    @Override
    public User findById(int id) {
        try {
            String sql="select * from user where id=?";
            User user = template.queryForObject(sql, new BeanPropertyRowMapper<>(User.class), id);
            return user;
        } catch (DataAccessException e) {
            // e.printStackTrace();
            return null;
        }
    }

    @Override
    public int findTotalCount(Map<String, String[]> condition) {
        String sql="select count(*) from user where 1=1";
        StringBuilder sb=new StringBuilder(sql);
        //遍历map
        Set<String> set = condition.keySet();
        //遍历map
        List<Object> params=new ArrayList<Object>();
        for (String key : set) {
            //排除分页条件参数
            if ("currentPage".equals(key)||"rows".equals(key)){
                continue;
            }
            //获取value
            String value = condition.get(key)[0];
            //判断value是否为空
            if (value!=null&&!"".equals(value)){
                sb.append(" and " +key+" like ? ");
                params.add("%"+value+"%");
            }
        }
        System.out.println(sb.toString());
        System.out.println(params);
        return template.queryForObject(sb.toString(), Integer.class,params.toArray());
    }

    @Override
    public List<User> findByPage(int start, int rows,Map<String, String[]> condition) {
        String sql="select * from user where 1=1";

        StringBuilder sb=new StringBuilder(sql);
        //遍历map
        Set<String> set = condition.keySet();
        //遍历map
        List<Object> params=new ArrayList<Object>();
        for (String key : set) {
            //排除分页条件参数
            if ("currentPage".equals(key)||"rows".equals(key)){
                continue;
            }
            //获取value
            String value = condition.get(key)[0];
            //判断value是否为空
            if (value!=null&&!"".equals(value)){
                sb.append(" and " +key+" like ? ");
                params.add("%"+value+"%");
            }
        }

        sb.append(" limit ?,? ");
        params.add(start);
        params.add(rows);
        List<User> users = template.query(sb.toString(), new BeanPropertyRowMapper<>(User.class),params.toArray());
        return users;
    }

}
