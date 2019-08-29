package JDBCTemplate;

import Domain.Emp;
import Utils.JDBCUtils;
import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.junit.Test;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class Demo2 {

    //修改1001号数据的salary为10000
    @Test
    public void test1() throws Exception {
       Properties prop=new Properties();
        InputStream is = Demo2.class.getClassLoader().getResourceAsStream("druid.properties");
        prop.load(is);
        DataSource ds = DruidDataSourceFactory.createDataSource(prop);
        JdbcTemplate template=new JdbcTemplate(ds);
        String sql="update emp set salary= ? where id=?";
        int count = template.update(sql, 10000, 1001);
        System.out.println(count);
    }

    //添加一条数据
    @Test
    public void test2(){
        JdbcTemplate template=new JdbcTemplate(JDBCUtils.getDataSource());
        String sql="insert into emp values (?,?,?,?,?,?,?,?)";
        int count = template.update(sql, 1015, "哪吒", 2, null, "2008-08-08", 9999, 1, 10);
        System.out.println(count);
    }
    //删除上一条记录
    @Test
    public void test3() throws Exception {
        Properties pro=new Properties();
        InputStream is = Demo2.class.getClassLoader().getResourceAsStream("druid.properties");
        pro.load(is);
        DataSource ds = DruidDataSourceFactory.createDataSource(pro);
        JdbcTemplate template=new JdbcTemplate(ds);
        String sql = "delete from emp where id =?";
        int count = template.update(sql, 1015);
        System.out.println(count);
    }

    //查询id为1001的记录,并将其封装为Map集合
    //查询的结果集长度只能为1,将列名作为key,将值作为value
    @Test
    public void test4(){
        JdbcTemplate template=new JdbcTemplate(JDBCUtils.getDataSource());
        String sql="select * from emp where id = ?";
        Map<String, Object> map = template.queryForMap(sql, 1001);
        System.out.println(map);
    }
    //查询所有记录,并将其封装为List集合
    @Test
    public void test5(){
        JdbcTemplate template=new JdbcTemplate(JDBCUtils.getDataSource());
        String sql="select * from emp";
        List<Map<String, Object>> list = template.queryForList(sql);
        for (Map<String, Object> map : list) {
            Set<String> set = map.keySet();
            for (String s : set) {
                System.out.print(s+","+map.get(s)+" ");
            }
            System.out.println();
        }
    }
    //查询所有记录,并将其封装为Emp对象的List集合
    @Test
    public void test6(){
        JdbcTemplate template=new JdbcTemplate(JDBCUtils.getDataSource());
        String sql="select * from emp";
        List<Emp> list = template.query(sql, new RowMapper<Emp>() {

            @Override
            public Emp mapRow(ResultSet rs, int i) throws SQLException {
                int id = rs.getInt(1);
                String ename = rs.getString(2);
                int job_id = rs.getInt(3);
                int mgr = rs.getInt(4);
                Date joindate = rs.getDate(5);
                double salary = rs.getDouble(6);
                double bonus = rs.getDouble(7);
                int dept_id = rs.getInt(8);
                return new Emp(id, ename, job_id, mgr, joindate, salary, bonus, dept_id);
            }
        });
        for (Emp emp : list) {
            System.out.println(emp);
        }
    }
    @Test
    public void test6_2(){
        JdbcTemplate template=new JdbcTemplate(JDBCUtils.getDataSource());
        String sql="select * from emp";
        List<Emp> list = template.query(sql,new BeanPropertyRowMapper<Emp>(Emp.class));
        for (Emp emp : list) {
            System.out.println(emp);
        }
    }
    //查询总记录数
    @Test
    public void test7() throws Exception {
        Properties pro=new Properties();
        InputStream is = Demo2.class.getClassLoader().getResourceAsStream("druid.properties");
        pro.load(is);
        DataSource ds = DruidDataSourceFactory.createDataSource(pro);
        String sql="select count(id) from emp";
        JdbcTemplate template=new JdbcTemplate(ds);
        Long a = template.queryForObject(sql, Long.class);
        System.out.println(a);
    }
}
