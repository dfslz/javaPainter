import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dialog;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;

import javax.swing.*;

import com.sun.xml.internal.ws.handler.HandlerException;

public class DrawText {
    public static void draw(Text text) {
        Graphics2D g2d = (Graphics2D) Common.buffer.getGraphics();
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setFont(text.font);
        g2d.setColor(text.color);
        g2d.drawString(text.text, text.x, text.y);
    }

    public static void dialog(MouseEvent me) {
        Text text = new Text();
        text.x = me.getX();
        text.y = me.getY();

        // Dialog input = new JDialog(Common.painter);
        // input.setModal(true);
        // input.setSize(200, 100);
        // input.setLocation(500, 300);
        // input.setLayout(new BorderLayout());

        // JTextField jtf = new JTextField();
        // input.add(jtf, BorderLayout.NORTH);

        // JPanel cjp = new JPanel(new BorderLayout());
        // cjp.add(new JLabel("Size: "), BorderLayout.WEST);
        // JTextField tsize = new JTextField();
        // cjp.add(tsize, BorderLayout.CENTER);
        // input.add(cjp, BorderLayout.CENTER);

        // JPanel jp = new JPanel(new BorderLayout());
        
        // JButton ok = new JButton("OK");
        // ok.addActionListener(new ActionListener() {
        //     @Override
        //     public void actionPerformed(ActionEvent e) {
        //         if(e.getActionCommand().equals("OK")) {
        //             text.text = jtf.getText();
        //             text.font = new Font(text.font.getName(), text.font.getStyle(), Integer.parseInt(tsize.getText()));
        //             input.setVisible(false);
        //         }
        //     }
        // });

        // JButton scolor = new JButton("color");
        // scolor.addActionListener(new ActionListener() {
        //     @Override
        //     public void actionPerformed(ActionEvent e) {
        //         try {
        //             text.color = JColorChooser.showDialog(Common.painter, "color", Color.BLACK);
        //         } catch(HandlerException he) {
        //         }
        //     }
        // });

        // jp.add(ok, BorderLayout.WEST);
        // jp.add(scolor, BorderLayout.CENTER);
        // input.add(jp, BorderLayout.SOUTH);
        // input.setVisible(true);
        Common.showProperty(text);
        Common.renderQueue.push(text);
        Common.painterCanvas.repaint();
    }
}