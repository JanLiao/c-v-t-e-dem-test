package util;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXScrollPane;

/** 
* @author: jan 
* @date: 2018年5月25日 上午9:17:58 
*/
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.geometry.Bounds;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.transform.Affine;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;

public class TT extends Application {

    //Canvas canvas = new Canvas(600, 600);

    @Override
    public void start(Stage primaryStage) {

    	HBox hbox = new HBox();
    	VBox box = new VBox();
    	box.setMinSize(100, 580);
    	box.setAlignment(Pos.CENTER);
        JFXScrollPane scrollPane = new JFXScrollPane();
        scrollPane.setMinSize(680, 580);
        showBounds(scrollPane);

        //scrollPane.viewportBoundsProperty().addListener((ChangeListener<Bounds>) (observable, oldValue, newValue) -> showBounds( scrollPane));
        //scrollPane.hvalueProperty().addListener((ChangeListener<Number>) (observable, oldValue, newValue) -> showBounds( scrollPane));
        //scrollPane.vvalueProperty().addListener((ChangeListener<Number>) (observable, oldValue, newValue) -> showBounds( scrollPane));

        hbox.getChildren().add(box);
        hbox.getChildren().add(scrollPane);
        Scene scene = new Scene(hbox, 800, 600);

        primaryStage.setScene( scene);
        primaryStage.show();

    }

    private void showBounds(JFXScrollPane scrollPane) {
    	

    	//scrollPane.setContent(canvas);
    	VBox box = new VBox();
    	double size = 80;
    	for(int i = 0; i < 3; i++) {
    		    		
    		HBox inner = new HBox();
    		inner.setSpacing(30);
    		inner.setAlignment(Pos.CENTER);
    		VBox vbox = new VBox();
    		vbox.setMinSize(100, 500);
    		inner.getChildren().add(vbox);
    		Canvas canvas = new Canvas(500, 500);
    		GraphicsContext gc = canvas.getGraphicsContext2D();
    		Image innerImg = new Image(getClass().getResourceAsStream("L.jpg"), 500, 500, true, true);
        	gc.drawImage(innerImg, 10 , 10);
        	gc.strokeOval(0, 0, size*2, size*2);
        	inner.getChildren().add(canvas);
        	
        	VBox innerBox = new VBox();
        	innerBox.setSpacing(30);
        	innerBox.setAlignment(Pos.CENTER);
        	Label innerLabel = new Label("用户:  user");
        	innerBox.getChildren().add(innerLabel);
        	Label innerLabel1 = new Label("重复率:  1");
        	innerBox.getChildren().add(innerLabel1);
        	Label innerlabel2 = new Label("");
        	innerlabel2.setMinSize(20, 20);
        	innerlabel2.setStyle("-fx-background-color:RED");
        	innerBox.getChildren().add(innerlabel2);
        	JFXCheckBox jfxCheckBox = new JFXCheckBox("融合选中");
        	innerBox.getChildren().add(jfxCheckBox);
        	inner.getChildren().add(innerBox);
        	box.getChildren().add(inner);
    	}

        // demo: draw a line of the canvas size and a rectangle of the viewport size => the rectangle must always be in the center
    	scrollPane.setContent(box);

    }

    public static void main(String[] args) {
        launch(args);
    }

}

