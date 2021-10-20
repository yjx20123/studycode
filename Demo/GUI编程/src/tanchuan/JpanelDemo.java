package tanchuan;

import jianpan.JFrameDemo;

import javax.swing.*;
import java.awt.*;

public class JpanelDemo extends JFrame {
       public JpanelDemo(){
//           JFrame jFrame = new JFrame();
           Container container = new Container();
           container.add(new Label("dfasdf"));
//           jFrame.add(new Button("sfasdfa"));
           setVisible(true);
       }

    public static void main(String[] args) {
        new JpanelDemo();
    }
}
