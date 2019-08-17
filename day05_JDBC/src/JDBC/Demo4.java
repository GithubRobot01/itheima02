package JDBC;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

//删除表中数据
public class Demo4 {
    public static void main(String[] args) {
        try(//获取数据库连接对象
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydatabase", "root", "123456");
            //获取执行sql语句的对象
            Statement statement = conn.createStatement())
        {
            Class.forName("com.mysql.jdbc.Driver");
            String sql="delete from account where name='zs'";
            int i = statement.executeUpdate(sql);
            if (i>0){
                System.out.println("数据删除成功!");
            }else{
                System.out.println("数据删除失败!");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
