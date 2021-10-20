package Layout;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class TestBorderLayout{
    public static void main(String[] args) {
        Frame frame = new Frame("齐天大圣");
        frame.setSize(400,500);
        Button button = new Button("east");
        Button button1 = new Button("west");
        Button button2= new Button("south");
        Button button3 = new Button("north");
        Button button4 = new Button("center");
        frame.add(button,BorderLayout.EAST);
        frame.add(button1,BorderLayout.WEST);
        frame.add(button2,BorderLayout.SOUTH);
        frame.add(button3,BorderLayout.NORTH);
        frame.add(button4,BorderLayout.CENTER);
        frame.setVisible(true);
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }
}
