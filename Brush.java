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
        for(int i = 0; i < trace.size(); ++i) {
            int w = trace.get(i).width;
            int h = trace.get(i).height;
            w = (x-w)*(x-w)+(y-h)*(y-h);
            if(w < 200) return true;
        }
        return false;
    }

    public void add(int x, int y) {
        for(int i = 0; i < trace.size(); ++i) {
            trace.get(i).width += x;
            trace.get(i).height += y;
        }
    }
}