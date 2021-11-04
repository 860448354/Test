package Ojdbc;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class JDBC {
    static JdbcTemplate jt = null;
    static NamedParameterJdbcTemplate njt = null;

    /*public static void main(String[] args) {
        new JDBC().select();
    }*/
    @BeforeClass
    public static  JdbcTemplate getConn(){
        //要有数据源,其实就是连接
        DriverManagerDataSource dmds =
                new DriverManagerDataSource(
                        "jdbc:oracle:thin:@127.0.0.1:1521:xe",
                        "HR", "123456");
        //设置驱动
        dmds.setDriverClassName("oracle.jdbc.driver.OracleDriver");
        //获取模板对象，等同于以前的BaseDao
        /*jt = new JdbcTemplate(dmds);
        njt = new NamedParameterJdbcTemplate(dmds);*/
        return new JdbcTemplate(dmds);
    }
    @Test
    public void select(){
        JdbcTemplate jt = getConn();
        String sql = "select ename from emp where empid=?";
        Map<String,Object> map = jt.queryForMap(sql,"1");
        System.out.println(map);
    }
   /*@Test
    public void select2() {
       //单行多列
       String sql = "select * from emp where empid=?";
//        Dept name = jt.queryForObject(sql, new RowMapper<Dept>() {
//            @Override
//            public Dept mapRow(ResultSet rs, int i) throws SQLException {
//                Dept d = new Dept();
//                d.setDeptNo(rs.getInt("department_id"));
//                d.setDeptName(rs.getString("department_name"));
//                return d;
//            }
//        }, 10);
//        System.out.println(name);
       //以表的列名为key,值为value
       Map<String, Object> map = jt.queryForMap(sql, "1");
       System.out.println(map);
   }*/
    /*@Test
    public List<Emp> select3(){
        //多行
        String sql = "select empid,ename from emp";
        List<Emp> list = jt.query(sql,new RowMapper<Emp>() {
            @Override
            public Emp mapRow(ResultSet rs, int i) throws SQLException {
                Emp d = new Emp();
                d.setEmpid(rs.getNString("empid"));
                d.setEname(rs.getNString("ename"));
                return d;
            }
        });
        return list;
    }*/
    /*@Test
    public Map<String,Object> select4(){
        String sql = "select empid,ename from emp";
        List<Map<String,Object>> list= jt.queryForList(sql);
        list.forEach(d->{
            System.out.println(d);
        });
        return (Map<String, Object>) list;
    }*/
    /*@Test
    public List<Map<String, Object>> findAll(){
        String sql = "SELECT * FROM emp";
        List<Emp> e = new ArrayList<Emp>();
        List<Map<String, Object>> rows = jt.queryForList(sql);
        for (Map row : rows) {
            Emp emp = new Emp();
            emp.setEmpid((String) row.get("empid"));
            emp.setEname((String)row.get("ename"));
            e.add(emp);
        }
        return rows;
    }*/

}
