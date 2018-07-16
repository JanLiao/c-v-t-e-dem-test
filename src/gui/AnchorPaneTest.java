package gui;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXListView;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class AnchorPaneTest extends Application {
	
	private static final String ITEM = "Item ";
    private int counter = 0;

	@Override
	public void start(Stage stage) throws Exception {
		AnchorPane pane = new AnchorPane();
		pane.setStyle("-fx-background-color:WHITE");
		
		JFXListView<Label> list = new JFXListView<>();
        for (int i = 0; i < 4; i++) {
            list.getItems().add(new Label(ITEM + i));
        }
        list.setLayoutX(14);
        list.setLayoutY(14);
        list.setExpanded(true);
		
		FlowPane flow = new FlowPane();
		flow.setStyle("-fx-background-color:WHITE");

        JFXButton button3D = new JFXButton("3D");
        button3D.setOnMouseClicked(e -> list.depthProperty().set(++counter % 2));

        JFXButton buttonExpand = new JFXButton("EXPAND");
        buttonExpand.setOnMouseClicked(e -> {
            list.depthProperty().set(0);
            list.setExpanded(true);
        });

        JFXButton buttonCollapse = new JFXButton("COLLAPSE");
        buttonCollapse.setOnMouseClicked(e -> {
            list.depthProperty().set(0);
            list.setExpanded(false);
        });
        
        flow.getChildren().add(button3D);
        flow.getChildren().add(buttonExpand);
        flow.getChildren().add(buttonCollapse);
        
        //list.setExpanded(true);
        //list.depthProperty().set(0);
        //list.setExpanded(true);
        
        list.setExpanded(true);
        pane.getChildren().add(list);
        //AnchorPane.setBottomAnchor(list, 12.0);
        AnchorPane.setTopAnchor(list, 14.0);
        AnchorPane.setLeftAnchor(list, 14.0);
        AnchorPane.setRightAnchor(list, 465.0); 
        
        HBox box = new HBox();
        box.getChildren().add(flow);
        box.getChildren().add(pane);
        box.setSpacing(40);
        
        StackPane main = new StackPane();
        main.getChildren().add(box);
        main.setBackground(new Background(new BackgroundFill(Color.WHITE, CornerRadii.EMPTY, Insets.EMPTY)));
        StackPane.setMargin(pane, new Insets(20, 0, 0, 20));
        
        list.setExpanded(true);
        final Scene scene = new Scene(main, 1000, 600, Color.WHITE);
        stage.setTitle("JFX ListView Demo ");
        scene.getStylesheets().add(AnchorPaneTest.class.getResource("jfoenix-components.css").toExternalForm());
        stage.setScene(scene);
        //stage.setResizable(false);
        stage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
