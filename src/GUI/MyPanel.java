package GUI;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.swing.JPanel;
import PaintTools.Painter;

//import com.chinasofti.xian.tetris.Painter;
//import com.chinasofti.xian.tetris.Table;

/**
 * ��Ϸ����壬������Ϸ���ݻᡰ���ơ���������У���Ҳ������Ϸ�Ŀ��ƣ�������ƺ�̨��<br>
 * ����壬����ң�Painter���������ݣ��������
 * @author Administrator
 *
 */
public class MyPanel extends JPanel {
	/**
	 * һ�����滭�壬���Ի��ơ���ʼ��Ϸ��ҳ��͡�����ѡ�񡱽���
	 */
	private static final long serialVersionUID = 1L;
	private MyFrame myFrame;//���һ�������ڵ�����
	private Painter painter;//������

	//˫������Ҫ�Ķ���
	private BufferedImage imageBuffer = null;//�����ͼ�����
	private Graphics gBuffer = null;//ͨ�����ڻ�������л�ͼ
	//ͨ�����췽�����������ڴ��������һ�ݣ�����
	
	//�����ĸ�ѡ��
	ChooseLevel chooseLevel = null;
	IlluBooks illuBooks = null;
	Helps helps = null;
	AboutUs aboutUs = null;
	
	public MyPanel(MyFrame myFrame) throws IOException{
		this.myFrame = myFrame;
		//���������ʱ�������ڴ˿��Ժͻ��ƶ���Painter��
		painter = new Painter();
		//��ʼ��4��ѡ���������Ķ���
		this.chooseLevel = new ChooseLevel(myFrame,this);
		this.illuBooks = new IlluBooks(myFrame,this);
		this.helps = new Helps(myFrame, this);
		this.aboutUs = new AboutUs(myFrame,this);
		//��ʼ��˫������������
		if(this.imageBuffer == null)
		{
			this.imageBuffer = 
					new BufferedImage(MyFrame.WINDOW_WIDTH,MyFrame.WINDOW_HEIGHT, BufferedImage.TYPE_INT_ARGB);
			this.gBuffer = this.imageBuffer.getGraphics();
		}
		//��ʼ������궯��
//		System.out.println(this);

		
	}
	
	public void start() {
		//�����ͼ����󣬰ѵ�һ�������Ƶ�ͼ�λ�����
		try {
			painter.drawOnePhotoOnTable(0,0,MyFrame.WINDOW_WIDTH-15,MyFrame.WINDOW_HEIGHT-46,"StartInterface.png",(Graphics2D)this.gBuffer);
		} catch (IOException e) {
			throw new RuntimeException("��ʼ��������¼��������쳣");
		}
		
		//�ѻ����л��Ƶ����ݻ��Ƶ���������
		Graphics src = this.getGraphics();//��ȡ��ǰ���������Ļ�ͼ����
		src.drawImage(imageBuffer, 0, 0, null);//ͨ�������ͼ���󣬰ѻ�����ͼ������ݣ�һ���ԡ����ơ��������Ŀ�������
		myFrame.addMouseListener(myFrame.gui_1);

	}
	public void options() throws IOException{
		//�����ͼ����󣬰Ѷ��������Ƶ�ͼ�λ�����
		painter.drawOnePhotoOnTable(0,0,MyFrame.WINDOW_WIDTH-15,MyFrame.WINDOW_HEIGHT-46,"OptionsInterface.png",(Graphics2D)this.gBuffer);

		//�ѻ����л��Ƶ����ݻ��Ƶ���������
		Graphics src = this.getGraphics();//��ȡ��ǰ���������Ļ�ͼ����
//		src=null;
		src.drawImage(imageBuffer, 0, 0, null);//ͨ�������ͼ���󣬰ѻ�����ͼ������ݣ�һ���ԡ����ơ��������Ŀ�������
		myFrame.addMouseListener(myFrame.gui_2);
	}
//	@Override
//	public void paint(Graphics g) {
//		// TODO Auto-generated method stub
//		super.paint(g);
//		
//		onDraw();
//	}
}
