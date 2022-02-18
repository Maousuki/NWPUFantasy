package data;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import GUI.Game;
import GUI.MyFrame;
import GUI.MyPanel;
import PaintTools.Painter;

public class Home {
	//双缓冲需要的对象
	private BufferedImage imageBuffer = null;//缓冲的图像对象
	private Graphics gBuffer = null;//通过它在缓冲对象中绘图
	private Painter painter; //绘制类
	private MyPanel prePanel; //备份
	
	public static int coin = 0;
	public static int hp = 100;
	public static int homePositionX = 954;
	public static int homePositionY = 368;
	
	private BufferedImage homeImg;
	private BufferedImage startPointImg;
	private BufferedImage bloodImg;
	private BufferedImage redBloodImg;
	
	public static int home_WIDTH = 63;
	public static int home_HEIGHT = 160;
	
	public static int startPoint_WIDTH = 87;
	public static int startPoint_HEIGHT = 78;
	
	public static int blood_WIDTH = 351;
	public static int blood_HEIGHT = 47;
	
	public static int redBlood_WIDTH = 287*hp/100;
	public static int redBlood_HEIGHT = 15;
	
	public BufferedImage createScaledImg(BufferedImage originImg, float scaleX, float scaleY){
		//计算出要拉伸的图片目标宽、高
		int scaledWidth = (int)(originImg.getWidth()*scaleX);
		int scaledHeight = (int)(originImg.getHeight()*scaleY);
		
		//创建一个拉伸后的照片对象，准备通过原始照片拉伸它
		BufferedImage newImage = new BufferedImage(scaledWidth, scaledHeight, originImg.getType());
		
		//将原始照片，按照缩放比率，绘制到目标拉伸照片对象中
		Graphics g = newImage.getGraphics();
		g.drawImage(originImg, 0, 0, scaledWidth, scaledHeight, null);
		g.dispose();
		return newImage;
	}
	
	private void loadStartPointImg(){
		BufferedImage origin_plane = null;
		//加载图片
		try {
			origin_plane = ImageIO.read(Painter.class.getResource("/imgs/startPoint" + ".png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//计算每一小格图片的拉伸比例（要求每一个小格子原始图片尺寸完全一样！）
		float scaleX = startPoint_WIDTH / (float)origin_plane.getWidth();
		float scaleY = startPoint_HEIGHT / (float)origin_plane.getHeight();
		
		//拉伸各个颜色的小格子图片
		startPointImg = createScaledImg(origin_plane, scaleX, scaleY);
	}
	
	private void loadBloodImg(){
		BufferedImage origin_plane = null;
		//加载图片
		try {
			origin_plane = ImageIO.read(Painter.class.getResource("/imgs/blood" + ".png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//计算每一小格图片的拉伸比例（要求每一个小格子原始图片尺寸完全一样！）
		float scaleX = blood_WIDTH / (float)origin_plane.getWidth();
		float scaleY = blood_HEIGHT / (float)origin_plane.getHeight();
		
		//拉伸各个颜色的小格子图片
		bloodImg = createScaledImg(origin_plane, scaleX, scaleY);
	}
	
	private void loadReadBloodImg(){
		BufferedImage origin_plane = null;
		//加载图片
		try {
			origin_plane = ImageIO.read(Painter.class.getResource("/imgs/redBlood" + ".png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//计算每一小格图片的拉伸比例（要求每一个小格子原始图片尺寸完全一样！）
		float scaleX = redBlood_WIDTH / (float)origin_plane.getWidth();
		float scaleY = redBlood_HEIGHT / (float)origin_plane.getHeight();
		
		//拉伸各个颜色的小格子图片
		redBloodImg = createScaledImg(origin_plane, scaleX, scaleY);
	}
	
	private void loadHomeImg(){
		BufferedImage origin_plane = null;
		//加载图片
		try {
			origin_plane = ImageIO.read(Painter.class.getResource("/imgs/home" + ".png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//计算每一小格图片的拉伸比例（要求每一个小格子原始图片尺寸完全一样！）
		float scaleX = home_WIDTH / (float)origin_plane.getWidth();
		float scaleY = home_HEIGHT / (float)origin_plane.getHeight();
		
		//拉伸各个颜色的小格子图片
		homeImg = createScaledImg(origin_plane, scaleX, scaleY);
	}
	
	//绘制函数
	public void drawSelf(Graphics2D g2d) throws IOException {
		
		g2d.drawImage(homeImg, 920, 210, 63,160, null);
		g2d.drawImage(startPointImg, 100,10, 87,78, null);
		g2d.drawImage(bloodImg, 350, 10,351,47, null);
		g2d.drawImage(redBloodImg, 380, 25, 287*hp/100,15, null);
	
	    

	}
	
	public Home(MyPanel prePanel) {
		this.prePanel = prePanel;
	    this.painter = new Painter();
		if(this.imageBuffer == null)
		{
			this.imageBuffer = 
					new BufferedImage(MyFrame.WINDOW_WIDTH,MyFrame.WINDOW_HEIGHT, BufferedImage.TYPE_INT_ARGB);
			this.gBuffer = this.imageBuffer.getGraphics();
		}
		
		loadStartPointImg();
		loadBloodImg();
		loadReadBloodImg();
		loadHomeImg();
	}
	
}
