package jianpan;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class TestKeyListen  {
    public static void main(String[] args) {

    new KeyFrame();

    }
}
class KeyFrame extends Frame{
    public KeyFrame(){
        setBounds(1,2,300,400);
        setVisible(true);
        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                //获得键盘的
                int keyCode = e.getKeyCode();
                if(keyCode==KeyEvent.VK_UP){
                    System.out.println("你按下上建"+keyCode);
                }
            }
        });
    }

}
