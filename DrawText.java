import java.awt.BorderLayout;
import java.awt.Dialog;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JTextField;

public class DrawText {
    public static void draw(Text text) {
        Graphics2D g2d = (Graphics2D) Common.buffer.getGraphics();
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.drawString(text.text, text.x, text.y);
    }

    public static void dialog(MouseEvent me) {
        Text text = new Text();
        text.x = me.getX();
        text.y = me.getY();

        Dialog input = new JDialog(Common.painter);
        input.setModal(true);
        input.setSize(200, 80);
        input.setLocation(500, 300);
        input.setLayout(new BorderLayout());

        JTextField jtf = new JTextField();
        input.add(jtf, BorderLayout.CENTER);
        
        JButton ok = new JButton("OK");
        ok.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getActionCommand().equals("OK")) {
                    text.text = jtf.getText();
                    input.setVisible(false);
                }
            }
        });
        input.add(ok, BorderLayout.SOUTH);
        input.setVisible(true);
        Common.renderQueue.push(text);
        Common.painterCanvas.repaint();
    }
}