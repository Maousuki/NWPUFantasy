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


public class IlluBooks extends JPanel implements SecondGUI{
	/**
	 * 图鉴类，展示游戏内所有元素的信息
	 */
	private static int page=0;         //图鉴的当前所在页数
	private MyPanel myPanel;// 存放一份主窗口的引用
	private Painter painter;// 绘制类
	private MyFrame myFrame;
	// 双缓冲需要的对象
	private BufferedImage imageBuffer = null;// 缓冲的图像对象
	private Graphics gBuffer = null;// 通过它在缓冲对象中绘图

	public static int getPage() {
		return page;
	}


	public static void setPage(int page) {
		IlluBooks.page = page;
	}


	// 通过构造方法，把主窗口传入主面板一份，备用
	public IlluBooks(MyFrame myFrame,MyPanel myPanel) {
		this.myPanel = myPanel;
		this.myFrame = myFrame;
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

		myFrame.removeMouseListener(myFrame.gui_2); //移除主界面的监听器
		switch(page) {
		case 0:
			try {
				myFrame.removeMouseListener(myFrame.gui_3_2); //移除下一页按钮的监听器
				painter.drawOnePhotoOnTable(0,0,MyFrame.WINDOW_WIDTH-15,MyFrame.WINDOW_HEIGHT-46,"illu1.png",(Graphics2D)this.gBuffer);
			} catch (IOException e) {
				throw new RuntimeException("一级界面“图鉴”界面鼠标监听器异常");
			}
			break;
		case 1:
			try {
				myFrame.removeMouseListener(myFrame.gui_3_2); //移除下一页按钮的监听器
				painter.drawOnePhotoOnTable(0, 0, MyFrame.WINDOW_WIDTH - 15, MyFrame.WINDOW_HEIGHT - 46, "illu2.png",
						(Graphics2D) this.gBuffer);
			} catch (IOException e) {
				throw new RuntimeException("一级界面“图鉴”界面鼠标监听器异常");
			}
			break;
		case 2:
			try {
				myFrame.removeMouseListener(myFrame.gui_3_2); //移除下一页按钮的监听器
				painter.drawOnePhotoOnTable(0,0,MyFrame.WINDOW_WIDTH-15,MyFrame.WINDOW_HEIGHT-46,"illu3.png",(Graphics2D)this.gBuffer);
			} catch (IOException e) {
				throw new RuntimeException("一级界面“图鉴”界面鼠标监听器异常");
			}
			break;
		case 3:
			try {
				myFrame.removeMouseListener(myFrame.gui_3_2); //移除下一页按钮的监听器
				painter.drawOnePhotoOnTable(0,0,MyFrame.WINDOW_WIDTH-15,MyFrame.WINDOW_HEIGHT-46,"illu4.png",(Graphics2D)this.gBuffer);
			} catch (IOException e) {
				throw new RuntimeException("一级界面“图鉴”界面鼠标监听器异常");
			}
			break;
		}
		
		//把缓冲中绘制的内容绘制到主界面中
		Graphics src = myPanel.getGraphics();//获取当前主面板自身的绘图对象
		src.drawImage(imageBuffer, 0, 0, null);//通过这个绘图对象，把缓冲区图像的内容，一次性“复制”到主面板的可视区域
		myFrame.addMouseListener(myFrame.gui_3_2);//将图鉴界面的所有监听器加载到Frame里面
	}

}
