package util;
/** 
* @author: jan 
* @date: 2018年5月8日 上午9:44:40 
*/
import java.awt.BorderLayout;
import java.awt.Toolkit;

import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

import javax.swing.JFrame;

public class WebUITest {
	private static final int WIDTH = 1200;
	private static final int HEIGHT = 600;
	private static final String url = "http://localhost:8080/Glaucoma/";
	//private static final String urlStart = "http://";

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		JFrame frame = new JFrame("CVTE医疗图像标注平台");
		final JFXPanel webBrowser = new JFXPanel();
		frame.setLayout(new BorderLayout());
		frame.add(webBrowser, BorderLayout.CENTER);
		Platform.runLater(new Runnable() {

			@Override
			public void run() {
				Group root = new Group();
				Scene scene = new Scene(root, WIDTH, HEIGHT);
				webBrowser.setScene(scene);
				Double widthDouble = new Integer(WIDTH).doubleValue();
				Double heightDouble = new Integer(HEIGHT).doubleValue();

				WebView view = new WebView();
				view.setMinSize(widthDouble, heightDouble);
				view.setPrefSize(widthDouble, heightDouble);
				final WebEngine eng = view.getEngine();
				eng.load(url);
				root.getChildren().add(view);
			}
		});

		int screenWidth = Toolkit.getDefaultToolkit().getScreenSize().width;
		int screenHeight = Toolkit.getDefaultToolkit().getScreenSize().height;

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(WIDTH, HEIGHT);
		frame.setLocation((screenWidth - WIDTH) / 2, (screenHeight - HEIGHT) / 2);
		frame.setVisible(true);
	}

}
