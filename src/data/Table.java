package data;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.LinkedList;

import GUI.Game;
import GUI.MyFrame;
import GUI.MyPanel;

public class Table {
	private MyPanel prePanel;
	//����������
	private LinkedList<Tower> towers = new LinkedList<Tower>();
	private Home home =null;
	public LinkedList<Monster> monsters = new LinkedList<Monster>();
	private LinkedList<Monster> removemonsters = null;
	private Game myGame;
	public Table(MyPanel prePanel,Game myGame) {
		this.home = new Home(prePanel);
		this.myGame=myGame;
		this.prePanel = prePanel;
	}
	public int getMonstersSize() {
		return monsters.size();
	}
	public void dltBlood(int index,int hurt){
		System.out.println("!!!"+monsters.get(index).getBlood());
		monsters.get(index).setBlood(monsters.get(index).getBlood()-hurt);
	}
	public void setTower(MyFrame myFrame,MyPanel myPanel,double posX,double posY,int id) {
		towers.add(new Tower(this,myFrame,myPanel,posX,posY,id));
	}
	/**
	 * @return ����table�е�monsters����
	 */
	public LinkedList<Monster> getMonsters(){
		return monsters;
	}

	public Monster getMonsters(int index){
		return monsters.get(index);
	}
	/**
	 * �������е�Ŀ������
	 * @param gBuffer 
	 * @throws IOException 
	 */
	public void drawAll(Graphics2D g2d) throws IOException {
//		synchronized("123") {
		drawMonster(g2d);
		drawPoint(g2d);
//		}
		drawCard(g2d);
		drawHome(g2d);
		drawTower(g2d);	
		
	}
	/**
	 * �������е�����������
	 * @throws IOException 
	 */
	private void drawCard(Graphics2D g2d) throws IOException {
		myGame.drawCard(g2d);
	}
	private void drawPoint(Graphics2D g2d) throws IOException {
		myGame.drawPoint(g2d);
	}
	/**
	 * �������е��������������ӵ�
	 * @throws IOException 
	 */
	private void drawTower(Graphics2D g2d) throws IOException {
		for(Tower tower : towers) {
//			System.out.println("tower: "+tower.getPosX()+"   "+tower.getPosY());
			tower.drawSelf(g2d);
		}
	}
	/**
	 * �������еĹ���
	 */
	private void drawMonster(Graphics2D g2d) {
		for(Monster monster : monsters)

			{
			monster.drawSelf(g2d);
			}
		
	}
		
	/**
	 * ����home�Ǳ�
	 * @throws IOException 
	 */
	private void drawHome(Graphics2D g2d) throws IOException {
		home.drawSelf(g2d);
	}
		
	/**
	 * ����ˢ��
	 * ��������ˢ��
	 * �����ƶ�
	 * point�������򲻱�
	 * home����ˢ��
	 * @throws IOException 
	 */
	public void change(int flag) throws IOException {
		if(flag==0|| flag==100 || flag == 200 || flag == 300 || flag ==400 ||flag == 500 || flag == 600)
		{
			int i = (int)flag/50;
			i=i%5;
			if(i < 1) {
				i=1;
			}else if(i > 4 ) {
				i=1;
			}
			monsters.add(new Monster(105, 60, prePanel, i));
		}
		for(Monster monster : monsters)monster.move();
		for(Tower tower: towers) {
			int T=60*tower.getCycle()/1000;
			tower.move();
			if(flag%T==0)tower.launch();
		}
	}
		
	/**
	 * ��������Ĺ���
	 */
	public void flushMonster() {
		for(Monster removeMonster: removemonsters) {
			monsters.remove(removeMonster);
		}
	}
}
