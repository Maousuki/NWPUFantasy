package GUI;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.swing.JPanel;
import PaintTools.Painter;

//import com.chinasofti.xian.tetris.Painter;
//import com.chinasofti.xian.tetris.Table;

/**
 * 游戏主面板，所有游戏内容会“绘制”到此面板中，它也负责游戏的控制（界面控制后台）<br>
 * 主面板，负责找到数据（Table），命令画家（Painter）绘制数据，到面板中
 * @author Administrator
 *
 */
public class ChooseLevel extends JPanel implements SecondGUI{
	private MyFrame myFrame;//存放一份主窗口的引用
	private MyPanel myPanel;//存放一份前一页画板的引用，备用
	private Painter painter;//绘制类
	//双缓冲需要的对象
	private BufferedImage imageBuffer = null;//缓冲的图像对象
	private Graphics gBuffer = null;//通过它在缓冲对象中绘图
	//通过构造方法，把主窗口传入主面板一份，备用
	public ChooseLevel(MyFrame myFrame,MyPanel myPanel){
		this.myFrame = myFrame;
		this.myPanel = myPanel;
		//创建主面板时，我们在此可以和绘制对象（Painter）
		painter = new Painter();
		
		//初始化双缓冲所需数据
		if(this.imageBuffer == null)
		{
			this.imageBuffer = 
					new BufferedImage(MyFrame.WINDOW_WIDTH,MyFrame.WINDOW_HEIGHT, BufferedImage.TYPE_INT_ARGB);
			this.gBuffer = this.imageBuffer.getGraphics();
		}
	}
	
	@Override
	public void start() throws IOException{
		//命令绘图类对象，把第一层界面绘制到图形缓冲中
		try {
			painter.drawOnePhotoOnTable(0,0,MyFrame.WINDOW_WIDTH-15,MyFrame.WINDOW_HEIGHT-46,"chooseLevel.png",(Graphics2D)this.gBuffer);
		} catch (IOException e) {
			throw new RuntimeException("一级界面“功能选择”界面鼠标监听器异常");
		}
		
		//把缓冲中绘制的内容绘制到主界面中
		Graphics src = myPanel.getGraphics();//获取当前主面板自身的绘图对象
		src.drawImage(imageBuffer, 0, 0, null);//通过这个绘图对象，把缓冲区图像的内容，一次性“复制”到主面板的可视区域
//		System.out.println("!!!!");
		myFrame.addMouseListener(myFrame.gui_3_1);

	}
	
//	@Override
//	public void paint(Graphics g) {
//		// TODO Auto-generated method stub
//		super.paint(g);
//		
//		onDraw();
//	}
}
