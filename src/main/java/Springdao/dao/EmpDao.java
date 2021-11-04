package Springdao.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class EmpDao {
    @Autowired
    private JdbcTemplate jt;
    public int insert2(){
        String sql = "insert into emp(empid,ename,deptno) VALUES(?,?,?)";
        return jt.update(sql,"1","雷建威","4");
    }
    public int insert3(){
        String sql = "insert into emp(empid,ename,deptno) VALUES(?,?,?)";
        return jt.update(sql,"2","刘雪军","4");
    }
    //将低于平均工资的员工工资上浮20%，并将最高的员工工资下调50%
    public int update(){
        String sql = "update emp set salary = salary*1.2 where salary<(select avg(salary) from emp)";
        return jt.update(sql);
    }
    public int update2(){
        String sql = "update emp set salary = salary*0.5 where salary=(select max(salary) from emp)";
        return jt.update(sql);
    }
}
