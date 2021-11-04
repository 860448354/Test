package Springdao.service;

import Springdao.dao.DeptDao;
import Springdao.dao.EmpDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(rollbackFor = Exception.class)
public class HumanResourceService {
    @Autowired
    DeptDao deptDao;
    EmpDao empDao;
    public int insert(){
        return deptDao.insert();
    }
    public int insert2() {
        return empDao.insert2();
    }
    public int insert3(){
        return empDao.insert3();
    }
    public int delete1(){
        return deptDao.deleteemp();
    }
    public int delete2(){
        return deptDao.deletedept();
    }
    public int update(){
        return empDao.update();
    }
    public int update2(){
        return empDao.update2();
    }
}
