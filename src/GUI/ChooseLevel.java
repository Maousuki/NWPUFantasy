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
 * ����壬�����ҵ����ݣ�Table��������ң�Painter���������ݣ��������
 * @author Administrator
 *
 */
public class ChooseLevel extends JPanel implements SecondGUI{
	private MyFrame myFrame;//���һ�������ڵ�����
	private MyPanel myPanel;//���һ��ǰһҳ��������ã�����
	private Painter painter;//������
	//˫������Ҫ�Ķ���
	private BufferedImage imageBuffer = null;//�����ͼ�����
	private Graphics gBuffer = null;//ͨ�����ڻ�������л�ͼ
	//ͨ�����췽�����������ڴ��������һ�ݣ�����
	public ChooseLevel(MyFrame myFrame,MyPanel myPanel){
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
		//�����ͼ����󣬰ѵ�һ�������Ƶ�ͼ�λ�����
		try {
			painter.drawOnePhotoOnTable(0,0,MyFrame.WINDOW_WIDTH-15,MyFrame.WINDOW_HEIGHT-46,"chooseLevel.png",(Graphics2D)this.gBuffer);
		} catch (IOException e) {
			throw new RuntimeException("һ�����桰����ѡ�񡱽������������쳣");
		}
		
		//�ѻ����л��Ƶ����ݻ��Ƶ���������
		Graphics src = myPanel.getGraphics();//��ȡ��ǰ���������Ļ�ͼ����
		src.drawImage(imageBuffer, 0, 0, null);//ͨ�������ͼ���󣬰ѻ�����ͼ������ݣ�һ���ԡ����ơ��������Ŀ�������
//		System.out.println("!!!!");
		myFrame.addMouseListener(myFrame.gui_3_1);

	}
	
//	@Override
//	public void paint(Graphics g) {
//		// TODO Auto-generated method stub
//		super.paint(g);
//		
//		onDraw();
//	}
}
