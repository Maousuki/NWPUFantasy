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
 * 此类为界面的“绘画类”，负责将游戏数据绘制到界面
 * @author Administrator
 *
 */
public class Painter {
	
	BufferedImage img_photo;//所画图片
	//空构造方法
	public Painter() {
		
	}
	
	/**
	 * 内部方法，通过一个原始图片对象，按照指定的宽、高缩放比率，拉伸它并返回拉伸后的图片对象
	 * @param originImg 原始图片
	 * @param scaleX 宽缩放比率
	 * @param scaleY 高缩放比率
	 * @return 返回拉伸后的目标照片对象
	 */
	private BufferedImage createScaledImg(BufferedImage originImg, float scaleX, float scaleY){
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
	
	/**
	 * 内部方法，用于初始化图片元素
	 * @throws IOException 
	 */
	
	
	/**
	 * 内部方法，绘制任意图片
	 */
	
	/**
	 * 根据传入的格子数坐标，在界面上绘制一个格子图片
	 * @param x 待绘制图片的x坐标（基于屏幕左上角）
	 * @param y 待绘制图片的y坐标（基于屏幕左上角）
	 * @param dx 待绘制的图片的x轴长度
	 * @param dy 待绘制的图片的y轴坐标
	 * @param photoId 待绘制图片的文件名
	 */
	public void drawOnePhotoOnTable(int x, int y, int dx,int dy,String photoId, Graphics2D g2d) throws IOException{
		
		//第一步：加载原始图片
		//从/res/imgs目录，加载原始照片（未拉伸）
		String photoAddress = "/imgs/"+photoId;
		BufferedImage origin_photo = ImageIO.read(Painter.class.getResource(photoAddress));
				
		//计算图片宽高比例
		float scaleX = dx / (float)origin_photo.getWidth();
		float scaleY = dy / (float)origin_photo.getHeight();
				
		//创建拉伸后的图片
		img_photo = createScaledImg(origin_photo, scaleX, scaleY);
		
		BufferedImage toDraw = img_photo;
		
		//绘制出这个格子
		g2d.drawImage(toDraw, x, y, dx, dy, null);
	}
	
}
