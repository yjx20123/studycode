package tanchuan;

import javax.swing.*;
import java.awt.*;

public class TestComboboxDemo1 extends JFrame {
    public TestComboboxDemo1(){
        Container container = this.getContentPane();
        JComboBox jComboBox = new JComboBox();
        jComboBox.addItem("正在上映");
        jComboBox.addItem("热映");
        jComboBox.addItem("即将上市");
        container.add(jComboBox);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new TestComboboxDemo1();
    }
}
