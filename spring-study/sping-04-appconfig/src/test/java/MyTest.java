import com.kuang.config.Myconfig;
import com.kuang.pojo.User;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MyTest {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Myconfig.class);
        User bean = context.getBean(User.class);
        String name = bean.getName();
        System.out.println(name);
    }
}
