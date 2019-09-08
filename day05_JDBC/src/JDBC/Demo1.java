package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Demo1 {
    public static void main(String[] args) throws ClassNotFoundException {

        //注册驱动:告诉程序该使用哪一个数据库驱动jar
        /*在com.mysql.jdbc.Driver类中存在静态代码块
         static {
            try {
                java.sql.DriverManager.registerDriver(new Driver());
            } catch (SQLException E) {
                throw new RuntimeException("Can't register driver!");
            }
        }
         */
        Class.forName("com.mysql.jdbc.Driver");
        Connection conn = null;
        Statement statement=null;
        try {
            //获取数据库连接对象
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydatabase", "root", "123456");
            //定义sql语句
            String sql="update account set balance=500 where id=1";
            //获取执行sql语句的对象 Statement
            statement = conn.createStatement();
            //执行sql
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }finally{
            //释放资源
            if (conn!=null){
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (statement!=null){
                try {
                    statement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

        }
    }
}
