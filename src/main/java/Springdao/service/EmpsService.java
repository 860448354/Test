package Springdao.service;

import Springdao.dao.EmpsDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmpsService {
    @Autowired
    EmpsDao empsDao;
    public int insert(){
        return empsDao.insert();
    }
}
