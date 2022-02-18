package GUI;

import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;

import javax.swing.JFrame;

import PaintTools.Music;
import data.Point;

/**
 * �����ϴ��������ڣ�����������һ���ӻ����ڣ��������������̵���������<br>
 * ���ڲ���������Ϸ����������ͼ��java��Ϊpanel��壩
 *
 */
public class MyFrame extends JFrame {
	// ���ڵĿ��ߣ�������
	public static final int WINDOW_WIDTH = 1000;
	public static final int WINDOW_HEIGHT = 600;
	private static MyPanel myPanel;
	public static int position = 0;
	private Game game;
	private Music music = new Music();
	/**
	 * ��ǰ�Զ��崰�ڵĹ��췽����������������ƴ��ڵ���ʽ����Ϊ
	 * @throws IOException 
	 */
	MouseListener gui_1=new MouseListener() {//��������¼�
		@Override
		public void mouseClicked(MouseEvent e) {//�����(���ɿ�ǰ���߲���)
			// TODO Auto-generated method stub
			int x=e.getX();
			int y=e.getY();
//			System.out.println(x+"  "+y+"  "+e.getButton());
			if(e.getButton()==1&&x>=356&&x<=625&&y>=447&&y<=518)//����������ڰ�ť������
				try {
					music.play("click.wav");
					removeMouseListener(gui_1);
					myPanel.options();//����ѡ�����
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			return;
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			return;
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			return;
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			return;
		}
	};
	MouseListener gui_2=new MouseListener() {
		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			int x=e.getX();
			int y=e.getY();
			if(e.getButton()==1) {
				if(x>=375&&x<=591&&y>=107&&y<=177) {
					try {
						music.play("click.wav");
						removeMouseListener(gui_2);
						chooseLevel();//����ѡ�ؽ���
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				else if(x>=375&&x<=591&&y>=201&&y<=271) {
					try {
						music.play("click.wav");
						removeMouseListener(gui_2);
						illustratedBooks();//����ͼ������
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				else if(x>=375&&x<=591&&y>=306&&y<=376) {
					try {
						music.play("click.wav");
						removeMouseListener(gui_2);
						helps();//�����������
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				else if(x>=375&&x<=591&&y>=411&&y<=481) {
					try {
						music.play("click.wav");
						removeMouseListener(gui_2);
						aboutUs();//����������ǽ���
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		}
		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			return;
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			return;
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			return;
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			return;
		}
		
	};
	MouseListener gui_3_1 = new MouseListener() {//��������¼�
		@Override
		public void mouseClicked(MouseEvent e) {//�����(���ɿ�ǰ���߲���)
			// TODO Auto-generated method stub
			int x=e.getX();
			int y=e.getY();
//			System.out.println(x+"  "+y+"  "+e.getButton());
			//68 437
			//321 281
			//586 150
			//453 151
			//902 287
			if(e.getButton() == MouseEvent.BUTTON1) {
				if((x-142)*(x-142)+(y-278)*(y-278)<=100*100) {
					try {
						music.play("click.wav");
						theFirstLevel();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				else if((x-414)*(x-414)+(y-490)*(y-490)<=100*100) {
					try {
						music.play("click.wav");
						theSecondLevel();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				else if((x-704)*(x-704)+(y-213)*(y-213)<=100*100) {
					try {
						music.play("click.wav");
						theThirdLevel();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			return;
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			return;
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			return;
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			return;
		}
	};
	public MouseListener gui_4_1 = new MouseListener() {// ��������¼�
		@Override
		public void mouseClicked(MouseEvent e) {// �����(���ɿ�ǰ���߲���)
			// TODO Auto-generated method stub
			int x = e.getX();
			int y = e.getY();
	//		System.out.println(x+"  "+y+"  "+e.getButton());
			// 68 437
			// 321 281
			// 586 150
			// 453 151
			// 902 287
			if (e.getButton() == MouseEvent.BUTTON1) {
				if ((x - 246) * (x - 246) + (y - 247) * (y - 247) <= 30 * 30) {
					try {
						music.play("click.wav");
						position = 1;
						game.point.chooseTower();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				} else if ((x - 381) * (x - 381) + (y - 437) * (y - 437) <= 30 * 30) {
					try {
						music.play("click.wav");
						position = 2;
						game.point.chooseTower();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				} else if ((x - 718) * (x - 718) + (y - 164) * (y - 164) <= 30 * 30) {
					try {
						music.play("click.wav");
						position = 3;
						game.point.chooseTower();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				} else if ((x - 738) * (x - 738) + (y - 338) * (y - 338) <= 30 * 30) {
					try {
						music.play("click.wav");
						position = 4;
						game.point.chooseTower();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			return;
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			return;
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			return;
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			return;
		}
	};

	/*
	 * ����ѡ�������¼�
	 */
	public MouseListener gui_4_2 = new MouseListener() {// ��������¼�
		@Override
		public void mouseClicked(MouseEvent e) {// �����(���ɿ�ǰ���߲���)
			// TODO Auto-generated method stub
			int x = e.getX();
			int y = e.getY();
//			System.out.println(x+"  "+y+"  "+e.getButton());
			// 68 437
			// 321 281
			// 586 150
			// 453 151
			// 902 287
			if (e.getButton() == MouseEvent.BUTTON1) {
//				System.out.println(x+"   "+y);
				if (x <= 770 && x >= 675 && y <= 540 && y >= 420) {
					music.play("click.wav");
					game.setTower(game.posX, game.posY, 1);
				} else if (x <= 870 && x >= 775 && y <= 540 && y >= 420) {
					music.play("click.wav");
					game.setTower(game.posX, game.posY, 2);
				} else if (x <= 970 &&x >= 875 && y <= 540 && y >=420) {
					music.play("click.wav");
					game.setTower(game.posX, game.posY, 3);
				}
			}
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			return;
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			return;
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			return;
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			return;
		}
	};
	MouseListener gui_3_2 = new MouseListener() {// ��������¼�
		@Override
		public void mouseClicked(MouseEvent e) {// �����(���ɿ�ǰ���߲���)
			// TODO Auto-generated method stub
			int x = e.getX();
			int y = e.getY(); //��ȡ�����������

			//��һҳ����
			if (e.getButton() == MouseEvent.BUTTON1) {
				if (IlluBooks.getPage() == 0 && x >= 914 && x <= 985 && y >= 280 && y <= 343) {
					try {
						IlluBooks.setPage(1);
						illustratedBooks();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				} else if (IlluBooks.getPage() == 1 && x >= 914 && x <= 985 && y >= 280 && y <= 343) {
					try {
						IlluBooks.setPage(2);
						illustratedBooks();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				} else if (IlluBooks.getPage() == 2 && x >= 914 && x <= 985 && y >= 280 && y <= 343) {
					try {
						IlluBooks.setPage(3);
						illustratedBooks();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				} else if (IlluBooks.getPage() == 3 && x >= 914 && x <= 985 && y >= 280 && y <= 343) {
					try {
						IlluBooks.setPage(0);
						illustratedBooks();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			}

			//��һҳ����
			if (IlluBooks.getPage() == 0 && x >= 18 && x <= 89 && y >= 280 && y <= 343) {
				try {
					IlluBooks.setPage(3);
					illustratedBooks();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			} else if (IlluBooks.getPage() == 1 && x >= 18 && x <= 89 && y >= 280 && y <= 343) {
				try {
					IlluBooks.setPage(0);
					illustratedBooks();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			} else if (IlluBooks.getPage() == 2 && x >= 18 && x <= 89 && y >= 280 && y <= 343) {
				try {
					IlluBooks.setPage(1);
					illustratedBooks();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			} else if (IlluBooks.getPage() == 3 && x >= 18 && x <= 89 && y >= 280 && y <= 343) {
				try {
					IlluBooks.setPage(2);
					illustratedBooks();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

			//���������湦��
			if (x >= 914 && x <= 979 && y >= 45 && y <= 86) {
				try {
					removeMouseListener(gui_3_2);
					myPanel.options(); //����������
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			return;
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			return;
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			return;
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			return;
		}

	};
	
	MouseListener gui_3_3 = new MouseListener() {//��������¼�
		@Override
		public void mouseClicked(MouseEvent e) {//�����(���ɿ�ǰ���߲���)
			// TODO Auto-generated method stub
			int x=e.getX();
			int y=e.getY();
			if(e.getButton() == MouseEvent.BUTTON1) {
				if((x-42)*(x-42)+(y-312)*(y-312)<=37*37) {
					try {
						music.play("click.wav");
						myPanel.helps.last();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				
				else if((x-940)*(x-940)+(y-313)*(y-313)<=37*37) {
					try {
						music.play("click.wav");
						myPanel.helps.next();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				else if(e.getButton()==1&&x>=907&&x<=968&&y>=52&&y<=95) {
					try {
						music.play("click.wav");
						myPanel.helps.back();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				
			}
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			return;
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			return;
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			return;
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			return;
		}
	};
	
	MouseListener gui_3_4=new MouseListener() {//��������¼�
		@Override
		public void mouseClicked(MouseEvent e) {//�����(���ɿ�ǰ���߲���)
			// TODO Auto-generated method stub
			int x=e.getX();
			int y=e.getY();
//			System.out.println(x+"  "+y+"  "+e.getButton());
			if(e.getButton()==1 && x >= myPanel.getWidth()-AboutUs.RETURN_WIDTH && x <=myPanel.getWidth() &&y>=0&&y<=AboutUs.RETURN_HEIGHT)
				
				try {
					music.play("click.wav");
					myPanel.options();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
	};

	public MyFrame() throws IOException {
		this.setTitle("�����ϴ� v1.0");// ���ñ���
		this.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);// ���ô��ڴ�С
		this.setResizable(false);// ��ֹ������С

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// ��ǰ�����������ڹ������̣����ڹر�ʱ�˳�����

		myPanel = new MyPanel(this);// �����Զ�����壬���������Լ���������
//		yPanel myPanel = new MyPanel(this);
//	/	yPanel myPanel = new MyPanel(this);
		// yPanel myPanel = new MyPanel(this);

		this.getContentPane().add(myPanel);// ���Զ�����Ϸ����壬��ӵ����ڵ��������

		this.setVisible(true);// �ô��ڿ���

	}

	public void chooseLevel() throws IOException {
		myPanel.chooseLevel.start();
	}
	public void illustratedBooks() throws IOException{
		myPanel.illuBooks.start();
	}
	public void helps() throws IOException{
		myPanel.helps.start();

	}
	public void aboutUs() throws IOException{
		myPanel.aboutUs.start();

	}

	public void theFirstLevel() throws IOException {
		game = new Game(this, myPanel);
		game.initMainLoop();
	}

	public void theSecondLevel() throws IOException {
		
	}

	public void theThirdLevel() throws IOException {
		
	}

	public static void main(String[] args) throws IOException {
		new MyFrame();// ���������ڶ����ڲ����Զ�������������ʾ����
		myPanel.start();
	}
}
