import java.awt.*;
import java.io.File;

import javax.swing.*;

public class Tool extends JToolBar {
    private static final String IMG = "img";

    private static final long serialVersionUID = 1L;

    JToggleButton select;
    JToggleButton rectangle;
    JToggleButton line;
    JToggleButton circle;

    public Tool() {
        this.setFloatable(false);//不可移动
        this.setOrientation(JToolBar.VERTICAL);//竖直排列

        //选择工具
        String path = IMG + File.separator;
        select = getIconButton(30, path+"select.jpeg", "select");
        select.addMouseListener(new ToolListener());
        this.add(select);

        Common.setTool(select);//初始化工具栏监听器默认工具

        //矩形工具
        rectangle = getIconButton(30, path+"rectangle.jpg", "rectangle");
        rectangle.addMouseListener(new ToolListener());
        this.add(rectangle);

        //直线工具
        line = getIconButton(30, path+"line.jpeg", "line");
        line.addMouseListener(new ToolListener());
        this.add(line);

        //圆形工具
        circle = getIconButton(30, path+"circle.png", "circle");
        circle.addMouseListener(new ToolListener());
        this.add(circle);
    }

    public JToggleButton getIconButton(int size, String file, String note) {
        ImageIcon imgicon = new ImageIcon(file);
        Image img = imgicon.getImage().getScaledInstance(size, size, Image.SCALE_DEFAULT);
        JToggleButton jb = new JToggleButton(new ImageIcon(img));
        jb.setToolTipText(note);
        jb.setName(note);
        return jb;
    }
}