package tanchuan;

import javax.swing.*;
import java.awt.*;
import java.util.Vector;

public class TestComboboxDemo03 extends JFrame {
    public TestComboboxDemo03(){
        Container container = getContentPane();

        TextField field = new TextField("hello");
        TextField field1 = new TextField("world",20);
        JPasswordField jPasswordField = new JPasswordField();
        jPasswordField.setEchoChar('*');
        container.add(jPasswordField,BorderLayout.CENTER);
        container.add(field,BorderLayout.NORTH);
        container.add(field1,BorderLayout.SOUTH);
        setVisible(true);
        setSize(400,300);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);


    }

    public static void main(String[] args) {
        new TestComboboxDemo03();
    }
}
