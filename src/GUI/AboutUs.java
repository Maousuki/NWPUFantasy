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

public class AboutUs  extends JPanel implements  SecondGUI {
	private static final long serialVersionUID = 1L;

	private MyFrame myFrame;
	private MyPanel myPanel;
	// ���ذ�ť�Ŀ�Ⱥ͸߶�
	static final int RETURN_WIDTH = 50;
	static final int RETURN_HEIGHT = 50;

	private Painter painter;// �滭������
	private BufferedImage imageBuffer = null;// �����ͼ�����
	private Graphics gBuffer = null;// ͨ�����ڻ�������л�ͼ

	public AboutUs(MyFrame myFrame, MyPanel myPanel) {

		this.myFrame = myFrame;
		this.myPanel = myPanel;
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
		
		
		
		// TODO Auto-generated method stub
        painter.drawOnePhotoOnTable(0, 0, myPanel.getWidth(), myPanel.getHeight(), "aboutUsInterface.png",
				(Graphics2D) gBuffer);

		// �ѻ����л��Ƶ����ݻ��Ƶ���������
		Graphics src = myPanel.getGraphics();
		src.drawImage(imageBuffer, 0, 0, null);

		BufferedImage imageBuffer_2 = new BufferedImage(myPanel.getWidth(), myPanel.getHeight(),
				BufferedImage.TYPE_INT_ARGB);// �����ͼ�����
		Graphics gBuffer_2 = imageBuffer_2.getGraphics();// ͨ�����ڻ�������л�ͼ
		painter.drawOnePhotoOnTable(0, 0, RETURN_WIDTH, RETURN_HEIGHT, "returnInterface.png", (Graphics2D) gBuffer_2);
		src.drawImage(imageBuffer_2, myPanel.getWidth() - RETURN_WIDTH, 0, null);
		// ȥ����һ�¼��ļ�����
				myFrame.removeMouseListener(myFrame.gui_2);
		// ���������ǽ�����¼��������������������

		myFrame.addMouseListener(myFrame.gui_3_4);

	}

}
