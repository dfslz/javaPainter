import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import javax.swing.filechooser.FileFilter;

public class Menu extends JMenuBar {
    private static final long serialVersionUID = 1L;
    //菜单
    JMenu file = new JMenu("File");
    JMenu edit = new JMenu("Edit");
    JMenu help = new JMenu("Help");
    //项
    JMenuItem open = new JMenuItem("Open");
    JMenuItem close = new JMenuItem("Close");
    JMenuItem save = new JMenuItem("Save");

    public Menu() {
        //File
        open.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(e.getActionCommand().equals("Open")) {
                    JFileChooser fc = new JFileChooser();
                    //fc.setFileFilter(new JNotepadFileFilter());
                    int op = fc.showOpenDialog(JavaPainter.painter);
                }
            }
        });
        file.add(open);
        file.add(close);
        this.add(file);
        //Edit
        this.add(edit);
        //Help
        this.add(help);
    }
}