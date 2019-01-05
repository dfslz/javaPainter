import java.io.Serializable;

/**
 * MyGraphics是我所有图形的父类
 * @author 东北大学计算机1606班罗智
 */

public abstract class MyGraphics implements Serializable {

    private static final long serialVersionUID = 1L;

    abstract public boolean selected(int x, int y);//是否选中
    abstract public void add(int x, int y);//设置位置
}