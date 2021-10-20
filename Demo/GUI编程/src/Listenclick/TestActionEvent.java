package Listenclick;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class TestActionEvent  {
    public static void main(String[] args) {
        //按下按钮，触发一些事件
        Frame f1 = new Frame("事件监听");
        Button button = new Button("btn1");
        MyActionListener myActionListener = new MyActionListener();
        button.addActionListener(myActionListener);
        f1.add(button,BorderLayout.CENTER);
        f1.pack();
        f1.setVisible(true);
        windowClose(f1);
    }
    //关闭窗体的事件
    private static void windowClose(Frame frame){
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }
}
class MyActionListener implements ActionListener{
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("aaaa");
    }
}
