package util;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;
import javafx.scene.transform.Affine;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;

/** 
* @author: jan 
* @date: 2018年5月22日 下午5:08:08 
*/
public class CanvasDemo extends Application {

	@Override
	public void start(Stage primaryStage) {
		
		LabelData data = new LabelData(69.95, 249.82, 6.23, 0.46, 0.51, 50, 2, 0, 0, 255, 1);
		LabelData data1 = new LabelData(73.01, 224.12, 14.68, 0.67, 0.93, 50, 2, 51, 171, 160, 1);
		
        primaryStage.setTitle("Drawing Operations Test");
        VBox root = new VBox();
        //Group root = new Group();
        Canvas canvas = new Canvas(530, 530);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        drawShapes(gc);
//        Image img = new Image(getClass().getResourceAsStream("./L.jpg"), 530*2, 530*2, true, true);
//    	gc.drawImage(img, 50, 260, 350, 350, 0, 0, 530, 530);
//    	gc.setLineWidth(2);
//    	gc.transform(new Affine(new Rotate(45, (96.61 + 33.5)*2, (232 + 36.5)*2)));
//        gc.setStroke(Color.rgb(51, 171, 160));
//        gc.strokeOval(96.61*2, 232*2, 33.5*2*2, 36.5*2*2);
        
//        Image image = new Image(getClass().getResourceAsStream("L.jpg"), 530, 530, true, true);
//        ImageView iv2 = new ImageView();
//        iv2.setImage(image);
//        iv2.setPreserveRatio(true);
//        iv2.setSmooth(true);
//        iv2.setCache(true);
        
        root.getChildren().add(canvas);
        primaryStage.setScene(new Scene(root, 530, 530));
        primaryStage.show();
    }
 
    private void drawShapes(GraphicsContext gc) {
    	Image img = new Image(getClass().getResourceAsStream("R.jpg"), 530*2, 530*2, true, true);
    	gc.drawImage(img, (73.01 - 70)*2, (224.12 - 70)*2, 530, 530, 0, 0, 530, 530);
    	gc.setLineWidth(2);
//        gc.setFill(Color.GREEN);
    	gc.save();
        gc.setStroke(Color.rgb(51, 171, 160));
//        gc.setLineWidth(5);
//        gc.strokeLine(40, 10, 10, 40);
        //gc.fillOval(10, 60, 30, 30);
        gc.transform(new Affine(new Rotate(14, ((73.01 + 50*0.67)*2), ((224.12 + 50*0.93)*2))));
        gc.strokeOval((73.01*2 - (73.01 - 70)*2), (224.12*2 - (224.12 - 70)*2), 50*0.67*2*2, 50*0.93*2*2);
        gc.restore();
        
        gc.save();
        gc.setStroke(Color.rgb(0, 0, 255));
        gc.transform(new Affine(new Rotate(6.23, ((69.95 + 50*0.46)*2), ((249.82*2 + 50*0.51)*2))));
        gc.strokeOval((69.95*2 - (73.01 - 70)*2), (249.82*2 - (224.12 - 70)*2), 50*0.46*2*2, 50*0.51*2*2);
        gc.restore();
        //gc.strokeOval(60, 60, 30, 30);
//        gc.fillRoundRect(110, 60, 30, 30, 10, 10);
//        gc.strokeRoundRect(160, 60, 30, 30, 10, 10);
//        gc.fillArc(10, 110, 30, 30, 45, 240, ArcType.OPEN);
//        gc.fillArc(60, 110, 30, 30, 45, 240, ArcType.CHORD);
//        gc.fillArc(110, 110, 30, 30, 45, 240, ArcType.ROUND);
//        gc.strokeArc(10, 160, 30, 30, 45, 240, ArcType.OPEN);
//        gc.strokeArc(60, 160, 30, 30, 45, 240, ArcType.CHORD);
//        gc.strokeArc(110, 160, 30, 30, 45, 240, ArcType.ROUND);
//        gc.fillPolygon(new double[]{10, 40, 10, 40},
//                       new double[]{210, 210, 240, 240}, 4);
//        gc.strokePolygon(new double[]{60, 90, 60, 90},
//                         new double[]{210, 210, 240, 240}, 4);
//        gc.strokePolyline(new double[]{110, 140, 110, 140},
//                          new double[]{210, 210, 240, 240}, 4);
    }

	public static void main(String[] args) {
		launch(args);
	}
}
