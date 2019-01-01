import java.awt.event.*;
import javax.swing.*;

public class ToolListener extends MouseAdapter {
    @Override
    public void mouseClicked(MouseEvent me) {
        try {
            Common.tool.setSelected(false);
            Common.tool = (JToggleButton) me.getSource();
            Common.tool.setSelected(true);

            switch (Common.tool.getName()) {
            case "line":
                DrawLine.init();
                break;
            case "circle":
                DrawCircle.init();
                break;
            default:
                break;
            }
        } catch (NullPointerException npe) {
            System.out.println("工具栏没有初始化");
            System.exit(0);
        }
    }
}