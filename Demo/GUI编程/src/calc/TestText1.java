package calc;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TestText1 {
    public static void main(String[] args) {
        //启动
    new MyFrame();
    }
}
class MyFrame extends Frame{
    public MyFrame(){
        TextField textField = new TextField();
        add(textField);
        //监听文本框输入的数字
        MyActionListener2 myActionListener2 = new MyActionListener2();
        textField.addActionListener(myActionListener2);
        //设置替换编码
        textField.setEchoChar('*');
        setVisible(true);
        pack();
    }
}
class MyActionListener2 implements ActionListener{

    @Override
    public void actionPerformed(ActionEvent e) {
      TextField field= (TextField) e.getSource();//获得一些资源
        System.out.println(field.getText());
        field.setText("");//null是一个对象，空是一个字符串
    }
}
