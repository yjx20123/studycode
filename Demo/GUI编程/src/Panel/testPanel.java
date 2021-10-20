package Panel;

import java.awt.*;

//Panel可以看成一个空间，但是不能单独存在
public class testPanel {
    public static void main(String[] args) {
        Frame frame = new Frame();
        Frame frame1= new Frame();
        Panel panel = new Panel();
        frame.setLayout(null);
         //坐标
        frame.setBounds(300,300,500,500);
        frame.setBackground(Color.cyan);
        //panel设置坐标，想当于frame
        panel.setBounds(50,50,400,400);
        panel.setBackground(Color.pink);
        frame.add(panel);
        panel.add(new Button("btn1"));



        frame.setVisible(true);

    }

}
