package com.cvte.client.gui;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXRippler;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.effects.JFXDepthManager;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * @author jan
 * @date 2018年4月6日 上午12:03:08
 * @version V1.0 
 */
public class MarkDemo extends Application {
	
	private static JFXTextArea area = null;
	
	private static final String FX_BACKGROUND_COLOR_WHITE = "-fx-background-color:WHITE;";

	public void start(Stage stage) {
		
		GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(20);
        grid.setVgap(20);
        //grid.setPadding(new Insets(25, 25, 25, 25));
        grid.setPadding(new Insets(20, 20, 20, 20));

        Text scenetitle = new Text("Welcome");
        scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        
        Label l2 = new Label("Welcome");
        l2.setStyle(FX_BACKGROUND_COLOR_WHITE);
        l2.setPadding(new Insets(10, 10, 10, 10));       
        JFXRippler rippler2 = new JFXRippler(l2);
        JFXDepthManager.setDepth(rippler2, 2);
        
        grid.add(scenetitle, 0, 0, 2, 1);
        grid.add(rippler2, 0, 0, 2, 3);

//        Label userName = new Label("User Name:");
//        grid.add(userName, 0, 1);
//
//        TextField userTextField = new TextField();
//        grid.add(userTextField, 1, 1);
//
//        Label pw = new Label("Password:");
//        grid.add(pw, 0, 2);
//
//        PasswordField pwBox = new PasswordField();
//        grid.add(pwBox, 1, 2);
//
//        Button btn = new Button("Sign in");
//        HBox hbBtn = new HBox(10);
//        hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
//        hbBtn.getChildren().add(btn);
//        grid.add(hbBtn, 1, 4);
//
//        final Text actiontarget = new Text();
//        grid.add(actiontarget, 1, 6);
//
//        btn.setOnAction(new EventHandler<ActionEvent>() {
//
//            @Override
//            public void handle(ActionEvent e) {
//                //actiontarget.setFill(Color.FIREBRICK);
//            	actiontarget.setFill(Color.GREEN);
//                actiontarget.setText("Sign in button pressed");
//            }
//        });
		
//		final VBox main = new VBox();
//        main.setSpacing(30);
//        main.setStyle("-fx-background-color:WHITE;-fx-padding:40;");
//        FlowPane main = new FlowPane();
//        main.setVgap(20);
//        main.setHgap(20);
        
        //ButtonDemo.class.getResource("1.jpg")
        //Label l5 = new Label("IMG");
        
//        Image image = new Image(getClass().getResourceAsStream("1.jpg"));
//        ImageView iv1 = new ImageView();
//        iv1.setImage(image);
//        iv1.setStyle(FX_BACKGROUND_COLOR_WHITE);
//        iv1.setFitHeight(300);
//        iv1.setFitWidth(300);
        //l5.setPadding(new Insets(180));
        
        area = new JFXTextArea();
        area.setPromptText("日志输出");
        area.setLabelFloat(true);
        area.setMinHeight(300);
        area.setMinWidth(500);
        
        JFXRippler rippler5 = new JFXRippler(area);
        //grid.getChildren().add(rippler5);
        grid.add(rippler5, 2, 5);
        JFXDepthManager.setDepth(rippler5, 8);

        JFXButton button = new JFXButton("好");
        button.getStyleClass().add("button-raised");
        //grid.getChildren().add(button);
        grid.add(button, 0, 10);
        
        JFXButton button1 = new JFXButton("不好");
        button1.getStyleClass().add("button-raised");
        //grid.getChildren().add(button1);
        grid.add(button1, 4, 10);

        StackPane pane = new StackPane();
        pane.getChildren().add(grid);
        StackPane.setMargin(grid, new Insets(100));
        pane.setStyle("-fx-background-color:WHITE");

        final Scene scene = new Scene(pane, 800, 600);
        scene.getStylesheets().add(ButtonDemo.class.getResource("jfoenix-components.css").toExternalForm());
        stage.setTitle("眼  底  demo  系  统");
        stage.getIcons().add(new Image(getClass().getResourceAsStream("3.jpg")));
        stage.setScene(scene);
        stage.show();
        
    }

    public static void main(String[] args) {
    	Thread watchThread = new Thread(new Runnable() {
        	public void run() {
				for(int i = 0; i < 200000; i++) {
//					try {
//						Thread.sleep(5000);
//					} catch (InterruptedException e) {
//						e.printStackTrace();
//					}
					//MarkDemo.area.insertText(i, i + "=我是谁");
					//MarkDemo.area.setText(i + "=我是谁");
					if(MarkDemo.area == null) {
						//System.out.println("is null");
					}else {
						break;
						//MarkDemo.area.appendText("\t\n" + i + "=我是谁");
					}
				}
				
				for(int i = 0; i < 2000; i++) {
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					MarkDemo.area.appendText("\t\n" + i + "=我是谁");
				}
			}
		});
		watchThread.start();
    	System.out.println("start====");
        launch(args);
        System.out.println("end======");
    }

	
}
