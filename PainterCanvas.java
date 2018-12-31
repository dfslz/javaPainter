import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class PainterCanvas extends JPanel {

    private static final long serialVersionUID = 1L;

    public static Image img = null;

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        if(img != null) {
            g.drawImage(img, 0, 0, this);
        }
    }
}