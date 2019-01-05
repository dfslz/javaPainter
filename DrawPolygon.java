import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseEvent;

public class DrawPolygon {
    private static MyPolygon polygon;
    private static int[] x, y;
    private static int count;

    public static void init() {
        count = 0;
    }

    public static void drawPolygon(MyPolygon mp) {
        Graphics2D g2d = (Graphics2D) Common.buffer.getGraphics();
        g2d.setColor(mp.color);
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        x = new int[mp.x.size()];
        y = new int[mp.y.size()];
        for (int i = 0; i < mp.x.size(); ++i) {
            x[i] = mp.x.get(i);
            y[i] = mp.y.get(i);
        }
        if(!mp.isFilled) {
            g2d.drawPolygon(x, y, mp.x.size());
        } else {
            g2d.fillPolygon(x, y, mp.x.size());
        }
    }

    public static void drawPolygon(MouseEvent me) {
        if (me.getButton() == MouseEvent.BUTTON3 && count > 2) {// 右键
            polygon.x.add(me.getX());
            polygon.y.add(me.getY());
            Common.renderQueue.push(polygon);
            Common.showProperty(polygon);
            Common.painterCanvas.repaint();
            count = 0;
        } else if (me.getButton() == MouseEvent.BUTTON1) {// 左键
            if(count == 0) polygon = new MyPolygon();
            polygon.x.add(me.getX());
            polygon.y.add(me.getY());
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
            g2d.drawLine(polygon.x.get(0), polygon.y.get(0), me.getX(), me.getY());
        } else {
            x = new int[count + 1];
            y = new int[count + 1];
            for (int i = 0; i < count; ++i) {
                x[i] = polygon.x.get(i);
                y[i] = polygon.y.get(i);
            }
            x[count] = me.getX();
            y[count] = me.getY();
            g2d.drawPolygon(x, y, count + 1);
        }
    }
}