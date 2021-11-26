import com.kuang.service.Userservice;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        Userservice userService = (Userservice) context.getBean("userService");
        userService.add();
    }
}
