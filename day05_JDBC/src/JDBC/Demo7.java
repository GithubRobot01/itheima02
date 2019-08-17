package JDBC;

import Util.JDBCUtils;

import java.sql.*;
import java.util.Scanner;

public class Demo7 {
    //存在登录安全问题
   /* public static boolean login(String username, String password) {
        Connection conn = null;
        Statement statement = null;
        ResultSet rs = null;
        if (username == null || password == null) {
            return false;
        }
        try {
            String sql = "select * from user where username ='" + username + "'and password ='" + password + "'";
            conn = JDBCUtils.getConnection();
            statement = conn.createStatement();
            rs = statement.executeQuery(sql);

            return rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(rs,statement, conn);
        }
        return false;
    }*/
    public static boolean login(String username, String password) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        if (username == null || password == null) {
            return false;
        }
        try {
            String sql = "select * from user where username = ? and password = ?";
            conn = JDBCUtils.getConnection();
            ps = conn.prepareStatement(sql);
            //给sql语句中的?赋值
            ps.setString(1,username);
            ps.setString(2,password);
            rs = ps.executeQuery();

            return rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(rs, ps, conn);
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("请输入用户名:");
            String name = sc.nextLine();
            System.out.println("请输入密码:");
            String pass = sc.nextLine();
            boolean b = login(name, pass);
            if (b) {
                System.out.println("登录成功!");
            } else {
                System.out.println("登录失败!");
            }
        }
    }
}
