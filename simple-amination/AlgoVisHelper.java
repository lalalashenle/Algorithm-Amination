import java.awt.*;
import java.awt.geom.Ellipse2D;

public class AlgoVisHelper {

    private AlgoVisHelper() {} // 设置成私有类，直接调用

    public static void setStrokeWidth(Graphics2D g2d, int w) {
        int strokeWidth = w;
        g2d.setStroke(new BasicStroke(strokeWidth, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
    }

    public static void setColor(Graphics2D g2d, Color color) {
        g2d.setColor(color);
    }

    public static void strokeCircle(Graphics2D g2d, int x, int y, int r) { // 圆心，半径,空心

        Ellipse2D circle = new Ellipse2D.Double(x-r, y-r, 2*r, 2*r);
        g2d.draw(circle);
    }

    public static void filCircle(Graphics2D g2d, int x, int y, int r) { // 圆心，半径，实心

        Ellipse2D circle = new Ellipse2D.Double(x-r, y-r, 2*r, 2*r);
        g2d.fill(circle);
    }

    public static void pause(int t) {

        try{
            Thread.sleep(t);
        }
        catch (InterruptedException e){
            System.out.println("Error in sleeping.");
        }
    }

}
