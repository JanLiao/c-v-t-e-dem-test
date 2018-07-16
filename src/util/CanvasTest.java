package util;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;
import javafx.scene.transform.Affine;
import javafx.scene.transform.Rotate;
import javafx.stage.Stage;

/** 
* @author: jan 
* @date: 2018年5月22日 下午5:08:08 
*/
public class CanvasTest extends Application {

	@Override
	public void start(Stage primaryStage) {
		
		LabelData data = new LabelData(69.95, 249.82, 6.23, 0.46, 0.51, 50, 2, 0, 0, 255, 1);
		LabelData data1 = new LabelData(73.01, 224.12, 14.68, 0.67, 0.93, 50, 2, 51, 171, 160, 1);
		
        primaryStage.setTitle("Drawing Operations Test");
        Group root = new Group();
        Canvas canvas = new Canvas(530, 530);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        //drawShapes(gc);
        Image img = new Image(getClass().getResourceAsStream("./L.jpg"), 530, 530, true, true);
    	gc.drawImage(img, 0, 0, 530, 530, 0, 0, 530, 530);
    	gc.setLineWidth(2);
    	int angle = 0;
    	//gc.save();
//    	angle += 10;
    	gc.save();
    	gc.transform(new Affine(new Rotate(angle, (307.53), (195.43))));
    	gc.setStroke(Color.rgb(51, 171, 160));
    	gc.strokeOval(307.53, 195.43, 32*2, 36*2);
    	gc.restore();
    	
    	gc.save();
    	gc.transform(new Affine(new Rotate(242.65, (307.53), (195.43))));
    	gc.setStroke(Color.rgb(51, 171, 160));
    	gc.strokeOval(307.53, 195.43, 32*2, 36*2);
    	gc.restore();
    	
    	double sin = Math.sin(Math.toRadians(242.65));
    	double cos = Math.cos(Math.toRadians(242.65));
    	System.out.println(sin + "=" + cos);
    	double x1 = 307.53 + 32*cos - 36*sin;
    	double y1 = 195.43 + 32*sin + 36*cos;
    	System.out.println(x1 + "=" + y1);
    	
    	double leftnew = x1 - 32;
    	double topnew = y1 - 36;
    	gc.save();
    	gc.transform(new Affine(new Rotate(0, x1, y1)));
    	gc.setStroke(Color.rgb(0, 255, 0));
    	gc.strokeOval(leftnew, topnew, 32*2, 36*2);
    	gc.restore();
    	
    	gc.save();
    	gc.transform(new Affine(new Rotate(90, x1, y1)));
    	gc.setStroke(Color.rgb(0, 0, 255));
    	gc.strokeOval(x1 - 36, y1 - 32, 32*2, 36*2);
    	gc.restore();
    	
    	//gc.restore();
//    	for(int i = 0; i< 5; i++) {
//            gc.transform(new Affine(new Rotate(angle, (307.53), (195.43))));
//        	gc.setStroke(Color.rgb(51, 171, 160));
//        	gc.strokeOval(307.53, 195.43, 32*2, 36*2);
//        	angle += 10;
//    	}
        
        root.getChildren().add(canvas);
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }
 
    private void drawShapes(GraphicsContext gc) {
    	Image img = new Image(getClass().getResourceAsStream("R.jpg"), 530, 530, true, true);
    	gc.drawImage(img, 0, 0);
    	gc.setLineWidth(2);
//        gc.setFill(Color.GREEN);
    	gc.save();
        gc.setStroke(Color.rgb(51, 171, 160));
//        gc.setLineWidth(5);
//        gc.strokeLine(40, 10, 10, 40);
        //gc.fillOval(10, 60, 30, 30);
        gc.transform(new Affine(new Rotate(14.68, 73.01, 224.12)));
        gc.strokeOval(73.01, 224.12, 50*0.67*2, 50*0.93*2);
        gc.restore();
        
        gc.save();
        gc.setStroke(Color.rgb(0, 0, 255));
        gc.transform(new Affine(new Rotate(6.23, 69.95, 249.82)));
        gc.strokeOval(69.95, 249.82, 50*0.46*2, 50*0.51*2);
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
