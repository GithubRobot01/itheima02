package JDBC;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

//查询emp表中的数据将其封装为对象,然后存入集合
public class Demo6 {
    public static List<Emp> findAll(){
        String sql="select * from emp";
        List<Emp> list=new ArrayList<>();
        try ( Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydatabase","root","123456");
              Statement statement = conn.createStatement();
              ResultSet rs = statement.executeQuery(sql))
        {
            //Class.forName("com.mysql.jdbc.Driver");
            while(rs.next()){
                int id=rs.getInt("id");
                String ename=rs.getString("ename");
                int job_id=rs.getInt(3);
                int mgr=rs.getInt(4);
                Date joindate=rs.getDate(5);
                double salary=rs.getDouble("salary");
                double bonus=rs.getDouble(7);
                int dept_id=rs.getInt(8);
                Emp emp=new Emp(id,ename,job_id,mgr,joindate,salary,bonus,dept_id);
                list.add(emp);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public static void main(String[] args) {
        List<Emp> all = findAll();
        for (Emp emp : all) {
            System.out.println(emp);
        }
    }
}
