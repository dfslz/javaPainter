import java.awt.event.*;
import java.io.File;

import javax.swing.*;
import javax.swing.filechooser.FileFilter;

public class Menu extends JMenuBar {
    private static final long serialVersionUID = 1L;
    // 菜单
    JMenu file = new JMenu("File");
    JMenu edit = new JMenu("Edit");
    JMenu help = new JMenu("Help");
    // 项
    JMenuItem open = new JMenuItem("Open");
    JMenuItem close = new JMenuItem("Close");
    JMenuItem save = new JMenuItem("Save");

    JMenuItem undo = new JMenuItem("Undo");
    JMenuItem redo = new JMenuItem("Redo");

    public Menu() {
        // File
        open.addActionListener(menuAction);
        file.add(open);

        save.addActionListener(menuAction);
        file.add(save);

        close.addActionListener(menuAction);
        file.add(close);

        this.add(file);

        // Edit
        undo.addActionListener(menuAction);
        edit.add(undo);
        redo.addActionListener(menuAction);
        edit.add(redo);

        this.add(edit);

        // Help
        this.add(help);
    }

    FileFilter filter = new FileFilter() {
        @Override
        public boolean accept(File f) {
            if (f.isDirectory())
                return true;
            return f.getName().endsWith("jp");
        }

        @Override
        public String getDescription() {
            return ".jp";
        }
    };

    ActionListener menuAction = new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getActionCommand().equals("Open")) {
                JFileChooser fc = new JFileChooser();
                fc.setFileFilter(filter);
                int ok = fc.showOpenDialog(Common.painter);
                if (ok == JFileChooser.APPROVE_OPTION) {
                    Common.currentFile = fc.getSelectedFile();
                } else {
                    return;
                }
                if (Common.currentFile != null) {
                    Common.open();
                    Common.history = new RenderQueue();
                }
            } else if (e.getActionCommand().equals("Close")) {
                Common.initBuffer();
                Common.currentFile = null;
                Common.renderQueue = new RenderQueue();
                Common.history = new RenderQueue();
                Common.painterCanvas.repaint();
            } else if (e.getActionCommand().equals("Save")) {
                if (Common.currentFile == null) {
                    JFileChooser fc = new JFileChooser();
                    fc.setFileFilter(filter);
                    int ok = fc.showSaveDialog(Common.painter);
                    if (ok == JFileChooser.APPROVE_OPTION) {
                        Common.currentFile = fc.getSelectedFile();
                    } else {
                        return;
                    }
                }
                if (Common.currentFile != null) {
                    Common.save();
                }
            } else if (e.getActionCommand().equals("Undo")) {
                if (Common.renderQueue.size() > 0) {
                    Common.history.push(Common.renderQueue.top());
                    Common.renderQueue.pop();
                    Common.painterCanvas.repaint();
                }
            } else if (e.getActionCommand().equals("Redo")) {
                if (Common.history.size() > 0) {
                    Common.renderQueue.push(Common.history.top());
                    Common.history.pop();
                    Common.painterCanvas.repaint();
                }
            }
        }
    };

}