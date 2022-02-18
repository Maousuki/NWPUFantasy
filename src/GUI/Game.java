package GUI;

import java.util.*;
import java.util.Timer;
import timer.ReschedulableTimerTask;

import javax.imageio.ImageIO;
import javax.swing.*;

import PaintTools.Painter;
import data.Home;
import data.Monster;
import data.Point;
import data.Table;
import data.Tower;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Game extends JPanel{
	
	private MyFrame mainFrame;//存放一份主窗口的引用
	private MyPanel prePanel;//存放前一页的二级面板
	
	//数据与画笔
	private Table table;//游戏主业务类
	private Painter painter;//绘制类
	public Point point;
	public LinkedList<Tower> towers = new LinkedList<Tower>();
	public int f1,f2,f3,f4,posX,posY;
	//窗口属性
	public int fff;
	public static final int MAP_WIDTH = 800;
	public static final int MAP_HEIGHT = 600;
	private int flag;
	//双缓冲需要的对象
	private BufferedImage imageBuffer = null;//缓冲的图像对象
	public Graphics gBuffer = null;//通过它在缓冲对象中绘图
	
	public static final int GAME_WIDTH = MyFrame.WINDOW_WIDTH-15;
	public static final int GAME_HEIGHT = MyFrame.WINDOW_HEIGHT-46;
	
	private BufferedImage gameImg;
	//定时器相关属性
	public static final int FPS = 1000;
	ReschedulableTimerTask gameTimerTask;//代表定时器执行的任务（不是定时器本身）
	Timer gameTimer = null;//定时器本身，由它开启、停止、变化定时器
	
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
	
	private void loadImg(){
		BufferedImage origin_plane = null;
		//加载图片
		try {
			origin_plane = ImageIO.read(Painter.class.getResource("/imgs/ongame" + ".png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//计算每一小格图片的拉伸比例（要求每一个小格子原始图片尺寸完全一样！）
		float scaleX = GAME_WIDTH / (float)origin_plane.getWidth();
		float scaleY = GAME_HEIGHT / (float)origin_plane.getHeight();
		
		//拉伸各个颜色的小格子图片
		gameImg = createScaledImg(origin_plane, scaleX, scaleY);
	}
	
	
	//通过构造方法，把主窗口传入主面板一份，备用
	public Game(MyFrame myFrame, MyPanel prePanel){
		f1=f2=f3=f4=fff=0;
		this.mainFrame = myFrame;
		this.prePanel = prePanel;
		point = new Point(myFrame,prePanel,table,this);
		flag=0;
		//创建主面板时，我们在此可以创建游戏主对象（Table）和绘制对象（Painter）
		table = new Table(prePanel,this);
		painter = new Painter();
			
		//初始化双缓冲所需数据
		if(this.imageBuffer == null)
		{
			this.imageBuffer = 
					new BufferedImage(MyFrame.WINDOW_WIDTH,MyFrame.WINDOW_HEIGHT, BufferedImage.TYPE_INT_ARGB);
			this.gBuffer = this.imageBuffer.getGraphics();
		}
			
		//初始化主循环定时器
		this.gameTimer = new Timer();
		}

	/**
	 * 开始进入一个主循环（开启主定时器）
	 * @throws IOException 
	 */
	public void drawCard(Graphics2D g2d) throws IOException {
		if(fff!=0)point.drawCard(g2d);
	}
	public void drawPoint(Graphics2D g2d) throws IOException {
		point.drawSelf(g2d);
	}
	 
	public void setTower(double posX,double posY,int id) {
//		System.out.println("tower: "+posX+"   "+posY);
		mainFrame.position=0;
		table.setTower(mainFrame,prePanel,posX,posY,id);
		mainFrame.removeMouseListener(mainFrame.gui_4_2);
		mainFrame.addMouseListener(mainFrame.gui_4_1);
		
		fff=0;
	}
	public void initMainLoop(){
		//创建定时器的执行任务对象（但并未开始执行定时器！）
		gameTimerTask = new ReschedulableTimerTask() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				
				try {
					pushOneStep();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}//让游戏所有元素变化一下，再重绘
				flag=(flag+1)%3000;
				try {
					onDraw();
					if(Home.hp == 0 ) {
						JDialog gameOver = new JDialog(mainFrame,"GameOver");
						JButton jb = new JButton("确定");
						JLabel jl = new JLabel("任务失败 !  点击确定返回选项界面");
						jl.setFont(new Font("宋体", Font.PLAIN, 20));
						gameOver.setVisible(true);
						gameOver.setSize(400, 150);
						gameOver.setLocationRelativeTo(null);
						gameOver.setLayout(new FlowLayout());
						gameOver.add(jl);
						gameOver.add(jb);
						gameOver.setResizable(false);
						jb.addActionListener(new ActionListener() {
						@Override            
						public void actionPerformed(ActionEvent e) {
							if (e.getActionCommand().equals("确定")) {
								// 判断是不是确定按钮被点击            
								gameOver.setVisible(false);// 对话框不可见   
							}
							try {
								prePanel.options();
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							}
						});
						
						cancel();
					}
					boolean f=true;
					for(Monster monster: table.monsters) {
						if(monster.isDead()==false)f=false;
					}
					if(Home.hp != 0 && f==true) {
						JDialog gameOver = new JDialog(mainFrame,"GameOver");
						JButton jb = new JButton("确定");
						JLabel jl = new JLabel("任务成功 !  点击确定返回选项界面");
						jl.setFont(new Font("宋体", Font.PLAIN, 20));
						gameOver.setVisible(true);
						gameOver.setSize(400, 150);
						gameOver.setLocationRelativeTo(null);
						gameOver.setLayout(new FlowLayout());
						gameOver.add(jl);
						gameOver.add(jb);
						gameOver.setResizable(false);
						jb.addActionListener(new ActionListener() {
						@Override            
						public void actionPerformed(ActionEvent e) {
							if (e.getActionCommand().equals("确定")) {
								// 判断是不是确定按钮被点击            
								gameOver.setVisible(false);// 对话框不可见   
							}
							try {
								prePanel.options();
							} catch (IOException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							}
						});
						cancel();
					}
				
				//如果怪物对象消失
				
				//如果怪物对象消失
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}//重新绘制
			}
		};
		
		startMainLoop();//开始定时器
	}
	
	
	private void pushOneStep() throws IOException {
		table.change(flag);
	}
	//开启主定时器，进入主绘制循环
	public void startMainLoop(){
		//按FPS值，开启一个定时器
		mainFrame.addMouseListener(mainFrame.gui_4_1);
		gameTimer.schedule(gameTimerTask, 0, (int)(1.0f/FPS * 1000));
	}
	
	public void drawGameSelf(Graphics2D g2d) {
			try {
				painter.drawOnePhotoOnTable(0,0,MyFrame.WINDOW_WIDTH-15,MyFrame.WINDOW_HEIGHT-46,"ongame.png",(Graphics2D)this.gBuffer);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
//		Graphics src = prePanel.getGraphics();//获取当前主面板自身的绘图对象
//		src.drawImage(imageBuffer, 0, 0, null);//通过这个绘图对象，把缓冲区图像的内容，一次性“复制”到主面板的可视区域
	}
	//使用带双缓冲的方法绘制
	public void onDraw() throws IOException{
		
		
			drawGameSelf((Graphics2D)gBuffer);
		
		
			table.drawAll((Graphics2D)gBuffer);
		
			//把缓冲中绘制的内容绘制到主界面中
			Graphics src = prePanel.getGraphics();//获取当前主面板自身的绘图对象
			src.drawImage(imageBuffer, 0, 0, null);//通过这个绘图对象，把缓冲区图像的内容，一次性“复制”到主面板的可视区域
	}
		@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		super.paint(g);
		
		try {
			onDraw();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

