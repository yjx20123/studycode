import java.util.Timer;
import java.util.TimerTask;

public class user {
    public static void main(String[] args) {
        Timer timer = new Timer();
        TimerTask task=new TimerTask() {
            @Override
            public void run() {
                System.out.println("测试测试");
            }
        };
        timer.schedule(task,1000,1000);

    }

}
