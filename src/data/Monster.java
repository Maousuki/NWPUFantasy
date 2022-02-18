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
	 * 图鉴类，展示游戏内所有元素的信息
	 */
	private static int page=0;//图鉴的当前所在页数
	private MyPanel myPanel;// 存放一份主窗口的引用
	private Painter painter;// 绘制类
	private MyFrame myFrame;
	// 双缓冲需要的对象
	private BufferedImage monsterImg;//拉伸后的子弹照片，保存起来
	
	private static final int MONSTER_WIDTH = 60;
	private static final int MONSTER_HEIGHT = 60;
	private int lifeFlag = 1;
	
	private void loadImg(){
		BufferedImage origin_plane = null;
		//加载图片
		try {
			origin_plane = ImageIO.read(Painter.class.getResource("/imgs/monster_" + id + ".png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//计算每一小格图片的拉伸比例（要求每一个小格子原始图片尺寸完全一样！）
		float scaleX = MONSTER_WIDTH / (float)origin_plane.getWidth();
		float scaleY = MONSTER_HEIGHT / (float)origin_plane.getHeight();
		
		//拉伸各个颜色的小格子图片
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
		// 初始化双缓冲所需数据
		loadImg();//加载图片
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
//917,307第一关家坐标
//923，220第二关家坐标
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
	//保存当前坐标



	public void drawSelf(Graphics2D g2d) {
		// TODO Auto-generated method stub
		if (monsterImg == null) {
			return;
		}
		if(lifeFlag == 1)

		// 图片中心位置作为当前物体坐标点，所以需要向左上方偏移半个图片尺寸
		{
			g2d.drawImage(monsterImg, (int) posX, (int) posY, MONSTER_WIDTH,MONSTER_HEIGHT, null);
		}else 
		{
			return;
		}
		
	}
	
	
	
	
}
