import java.awt.Color;
import java.io.Serializable;
import java.util.Vector;

public class MyPolygon extends MyGraphics implements Serializable {

    private static final long serialVersionUID = 1L;

    public Vector<Integer> x;
    public Vector<Integer> y; 
    public Color color;

    public MyPolygon() {
        x = new Vector<>();
        y = new Vector<>();
        color = Color.BLACK;
    }
}