import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;

public class AlgoFrame extends JFrame {
    private int canvasWidth;
    private int canvasHeight;

    private JPanel canvas;

    public AlgoFrame(String title, int canvasWidth, int canvasHeight) { // 构造函数
        super(title); // super指向父类

        this.canvasWidth = canvasWidth;
        this.canvasHeight = canvasHeight;

        AlgoCanvas canvas = new AlgoCanvas();
        setContentPane(canvas); // 设置窗口内容面板(canvas)
        pack(); // 自动布局，调整窗口大小

        setResizable(false); // 方便起见，不允许用户改变窗口形状
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 退出自动关闭

        setVisible(true); //  显示窗口。安全起见，要放在最后面
    }

    public AlgoFrame(String title) {
        this(title, 1024, 768);
    }

    public int getCanvasWidth() {return canvasWidth;} // 外部接口
    public int getCanvasHeight() {return canvasHeight;}

    private Circle[] circles;
    public void render(Circle[] circles) {
        this.circles = circles;
        repaint(); // JFrame提供的函数, 重新刷新
    }

    private class AlgoCanvas extends JPanel { // 画板私有类  // JPanel默认支持双缓存

        public AlgoCanvas() {  // 可写可不写
            super(true);
        }

        @Override
        public void paintComponent(Graphics g) { // 覆盖原函数
            super.paintComponent(g);

            Graphics2D g2d = (Graphics2D)g; // 将 Graphics 转换成 Graphics2D ; 强制类型转换

            // 抗锯齿
            RenderingHints hints = new RenderingHints(
                                            RenderingHints.KEY_ANTIALIASING,
                                            RenderingHints.VALUE_ANTIALIAS_ON);
            hints.put(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
            g2d.addRenderingHints(hints);

            // 具体绘制
            AlgoVisHelper.setStrokeWidth(g2d, 1);
            AlgoVisHelper.setColor(g2d, Color.RED);
            for(Circle circle: circles) // 遍历circles中的每一个元素
                AlgoVisHelper.strokeCircle(g2d, circle.x, circle.y, circle.getR());

        }

        @Override
        public Dimension getPreferredSize() { // 自动调用，设置画布大小
            return new Dimension(canvasWidth,canvasHeight);
        }
    }
}
