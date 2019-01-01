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
}