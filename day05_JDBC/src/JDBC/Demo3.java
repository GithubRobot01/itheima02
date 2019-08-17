package JDBC;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

//修改数据库表中的数据
public class Demo3 {
    public static void main(String[] args) {
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydatabase","root","123456");
             Statement statement = conn.createStatement())
        {
            Class.forName("com.mysql.jdbc.Driver");
            String sql="update account set balance=1500 where name='zs'";
            int i = statement.executeUpdate(sql);
            if (i>0){
                System.out.println("数据修改成功!");
            }else{
                System.out.println("数据修改失败!");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
