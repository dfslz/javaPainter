import java.awt.event.MouseEvent;

public class Pick {
    private static MyGraphics picked;
    private static int x, y;

    public static void init() {
        picked = null;
    }

    public static void select(MouseEvent me) {
        for(int i = Common.renderQueue.size() - 1; i >= 0; --i) {
            if(Common.renderQueue.get(i).selected(me.getX(), me.getY())) {
                picked = Common.renderQueue.get(i);
                break;
            }
        }
        x = me.getX();
        y = me.getY();
    }

    public static void modify(MouseEvent me) {
        for(int i = Common.renderQueue.size() - 1; i >= 0; --i) {
            if(Common.renderQueue.get(i).selected(me.getX(), me.getY())) {
                picked = Common.renderQueue.get(i);
                break;
            }
        }
        Common.showProperty(picked);
        picked = null;
    }

    public static void drag(MouseEvent me) {
        if(picked != null) {
            picked.add(me.getX() - x, me.getY() - y);
            Common.painterCanvas.repaint();
        }
        x = me.getX();
        y = me.getY();
    }
}