package util;

import javafx.concurrent.Task;
import javafx.concurrent.WorkerStateEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.layout.Background;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/** 
* @author: jan 
* @date: 2018年5月28日 下午1:20:44 
*/
public class ProgressFrom {

    private Stage dialogStage;
    private ProgressIndicator progressIndicator;

    public ProgressFrom(final Task<?> task,Stage primaryStage) {

        dialogStage = new Stage();
        progressIndicator = new ProgressIndicator();

        // 窗口父子关系
        dialogStage.initOwner(primaryStage);
        dialogStage.initStyle(StageStyle.UNDECORATED);
        dialogStage.initStyle(StageStyle.TRANSPARENT);
        dialogStage.initModality(Modality.APPLICATION_MODAL);

        // progress bar
        Label label = new Label("数据加载中, 请稍后...");
        label.setTextFill(Color.BLUE);
        //label.getStyleClass().add("progress-bar-root");
        progressIndicator.setProgress(-1F);
        //progressIndicator.getStyleClass().add("progress-bar-root");
        progressIndicator.progressProperty().bind(task.progressProperty());

        VBox vBox = new VBox();
        vBox.setSpacing(10);
        vBox.setBackground(Background.EMPTY);
        vBox.getChildren().addAll(progressIndicator,label);

        Scene scene = new Scene(vBox);
        scene.setFill(null);
        dialogStage.setScene(scene);

        Thread inner = new Thread(task);
        inner.start();

        task.setOnSucceeded(new EventHandler<WorkerStateEvent>() {
            public void handle(WorkerStateEvent event) {
                dialogStage.close();
            }
        });
    }

    public void activateProgressBar() {
        dialogStage.show();
    }

    public Stage getDialogStage(){
        return dialogStage;
    }

    public void cancelProgressBar() {
        dialogStage.close();
    }
}
