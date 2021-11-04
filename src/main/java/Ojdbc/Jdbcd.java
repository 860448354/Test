package Ojdbc;

import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.util.List;
import java.util.Map;

public class Jdbcd {
    public JdbcTemplate  getConn(){
        DriverManagerDataSource dr=new DriverManagerDataSource
                ("jdbc:oracle:thin:@127.0.0.1:1521:XE", "HR", "123456");
        //设置驱动
        dr.setDriverClassName("oracle.jdbc.driver.OracleDriver");
        //获取模板对象，等同于之前的BaseDao
        return new JdbcTemplate(dr);
    }
    //查询月薪高于平均月薪（salary）的员工信息
    @Test
    public  void  selectSalary(){
        JdbcTemplate jt = getConn();
        String sql="select * from emp where SALARY >(select avg(salary) from emp)";
        List<Map<String,Object>> list = jt.queryForList(sql);
        list.forEach(d->{
            System.out.println(d);
        });
    }
    //查询部门人数小于3个的部门信息
    @Test
    public  void selectDept(){
        JdbcTemplate jt = getConn();
        String sql="select * from dept where deptno in (select count(*) from emp GROUP BY deptno having count(*)<3)";
        List<Map<String ,Object>> list=jt.queryForList(sql);
        list.forEach(d->{
            System.out.println(d);
        });
    }
    //打印出职位是SaleMan的所有员工信息
    @Test
    public void  selectSaleMan(){
        JdbcTemplate jt = getConn();
        String sql="select * from emp e join dept d on e.deptno=d.deptno where e.job='SaleMen'";
        List<Map<String ,Object>> list=jt.queryForList(sql);
        list.forEach(d->{
            System.out.println(d);
        });
    }
    //打印201号员工所有资料
    @Test
    public void selectEmp201(){
        JdbcTemplate jt = getConn();
        String sql="select * from emp e join dept d on e.deptno=d.deptno where e.empid='201'";
        List<Map<String ,Object>> list=jt.queryForList(sql);
        list.forEach(d->{
            System.out.println(d);
        });
    }
}