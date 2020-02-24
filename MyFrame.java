import javax.swing.*;
import java.awt.*;

// 视图层
// 将获得的数据进行组织，美化等，并最终向用户输出，可以直观的看到web界面
// MCV --> V   render:渲染
// 桌面+画板； 绘制工作在画板上进行
// 我要在这里进行面板绘制
public class MyFrame extends JFrame {

    private int tableWidth;
    private int tableHeight;

    // 构造函数
    public MyFrame(String title, int tableWidth, int tableHeight) {

        super(title);
        this.tableHeight = tableHeight;
        this.tableHeight = tableHeight;

        // setTitle(title);
        MyCanvas canvas = new MyCanvas();
        canvas.setPreferredSize(new Dimension(tableWidth, tableHeight));
        setContentPane(canvas); // 设置画板
        setResizable(false);
        pack();


        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

    }

    // 构造函数
    public MyFrame(String title) {
        this(title, 800, 800);
    }

    // 外部接口
    public int getTableWidth(){return tableWidth;}
    public int getTableHeight(){return tableHeight;}

    // 画板
    private class MyCanvas extends JPanel {

        @Override
        public void paintComponent(Graphics g) {

            super.paintComponent(g); // 先调用父类，以下是个性化的绘制函数。。
            Graphics2D g2d = (Graphics2D)g;

            // 抗锯齿
            RenderingHints hints = new RenderingHints(
                    RenderingHints.KEY_ANTIALIASING,
                    RenderingHints.VALUE_ANTIALIAS_ON);
            hints.put(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
            g2d.addRenderingHints(hints);

            // 绘制图案
            g2d.setColor(Color.BLUE);
            g2d.drawOval(50,50,100,100);

        }

    }

    public static void main(String[] args) {
        // write your code here

        // TODO: 20.02.23 实现动画效果

        String title = "Hello Word!";

        EventQueue.invokeLater(() -> {
            MyFrame frame = new MyFrame(title, 800, 800);
        });
    }

}
