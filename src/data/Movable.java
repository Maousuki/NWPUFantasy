package data;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

/**
 * �����ϣ����п��Զ��ƶ�������Ĺ�ͬ���࣬�Ҽ����ˡ��������ڡ�������������Щ�������С����١�
 * @author Administrator
 *
 */
public class Movable {
	protected double posX;//x����
	protected double posY;//y����
	private int lifeCircle;//�������ڵ�λΪ���룬0��������
	private int lifeDuration;//��ǰ�����Ѿ����ȹ���������������
	
	public Movable(double posX2, double posY2,int lifeCircle) {
		super();
		this.posX = posX2;
		this.posY = posY2;
		this.lifeCircle = lifeCircle;
		this.lifeDuration = 0;//�������壬һ�������Ѿ������������ڶ���0
	}
	
	/**
	 * ���󷽷�������ʵ�������ܹ����Լ��ܹ����Ƴ���
	 * @param g2d ���ƶ��󣨻��ʣ�
	 */
	
	public double getPosX() {
		return posX;
	}

	public double getPosY() {
		return posY;
	}
	
	/**
	 * ���߷�����ͨ��һ��ԭʼͼƬ���󣬰���ָ���Ŀ������ű��ʣ�������������������ͼƬ����
	 * @param originImg ԭʼͼƬ
	 * @param scaleX �����ű���
	 * @param scaleY �����ű���
	 * @return ����������Ŀ����Ƭ����
	 */
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
	
	/**
	 * ����һ������Ŀ�����꣬�ı䵱ǰ���������
	 * @param destX Ŀ��X����
	 * @param destY
	 */
	public void changePositionAbsolute(float destX, float destY){
		this.posX = destX;
		this.posY = destY;
	}
	
	/**
	 * ͨ��һ��ƫ�����꣨��ֵ�����ı䵱ǰ���������
	 * @param dx
	 * @param dy
	 */
	public void changePositionRelative(double dx, double dy){
		this.posX += dx;
		this.posY += dy;
	}
	
	/**
	 * �õ�ǰ���������ȹ�һ��ʱ�䣨��������
	 * @param lifePassed �ȹ���ʱ�䣨���룩
	 * @return ��ǰ�����Ƿ���ս��ˣ�true��ʾ���������ѵ���false��ʾ��������δ��
	 */
	public boolean lifePass(float lifePassed){
		if(lifeCircle == 0){
			//����ǰ����Ϊ���������ģ���ֱ�ӷ���false�������������������壩
			return false;
		}
		
		//��ǰ�Ѷȹ����������ڣ����ϱ��ζȹ�����������
		this.lifeDuration += lifePassed;
		
		//�������������Ƿ��Ѿ����
		return lifeDuration >= lifeCircle;
	}
	
	/**
	 * ��֪��ǰ���������Ƿ��ѵ������ս���
	 * @return true��ʾ���������ѵ���false��ʾ��������δ��
	 */
	public boolean lifeEnded(){
		if(lifeCircle == 0){
			//����ǰ����Ϊ���������ģ���ֱ�ӷ���false�������������������壩
			return false;
		}
		
		//�������������Ƿ��Ѿ����
		return lifeDuration >= lifeCircle;
	}
}
