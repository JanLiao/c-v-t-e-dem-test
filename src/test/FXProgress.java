package test;

import javafx.application.Application;
import javafx.stage.Stage;
import java.util.concurrent.TimeUnit;
import javafx.concurrent.Task;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.ProgressBar;

public class FXProgress extends Application {
    public static void main(final java.lang.String[] args) {
        Application.launch(FXProgress.class, args);
    }

    @Override public void start(Stage stage) {
        stage.setTitle("FXProgress");
        ProgressBar bar = new ProgressBar();
        Task task = createTask();
        bar.progressProperty().bind(task.progressProperty());
        Group root = new Group();
        root.getChildren().add(bar);
        Scene scene = new Scene(root, 300, 300);
        stage.setScene(scene);
        Thread thread =         new Thread(task);
        thread.setDaemon(true);
        thread.start();
        stage.show();
    }

    private Task createTask(){

        return new Task<Void>(){
            @Override protected Void call() throws Exception {
                for(int iterations = 0; iterations < 100; iterations++){
                    if(isCancelled()) break;
                    TimeUnit.SECONDS.sleep(1);
                    updateProgress(iterations,100);
                }
                return null;
            }
        };
    }
}
