package PaintTools;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Stroke;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import GUI.MyFrame;

/**
 * ����Ϊ����ġ��滭�ࡱ��������Ϸ���ݻ��Ƶ�����
 * @author Administrator
 *
 */
public class Painter {
	
	BufferedImage img_photo;//����ͼƬ
	//�չ��췽��
	public Painter() {
		
	}
	
	/**
	 * �ڲ�������ͨ��һ��ԭʼͼƬ���󣬰���ָ���Ŀ������ű��ʣ�������������������ͼƬ����
	 * @param originImg ԭʼͼƬ
	 * @param scaleX �����ű���
	 * @param scaleY �����ű���
	 * @return ����������Ŀ����Ƭ����
	 */
	private BufferedImage createScaledImg(BufferedImage originImg, float scaleX, float scaleY){
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
	 * �ڲ����������ڳ�ʼ��ͼƬԪ��
	 * @throws IOException 
	 */
	
	
	/**
	 * �ڲ���������������ͼƬ
	 */
	
	/**
	 * ���ݴ���ĸ��������꣬�ڽ����ϻ���һ������ͼƬ
	 * @param x ������ͼƬ��x���꣨������Ļ���Ͻǣ�
	 * @param y ������ͼƬ��y���꣨������Ļ���Ͻǣ�
	 * @param dx �����Ƶ�ͼƬ��x�᳤��
	 * @param dy �����Ƶ�ͼƬ��y������
	 * @param photoId ������ͼƬ���ļ���
	 */
	public void drawOnePhotoOnTable(int x, int y, int dx,int dy,String photoId, Graphics2D g2d) throws IOException{
		
		//��һ��������ԭʼͼƬ
		//��/res/imgsĿ¼������ԭʼ��Ƭ��δ���죩
		String photoAddress = "/imgs/"+photoId;
		BufferedImage origin_photo = ImageIO.read(Painter.class.getResource(photoAddress));
				
		//����ͼƬ��߱���
		float scaleX = dx / (float)origin_photo.getWidth();
		float scaleY = dy / (float)origin_photo.getHeight();
				
		//����������ͼƬ
		img_photo = createScaledImg(origin_photo, scaleX, scaleY);
		
		BufferedImage toDraw = img_photo;
		
		//���Ƴ��������
		g2d.drawImage(toDraw, x, y, dx, dy, null);
	}
	
}
