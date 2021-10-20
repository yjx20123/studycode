package tanchuan;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class ImageIconDemo extends JFrame {
    public ImageIconDemo(){
        //获取图片的地址
        JLabel jLabel=new JLabel("imageIcon");
        URL url=ImageIconDemo.class.getResource("1.png");
        ImageIcon imageIcon = new ImageIcon(url);
        jLabel.setIcon(imageIcon);
        jLabel.setHorizontalAlignment(SwingConstants.CENTER);
        Container contentPane = getContentPane();
        contentPane.add(jLabel);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBounds(100,100,200,290);
    }

    public static void main(String[] args) {
            new ImageIconDemo();
    }
}
