import java.awt.Color;
import java.io.Serializable;

public class MyLine extends MyGraphics implements Serializable {

    private static final long serialVersionUID = 1L;
    
    public int sx, sy, ex, ey;
    public Color color;

    public MyLine() {
        sx = sy = ex = ey = -1;
        color = Color.BLACK;
    }

    public boolean selected(int x, int y) {
        int minx = sx < ex ? sx : ex;
        int miny = sy < ey ? sy : ey;
        int maxx = sx > ex ? sx : ex;
        int maxy = sy > ey ? sy : ey;
        return x > minx && x < maxx && y > miny && y < maxy;
    }

    public void add(int x, int y) {
        sx += x;
        sy += y;
        ex += x;
        ey += y;
    }
}