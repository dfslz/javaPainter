import java.awt.*;
import java.awt.event.*;

public class DrawLine {
    private static boolean twice;
    private static MyLine line;

    public static void init() {
        twice = false;
    }

    public static void drawLine(MyLine ml) {
        Graphics2D g2d = (Graphics2D)Common.buffer.getGraphics();
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.drawLine(ml.sx, ml.sy, ml.ex, ml.ey);
    }

    public static void drawLine(MouseEvent me) {
        if (twice) {
            line.ex = me.getX();
            line.ey = me.getY();
            Common.renderQueue.push(line);
            Common.painterCanvas.repaint();
            twice = false;
        } else {
            line = new MyLine();
            line.sx = me.getX();
            line.sy = me.getY();
            twice = true;
        }
    }

    public static void preview(MouseEvent me) {
        if(!twice) return;
        Graphics2D g2d = (Graphics2D)Common.painterCanvas.getGraphics();
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.drawImage(Common.buffer, 0, 0, Common.painterCanvas);
        g2d.drawLine(line.sx, line.sy, me.getX(), me.getY());
    }
}