import java.awt.Color;
import java.awt.Dimension;
import java.io.Serializable;
import java.util.Vector;

public class Brush extends MyGraphics implements Serializable{
    private static final long serialVersionUID = 1L;
    public Color color;
    public int size;

    public Vector<Dimension> trace;
    
    public Brush() {
        trace = new Vector<>();
        color = Color.BLACK;
        size = 12;
    }

    public boolean selected(int x, int y) {
        return true;//画笔不可选中
    }

    public void add(int x, int y) {}
}