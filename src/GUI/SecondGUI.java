package GUI;
/**
 * 二级界面接口，还有公共方法start（）
 * @author 2019302948邢文成
 */
import java.io.IOException;

public interface SecondGUI {
	/**
	 * 
	 * @param myPanel 一级界面
	 * @throws IOException
	 */
	public void start() throws IOException;
}
