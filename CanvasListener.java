import java.awt.event.*;

public class CanvasListener extends MouseAdapter {
    @Override
    public void mouseClicked(MouseEvent me) {
        try {
            switch (Common.tool.getName()) {
            case "line":
                DrawLine.drawLine(me);
                break;
            case "circle":
                DrawCircle.drawCircle(me);
                break;
            case "rectangle":
                DrawRectangle.drawRectangle(me);
                break;
            case "polygon":
                DrawPolygon.drawPolygon(me);
                break;
            case "triangle":
                DrawTriangle.drawTriangle(me);
                break;
            case "text":
                DrawText.dialog(me);
                break;
            case "select":
                Pick.modify(me);
                break;
            default:
                break;
            }
        } catch (NullPointerException npe) {
            System.out.println("toolbar is not initial");
        }
    }

    @Override
    public void mouseMoved(MouseEvent me) {
        switch (Common.tool.getName()) {
        case "line":
            DrawLine.preview(me);
            break;
        case "circle":
            DrawCircle.preview(me);
            break;
        case "rectangle":
            DrawRectangle.preview(me);
            break;
        case "polygon":
            DrawPolygon.preview(me);
            break;
        case "triangle":
            DrawTriangle.preview(me);
            break;
        }
    }

    @Override
    public void mouseDragged(MouseEvent me) {
        switch (Common.tool.getName()) {
        case "pen":
            DrawTrace.draw(me);
            break;
        case "select":
            Pick.drag(me);
            break;
        default:
            break;
        }
    }

    @Override
    public void mousePressed(MouseEvent me) {
        switch (Common.tool.getName()) {
        case "pen":
            DrawTrace.init();
            break;
        case "select":
            Pick.select(me);
            break;
        default:
            break;
        }
    }

    @Override
    public void mouseReleased(MouseEvent me) {
        switch(Common.tool.getName()) {
        case "pen":
            try {
                Brush brush = (Brush) Common.renderQueue.top();
                if(brush.trace.size() < 2) {
                    Common.renderQueue.pop();
                } else {
                    Common.showProperty(Common.renderQueue.top());
                }
            } catch(Exception e) {
                //do nothing
            }
            break;
        case "select":
            Pick.init();
            break;
        default:
            break;
        }
    }
}