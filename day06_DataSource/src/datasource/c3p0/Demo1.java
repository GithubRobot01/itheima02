package datasource.c3p0;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class Demo1 {
    public static void main(String[] args) throws SQLException {
        //创建数据库连接池对象
        DataSource ds = new ComboPooledDataSource();
        for (int i = 1; i <= 11; i++) {
            //获取连接对象
            Connection conn = ds.getConnection();
            //打印测试是否成功
            System.out.println(i + ":" + conn);
            if (i == 5) {
                //归还连接到连接池
                conn.close();
            }
        }
    }
}
