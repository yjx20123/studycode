package jianpan;

import javax.swing.*;

public class JFrameDemo {
    //初始化

    public void init(){
        JFrame jFrame = new JFrame("这是一个Jframe窗口");
        jFrame.setVisible(true);
        jFrame.setBounds(100,100,200,200);
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        JLabel jLabel = new JLabel("欢迎来到天宫！！！");
        jFrame.add(jLabel);
    }

    public static void main(String[] args) {
        new JFrameDemo().init();
    }
}
