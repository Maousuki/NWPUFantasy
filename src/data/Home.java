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
	//˫������Ҫ�Ķ���
	private BufferedImage imageBuffer = null;//�����ͼ�����
	private Graphics gBuffer = null;//ͨ�����ڻ�������л�ͼ
	private Painter painter; //������
	private MyPanel prePanel; //����
	
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
		//�����Ҫ�����ͼƬĿ�����
		int scaledWidth = (int)(originImg.getWidth()*scaleX);
		int scaledHeight = (int)(originImg.getHeight()*scaleY);
		
		//����һ����������Ƭ����׼��ͨ��ԭʼ��Ƭ������
		BufferedImage newImage = new BufferedImage(scaledWidth, scaledHeight, originImg.getType());
		
		//��ԭʼ��Ƭ���������ű��ʣ����Ƶ�Ŀ��������Ƭ������
		Graphics g = newImage.getGraphics();
		g.drawImage(originImg, 0, 0, scaledWidth, scaledHeight, null);
		g.dispose();
		return newImage;
	}
	
	private void loadStartPointImg(){
		BufferedImage origin_plane = null;
		//����ͼƬ
		try {
			origin_plane = ImageIO.read(Painter.class.getResource("/imgs/startPoint" + ".png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//����ÿһС��ͼƬ�����������Ҫ��ÿһ��С����ԭʼͼƬ�ߴ���ȫһ������
		float scaleX = startPoint_WIDTH / (float)origin_plane.getWidth();
		float scaleY = startPoint_HEIGHT / (float)origin_plane.getHeight();
		
		//���������ɫ��С����ͼƬ
		startPointImg = createScaledImg(origin_plane, scaleX, scaleY);
	}
	
	private void loadBloodImg(){
		BufferedImage origin_plane = null;
		//����ͼƬ
		try {
			origin_plane = ImageIO.read(Painter.class.getResource("/imgs/blood" + ".png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//����ÿһС��ͼƬ�����������Ҫ��ÿһ��С����ԭʼͼƬ�ߴ���ȫһ������
		float scaleX = blood_WIDTH / (float)origin_plane.getWidth();
		float scaleY = blood_HEIGHT / (float)origin_plane.getHeight();
		
		//���������ɫ��С����ͼƬ
		bloodImg = createScaledImg(origin_plane, scaleX, scaleY);
	}
	
	private void loadReadBloodImg(){
		BufferedImage origin_plane = null;
		//����ͼƬ
		try {
			origin_plane = ImageIO.read(Painter.class.getResource("/imgs/redBlood" + ".png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//����ÿһС��ͼƬ�����������Ҫ��ÿһ��С����ԭʼͼƬ�ߴ���ȫһ������
		float scaleX = redBlood_WIDTH / (float)origin_plane.getWidth();
		float scaleY = redBlood_HEIGHT / (float)origin_plane.getHeight();
		
		//���������ɫ��С����ͼƬ
		redBloodImg = createScaledImg(origin_plane, scaleX, scaleY);
	}
	
	private void loadHomeImg(){
		BufferedImage origin_plane = null;
		//����ͼƬ
		try {
			origin_plane = ImageIO.read(Painter.class.getResource("/imgs/home" + ".png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//����ÿһС��ͼƬ�����������Ҫ��ÿһ��С����ԭʼͼƬ�ߴ���ȫһ������
		float scaleX = home_WIDTH / (float)origin_plane.getWidth();
		float scaleY = home_HEIGHT / (float)origin_plane.getHeight();
		
		//���������ɫ��С����ͼƬ
		homeImg = createScaledImg(origin_plane, scaleX, scaleY);
	}
	
	//���ƺ���
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
