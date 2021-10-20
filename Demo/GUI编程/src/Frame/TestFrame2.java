package Frame;

import java.awt.*;

public class TestFrame2  {
    public static void main(String[] args) {
       MyFrame myFrame = new MyFrame(100,100,200,200,Color.black);
       MyFrame myFrame1 = new MyFrame(300,100,200,200,Color.orange);
       MyFrame myFrame2 = new MyFrame(300,200,200,200,Color.yellow);
       MyFrame myFrame3= new MyFrame(400,400,200,200,Color.orange);

    }
}
class MyFrame extends Frame{
    static int id=0;//可能存在多个窗口
    public MyFrame(int x,int y,int w,int h,Color color){
        super("myframe"+(++id));
        setBackground(color);
        setBounds(x,y,w,h);
        setVisible(true);
        setResizable(false);
    }
}
