package GUI;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.swing.JPanel;

import PaintTools.Painter;


public class IlluBooks extends JPanel implements SecondGUI{
	/**
	 * ͼ���࣬չʾ��Ϸ������Ԫ�ص���Ϣ
	 */
	private static int page=0;         //ͼ���ĵ�ǰ����ҳ��
	private MyPanel myPanel;// ���һ�������ڵ�����
	private Painter painter;// ������
	private MyFrame myFrame;
	// ˫������Ҫ�Ķ���
	private BufferedImage imageBuffer = null;// �����ͼ�����
	private Graphics gBuffer = null;// ͨ�����ڻ�������л�ͼ

	public static int getPage() {
		return page;
	}


	public static void setPage(int page) {
		IlluBooks.page = page;
	}


	// ͨ�����췽�����������ڴ��������һ�ݣ�����
	public IlluBooks(MyFrame myFrame,MyPanel myPanel) {
		this.myPanel = myPanel;
		this.myFrame = myFrame;
		// ���������ʱ�������ڴ˿��Ժͻ��ƶ���Painter��
		painter = new Painter();

		// ��ʼ��˫������������
		if (this.imageBuffer == null) {
			this.imageBuffer = new BufferedImage(MyFrame.WINDOW_WIDTH, MyFrame.WINDOW_HEIGHT,
					BufferedImage.TYPE_INT_ARGB);
			this.gBuffer = this.imageBuffer.getGraphics();
		}
	}


	@Override
	public void start() throws IOException {

		myFrame.removeMouseListener(myFrame.gui_2); //�Ƴ�������ļ�����
		switch(page) {
		case 0:
			try {
				myFrame.removeMouseListener(myFrame.gui_3_2); //�Ƴ���һҳ��ť�ļ�����
				painter.drawOnePhotoOnTable(0,0,MyFrame.WINDOW_WIDTH-15,MyFrame.WINDOW_HEIGHT-46,"illu1.png",(Graphics2D)this.gBuffer);
			} catch (IOException e) {
				throw new RuntimeException("һ�����桰ͼ�����������������쳣");
			}
			break;
		case 1:
			try {
				myFrame.removeMouseListener(myFrame.gui_3_2); //�Ƴ���һҳ��ť�ļ�����
				painter.drawOnePhotoOnTable(0, 0, MyFrame.WINDOW_WIDTH - 15, MyFrame.WINDOW_HEIGHT - 46, "illu2.png",
						(Graphics2D) this.gBuffer);
			} catch (IOException e) {
				throw new RuntimeException("һ�����桰ͼ�����������������쳣");
			}
			break;
		case 2:
			try {
				myFrame.removeMouseListener(myFrame.gui_3_2); //�Ƴ���һҳ��ť�ļ�����
				painter.drawOnePhotoOnTable(0,0,MyFrame.WINDOW_WIDTH-15,MyFrame.WINDOW_HEIGHT-46,"illu3.png",(Graphics2D)this.gBuffer);
			} catch (IOException e) {
				throw new RuntimeException("һ�����桰ͼ�����������������쳣");
			}
			break;
		case 3:
			try {
				myFrame.removeMouseListener(myFrame.gui_3_2); //�Ƴ���һҳ��ť�ļ�����
				painter.drawOnePhotoOnTable(0,0,MyFrame.WINDOW_WIDTH-15,MyFrame.WINDOW_HEIGHT-46,"illu4.png",(Graphics2D)this.gBuffer);
			} catch (IOException e) {
				throw new RuntimeException("һ�����桰ͼ�����������������쳣");
			}
			break;
		}
		
		//�ѻ����л��Ƶ����ݻ��Ƶ���������
		Graphics src = myPanel.getGraphics();//��ȡ��ǰ���������Ļ�ͼ����
		src.drawImage(imageBuffer, 0, 0, null);//ͨ�������ͼ���󣬰ѻ�����ͼ������ݣ�һ���ԡ����ơ��������Ŀ�������
		myFrame.addMouseListener(myFrame.gui_3_2);//��ͼ����������м��������ص�Frame����
	}

}
