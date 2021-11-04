package Test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Demo {
    public static void main(String[] args) throws Exception {
       Class c = Student.class;
       Object o=c.newInstance();
       Method[] method = c.getDeclaredMethods();
        for (Method m : method) {
           m.invoke(o,"工大",3);
        }
    }
}
