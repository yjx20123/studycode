package Listenclick;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TestActionEvent2 {
    public static void main(String[] args) {
        //两个按钮实现同一个监听
        //开始   停止
        Frame frame = new Frame("开始-停止");
        Button start = new Button("start");
        Button stop = new Button("stop");
        stop.setActionCommand("button2-stop");
        Mymonitor mymonitor = new Mymonitor();
        start.addActionListener(mymonitor);
        stop.addActionListener(mymonitor);
        frame.add(start,BorderLayout.NORTH);
        frame.add(stop,BorderLayout.SOUTH);
        frame.pack();
        frame.setVisible(true);

    }
}
class Mymonitor implements ActionListener{
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("按钮被点击了msg"+e.getActionCommand());
    }
}
