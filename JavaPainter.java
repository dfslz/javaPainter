import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
//import PainterCanvas.*;

public class JavaPainter {
    static JFrame painter = new JFrame("javaPainter");
    public static void main(String[] args) {
        //窗口部分及其布局BorderLayout
        painter.setJMenuBar(new Menu());
        painter.setLayout(new BorderLayout());
        painter.setResizable(false);//大小不可改变，为了保证双缓冲区大小一致

        //左侧工具栏及其布局
        JPanel tool = new JPanel(new FlowLayout());
        tool.add(new Tool(), BorderLayout.PAGE_START);
        painter.add(tool, BorderLayout.WEST);

        //右侧画布
        PainterCanvas painterCanvas = new PainterCanvas();
        painter.add(painterCanvas, BorderLayout.CENTER);

        //设置关闭及显示窗口
        painter.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        painter.setSize(1000, 800);
        painter.setVisible(true);

        //创建缓冲
        Dimension d = painterCanvas.getSize();
        PainterCanvas.img = painter.createImage(d.width, d.height);//创建双缓冲区
        Graphics gg = PainterCanvas.img.getGraphics();
        gg.setColor(Color.WHITE);
        gg.fillRect(0, 0, d.width+1, d.height+1);//设置缓冲区背景色

        //设置鼠标监听器
        Graphics g = painterCanvas.getGraphics();
        CanvasListener cl = new CanvasListener();
        cl.setG(g);//用于捕获动作绘图
        painterCanvas.addMouseListener(cl);
    }
}