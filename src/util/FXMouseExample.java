package util;
/** 
* @author: jan 
* @date: 2018年5月10日 下午9:43:35 
*/
import javafx.stage.*;
import javafx.scene.*;
import javafx.scene.input.*;
import javafx.scene.paint.*;
import javafx.event.*;
import javafx.application.*;
 
// 右手使用鼠标
public class FXMouseExample extends Application {
  public static void main(String[] args) {
    Application.launch(FXMouseExample.class, args);
  }
 
  @Override public void start(Stage stage) {
    stage.setTitle("FX Mouse Example");
    Group root = new Group();
//    Scene scene = SceneBuilder.create().root(root).width(400).height(300).fill(Color.WHITE)
//                                .onMousePressed(new EventHandler<MouseEvent>(){
//                                  @Override public void handle(MouseEvent e){
//                                    MouseButton button = e.getButton();
//                                    switch(button) {
//                                      case PRIMARY: System.out.println("Left Button Pressed"); break;
//                                      case SECONDARY: System.out.println("Right Button Pressed"); break;
//                                      case MIDDLE: System.out.println("Middle Button Pressed"); break;
//                                      default:
//                                        System.out.println(button);
//                                    }
//                                  }
//                                }).build();
    Scene scene = new Scene(root, 400, 300);
    scene.setOnMouseClicked(new EventHandler<MouseEvent>() {

		@Override
			public void handle(MouseEvent e) {
				MouseButton button = e.getButton();
				switch (button) {
				case PRIMARY:
					System.out.println("Left Button Pressed");
					break;
				case SECONDARY:
					System.out.println("Right Button Pressed");
					break;
				case MIDDLE:
					System.out.println("Middle Button Pressed");
					break;
				default:
					System.out.println(button);
				}
			}
    	
    });
    stage.setScene(scene);
    stage.show();
  }
}
