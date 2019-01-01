import java.io.Serializable;
import java.util.Vector;

public class RenderQueue implements Serializable {
    private static final long serialVersionUID = 1L;
    private Vector<MyGraphics> renderQueue;

    public RenderQueue() {
        renderQueue = new Vector<MyGraphics>();
    }

    public int size() {
        return renderQueue.size();
    }

    public void push(MyGraphics mg) {
        renderQueue.add(mg);
    }

    public void pop() {
        renderQueue.remove(renderQueue.size()-1);
    }

    public MyGraphics top() {
        return renderQueue.get(renderQueue.size() - 1);
    }

    public MyGraphics get(int position) {
        return renderQueue.get(position);
    }
}