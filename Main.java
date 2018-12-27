import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        JFrame painter = new JFrame("javaPainter");
        painter.setJMenuBar(new Menu());
        painter.setLayout(new BorderLayout());

        JPanel tool = new JPanel(new BorderLayout());
        tool.add(new Tool(), BorderLayout.PAGE_START);
        painter.add(tool, BorderLayout.WEST);

        JPanel painterCanvas = new JPanel();
        painterCanvas.setBackground(Color.WHITE);
        painter.add(painterCanvas, BorderLayout.CENTER);

        painter.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        painter.setSize(1000, 800);
        painter.setVisible(true);
    }
}