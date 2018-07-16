package gui;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDrawer;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public final class Drawer extends Application {

    @Override
    public void start(Stage stage) {
        FlowPane main = new FlowPane();
        main.setVgap(20);
        main.setHgap(20);

        JFXDrawer leftDrawer = new JFXDrawer();
        StackPane leftDrawerPane = new StackPane();
        leftDrawerPane.getStyleClass().add("red-400");
        leftDrawerPane.getChildren().add(new JFXButton("Left Content"));
        leftDrawer.setSidePane(leftDrawerPane);
        leftDrawer.setDefaultDrawerSize(150);
        leftDrawer.setOverLayVisible(false);
        leftDrawer.setResizableOnDrag(true);
        main.getChildren().add(leftDrawer);

        final Scene scene = new Scene(leftDrawer, 600, 600);
        scene.getStylesheets().add(Drawer.class.getResource("jfoenix-components.css").toExternalForm());
        stage.setTitle("JFX Button Demo");
        stage.getIcons().add(new Image(getClass().getResourceAsStream("1.jpg")));
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
