import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Tool extends JToolBar {
    private static final long serialVersionUID = 1L;

    public Tool() {
        this.setFloatable(false);//不可移动
        this.setOrientation(JToolBar.VERTICAL);//竖直排列

        this.add(getIconButton(30, "src/select.jpeg", "select"));
        this.add(getIconButton(30, "src/rectangle.jpg", "rectangle"));
    }

    public JToggleButton getIconButton(int size, String file, String note) {
        ImageIcon imgicon = new ImageIcon(file);
        Image img = imgicon.getImage().getScaledInstance(size, size, Image.SCALE_DEFAULT);
        JToggleButton jb = new JToggleButton(new ImageIcon(img));
        jb.setToolTipText(note);
        return jb;
    }
}