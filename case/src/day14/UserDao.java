package day14;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public class UserDao {
    public User login(User user){
        try {
            String sql="select * from user where username=? and password=?";
            JdbcTemplate template=new JdbcTemplate(JDBCUtils.getDateSource());
            //将查询结构封装为User对象,后两个参数为sql语句中?处的值
            User user1 = template.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), user.getUsername(), user.getPassword());
            return user1;
        } catch (DataAccessException e) {
            //e.printStackTrace();
            return null;
        }

    }
}
