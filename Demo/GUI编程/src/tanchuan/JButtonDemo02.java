package tanchuan;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class JButtonDemo02  extends JFrame {
    public JButtonDemo02(){
        Container contentPane = this.getContentPane();
        JCheckBox jCheckBox = new JCheckBox("1");
        JCheckBox jCheckBox1 = new JCheckBox("2");
        contentPane.add(jCheckBox,BorderLayout.NORTH);
        contentPane.add(jCheckBox1,BorderLayout.SOUTH);
        this.setVisible(true);
        this.setSize(500,500);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    }

    public static void main(String[] args) {
        new JButtonDemo02();
    }
}
