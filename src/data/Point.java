package data;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.*;
import javax.imageio.ImageIO;

import GUI.Game;
import GUI.MyFrame;
import GUI.MyPanel;
import PaintTools.*;

public class Point{
	//˫������Ҫ�Ķ���
	private BufferedImage imageBuffer = null;//�����ͼ�����
	private Graphics gBuffer = null;//ͨ�����ڻ�������л�ͼ
	private Painter painter; //������
	private MyPanel myPanel;
	private MyFrame myFrame;
	private Table myTable;
	private Game myGame;
	//�洢�ػ�λ���Ƿ�ʹ��
	private BufferedImage pointImg,tower1Img,tower2Img,tower3Img;//�������ӵ���Ƭ����������
	
	public static boolean isPoint1 = true;
	public static boolean isPoint2 = true;
	public static boolean isPoint3 = true;
	public static boolean isPoint4 = true;

	public static final int POINT_WIDTH = 95;
	public static final int POINT_HEIGHT = 80;
	
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
	private void loadPointImg(){
		BufferedImage origin_plane = null;
		//����ͼƬ
		try {
			origin_plane = ImageIO.read(Painter.class.getResource("/imgs/point.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//����ÿһС��ͼƬ�����������Ҫ��ÿһ��С����ԭʼͼƬ�ߴ���ȫһ������
		float scaleX = POINT_WIDTH / (float)origin_plane.getWidth();
		float scaleY = POINT_HEIGHT / (float)origin_plane.getHeight();
		
		//���������ɫ��С����ͼƬ
		pointImg = createScaledImg(origin_plane, scaleX, scaleY);
	}
	private void loadTower1Img(){
		BufferedImage origin_plane = null;
		//����ͼƬ
		try {
			origin_plane = ImageIO.read(Painter.class.getResource("/imgs/tower1.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//����ÿһС��ͼƬ�����������Ҫ��ÿһ��С����ԭʼͼƬ�ߴ���ȫһ������
		float scaleX = 95 / (float)origin_plane.getWidth();
		float scaleY = 120 / (float)origin_plane.getHeight();
		
		//���������ɫ��С����ͼƬ
		tower1Img = createScaledImg(origin_plane, scaleX, scaleY);
	}
	private void loadTower2Img(){
		BufferedImage origin_plane = null;
		//����ͼƬ
		try {
			origin_plane = ImageIO.read(Painter.class.getResource("/imgs/tower2.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//����ÿһС��ͼƬ�����������Ҫ��ÿһ��С����ԭʼͼƬ�ߴ���ȫһ������
		float scaleX = 95 / (float)origin_plane.getWidth();
		float scaleY = 120 / (float)origin_plane.getHeight();
		
		//���������ɫ��С����ͼƬ
		tower2Img = createScaledImg(origin_plane, scaleX, scaleY);
	}
	private void loadTower3Img(){
		BufferedImage origin_plane = null;
		//����ͼƬ
		try {
			origin_plane = ImageIO.read(Painter.class.getResource("/imgs/tower3.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//����ÿһС��ͼƬ�����������Ҫ��ÿһ��С����ԭʼͼƬ�ߴ���ȫһ������
		float scaleX = 95 / (float)origin_plane.getWidth();
		float scaleY = 120 / (float)origin_plane.getHeight();
		
		//���������ɫ��С����ͼƬ
		tower3Img = createScaledImg(origin_plane, scaleX, scaleY);
	}
	public void drawCard(Graphics2D g2d) {
		g2d.drawImage(tower1Img, 675, 420, 95,120, null);
		g2d.drawImage(tower2Img, 775, 420, 95,120, null);
		g2d.drawImage(tower3Img, 875, 420, 95,120, null);
	}
	public void drawSelf(Graphics2D g2d) throws IOException {
		//�����ĸ��ػ�
//		try {
			if(myGame.f1==0)g2d.drawImage(pointImg, (int) 202, (int) 185,POINT_WIDTH,POINT_HEIGHT, null);
			if(myGame.f2==0)g2d.drawImage(pointImg, (int) 335, (int) 375,POINT_WIDTH,POINT_HEIGHT, null);
			if(myGame.f3==0)g2d.drawImage(pointImg, (int) 670, (int) 100,POINT_WIDTH,POINT_HEIGHT, null);
			if(myGame.f4==0)g2d.drawImage(pointImg, (int) 692, (int) 275,POINT_WIDTH,POINT_HEIGHT, null);
//			painter.drawOnePhotoOnTable(202,185,POINT_WIDTH-15,POINT_HEIGHT,"point.png",(Graphics2D)this.gBuffer);
//		} catch (IOException e) {
			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		try {
//			painter.drawOnePhotoOnTable(335,375,POINT_WIDTH-15,POINT_HEIGHT,"point.png",(Graphics2D)this.gBuffer);
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		try {
//			painter.drawOnePhotoOnTable(670,100,POINT_WIDTH-15,POINT_HEIGHT,"point.png",(Graphics2D)this.gBuffer);
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		try {
//			painter.drawOnePhotoOnTable(692,275,POINT_WIDTH-15,POINT_HEIGHT,"point.png",(Graphics2D)this.gBuffer);
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		Graphics src =  myPanel.getGraphics();
	    src.drawImage(imageBuffer, 0, 0, null);
	
	}
		
	//���캯��
		public Point(MyFrame myFrame,MyPanel myPanel,Table myTable,Game myGame) {
			this.myFrame = myFrame;
			this.myTable = myTable;
			this.myGame = myGame;
			this.myPanel = myPanel;
		    this.painter = new Painter();
			if(this.imageBuffer == null)
			{
				this.imageBuffer = 
						new BufferedImage(MyFrame.WINDOW_WIDTH,MyFrame.WINDOW_HEIGHT, BufferedImage.TYPE_INT_ARGB);
				this.gBuffer = this.imageBuffer.getGraphics();
			}
			loadPointImg();
			loadTower1Img();
			loadTower2Img();
			loadTower3Img();
		}
		
		//���ƽ�������
		public void chooseTower() throws IOException {
			switch(myFrame.position) {
			case 1 :
				myGame.f1=1;
				myGame.posX=255;
				myGame.posY=195;
			    break;
			    
			case 2 :
				myGame.f2=1;
				myGame.posX=375;
				myGame.posY=375;
			    
			    break;
			case 3 :
				myGame.f3=1;
				myGame.posX=735;
				myGame.posY=115;
				
			    break;
			case 4 :
				myGame.f4=1;
				myGame.posX=735;
				myGame.posY=275;
				
			    break;
			}
				
			
	//		System.out.println(myGame.posX+"  "+myGame.posY);
			myFrame.removeMouseListener(myFrame.gui_4_1);
			myFrame.addMouseListener(myFrame.gui_4_2);
			myGame.fff=1;
			
		}
		
	//�û�����ʱ��ʾ��Ƭ����ʧ�ػ�
}