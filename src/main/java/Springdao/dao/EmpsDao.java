package Springdao.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class EmpsDao {
    @Autowired
    private JdbcTemplate jt;
    public int insert(){
        String sql = "insert into emps values(1,'雷建威','男',2000-11-11,'入职',1)";
        return insert();
    }
}
