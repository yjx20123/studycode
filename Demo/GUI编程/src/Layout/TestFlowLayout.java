package Layout;

import java.awt.*;

public class TestFlowLayout {
    public static void main(String[] args) {
        Frame frame = new Frame("流式布局");
        Button button = new Button("button1");
        Button button1 = new Button("button1");
        Button button2 = new Button("button1");
        Button button3 = new Button("button1");
        frame.setLayout(new FlowLayout(FlowLayout.LEFT));
        frame.setSize(200,300);
        frame.add(button);
        frame.add(button1);
        frame.add(button2);
        frame.add(button3);
        frame.setVisible(true);
    }
}
