package Frame;

import java.awt.*;

public class TestFrame1 {
    public static void main(String[] args) {
        Frame frame = new Frame("我的第一个Java图形界面");
        frame.setVisible(true);
        frame.setSize(400, 500);
        frame.setBackground(Color.orange);
        frame.setResizable(false);
    }
}
