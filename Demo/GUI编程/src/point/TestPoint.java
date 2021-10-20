package point;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Iterator;

public class TestPoint {
    public static void main(String[] args) {
        new MyFrame("画画");
    }
}
class MyFrame extends Frame{
    ArrayList points;
    //监听鼠标当前的位置
    public MyFrame(String title){
        super(title);
        setBounds(200,200,600,400);
        points=new ArrayList<>();
        //鼠标监听器，正对这个窗口
        this.addMouseListener(new MyMouseListener());
    }

    @Override
    public void paint(Graphics g) {
        //画画，监听鼠标的事件
        Iterator iterator = points.iterator();
        while (iterator.hasNext()){
            Point point = (Point) iterator.next();
            g.setColor(Color.black);
            g.fillOval(point.x,point.y,10,10);
        }
    }
    //添加一个点到界面上
    public void addPaint(Point point){
        points.add(point);
    }
    //适配器模式
    private class MyMouseListener extends MouseAdapter{
        //鼠标，按下，弹起，按住不放
        @Override
        public void mousePressed(MouseEvent e) {
            MyFrame frame = (MyFrame) e.getSource();
            frame.addPaint(new Point(e.getX(),e.getY()));
            frame.repaint();
        }


    }
}
