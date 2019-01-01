import java.awt.*;
import javax.swing.*;

//import PainterCanvas.*;

public class JavaPainter {
    public static void main(String[] args) {
        Common.painter = new JFrame("JavaPainter");

        //窗口部分及其布局BorderLayout
        Common.painter.setJMenuBar(new Menu());
        Common.painter.setLayout(new BorderLayout());
        //Common.painter.setResizable(false);//大小不可改变，为了保证双缓冲区大小一致

        //左侧工具栏及其布局
        Common.toolbar = new JPanel(new FlowLayout());
        Common.toolbar.add(new Tool(), BorderLayout.PAGE_START);
        Common.painter.add(Common.toolbar, BorderLayout.WEST);

        //右侧画布
        Common.painterCanvas = new PainterCanvas();
        Common.painterCanvas.setBackground(Color.WHITE);
        Common.painter.add(Common.painterCanvas, BorderLayout.CENTER);

        //设置关闭及显示窗口
        Common.painter.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Common.painter.setSize(1300, 800);
        Common.painter.setVisible(true);

        //初始化缓冲
        Common.initBuffer();

        //设置鼠标监听器
        CanvasListener cl = new CanvasListener();
        Common.painterCanvas.addMouseListener(cl);//这样添加不会监听动作,只监听点击等
        Common.painterCanvas.addMouseMotionListener(cl);//这样再添加只监听鼠标运动
    }
}