package util;
import com.jfoenix.controls.JFXCheckBox;

/** 
* @author: jan 
* @date: 2018年5月25日 上午9:17:58 
*/
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.geometry.Bounds;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.transform.Affine;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;

public class ss extends Application {

    Canvas canvas = new Canvas(600, 600);

    @Override
    public void start(Stage primaryStage) {

        ScrollPane scrollPane = new ScrollPane();
        showBounds( scrollPane);

        //scrollPane.viewportBoundsProperty().addListener((ChangeListener<Bounds>) (observable, oldValue, newValue) -> showBounds( scrollPane));
        //scrollPane.hvalueProperty().addListener((ChangeListener<Number>) (observable, oldValue, newValue) -> showBounds( scrollPane));
        //scrollPane.vvalueProperty().addListener((ChangeListener<Number>) (observable, oldValue, newValue) -> showBounds( scrollPane));

        Scene scene = new Scene(scrollPane, 800, 800);

        primaryStage.setScene( scene);
        primaryStage.show();

    }

    private void showBounds( ScrollPane scrollPane) {
    	

    	//scrollPane.setContent(canvas);
    	VBox box = new VBox();
    	
    	
        double hValue = scrollPane.getHvalue();
        double vValue = scrollPane.getVvalue();
        double width = scrollPane.viewportBoundsProperty().get().getWidth();
        double height = scrollPane.viewportBoundsProperty().get().getHeight();

        //double x = (scrollPane.getContent().getBoundsInParent().getWidth() - width) * hValue;
        //double y = (scrollPane.getContent().getBoundsInParent().getHeight() - height) * vValue;

        //System.out.println( "x=" + x + ", y=" + y + ", width=" + width + ", height=" + height);

        // demo: draw a line of the canvas size and a rectangle of the viewport size => the rectangle must always be in the center
        double size = 80;
        GraphicsContext gc = canvas.getGraphicsContext2D();
        
        Image innerImg = new Image(getClass().getResourceAsStream("404.jpg"));
    	gc.drawImage(innerImg, 10 , 10);
    	
    	Canvas canvas1 = new Canvas(400, 400);
        GraphicsContext gc1 = canvas1.getGraphicsContext2D();
        
        Image innerImg1 = new Image(getClass().getResourceAsStream("404.jpg"));
    	gc1.drawImage(innerImg1, 10 , 10);
    	gc1.strokeOval(0, 0, size*2, size*2);
    	box.getChildren().add(canvas);
    	box.getChildren().add(canvas1);
    	scrollPane.setContent(box);
    	
    	VBox innerBox = new VBox();
    	Label innerLabel = new Label("用户:  user");
    	innerBox.getChildren().add(innerLabel);
    	Label innerLabel1 = new Label("重复率:  1");
    	innerBox.getChildren().add(innerLabel1);
    	Label innerlabel2 = new Label("");
    	innerlabel2.setMinSize(20, 20);
    	innerlabel2.setStyle("-fx-background-color:RED");
    	innerBox.getChildren().add(innerlabel2);
    	JFXCheckBox jfxCheckBox = new JFXCheckBox("JFX CheckBox");
    	innerBox.getChildren().add(jfxCheckBox);
        
        gc.save();
    	gc.setStroke(Color.rgb(51, 171, 160));
    	gc.strokeOval(0, 0, size*2, size*2);
    	gc.restore();

    }

    public static void main(String[] args) {
        launch(args);
    }

}
