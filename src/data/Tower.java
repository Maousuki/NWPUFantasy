/**
 * 
 */
package data;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.LinkedList;

import javax.imageio.ImageIO;

import GUI.MyFrame;
import GUI.MyPanel;
import PaintTools.Painter;

/**
 * @author 2019302948
 *
 */
public class Tower {
	private int id;
	private int hurt;
	private int price;
	private int cycle;
	private int range;
	private int level;
	private double posX,posY;
	private Table myTable;
	private MyFrame myFrame;
	private MyPanel myPanel;
	private Painter painter;//������
	//˫������Ҫ�Ķ���
	private BufferedImage imageBuffer = null;//�����ͼ�����
	private Graphics gBuffer = null;//ͨ�����ڻ�������л�ͼ
	private Bullet[] bullet = new Bullet[20];
//	private Bullet b=new Bullet(posX,posY-20,0,myFrame,myPanel)
	private int l,r;
	
	private BufferedImage tower1Img,tower2Img,tower3Img;
	private static final int tower_WIDTH = 95;
	private static final int tower_HEIGHT = 120;
	
	private void loadImg1(){
		BufferedImage origin_plane = null;
		//����ͼƬ
		try {
			origin_plane = ImageIO.read(Painter.class.getResource("/imgs/tower1" + ".png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//����ÿһС��ͼƬ�����������Ҫ��ÿһ��С����ԭʼͼƬ�ߴ���ȫһ������
		float scaleX = tower_WIDTH / (float)origin_plane.getWidth();
		float scaleY = tower_HEIGHT / (float)origin_plane.getHeight();
		
		//���������ɫ��С����ͼƬ
		tower1Img = createScaledImg(origin_plane, scaleX, scaleY);
	}
	private void loadImg2(){
		BufferedImage origin_plane = null;
		//����ͼƬ
		try {
			origin_plane = ImageIO.read(Painter.class.getResource("/imgs/tower2" + ".png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//����ÿһС��ͼƬ�����������Ҫ��ÿһ��С����ԭʼͼƬ�ߴ���ȫһ������
		float scaleX = tower_WIDTH / (float)origin_plane.getWidth();
		float scaleY = tower_HEIGHT / (float)origin_plane.getHeight();
		
		//���������ɫ��С����ͼƬ
		tower2Img = createScaledImg(origin_plane, scaleX, scaleY);
	}
	private void loadImg3(){
		BufferedImage origin_plane = null;
		//����ͼƬ
		try {
			origin_plane = ImageIO.read(Painter.class.getResource("/imgs/tower3" + ".png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//����ÿһС��ͼƬ�����������Ҫ��ÿһ��С����ԭʼͼƬ�ߴ���ȫһ������
		float scaleX = tower_WIDTH / (float)origin_plane.getWidth();
		float scaleY = tower_HEIGHT / (float)origin_plane.getHeight();
		
		//���������ɫ��С����ͼƬ
		tower3Img = createScaledImg(origin_plane, scaleX, scaleY);
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
	
	Tower(Table myTable,MyFrame myFrame,MyPanel myPanel,double posX,double posY,int id){
		this.myFrame = myFrame;
		this.myPanel = myPanel;
		this.myTable = myTable;
		this.id = id;
		this.posX = posX;
		this.posY = posY;
		if(id==1) {
			hurt=30;
			price=0;
			cycle=1000;
			range=150;
		}
		else if(id==2) {
			hurt=60;
			price=0;
			cycle=5000;
			range=100;
		}
		else if(id==3){
			hurt=15;
			price=0;
			cycle=600;
			range=200;
		}
		else if(id==4) {
			hurt=30;
			price=0;
			cycle=1000;
			range=150;
		}
		level = 1;l=0;r=0;
		painter = new Painter();
		if(this.imageBuffer == null)
		{
			this.imageBuffer = 
					new BufferedImage(MyFrame.WINDOW_WIDTH,MyFrame.WINDOW_HEIGHT, BufferedImage.TYPE_INT_ARGB);
			this.gBuffer = this.imageBuffer.getGraphics();
		}
		
		loadImg1();
		loadImg2();
		loadImg3();
	}
	public int getId() {
		return id;
	}
	public int getHurt() {
		return hurt;
	}
	public int getPrice() {
		return price;
	}
	public int getCycle() {
		return cycle;
	}
	public int getLevel() {
		return level;
	}
	public int getRange() {
		return range;
	}
	public double getPosX() {
		return posX;
	}
	public double getPosY() {
		return posY;
	}
	public void upLevel() {
		if(level<3)level++;
	}
	public void launch() {
		if(myTable.getMonstersSize()==0)return;
		int x=0;
	//	System.out.println("l: "+l+"  r: "+r);
		while(x<myTable.getMonstersSize()&&((myTable.getMonsters(x).getPosX()-posX)*(myTable.getMonsters(x).getPosX()-posX)+(myTable.getMonsters(x).getPosY()-posY)*(myTable.getMonsters(x).getPosY()-posY)>range*range||myTable.getMonsters(x).isDead()==true))x++;
		if(x<myTable.getMonstersSize()) {
			bullet[r] = new Bullet(posX,posY,0,x,myFrame,myPanel,this,myTable);
			r=(r+1)%20;
		}
	}
	public void move() {
		for(int i=l;i!=r;i=(i+1)%20) {
			int x=bullet[i].getAttackId();
			bullet[i].moveAndAttack(myTable.getMonsters(x).getPosX(),myTable.getMonsters(x).getPosY());
			if((bullet[i].getPosX()-myTable.getMonsters(x).getPosX())*(bullet[i].getPosX()-myTable.getMonsters(x).getPosX())+(bullet[i].getPosY()-myTable.getMonsters(x).getPosY())*(bullet[i].getPosY()-myTable.getMonsters(x).getPosY())<=10*10) {
				myTable.dltBlood(x,hurt);
				l=(l+1)%20;
			}
			if(myTable.getMonsters(x).getBlood()<=0) {
				l=r;
				break;
			}
		}
	}
	public void drawSelf(Graphics2D g2d) throws IOException {
		if(id==1)g2d.drawImage(tower1Img, (int)(posX-tower_WIDTH/2), (int)(posY-tower_HEIGHT/2), tower_WIDTH,tower_HEIGHT, null);
		else if(id==2)g2d.drawImage(tower2Img, (int)(posX-tower_WIDTH/2), (int)(posY-tower_HEIGHT/2), tower_WIDTH,tower_HEIGHT, null);
		else if(id==3)g2d.drawImage(tower3Img, (int)(posX-tower_WIDTH/2), (int)(posY-tower_HEIGHT/2), tower_WIDTH,tower_HEIGHT, null);
		for(int i=l;i!=r;i=(i+1)%20) {
			bullet[i].drawSelf(g2d);
		}
	}
}
