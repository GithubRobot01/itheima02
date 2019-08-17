package JDBC;

import java.sql.*;

//查询表中的数据
public class Demo5 {
    public static void main(String[] args) {
        String sql="select * from account";
        try ( Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydatabase","root","123456");
              Statement statement = conn.createStatement();
              ResultSet rs = statement.executeQuery(sql))
        {
            Class.forName("com.mysql.jdbc.Driver");
            //让游标向下移动一行
            while (rs.next()){
                //获取数据,参数为第几列或列名
                int id = rs.getInt(1);
                String name=rs.getString("name");
                double balance=rs.getDouble(3);
                System.out.println(id+","+name+","+balance);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
