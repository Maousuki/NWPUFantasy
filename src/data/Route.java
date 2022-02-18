package data;

class GuaiDian {

	// 拐点的坐标方向
	private int gd_x;
	private int gd_y;
	private int dir;

	/**
	 * 构造函数，需要传入坐标方向
	 * 
	 * @param gd_x 拐点x坐标
	 * @param gd_y 拐点y坐标
	 * @param dir  拐点方向
	 */
	public GuaiDian(int gd_x, int gd_y, int dir) {
		this.gd_x = gd_x;
		this.gd_y = gd_y;
		this.dir = dir;

	}

	/**
	 * 得到拐点对应属性属性
	 * 
	 * @return
	 */

	public int getGd_x() {
		return gd_x;
	}

	public void setGd_x(int gd_x) {
		this.gd_x = gd_x;
	}

	public int getGd_y() {
		return gd_y;
	}

	/**
	 * 重新设定拐点属性
	 * 
	 * @param gd_y
	 */

	public void setGd_y(int gd_y) {
		this.gd_y = gd_y;
	}

	public int getDir() {
		return dir;
	}

	public void setDir(int dir) {
		this.dir = dir;
	}

}

public class Route {

	private static final int LEFT = 1;
	private static final int RIGHT = 2;
	private static final int UP = 3;
	private static final int DOWN = 4;

	GuaiDian gd1 = new GuaiDian(105, 290, 2);
	GuaiDian gd2 = new GuaiDian(371, 290, 3);
	GuaiDian gd3 = new GuaiDian(371, 200, 2);
	GuaiDian gd4 = new GuaiDian(856, 200, 4);
	GuaiDian gd5 = new GuaiDian(856, 304, 2);

	public GuaiDian[] routes = { gd1, gd2, gd3, gd4, gd5};
	private int i = 0;
    private int max = 5;
    public int min(int a,int b) {
    	if(a<b)return a;
    	return b;
    }
    public int max(int a,int b) {
    	if(a>b)return a;
    	return b;
    }
	public Point2D changePosition(double mons_x, double mons_y) {
		
		Point2D point2D = new Point2D(mons_x,mons_y);
		if (i == 5) {
			return null;
		}
		GuaiDian guaiDian = routes[i];
		if (i < max) {
			if (guaiDian.getDir() == LEFT) {
				if (mons_y != guaiDian.getGd_y()) {
					if (mons_y - guaiDian.getGd_y() < 0) {
						mons_y=min((int)(mons_y+1),guaiDian.getGd_y());
						point2D.setY(mons_y);

					} else if (mons_y - guaiDian.getGd_y() > 0) {
						mons_y=max((int)(mons_y-1),guaiDian.getGd_y());
						point2D.setY(mons_y);

					}
				} else {
					mons_x=max((int)(mons_x-1),guaiDian.getGd_x());
					point2D.setX(mons_x);
					i++;
				}

			} else if (guaiDian.getDir() == RIGHT) {
				if (mons_y != guaiDian.getGd_y()) {
					if (mons_y - guaiDian.getGd_y() < 0) {
						mons_y=min((int)(mons_y+1),guaiDian.getGd_y());
						point2D.setY(mons_y);

					} else if (mons_y - guaiDian.getGd_y() > 0) {
						mons_y=max((int)(mons_y-1),guaiDian.getGd_y());
						point2D.setY(mons_y);

					}
				} else {
					mons_x=min((int)(mons_x+1),guaiDian.getGd_x());
					point2D.setX(mons_x);
					i++;
				}

			} else if (guaiDian.getDir() == UP) {
				if (mons_x != guaiDian.getGd_x()) {
					if (mons_x - guaiDian.getGd_x() < 0) {
						mons_x=min((int)(mons_x+1),guaiDian.getGd_x());
						point2D.setX(mons_x);

					} else if (mons_x - guaiDian.getGd_x() > 0) {
						mons_x=max((int)(mons_x-1),guaiDian.getGd_x());
						point2D.setX(mons_x);

					}
				} else {
					mons_y=max((int)(mons_y-1),guaiDian.getGd_y());
					point2D.setY(mons_y);
					i++;
				}

			} else if (guaiDian.getDir() == DOWN) {
				if (mons_x != guaiDian.getGd_x()) {
					if (mons_x - guaiDian.getGd_x() < 0) {
						mons_x=min((int)(mons_x+1),guaiDian.getGd_x());
						point2D.setX(mons_x);

					} else if (mons_x - guaiDian.getGd_x() > 0) {
						mons_x=max((int)(mons_x-1),guaiDian.getGd_x());
						point2D.setX(mons_x);

					}
				} else {
					mons_y=min((int)(mons_y+1),guaiDian.getGd_y());
					point2D.setY(mons_y);
					i++;
				}
			}
			
		}
		return point2D;
	}
}