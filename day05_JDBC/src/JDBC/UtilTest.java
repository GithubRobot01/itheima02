package JDBC;

import Util.JDBCUtils;

import java.sql.*;

public class UtilTest {
    public static void main(String[] args) {
        ResultSet rs = null;
        Statement statement = null;
        Connection conn = null;
        try {
//            Class.forName("com.mysql.jdbc.Driver");
//            conn = DriverManager.getConnection("jdbc:mysql:///mydatabase", "root", "123456");
            conn=JDBCUtils.getConnection();
            String sql="select * from emp where id=1002";
            statement = conn.createStatement();
            rs = statement.executeQuery(sql);
            rs.next();
            int id=rs.getInt("id");
            String ename=rs.getString("ename");
            int job_id=rs.getInt(3);
            int mgr=rs.getInt(4);
            Date joindate=rs.getDate(5);
            double salary=rs.getDouble("salary");
            double bonus=rs.getDouble(7);
            int dept_id=rs.getInt(8);
            System.out.println(id+","+ename+","+job_id+","+mgr+","+joindate+","
            +salary+","+bonus+","+dept_id);
        }  catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.close(rs,statement,conn);
        }
    }
}
