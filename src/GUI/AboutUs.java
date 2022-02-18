package GUI;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.swing.JPanel;

import PaintTools.Painter;

public class AboutUs  extends JPanel implements  SecondGUI {
	private static final long serialVersionUID = 1L;

	private MyFrame myFrame;
	private MyPanel myPanel;
	// 返回按钮的宽度和高度
	static final int RETURN_WIDTH = 50;
	static final int RETURN_HEIGHT = 50;

	private Painter painter;// 绘画工具类
	private BufferedImage imageBuffer = null;// 缓冲的图像对象
	private Graphics gBuffer = null;// 通过它在缓冲对象中绘图

	public AboutUs(MyFrame myFrame, MyPanel myPanel) {

		this.myFrame = myFrame;
		this.myPanel = myPanel;
		// 创建主面板时，我们在此可以和绘制对象（Painter）
		painter = new Painter();

		// 初始化双缓冲所需数据
		if (this.imageBuffer == null) {
			this.imageBuffer = new BufferedImage(MyFrame.WINDOW_WIDTH, MyFrame.WINDOW_HEIGHT,
					BufferedImage.TYPE_INT_ARGB);
			this.gBuffer = this.imageBuffer.getGraphics();
		}

	}

	@Override
	public void start() throws IOException {
		
		
		
		// TODO Auto-generated method stub
        painter.drawOnePhotoOnTable(0, 0, myPanel.getWidth(), myPanel.getHeight(), "aboutUsInterface.png",
				(Graphics2D) gBuffer);

		// 把缓冲中绘制的内容绘制到主界面中
		Graphics src = myPanel.getGraphics();
		src.drawImage(imageBuffer, 0, 0, null);

		BufferedImage imageBuffer_2 = new BufferedImage(myPanel.getWidth(), myPanel.getHeight(),
				BufferedImage.TYPE_INT_ARGB);// 缓冲的图像对象
		Graphics gBuffer_2 = imageBuffer_2.getGraphics();// 通过它在缓冲对象中绘图
		painter.drawOnePhotoOnTable(0, 0, RETURN_WIDTH, RETURN_HEIGHT, "returnInterface.png", (Graphics2D) gBuffer_2);
		src.drawImage(imageBuffer_2, myPanel.getWidth() - RETURN_WIDTH, 0, null);
		// 去处上一事件的监听器
				myFrame.removeMouseListener(myFrame.gui_2);
		// 将关于我们界面的事件监听器加载在主框架中

		myFrame.addMouseListener(myFrame.gui_3_4);

	}

}
