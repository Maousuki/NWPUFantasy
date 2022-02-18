package data;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import GUI.MyFrame;
import GUI.MyPanel;
import PaintTools.Painter;

public class Bullet extends Movable{
	private MyFrame myFrame;
	private MyPanel myPanel;
	private Table myTable;
	private Painter painter;//������
	//˫������Ҫ�Ķ���
	private Tower myTower;
	private int attackId;
	private BufferedImage imageBuffer = null;//�����ͼ�����
	private Graphics gBuffer = null;//ͨ�����ڻ�������л�ͼ
	
	private BufferedImage bulletImg;
	
	private static final int bullet_WIDTH = 10;
	private static final int bullet_HEIGHT = 10;
	
	public Bullet(double posX, double posY,int lifeCircle, int attackId,MyFrame myFrame,MyPanel myPanel,Tower myTower,Table myTable) {
		super(posX, posY, lifeCircle);
		this.myFrame=myFrame;
		this.myPanel=myPanel;
		this.myTower=myTower;
		this.myTable=myTable;
		this.attackId=attackId;
		// TODO Auto-generated constructor stub
		painter = new Painter();
		if(this.imageBuffer == null)
		{
			this.imageBuffer = 
					new BufferedImage(MyFrame.WINDOW_WIDTH,MyFrame.WINDOW_HEIGHT, BufferedImage.TYPE_INT_ARGB);
			this.gBuffer = this.imageBuffer.getGraphics();
		}
		
		loadImg();
	}
	
	private void loadImg(){
		BufferedImage origin_plane = null;
		//����ͼƬ
		try {
			origin_plane = ImageIO.read(Painter.class.getResource("/imgs/bullet" + ".png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		float scaleX = bullet_WIDTH / (float)origin_plane.getWidth();
		float scaleY = bullet_HEIGHT / (float)origin_plane.getHeight();
		
		bulletImg = createScaledImg(origin_plane, scaleX, scaleY);
	}
	
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
	
	public int getAttackId() {
		return attackId;
	}
	public void moveAndAttack(double toX,double toY) {
		double dx=toX-posX,dy=toY-posY;
		double len=Math.sqrt(dx*dx+dy*dy);
		if(len>5)len=5;
		dx=dx/Math.sqrt(dx*dx+dy*dy)*len;
		dy=dy/Math.sqrt(dx*dx+dy*dy)*len;
		changePositionRelative(dx,dy);
	}
	public void drawSelf(Graphics2D g2d) throws IOException {
		
		g2d.drawImage(bulletImg, (int) posX, (int) posY, bullet_WIDTH,bullet_HEIGHT, null);
	}
}
