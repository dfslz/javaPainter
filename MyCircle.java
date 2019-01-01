import java.awt.Color;
import java.awt.Dimension;
import java.io.Serializable;

public class MyCircle extends MyGraphics implements Serializable {

    private static final long serialVersionUID = 1L;

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
}