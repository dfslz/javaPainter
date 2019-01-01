import java.awt.Color;
import java.io.Serializable;
import java.util.Vector;

public class MyRectangle extends MyPolygon implements Serializable {
    private static final long serialVersionUID = 1L;

    public MyRectangle() {
        x = new Vector<>(4);//初始化成只有４个大小的点
        y = new Vector<>(4);
        color = Color.BLACK;
    }
}