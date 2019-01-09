import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseEvent;

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
        Common.showProperty(text);
        Common.renderQueue.push(text);
        Common.painterCanvas.repaint();
    }
}