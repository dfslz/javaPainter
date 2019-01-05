import java.awt.*;
import java.awt.event.MouseEvent;

public class DrawRectangle {
    private static boolean twice;
    private static MyRectangle rectangle;
    private static int[] x = new int[4], y = new int[4];

    public static void init() {
        twice = false;
    }

    public static void drawRectangle(MouseEvent me) {
        if (twice) {
            // 右上角
            rectangle.x.add(me.getX());
            rectangle.y.add(rectangle.y.get(0));
            // 右下角
            rectangle.x.add(me.getX());
            rectangle.y.add(me.getY());
            // 左下角
            rectangle.x.add(rectangle.x.get(0));
            rectangle.y.add(me.getY());

            Common.renderQueue.push(rectangle);
            Common.showProperty(rectangle);
            Common.painterCanvas.repaint();
            twice = false;
        } else {
            rectangle = new MyRectangle();
            rectangle.x.add(me.getX());
            x[0] = me.getX();
            rectangle.y.add(me.getY());
            y[0] = me.getY();
            twice = true;
        }
    }

    public static void preview(MouseEvent me) {
        if (!twice) {
            return;
        }
        Graphics2D g2d = (Graphics2D) Common.painterCanvas.getGraphics();
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.drawImage(Common.buffer, 0, 0, Common.painterCanvas);
        x[1] = x[0];
        y[1] = me.getY();
        x[2] = me.getX();
        y[2] = me.getY();
        x[3] = me.getX();
        y[3] = y[0];
        g2d.drawPolygon(x, y, 4);
    }
}