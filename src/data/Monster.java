package data;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import GUI.MyFrame;
import GUI.MyPanel;
import PaintTools.Painter;

public class Monster extends Movable{
	private int id = 0;

	private int blood = 100;
	private int coin = 50;
	private int hurt = 10;
	Route route = new Route();

	/**
	 * ͼ���࣬չʾ��Ϸ������Ԫ�ص���Ϣ
	 */
	private static int page=0;//ͼ���ĵ�ǰ����ҳ��
	private MyPanel myPanel;// ���һ�������ڵ�����
	private Painter painter;// ������
	private MyFrame myFrame;
	// ˫������Ҫ�Ķ���
	private BufferedImage monsterImg;//�������ӵ���Ƭ����������
	
	private static final int MONSTER_WIDTH = 60;
	private static final int MONSTER_HEIGHT = 60;
	private int lifeFlag = 1;
	
	private void loadImg(){
		BufferedImage origin_plane = null;
		//����ͼƬ
		try {
			origin_plane = ImageIO.read(Painter.class.getResource("/imgs/monster_" + id + ".png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//����ÿһС��ͼƬ�����������Ҫ��ÿһ��С����ԭʼͼƬ�ߴ���ȫһ������
		float scaleX = MONSTER_WIDTH / (float)origin_plane.getWidth();
		float scaleY = MONSTER_HEIGHT / (float)origin_plane.getHeight();
		
		//���������ɫ��С����ͼƬ
		monsterImg = createScaledImg(origin_plane, scaleX, scaleY);
	}
	
	
	
	public Monster(double posX, double posY,MyPanel prepanel, int id) {
		
		super(posX, posY,0);
		switch(id)
		{
			case 1 :
				this.id = 1;
				blood  += 50;
				coin += 25;
				hurt++;
				break;
			case 2 :
				this.id = 2;
				break;
			case 3 :
				this.id = 3;
				break;
			case 4 :
				this.id = 4;
				break;
				
				
				
		}
		this.myPanel = prepanel;
		this.painter = new Painter();
		// ��ʼ��˫������������
		loadImg();//����ͼƬ
	}
	
	
	



	public int getBlood() {
		return blood;
	}



	public void setBlood(int blood) {
		this.blood = blood;
	}



	public int getCoin() {
		return coin;
	}


	public void setCoin(int coin) {
		this.coin = coin;
	}


	public int getHurt() {
		return hurt;
	}

	public void setHurt(int hurt) {
		this.hurt = hurt;
	}

	public boolean isDead() {
		return blood <= 0;
	}
//917,307��һ�ؼ�����
//923��220�ڶ��ؼ�����
	public void Attack(int hp,int hurt,double posX, double posY ) {
		if(posX == 917 && posY == 307) {
			hp = hp-hurt;	
		}
	}
	

	public void move() {
		if(blood <= 0) {
			lifeFlag = 0;
		}
		if(lifeFlag == 0)return;
		if(posX == 856 && posY == 304) {
			lifeFlag = 0;
			Home.hp-=20;
			blood = 0;
		}else {
			Point2D point2D = route.changePosition(posX, posY);
			posX = point2D.getX();
			posY = point2D.getY();
		}
	}
	//���浱ǰ����



	public void drawSelf(Graphics2D g2d) {
		// TODO Auto-generated method stub
		if (monsterImg == null) {
			return;
		}
		if(lifeFlag == 1)

		// ͼƬ����λ����Ϊ��ǰ��������㣬������Ҫ�����Ϸ�ƫ�ư��ͼƬ�ߴ�
		{
			g2d.drawImage(monsterImg, (int) posX, (int) posY, MONSTER_WIDTH,MONSTER_HEIGHT, null);
		}else 
		{
			return;
		}
		
	}
	
	
	
	
}
