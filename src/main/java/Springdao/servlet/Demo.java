package Springdao.servlet;

import Springdao.service.EmpsService;
import Springdao.service.HumanResourceService;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Demo {
    HumanResourceService humanResourceService;
    EmpsService empsService;
    @Before
    public void initIoc(){
        ApplicationContext ctx =
                new ClassPathXmlApplicationContext("poll.xml");
        humanResourceService = ctx.getBean(HumanResourceService.class);
    }
   /* @Test
    public void test(){
        humanResourceService.insert();
        humanResourceService.insert2();
        humanResourceService.delete1();
        humanResourceService.delete2();
        humanResourceService.update();
        humanResourceService.update2();
        System.out.println("修改成功");
    }*/
    @Test
    public void test(){
        empsService.insert();
    }
}
