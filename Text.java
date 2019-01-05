import java.awt.Color;
import java.awt.Font;
import java.io.Serializable;

public class Text extends MyGraphics implements Serializable {

    private static final long serialVersionUID = 1L;

    public String text;
    public int x, y;
    public Font font;
    public Color color;

    public Text() {
        x = 0;
        y = 0;
        font = new Font("宋体", Font.PLAIN, 16);
    }

    public boolean selected(int x, int y) {
        int r2 = (x - this.x)*(x - this.x) + (y - this.y)*(y - this.y);
        if(r2 < 200) return true;
        return false;
    }

    @Override
    public void add(int x, int y) {
        this.x += x;
        this.y += y;
    }
}