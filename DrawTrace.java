import java.awt.event.MouseEvent;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

public class DrawTrace {
    public static void init() {
        Common.renderQueue.push(new Brush());
    }

    public static void draw(MouseEvent me) {
        Brush brush = (Brush) Common.renderQueue.top();

        brush.trace.add(new Dimension(me.getX(), me.getY()));
        Common.painterCanvas.repaint();
    }

    public static void drawTrace(Brush brush) {
        Graphics2D g2d = (Graphics2D) Common.buffer.getGraphics();
        g2d.setColor(brush.color);
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        for (int i = 1; i < brush.trace.size(); ++i) {
            int x1 = brush.trace.get(i - 1).width;
            int y1 = brush.trace.get(i - 1).height;
            int x2 = brush.trace.get(i).width;
            int y2 = brush.trace.get(i).height;
            g2d.drawLine(x1, y1, x2, y2);
        }

    }
}