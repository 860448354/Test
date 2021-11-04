package Springdao.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class DeptDao {
    @Autowired
    private JdbcTemplate jt;
    //创建一个新部门，同时添加3个员工
    public int insert(){
        String sql="insert into dept(deptno,dname,loc) values(?,?,?)";

        String sql3 = "insert into emp(empid,ename,deptno) VALUES(?,?,?)";
        return jt.update(sql,"4","人事部","dasdoao");
    }

    //删除一个部门，同时删除该部门下的所有员工
    public int deleteemp(){
        String sql="delete from emp where deptno = '5'";
        return jt.update(sql);
    }
    public int deletedept(){
        String sql="delete from dept where deptno=4";
        return jt.update(sql);
    }
}
