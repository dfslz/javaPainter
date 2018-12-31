import java.awt.*;
import java.awt.event.*;

public class CanvasListener extends MouseAdapter {
    private int sx, sy, ex, ey;//开始结束的(x, y)坐标
    private Graphics g;
    private boolean twice = false;

    public void setG(Graphics g) {
        this.g = g;
    }

    @Override
    public void mouseClicked(MouseEvent me) {
        if(twice) {
            ex = me.getX();
            ey = me.getY();
            g.drawLine(sx, sy, ex, ey);
            
            try {
                Graphics og = PainterCanvas.img.getGraphics();
                og.drawLine(sx, sy, ex, ey);
            } catch(NullPointerException ne) {//如果缓冲区为空则出错，输出错误信息退出
                System.out.println(ne.getMessage());
                System.exit(0);
            }
            twice = false;
        } else {
            sx = me.getX();
            sy = me.getY();
            twice = true;
        }
    }
}