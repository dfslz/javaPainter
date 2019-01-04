import java.io.Serializable;

public class Text extends MyGraphics implements Serializable {

    private static final long serialVersionUID = 1L;

    public String text;
    public int x, y;

    public Text() {
        x = 0;
        y = 0;
    }
}