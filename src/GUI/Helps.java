package GUI;


import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.swing.JPanel;
import PaintTools.Painter;

public class Helps extends JPanel implements SecondGUI{

	/**
	 * �����ڣ��ṩ��Ϸ�ڵİ����ֲ�
	 */
	private static final long serialVersionUID = 1L;
	private MyFrame myFrame;//���һ�������ڵ�����
	private MyPanel myPanel;
	private Painter painter;////������
	//˫������Ҫ�Ķ���
	private BufferedImage imageBuffer = null;//�����ͼ�����
	private Graphics gBuffer = null;//ͨ�����ڻ�������л�ͼ
	public static int pageNumber = 1;
	

	//ͨ�����췽�����������ڴ��������һ�ݣ�����
	
	public Helps(MyFrame myFrame, MyPanel myPanel) {
		this.myFrame = myFrame;
		this.myPanel = myPanel;
		
		//���������ʱ�������ڴ˿��Ժͻ��ƶ���Painter��
		painter = new Painter();
		
		//��ʼ��˫������������
		if(this.imageBuffer == null)
		{
			this.imageBuffer = 
					new BufferedImage(MyFrame.WINDOW_WIDTH,MyFrame.WINDOW_HEIGHT, BufferedImage.TYPE_INT_ARGB);
			this.gBuffer = this.imageBuffer.getGraphics();
		} 
	}
	
	@Override
	public void start() throws IOException{
		myFrame.removeMouseListener(myFrame.gui_2);
		painter.drawOnePhotoOnTable(0,0,MyFrame.WINDOW_WIDTH-15,MyFrame.WINDOW_HEIGHT-46,"help1.png",(Graphics2D)this.gBuffer);
		//�ѻ����л��Ƶ����ݻ��Ƶ���������
		Graphics src =  myPanel.getGraphics();//��ȡ��ǰ�������Ļ�ͼ����
	    src.drawImage(imageBuffer, 0, 0, null);//ͨ�������ͼ���󣬰ѻ�����ͼ������ݣ�һ���ԡ����ơ��������Ŀ�������
	    myFrame.addMouseListener(myFrame.gui_3_3);
	    
	}
	
	public void last() throws IOException{
		switch(pageNumber) {
		case 1:
			painter.drawOnePhotoOnTable(0,0,MyFrame.WINDOW_WIDTH-15,MyFrame.WINDOW_HEIGHT-46,"help4.png",(Graphics2D)this.gBuffer);
			//�ѻ����л��Ƶ����ݻ��Ƶ���������
			Graphics src =  myPanel.getGraphics();//��ȡ��ǰ�������Ļ�ͼ����
	    	src.drawImage(imageBuffer, 0, 0, null);//ͨ�������ͼ���󣬰ѻ�����ͼ������ݣ�һ���ԡ����ơ��������Ŀ�������
	    	pageNumber = 4;
	    	break;
		case 2:
		    painter.drawOnePhotoOnTable(0,0,MyFrame.WINDOW_WIDTH-15,MyFrame.WINDOW_HEIGHT-46,"help1.png",(Graphics2D)this.gBuffer);
		    //�ѻ����л��Ƶ����ݻ��Ƶ���������
		    Graphics src1 =  myPanel.getGraphics();//��ȡ��ǰ�������Ļ�ͼ����
	        src1.drawImage(imageBuffer, 0, 0, null);//ͨ�������ͼ���󣬰ѻ�����ͼ������ݣ�һ���ԡ����ơ��������Ŀ�������
	        pageNumber = 1;
	        break;
		case 3:
			painter.drawOnePhotoOnTable(0,0,MyFrame.WINDOW_WIDTH-15,MyFrame.WINDOW_HEIGHT-46,"help2.png",(Graphics2D)this.gBuffer);
			//�ѻ����л��Ƶ����ݻ��Ƶ���������
			Graphics src2 =  myPanel.getGraphics();//��ȡ��ǰ�������Ļ�ͼ����
		    src2.drawImage(imageBuffer, 0, 0, null);//ͨ�������ͼ���󣬰ѻ�����ͼ������ݣ�һ���ԡ����ơ��������Ŀ�������
		    pageNumber = 2;
		    break;
		case 4:
			painter.drawOnePhotoOnTable(0,0,MyFrame.WINDOW_WIDTH-15,MyFrame.WINDOW_HEIGHT-46,"help3.png",(Graphics2D)this.gBuffer);
			//�ѻ����л��Ƶ����ݻ��Ƶ���������
			Graphics src3 =  myPanel.getGraphics();//��ȡ��ǰ�������Ļ�ͼ����
		    src3.drawImage(imageBuffer, 0, 0, null);//ͨ�������ͼ���󣬰ѻ�����ͼ������ݣ�һ���ԡ����ơ��������Ŀ�������
		    pageNumber = 3;
		    break;    
		}
	    	
	}
	

	public void next() throws IOException{	
		switch(pageNumber) {
		case 1:
			painter.drawOnePhotoOnTable(0,0,MyFrame.WINDOW_WIDTH-15,MyFrame.WINDOW_HEIGHT-46,"help2.png",(Graphics2D)this.gBuffer);
			//�ѻ����л��Ƶ����ݻ��Ƶ���������
			Graphics src =  myPanel.getGraphics();//��ȡ��ǰ�������Ļ�ͼ����
	    	src.drawImage(imageBuffer, 0, 0, null);//ͨ�������ͼ���󣬰ѻ�����ͼ������ݣ�һ���ԡ����ơ��������Ŀ�������
	    	pageNumber = 2;
	    	break;
		case 2:
		    painter.drawOnePhotoOnTable(0,0,MyFrame.WINDOW_WIDTH-15,MyFrame.WINDOW_HEIGHT-46,"help3.png",(Graphics2D)this.gBuffer);
		    //�ѻ����л��Ƶ����ݻ��Ƶ���������
		    Graphics src1 =  myPanel.getGraphics();//��ȡ��ǰ�������Ļ�ͼ����
	        src1.drawImage(imageBuffer, 0, 0, null);//ͨ�������ͼ���󣬰ѻ�����ͼ������ݣ�һ���ԡ����ơ��������Ŀ�������
	        pageNumber = 3;
	        break;
		case 3:
			painter.drawOnePhotoOnTable(0,0,MyFrame.WINDOW_WIDTH-15,MyFrame.WINDOW_HEIGHT-46,"help4.png",(Graphics2D)this.gBuffer);
			//�ѻ����л��Ƶ����ݻ��Ƶ���������
			Graphics src2 =  myPanel.getGraphics();//��ȡ��ǰ�������Ļ�ͼ����
		    src2.drawImage(imageBuffer, 0, 0, null);//ͨ�������ͼ���󣬰ѻ�����ͼ������ݣ�һ���ԡ����ơ��������Ŀ�������
		    pageNumber = 4;
		    break;
		case 4:
			painter.drawOnePhotoOnTable(0,0,MyFrame.WINDOW_WIDTH-15,MyFrame.WINDOW_HEIGHT-46,"help1.png",(Graphics2D)this.gBuffer);
			//�ѻ����л��Ƶ����ݻ��Ƶ���������
			Graphics src3 =  myPanel.getGraphics();//��ȡ��ǰ�������Ļ�ͼ����
		    src3.drawImage(imageBuffer, 0, 0, null);//ͨ�������ͼ���󣬰ѻ�����ͼ������ݣ�һ���ԡ����ơ��������Ŀ�������
		    pageNumber = 1;
		    break;    
		}
	}

	public void back() throws IOException{
		myFrame.removeMouseListener(myFrame.gui_3_3);
		myPanel.options();	
	}
}