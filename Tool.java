import java.awt.*;
import java.io.File;

import javax.swing.*;

public class Tool extends JToolBar {
    private static final long serialVersionUID = 1L;

    JToggleButton select;
    JToggleButton rectangle;
    JToggleButton line;
    JToggleButton circle;
    JToggleButton polygon;
    JToggleButton triangle;

    public Tool() {
        this.setFloatable(false);//不可移动
        this.setOrientation(JToolBar.VERTICAL);//竖直排列

        //选择工具
        String path = "img" + File.separator;
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

        //多边形工具
        polygon = getIconButton(30, path+"polygon.jpeg", "polygon");
        polygon.addMouseListener(new ToolListener());
        this.add(polygon);

        //三角形工具
        triangle = getIconButton(30, path+"triangle.jpg", "triangle");
        triangle.addMouseListener(new ToolListener());
        this.add(triangle);
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