package util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXRippler;
import com.jfoenix.controls.JFXTabPane;
import com.jfoenix.effects.JFXDepthManager;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.image.Image;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class RipplerDemo extends Application {

    private static final String FX_BACKGROUND_COLOR_WHITE = "-fx-background-color:WHITE;";
    private static int counter = 0;
    private static int step = 1;

    @Override
    public void start(Stage stage) {

        //TODO drop shadow changes the width and height thus need to be considered
        //FlowPane main = new FlowPane();
    	HBox root = new HBox();
    	VBox box = new VBox();
    	FlowPane main = new FlowPane();
    	root.getChildren().add(main);
    	//main.setPadding(new Insets(50));
    	//main.setSpacing(50);
    	//main.setAlignment(Pos.CENTER);
        main.setVgap(10);
        main.setHgap(10);
        
        JFXTabPane tabPane = new JFXTabPane();
        tabPane.setPrefSize(550, 560);
        //tabPane.setMinSize(570, 490);
        Tab tab1 = new Tab();
        tab1.setText("视   盘");
        Canvas canvas1 = new Canvas(530, 530);
        double width1 = 530*4;
        double height1 = 530*4;
        GraphicsContext gc1 = canvas1.getGraphicsContext2D();
        File filePan = new File("C:\\Users\\CVTE\\Desktop\\test4\\mark\\2018-05-28214154\\user2\\data\\C.Users.Administrator.Desktop.眼底照.眼底照\\267\\L.jpg");
        InputStream fisPan = null;
		try {
			fisPan = new FileInputStream(filePan);
		} catch (FileNotFoundException e5) {
			e5.printStackTrace();
		}
        Image img1 = new Image(fisPan, width1, height1, true, true);
        gc1.drawImage(img1, 0,
        		0,
        		530, 530, 0, 0, 530, 530);
        JFXRippler rippler5 = new JFXRippler(canvas1);
        tab1.setContent(rippler5);
        JFXDepthManager.setDepth(rippler5, 5);
        
        Tab tab2 = new Tab();
        tab1.setText("视   盘");
        Canvas canvas2 = new Canvas(530, 530);
        double width2 = 530*4;
        double height2 = 530*4;
        GraphicsContext gc2 = canvas1.getGraphicsContext2D();
        File filePan1 = new File("C:\\Users\\CVTE\\Desktop\\test4\\mark\\2018-05-28214154\\user2\\data\\C.Users.Administrator.Desktop.眼底照.眼底照\\267\\L.jpg");
        InputStream fisPan1 = null;
		try {
			fisPan1 = new FileInputStream(filePan1);
		} catch (FileNotFoundException e5) {
			e5.printStackTrace();
		}
        Image img2 = new Image(fisPan1, width2, height2, true, true);
        gc2.drawImage(img2, 0,
        		0,
        		530, 530, 0, 0, 530, 530);
        JFXRippler rippler6 = new JFXRippler(canvas2);
        tab2.setContent(rippler6);
        JFXDepthManager.setDepth(rippler6, 5);
        
        tabPane.getTabs().add(tab1);
        tabPane.getTabs().add(tab2);
        main.getChildren().add(tabPane);
        box.getChildren().add(main);
        
        HBox hb = new HBox();
        JFXButton btn = new JFXButton("ssss");
        JFXButton btn1 = new JFXButton("ssss");
        hb.getChildren().add(btn);
        hb.getChildren().add(btn1);
        box.getChildren().add(hb);

        StackPane pane = new StackPane();
        pane.getChildren().add(box);
        StackPane.setMargin(root, new Insets(50));
        pane.setStyle("-fx-background-color:WHITE");

        final Scene scene = new Scene(pane, 1260, 600);

        stage.setTitle("JavaFX Ripple effect and shadows ");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();

    }

	public static void main(String[] args) {
        launch(args);
    }
}
