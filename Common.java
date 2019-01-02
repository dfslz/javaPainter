import java.awt.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import javax.swing.*;

public class Common {
    public static JFrame painter;//画板窗口
    public static JPanel toolbar;//工具栏
    public static PainterCanvas painterCanvas;//画布
    public static Image buffer;//缓冲区
    public static JToggleButton tool;//当前选中的工具
    public static RenderQueue renderQueue = new RenderQueue();//渲染队列
    public static RenderQueue history = new RenderQueue();
    public static File currentFile;//当前编辑的文件

    public static void setTool(JToggleButton _tool) {//设置工具
        Common.tool = _tool;
        Common.tool.setSelected(true);
    }

    public static void rendering() {//渲染缓冲区图像
        Dimension d = Common.painterCanvas.getSize();
        Graphics gg = Common.buffer.getGraphics();
        gg.setColor(Color.WHITE);
        gg.fillRect(0, 0, d.width, d.height);//设置缓冲区背景色,即清屏

        for(int i = 0; i < Common.renderQueue.size(); ++i) {//循环渲染每一个对象
            MyGraphics mg = renderQueue.get(i);

            if(mg instanceof MyLine) {
                DrawLine.drawLine((MyLine)mg);
            } else if(mg instanceof MyCircle) {
                DrawCircle.drawCircle((MyCircle)mg);
            } else if(mg instanceof MyRectangle) {
                //DrawRectangle.drawRectangle((MyRectangle)mg);
                DrawPolygon.drawPolygon((MyPolygon)mg);
            } else if(mg instanceof MyPolygon) {
                DrawPolygon.drawPolygon((MyPolygon)mg);
            } else if(mg instanceof MyTriangle) {
                DrawPolygon.drawPolygon((MyPolygon)mg);
            }
        }
    }

    public static void save() {//序列化文件保存
        try {
            FileOutputStream fout = new FileOutputStream(currentFile);
            ObjectOutputStream ofout = new ObjectOutputStream(fout);
            ofout.writeObject(Common.renderQueue);
            ofout.close();
            fout.close();
        } catch(FileNotFoundException fnfe) {
            System.out.println("file not exist! please choose file again!");
        } catch(IOException ioe) {
            System.out.println("object serialize failed!");
        }
    }

    public static void open() {//打开保存的文件
        try {
            FileInputStream fin = new FileInputStream(currentFile);
            ObjectInputStream ofin = new ObjectInputStream(fin);
            Common.renderQueue = (RenderQueue)ofin.readObject();
            ofin.close();
            fin.close();
        } catch(FileNotFoundException fnfe) {
            System.out.println("File not exist!");
        } catch(IOException ioe) {
            System.out.println("File open failed!");
        } catch(ClassNotFoundException cnfe) {
            System.out.println("File has been modified illegal! can not open again!");
        }

        Common.painterCanvas.repaint();
    }

    public static void initBuffer() {//初始化buffer
        Dimension d = Common.painterCanvas.getSize();
        Common.buffer = Common.painter.createImage(d.width, d.height);//创建双缓冲区
        Graphics gg = Common.buffer.getGraphics();
        gg.setColor(Color.WHITE);
        gg.fillRect(0, 0, d.width, d.height);//设置缓冲区背景色
    }
}