package calc;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class TestCalc {
    public static void main(String[] args) {
        new Calculator();
    }
}

//计算器类
public class Calculator extends Frame {
    public Calculator() {
        TextField field = new TextField(10);
        TextField field2 = new TextField(10);
        TextField field3 = new TextField(20);
        //一个按钮
        Button button = new Button("=");
        //添加一个监听
        button.addActionListener(new myCalculatorListener(field, field2, field3));
        //一个标签
        Label label = new Label("+");
        //布局
        setLayout(new FlowLayout());
        add(field);
        add(label);
        add(field2);
        add(button);
        add(field3);
        pack();
        setVisible(true);
    }


}

class myCalculatorListener implements ActionListener {
    private TextField num1;
    private TextField num2;
    private TextField num3;
    Calculator calculator;
    public myCalculatorListener(TextField num1, TextField num2, TextField num3) {
        this.num1 = num1;
        this.num2 = num2;
        this.num3 = num3;
    }
    public  myCalculatorListener(Calculator calculator){
        this.calculator=calculator;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //1、获得加数和被加数
        //2、将这个值+法运算后，放到第三个框

        int n1 = Integer.parseInt(num1.getText());
        int n2 = Integer.parseInt(num2.getText());
        num3.setText("" + (n1 + n2));
        //清除前两个框
        num1.setText("");
        num2.setText("");
    }
}