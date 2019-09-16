package day23.dao;

import day23.domain.Province;
import day23.util.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class ProvinceDaoImpl implements ProvinceDao{
    private JdbcTemplate template =new JdbcTemplate(JDBCUtils.getDataSource());

    @Override
    public List<Province> findAll() {
        String sql="select * from province";
        List<Province> provinces = template.query(sql, new BeanPropertyRowMapper<>(Province.class));
        return provinces;
    }
}
