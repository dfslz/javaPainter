import java.awt.Color;
import java.awt.Dimension;
import java.io.Serializable;

public class MyCircle extends MyGraphics implements Serializable {

    private static final long serialVersionUID = 1L;
    private int l, r, t, b;

    public int radius;
    public Dimension center;
    public boolean isFilled;
    public Color color;

    public MyCircle() {
        radius = 0;
        center = new Dimension(-1, -1);
        isFilled = false;
        color = Color.BLACK;
    }

    public boolean selected(int x, int y) {
        //按照椭圆右上角为center
        l = center.width;
        r = center.width + radius;
        t = center.height;
        b = center.height + radius;
        return x > l && x < r && y > t && y < b;
    }

    @Override
    public void add(int x, int y) {
        center.width += x;
        center.height += y;
    }
}