package Test;

import org.aspectj.lang.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class JokeAspect {
    @Pointcut("execution(* Test.JokeService.*(..))")
    public void a(){};
    @Before("a()")
    public void start(){
        System.out.println("小明已经上大三了，还是没有女朋友。在寝室的哥们的怂恿下，他决定去追一个心仪已久的女生。 ");
    }
    @After("a()")
    public void stop(){
        System.out.println("眼看那个女生越走越远，他只好从地上捡了一样东西，追上去说：“小姐姐，这块砖头是不是你掉的啊？");
    }
}
