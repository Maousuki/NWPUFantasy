package GUI;


import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.swing.JPanel;
import PaintTools.Painter;

public class Helps extends JPanel implements SecondGUI{

	/**
	 * 帮助内，提供游戏内的帮助手册
	 */
	private static final long serialVersionUID = 1L;
	private MyFrame myFrame;//存放一份主窗口的引用
	private MyPanel myPanel;
	private Painter painter;////绘制类
	//双缓冲需要的对象
	private BufferedImage imageBuffer = null;//缓冲的图像对象
	private Graphics gBuffer = null;//通过它在缓冲对象中绘图
	public static int pageNumber = 1;
	

	//通过构造方法，把主窗口传入主面板一份，备用
	
	public Helps(MyFrame myFrame, MyPanel myPanel) {
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
		myFrame.removeMouseListener(myFrame.gui_2);
		painter.drawOnePhotoOnTable(0,0,MyFrame.WINDOW_WIDTH-15,MyFrame.WINDOW_HEIGHT-46,"help1.png",(Graphics2D)this.gBuffer);
		//把缓冲中绘制的内容绘制到主界面中
		Graphics src =  myPanel.getGraphics();//获取当前面板自身的绘图对象
	    src.drawImage(imageBuffer, 0, 0, null);//通过这个绘图对象，把缓冲区图像的内容，一次性“复制”到主面板的可视区域
	    myFrame.addMouseListener(myFrame.gui_3_3);
	    
	}
	
	public void last() throws IOException{
		switch(pageNumber) {
		case 1:
			painter.drawOnePhotoOnTable(0,0,MyFrame.WINDOW_WIDTH-15,MyFrame.WINDOW_HEIGHT-46,"help4.png",(Graphics2D)this.gBuffer);
			//把缓冲中绘制的内容绘制到主界面中
			Graphics src =  myPanel.getGraphics();//获取当前面板自身的绘图对象
	    	src.drawImage(imageBuffer, 0, 0, null);//通过这个绘图对象，把缓冲区图像的内容，一次性“复制”到主面板的可视区域
	    	pageNumber = 4;
	    	break;
		case 2:
		    painter.drawOnePhotoOnTable(0,0,MyFrame.WINDOW_WIDTH-15,MyFrame.WINDOW_HEIGHT-46,"help1.png",(Graphics2D)this.gBuffer);
		    //把缓冲中绘制的内容绘制到主界面中
		    Graphics src1 =  myPanel.getGraphics();//获取当前面板自身的绘图对象
	        src1.drawImage(imageBuffer, 0, 0, null);//通过这个绘图对象，把缓冲区图像的内容，一次性“复制”到主面板的可视区域
	        pageNumber = 1;
	        break;
		case 3:
			painter.drawOnePhotoOnTable(0,0,MyFrame.WINDOW_WIDTH-15,MyFrame.WINDOW_HEIGHT-46,"help2.png",(Graphics2D)this.gBuffer);
			//把缓冲中绘制的内容绘制到主界面中
			Graphics src2 =  myPanel.getGraphics();//获取当前面板自身的绘图对象
		    src2.drawImage(imageBuffer, 0, 0, null);//通过这个绘图对象，把缓冲区图像的内容，一次性“复制”到主面板的可视区域
		    pageNumber = 2;
		    break;
		case 4:
			painter.drawOnePhotoOnTable(0,0,MyFrame.WINDOW_WIDTH-15,MyFrame.WINDOW_HEIGHT-46,"help3.png",(Graphics2D)this.gBuffer);
			//把缓冲中绘制的内容绘制到主界面中
			Graphics src3 =  myPanel.getGraphics();//获取当前面板自身的绘图对象
		    src3.drawImage(imageBuffer, 0, 0, null);//通过这个绘图对象，把缓冲区图像的内容，一次性“复制”到主面板的可视区域
		    pageNumber = 3;
		    break;    
		}
	    	
	}
	

	public void next() throws IOException{	
		switch(pageNumber) {
		case 1:
			painter.drawOnePhotoOnTable(0,0,MyFrame.WINDOW_WIDTH-15,MyFrame.WINDOW_HEIGHT-46,"help2.png",(Graphics2D)this.gBuffer);
			//把缓冲中绘制的内容绘制到主界面中
			Graphics src =  myPanel.getGraphics();//获取当前面板自身的绘图对象
	    	src.drawImage(imageBuffer, 0, 0, null);//通过这个绘图对象，把缓冲区图像的内容，一次性“复制”到主面板的可视区域
	    	pageNumber = 2;
	    	break;
		case 2:
		    painter.drawOnePhotoOnTable(0,0,MyFrame.WINDOW_WIDTH-15,MyFrame.WINDOW_HEIGHT-46,"help3.png",(Graphics2D)this.gBuffer);
		    //把缓冲中绘制的内容绘制到主界面中
		    Graphics src1 =  myPanel.getGraphics();//获取当前面板自身的绘图对象
	        src1.drawImage(imageBuffer, 0, 0, null);//通过这个绘图对象，把缓冲区图像的内容，一次性“复制”到主面板的可视区域
	        pageNumber = 3;
	        break;
		case 3:
			painter.drawOnePhotoOnTable(0,0,MyFrame.WINDOW_WIDTH-15,MyFrame.WINDOW_HEIGHT-46,"help4.png",(Graphics2D)this.gBuffer);
			//把缓冲中绘制的内容绘制到主界面中
			Graphics src2 =  myPanel.getGraphics();//获取当前面板自身的绘图对象
		    src2.drawImage(imageBuffer, 0, 0, null);//通过这个绘图对象，把缓冲区图像的内容，一次性“复制”到主面板的可视区域
		    pageNumber = 4;
		    break;
		case 4:
			painter.drawOnePhotoOnTable(0,0,MyFrame.WINDOW_WIDTH-15,MyFrame.WINDOW_HEIGHT-46,"help1.png",(Graphics2D)this.gBuffer);
			//把缓冲中绘制的内容绘制到主界面中
			Graphics src3 =  myPanel.getGraphics();//获取当前面板自身的绘图对象
		    src3.drawImage(imageBuffer, 0, 0, null);//通过这个绘图对象，把缓冲区图像的内容，一次性“复制”到主面板的可视区域
		    pageNumber = 1;
		    break;    
		}
	}

	public void back() throws IOException{
		myFrame.removeMouseListener(myFrame.gui_3_3);
		myPanel.options();	
	}
}