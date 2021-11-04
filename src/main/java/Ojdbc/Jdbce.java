package Ojdbc;

import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.util.List;
import java.util.Map;

public class Jdbce {
    public JdbcTemplate getConn(){
        DriverManagerDataSource dr=new DriverManagerDataSource
                ("jdbc:oracle:thin:@127.0.0.1:1521:XE", "HR", "123456");
        //设置驱动
        dr.setDriverClassName("oracle.jdbc.driver.OracleDriver");
        //获取模板对象，等同于之前的BaseDao
        return new JdbcTemplate(dr);
    }
    //统计每个月人入职人数
    @Test
    public void select1(){
        JdbcTemplate jt = getConn();
        String sql = "SELECT count(ename) from emp where to_char(hiredate,'mm')=10";
        List<Map<String,Object>> list = jt.queryForList(sql);
        list.forEach(d ->{
            System.out.println(d);
        });
    }
    //查询月薪高于平均月薪的员工
    @Test
    public void select2(){
        JdbcTemplate jt = getConn();
        String sql = "select * from emp where SALARY >(select avg(salary) from emp)";
        List<Map<String,Object>> list = jt.queryForList(sql);
        list.forEach(d ->{
            System.out.println(d);
        });
    }
    //查询部门人数小于三个的部门信息
    @Test
    public void select3(){
        JdbcTemplate jt = getConn();
        String sql = "select * from dept where deptno in (select count(*) from emp GROUP BY deptno having count(*)<3)";
        List<Map<String,Object>> list = jt.queryForList(sql);
        list.forEach(d ->{
            System.out.println(d);
        });
    }
    //打印出所有部门经理的信息
    @Test
    public void select4(){
        JdbcTemplate jt = getConn();
        String sql = "select * from emp e join dept d on e.DEPTNO = d.DEPTNO where job='部门经理' ";
        List<Map<String,Object>> list = jt.queryForList(sql);
        list.forEach(d ->{
            System.out.println(d);
        });
    }
    //打印出7499号员工的领导信息
    @Test
    public void select5(){
        JdbcTemplate jt = getConn();
        String sql = "select * from emp e join dept d on e.DEPTNO = d.DEPTNO where MGR = (select MGR from emp where empid=1)";
        List<Map<String,Object>> list = jt.queryForList(sql);
        list.forEach(d ->{
            System.out.println(d);
        });
    }
    //添加一个新部门，并为这个部门添加两个新员工
    @Test
    public void select6(){
        JdbcTemplate jt = getConn();
        String sql = "insert into dept(deptno,dname,loc) values('5','运营','dashisdw')";
        jt.update(sql);
        String sql2 = "insert into emp(empid,ename,deptno) VALUES('4','dasda','5')";
        jt.update(sql2);
        String sql3 = "insert into emp(empid,ename,deptno) VALUES('5','agdagr','5')";
        jt.update(sql3);
    }
    //计算公司每个月要发的工资
    @Test
    public void select7(){
        JdbcTemplate jt = getConn();
        String sql="select sum(salary),sum(comm) from emp";
        List<Map<String,Object>> list = jt.queryForList(sql);
        list.forEach(d ->{
            System.out.println(d);
        });
    }
    //统计出每一年的入职人数
    @Test
    public void select8(){
        JdbcTemplate jt = getConn();
        String sql="SELECT count(ename) from emp where to_char(hiredate,'yyyy')=2020";
        List<Map<String,Object>> list = jt.queryForList(sql);
        list.forEach(d ->{
            System.out.println(d);
        });
    }
    //统计每个职务的平均月薪
    @Test
    public void select9(){
        JdbcTemplate jt = getConn();
        String sql="SELECT job,avg(salary) from emp GROUP BY job";
        List<Map<String,Object>> list = jt.queryForList(sql);
        list.forEach(d ->{
            System.out.println(d);
        });
    }
}
