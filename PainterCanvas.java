import java.awt.*;
import javax.swing.*;

public class PainterCanvas extends JPanel {

    private static final long serialVersionUID = 1L;

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        if(Common.buffer != null) {
            Common.rendering();
            g.drawImage(Common.buffer, 0, 0, Common.painterCanvas);
        }
    }
}