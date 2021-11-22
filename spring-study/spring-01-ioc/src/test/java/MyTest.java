import com.kuang.dao.UserDaoImpl;
import com.kuang.service.UserServiceImpl;

public class MyTest {
    public static void main(String[] args) {
        UserServiceImpl userService=new UserServiceImpl();
        userService.getUser();
    }
}
