import java.awt.event.MouseEvent;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.lang.Math;

public class DrawCircle {
    private static boolean twice;
    private static MyCircle circle;

    public static void init() {
        twice = false;
    }

    public static void drawCircle(MyCircle mc) {
        Graphics2D g2d = (Graphics2D) Common.buffer.getGraphics();
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.drawOval(mc.center.width, mc.center.height, mc.radius, mc.radius);
    }

    public static void drawCircle(MouseEvent me) {
        if (twice) {
            int lenx = me.getX() - circle.center.width;
            int leny = me.getY() - circle.center.height;
            int len = lenx * lenx + leny * leny;
            circle.radius = (int) Math.rint(Math.sqrt(len));
            Common.renderQueue.push(circle);
            Common.painterCanvas.repaint();;
            twice = false;
        } else {
            circle = new MyCircle();
            circle.center = new Dimension(me.getX(), me.getY());
            twice = true;
        }
    }

    public static void preview(MouseEvent me) {
        if (!twice)
            return;
        Graphics2D g2d = (Graphics2D) Common.painterCanvas.getGraphics();
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.drawImage(Common.buffer, 0, 0, Common.painterCanvas);

        int lenx = me.getX() - circle.center.width;
        int leny = me.getY() - circle.center.height;
        int len = lenx * lenx + leny * leny;
        int radius = (int) Math.rint(Math.sqrt(len));
        g2d.drawOval(circle.center.width, circle.center.height, radius, radius);
    }
}