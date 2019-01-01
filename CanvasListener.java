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
            default:
                System.out.println("error: unknown tool");
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
}