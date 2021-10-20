package tanchuan;

import javax.swing.*;
import java.awt.*;

public class IConDemo extends JFrame implements Icon {
    private int width;
    private int height;

    public IConDemo() {
    }

    public IConDemo(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public void init() {
        IConDemo iConDemo = new IConDemo(15, 15);
        //图标放在标签，也可以放在按钮上
        JLabel jLabel = new JLabel("", iConDemo, SwingConstants.CENTER);
        Container contentPane = getContentPane();
        contentPane.add(jLabel);
        this.setVisible(true);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

    }

    public static void main(String[] args) {
        new IConDemo().init();
    }

    @Override
    public void paintIcon(Component c, Graphics g, int x, int y) {
        g.fillOval(x, y, width, height);
    }

    @Override
    public int getIconWidth() {
        return this.width;
    }

    @Override
    public int getIconHeight() {
        return this.height;
    }
}
