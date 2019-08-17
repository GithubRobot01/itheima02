package JDBCTemplate;

import Utils.JDBCUtils;
import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.io.InputStream;
import java.util.Properties;

public class Demo1 {
    public static void main(String[] args) throws Exception {
        //1.导入jar包
        /*使用工具类替换
        Properties pro=new Properties();
        InputStream is = Demo1.class.getClassLoader().getResourceAsStream("druid.properties");
        pro.load(is);
        DataSource ds = DruidDataSourceFactory.createDataSource(pro);*/
        //2.创建JDBCTemplate对象
        JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
        String sql="update account set balance=? where name=?";
        int count = template.update(sql, 5000, "ww");
        System.out.println(count);
    }
}
