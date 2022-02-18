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
	
	private MyFrame mainFrame;//���һ�������ڵ�����
	private MyPanel prePanel;//���ǰһҳ�Ķ������
	
	//�����뻭��
	private Table table;//��Ϸ��ҵ����
	private Painter painter;//������
	public Point point;
	public LinkedList<Tower> towers = new LinkedList<Tower>();
	public int f1,f2,f3,f4,posX,posY;
	//��������
	public int fff;
	public static final int MAP_WIDTH = 800;
	public static final int MAP_HEIGHT = 600;
	private int flag;
	//˫������Ҫ�Ķ���
	private BufferedImage imageBuffer = null;//�����ͼ�����
	public Graphics gBuffer = null;//ͨ�����ڻ�������л�ͼ
	
	public static final int GAME_WIDTH = MyFrame.WINDOW_WIDTH-15;
	public static final int GAME_HEIGHT = MyFrame.WINDOW_HEIGHT-46;
	
	private BufferedImage gameImg;
	//��ʱ���������
	public static final int FPS = 1000;
	ReschedulableTimerTask gameTimerTask;//����ʱ��ִ�е����񣨲��Ƕ�ʱ������
	Timer gameTimer = null;//��ʱ����������������ֹͣ���仯��ʱ��
	
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
	
	private void loadImg(){
		BufferedImage origin_plane = null;
		//����ͼƬ
		try {
			origin_plane = ImageIO.read(Painter.class.getResource("/imgs/ongame" + ".png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//����ÿһС��ͼƬ�����������Ҫ��ÿһ��С����ԭʼͼƬ�ߴ���ȫһ������
		float scaleX = GAME_WIDTH / (float)origin_plane.getWidth();
		float scaleY = GAME_HEIGHT / (float)origin_plane.getHeight();
		
		//���������ɫ��С����ͼƬ
		gameImg = createScaledImg(origin_plane, scaleX, scaleY);
	}
	
	
	//ͨ�����췽�����������ڴ��������һ�ݣ�����
	public Game(MyFrame myFrame, MyPanel prePanel){
		f1=f2=f3=f4=fff=0;
		this.mainFrame = myFrame;
		this.prePanel = prePanel;
		point = new Point(myFrame,prePanel,table,this);
		flag=0;
		//���������ʱ�������ڴ˿��Դ�����Ϸ������Table���ͻ��ƶ���Painter��
		table = new Table(prePanel,this);
		painter = new Painter();
			
		//��ʼ��˫������������
		if(this.imageBuffer == null)
		{
			this.imageBuffer = 
					new BufferedImage(MyFrame.WINDOW_WIDTH,MyFrame.WINDOW_HEIGHT, BufferedImage.TYPE_INT_ARGB);
			this.gBuffer = this.imageBuffer.getGraphics();
		}
			
		//��ʼ����ѭ����ʱ��
		this.gameTimer = new Timer();
		}

	/**
	 * ��ʼ����һ����ѭ������������ʱ����
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
		//������ʱ����ִ��������󣨵���δ��ʼִ�ж�ʱ������
		gameTimerTask = new ReschedulableTimerTask() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				
				try {
					pushOneStep();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}//����Ϸ����Ԫ�ر仯һ�£����ػ�
				flag=(flag+1)%3000;
				try {
					onDraw();
					if(Home.hp == 0 ) {
						JDialog gameOver = new JDialog(mainFrame,"GameOver");
						JButton jb = new JButton("ȷ��");
						JLabel jl = new JLabel("����ʧ�� !  ���ȷ������ѡ�����");
						jl.setFont(new Font("����", Font.PLAIN, 20));
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
							if (e.getActionCommand().equals("ȷ��")) {
								// �ж��ǲ���ȷ����ť�����            
								gameOver.setVisible(false);// �Ի��򲻿ɼ�   
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
						JButton jb = new JButton("ȷ��");
						JLabel jl = new JLabel("����ɹ� !  ���ȷ������ѡ�����");
						jl.setFont(new Font("����", Font.PLAIN, 20));
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
							if (e.getActionCommand().equals("ȷ��")) {
								// �ж��ǲ���ȷ����ť�����            
								gameOver.setVisible(false);// �Ի��򲻿ɼ�   
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
				
				//������������ʧ
				
				//������������ʧ
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}//���»���
			}
		};
		
		startMainLoop();//��ʼ��ʱ��
	}
	
	
	private void pushOneStep() throws IOException {
		table.change(flag);
	}
	//��������ʱ��������������ѭ��
	public void startMainLoop(){
		//��FPSֵ������һ����ʱ��
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
//		Graphics src = prePanel.getGraphics();//��ȡ��ǰ���������Ļ�ͼ����
//		src.drawImage(imageBuffer, 0, 0, null);//ͨ�������ͼ���󣬰ѻ�����ͼ������ݣ�һ���ԡ����ơ��������Ŀ�������
	}
	//ʹ�ô�˫����ķ�������
	public void onDraw() throws IOException{
		
		
			drawGameSelf((Graphics2D)gBuffer);
		
		
			table.drawAll((Graphics2D)gBuffer);
		
			//�ѻ����л��Ƶ����ݻ��Ƶ���������
			Graphics src = prePanel.getGraphics();//��ȡ��ǰ���������Ļ�ͼ����
			src.drawImage(imageBuffer, 0, 0, null);//ͨ�������ͼ���󣬰ѻ�����ͼ������ݣ�һ���ԡ����ơ��������Ŀ�������
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

