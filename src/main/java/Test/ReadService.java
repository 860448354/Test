package Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(rollbackFor = Exception.class)
public class ReadService {
    @Autowired
    ReadDao readDao;
    public void insert(){

    }
}
