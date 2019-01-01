import java.awt.Color;
import java.io.Serializable;
import java.util.Vector;

public class MyTriangle extends MyPolygon implements Serializable {

    private static final long serialVersionUID = 1L;

    public MyTriangle() {
        x = new Vector<>(3);
        y = new Vector<>(3);
        color = Color.BLACK;
    }
}