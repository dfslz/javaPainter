import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import javax.swing.*;

import com.sun.xml.internal.ws.handler.HandlerException;

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
                DrawPolygon.drawPolygon((MyPolygon)mg);
            } else if(mg instanceof MyPolygon) {
                DrawPolygon.drawPolygon((MyPolygon)mg);
            } else if(mg instanceof MyTriangle) {
                DrawPolygon.drawPolygon((MyPolygon)mg);
            } else if(mg instanceof Brush) {
                DrawTrace.drawTrace((Brush)mg);
            } else if(mg instanceof Text) {
                DrawText.draw((Text)mg);
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

    private static Font font;
    private static String string;
    private static int size;
    private static Color color;
    private static boolean isFilled;
    public static void showProperty(MyGraphics mg) {
        Dialog input = new Dialog(Common.painter);
        input.setModal(true);
        input.setSize(300, 120);
        input.setLocation(500, 300);
        input.setLayout(new BorderLayout());

        JTextField jtf = new JTextField("在这里填字符串");
        input.add(jtf, BorderLayout.NORTH);

        JPanel cjp = new JPanel(new BorderLayout());
        cjp.add(new JLabel("Size: "), BorderLayout.WEST);
        JTextField tsize = new JTextField("18");
        cjp.add(tsize, BorderLayout.CENTER);
        input.add(cjp, BorderLayout.CENTER);

        JPanel jp = new JPanel(new BorderLayout());
        
        JButton ok = new JButton("OK");
        ok.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getActionCommand().equals("OK")) {
                    string = jtf.getText();
                    size = Integer.parseInt(tsize.getText());
                    font = new Font("宋体", Font.PLAIN, size);
                    input.setVisible(false);
                }
            }
        });

        JButton scolor = new JButton("color");
        scolor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    color = JColorChooser.showDialog(Common.painter, "color", Color.BLACK);
                } catch(HandlerException he) {
                }
            }
        });

        jp.add(ok, BorderLayout.WEST);
        jp.add(scolor, BorderLayout.CENTER);
        jp.add(new JLabel("注意：设置只对拥有该属性的对象有效"), BorderLayout.SOUTH);
        JToggleButton jtb = new JToggleButton("填充");
        isFilled = false;
        jtb.setSelected(false);
        jtb.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent me) {
                JToggleButton tb = (JToggleButton)me.getSource();
                tb.setSelected(tb.isSelected());
                isFilled = tb.isSelected();
            }
        });
        input.add(jtb, BorderLayout.EAST);
        input.add(jp, BorderLayout.SOUTH);
        input.setVisible(true);

        if(mg instanceof MyLine) {
            ((MyLine)mg).color = color;
        } else if(mg instanceof MyCircle) {
            ((MyCircle)mg).color = color;
            ((MyCircle)mg).isFilled = isFilled;
        } else if(mg instanceof MyRectangle) {
            ((MyRectangle)mg).color = color;
            ((MyRectangle)mg).isFilled = isFilled;
        } else if(mg instanceof MyPolygon) {
            ((MyPolygon)mg).color = color;
            ((MyPolygon)mg).isFilled = isFilled;
        } else if(mg instanceof MyTriangle) {
            ((MyTriangle)mg).color = color;
            ((MyTriangle)mg).isFilled = isFilled;
        } else if(mg instanceof Brush) {
            ((Brush)mg).color = color;
        } else if(mg instanceof Text) {
            ((Text)mg).color = color;
            ((Text)mg).text = string;
            ((Text)mg).font = font;
        }

        Common.painterCanvas.repaint();
    }
}