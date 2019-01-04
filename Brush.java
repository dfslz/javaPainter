import java.awt.Dimension;
import java.io.Serializable;
import java.util.Vector;

public class Brush extends MyGraphics implements Serializable{
    private static final long serialVersionUID = 1L;
    public Vector<Dimension> trace;
    
    public Brush() {
        trace = new Vector<>();
    }
}