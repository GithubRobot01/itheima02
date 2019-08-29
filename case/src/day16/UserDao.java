package day16;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public class UserDao {
    public User login(User user){
        try {
            //使用用户名
            String sql="select * from user where username=?";
            JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
            User user1 = template.queryForObject(sql, new BeanPropertyRowMapper<User>(User.class), user.getUsername());
            return user1;
        } catch (DataAccessException e) {
            //e.printStackTrace();
            return null;
        }
    }
}
