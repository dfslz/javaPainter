import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseEvent;

public class DrawTriangle {
    private static MyTriangle triangle;
    private static int[] x, y;
    private static int count;

    public static void init() {
        count = 0;
    }

    public static void drawTriangle(MouseEvent me) {
        if(count == 2) {
            triangle.x.add(me.getX());
            triangle.y.add(me.getY());
            Common.renderQueue.push(triangle);
            Common.showProperty(triangle);
            Common.painterCanvas.repaint();
            count = 0;
        } else {
            if(count == 0) triangle = new MyTriangle();
            triangle.x.add(me.getX());
            triangle.y.add(me.getY());
            ++count;
        }
    }

    public static void preview(MouseEvent me) {
        if (count < 1) {
            return;
        }
        Graphics2D g2d = (Graphics2D) Common.painterCanvas.getGraphics();
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.drawImage(Common.buffer, 0, 0, Common.painterCanvas);

        if (count < 2) {
            g2d.drawLine(triangle.x.get(0), triangle.y.get(0), me.getX(), me.getY());
        } else {
            x = new int[count + 1];
            y = new int[count + 1];
            for (int i = 0; i < count; ++i) {
                x[i] = triangle.x.get(i);
                y[i] = triangle.y.get(i);
            }
            x[count] = me.getX();
            y[count] = me.getY();
            g2d.drawPolygon(x, y, count + 1);
        }
    }
}