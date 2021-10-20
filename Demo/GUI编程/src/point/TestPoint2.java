package point;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class TestPoint2 {
    public static void main(String[] args) {
        WindowFrame windowFrame = new WindowFrame();
        windowFrame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                System.exit(0);
                System.out.println("guanbi");
            }
        });
    }
}
class WindowFrame extends Frame{
    public WindowFrame(){
        setBounds(100,100,400,400);
        setBackground(Color.LIGHT_GRAY);
        setVisible(true);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowOpened(WindowEvent e) {
                System.out.println("窗口已打开！！！");
            }

            @Override
            public void windowClosing(WindowEvent e) {
                System.out.println("windowClosing");
            }

            @Override
            public void windowClosed(WindowEvent e) {

                System.out.println("windowClosed");System.exit(0);
            }

            @Override
            public void windowIconified(WindowEvent e) {
                System.out.println("windowIconified");
            }

            @Override
            public void windowDeiconified(WindowEvent e) {
                super.windowDeiconified(e);
            }

            @Override
            public void windowActivated(WindowEvent e) {
                super.windowActivated(e);
            }

            @Override
            public void windowDeactivated(WindowEvent e) {
                super.windowDeactivated(e);
            }

            @Override
            public void windowStateChanged(WindowEvent e) {
                super.windowStateChanged(e);
            }

            @Override
            public void windowGainedFocus(WindowEvent e) {
                super.windowGainedFocus(e);
            }

            @Override
            public void windowLostFocus(WindowEvent e) {
                super.windowLostFocus(e);
            }
        });
    }
}
