package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

//插入数据到数据库表中
public class Demo2 {
    public static void main(String[] args) {
        try(Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydatabase", "root", "123456");
            Statement statement = conn.createStatement())
        {
            Class.forName("com.mysql.jdbc.Driver");
            String sql="insert into account values (null,'ww',1000)";
            int i = statement.executeUpdate(sql);
            if (i>0){
                System.out.println("数据插入成功!");
            }else{
                System.out.println("数据插入失败!");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
