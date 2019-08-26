package 用户登录案例;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public class UserDao1 {
    //声明JDBCTemplate对象共用
    private JdbcTemplate template=new JdbcTemplate(JDBCUtils.getDataSource());

    /**
     * 登录方法
     * @param user 用户名和密码
     * @return
     */
    public User login(User user){
        try {
            String sql="select * from user where username = ? and password = ?";
            User user1=template.queryForObject(sql,new BeanPropertyRowMapper<>(User.class),user.getUsername(),user.getPassword());
            return user1;
        } catch (DataAccessException e) {
            return null;
        }
    }
}
