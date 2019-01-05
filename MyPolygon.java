import java.awt.Color;
import java.io.Serializable;
import java.util.Vector;

public class MyPolygon extends MyGraphics implements Serializable {

    private static final long serialVersionUID = 1L;
    private int l, r, t, b;

    public Vector<Integer> x;
    public Vector<Integer> y; 
    public Color color;
    public boolean isFilled;

    public MyPolygon() {
        x = new Vector<>();
        y = new Vector<>();
        color = Color.BLACK;
        isFilled = false;
    }

    public boolean selected(int x, int y) {
        l = r = this.x.get(0);
        t = b = this.y.get(0);
        for(int i = 0; i < this.x.size(); ++i) {
            if(this.x.get(i) < l) {
                l = this.x.get(i);
            } else if(this.x.get(i) > r) {
                r = this.x.get(i);
            }

            if(this.y.get(i) < t) {
                t = this.y.get(i);
            } else if(this.y.get(i) > b) {
                b = this.y.get(i);
            }
        }
        return x > l && x < r && y > t && y < b;
    }

    public void add(int x, int y) {
        for(int i = 0; i < this.x.size(); ++i) {
            this.x.set(i, this.x.get(i) + x);
            this.y.set(i, this.y.get(i) + y);
        }
    }
}