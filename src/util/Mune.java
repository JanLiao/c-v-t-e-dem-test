package util;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/** 
* @author: jan 
* @date: 2018年5月21日 上午12:46:59 
*/
public class Mune extends Application {

	@Override
	public void start(Stage stage) throws Exception {
stage.initStyle(StageStyle.TRANSPARENT);
        
        VBox root = new VBox();
        root.setId("root");
        // 引入样式
        root.getStylesheets().add(Mune.class.getResource("style.css").toString());
        
        //顶部
        VBox top = new VBox();
        top.setId("top");
        top.setPrefSize(300,26);
        // 标题栏
        AnchorPane title = new AnchorPane();
        Label close = new Label();
        close.setPrefWidth(33);
        close.setPrefHeight(26);
        close.setId("winClose");//winClose css样式Id
        title.getChildren().add(close);
        AnchorPane.setRightAnchor(close, 0.0);
        AnchorPane.setTopAnchor(close, 5.0);
        top.getChildren().add(title);
        
        // 内容
        VBox content = new VBox();
        content.setPrefWidth(300);
        content.setMinHeight(200);
        // 组装
        root.getChildren().addAll(top, content);
        Scene scene = new Scene(root);        
        stage.setScene(scene);
        
        // 显示
        stage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}

}
