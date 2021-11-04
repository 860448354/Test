package Test;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
@Repository
public class ReadDao {
    @Autowired
    public JdbcTemplate getConn(){
        DriverManagerDataSource dr=new DriverManagerDataSource
                ("jdbc:oracle:thin:@127.0.0.1:1521:XE", "HR", "123456");
        //设置驱动
        dr.setDriverClassName("oracle.jdbc.driver.OracleDriver");
        //获取模板对象，等同于之前的BaseDao
        return new JdbcTemplate(dr);
    }
    @Test
    public void insert(String name,String sex){
        JdbcTemplate jt =getConn();
        String sql = "insert into read(readid,readname,readsex) values(seq6.nextval,?,?)";
        int i = jt.update(sql,name,sex);
        if (i>0){
            System.out.println("新增成功");
        }
    }
}
