package ui;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JLabel;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXListView;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXRippler;
import com.jfoenix.controls.JFXRippler.RipplerMask;
import com.jfoenix.controls.JFXRippler.RipplerPos;
import com.jfoenix.controls.JFXScrollPane;
import com.jfoenix.controls.JFXTabPane;
import com.jfoenix.controls.JFXTreeTableColumn;
import com.jfoenix.controls.JFXTreeTableView;
import com.jfoenix.controls.RecursiveTreeItem;
import com.jfoenix.controls.cells.editors.TextFieldEditorBuilder;
import com.jfoenix.controls.cells.editors.base.GenericEditableTreeTableCell;
import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;
import com.jfoenix.effects.JFXDepthManager;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.SingleSelectionModel;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.control.TreeTableColumn.CellEditEvent;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.transform.Affine;
import javafx.scene.transform.Rotate;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/** 
* @author: jan 
* @date: 2018年5月21日 下午2:45:36 
*/
public class Mark extends Application {

	@Override
	public void start(Stage stage) throws Exception {
		
		//BorderPane root = new BorderPane();
		HBox root = new HBox();
		
		HBox leftEmpty = new HBox();
		leftEmpty.setMaxWidth(15);
		leftEmpty.setMinWidth(15);
		root.getChildren().add(leftEmpty);
		
		VBox leftContent = new VBox();
		leftContent.setMaxWidth(600);
		leftContent.setMinWidth(600);
        leftContent.setMaxHeight(600);
        leftContent.setMinHeight(600);
        leftContent.setStyle("-fx-padding:8;");
        leftContent.setAlignment(Pos.CENTER);
		
        JFXTabPane tabPane = new JFXTabPane();
        tabPane.setPrefSize(600, 620);
        //tabPane.setMinSize(600, 590);
        //tabPane.setMaxSize(600, 600);
        
        Tab tab1 = new Tab();
        tab1.setText("视   盘");
        Canvas canvas1 = new Canvas(530, 530);
        double width1 = 530*2.5;
        double height1 = 530*2.5;
        GraphicsContext gc1 = canvas1.getGraphicsContext2D();
        Image img1 = new Image(getClass().getResourceAsStream("L.jpg"), width1, height1, true, true);
    	gc1.drawImage(img1, (95.61 - 70)*2.5, (232 - 70)*2.5, 530, 530, 0, 0, 530, 530);
    	gc1.setLineWidth(2);
    	gc1.save();
    	gc1.setStroke(Color.rgb(51, 171, 160));
    	gc1.transform(new Affine(new Rotate(0, (95.61*2.5 - (95.61 - 70)*2.5), (232*2.5 - (232 - 70)*2.5))));
        gc1.strokeOval(95.61*2.5 - (95.61 - 70)*2.5, 232*2.5 - (232 - 70)*2.5, 33.5*2*2.5, 36.5*2*2.5);
        gc1.restore();
        VBox pane1 = new VBox();
        pane1.setAlignment(Pos.CENTER);
        pane1.getChildren().add(canvas1);
        JFXRippler rippler5 = new JFXRippler(pane1);
        //JFXRippler rippler7 = new JFXRippler(canvas, RipplerMask.RECT, RipplerPos.FRONT);
        tab1.setContent(rippler5);
        JFXDepthManager.setDepth(rippler5, 5);
        tabPane.getTabs().add(tab1);
        
        Tab tab2 = new Tab();
        tab2.setText("视   杯");
        Canvas canvas2 = new Canvas(530, 530);
        double width2 = 530*2.5;
        double height2 = 530*2.5;
        GraphicsContext gc2 = canvas2.getGraphicsContext2D();
        Image img2 = new Image(getClass().getResourceAsStream("L.jpg"), width2, height2, true, true);
    	gc2.drawImage(img2, (109.18 - 70)*2.5, (251.91 - 70)*2.5, 530, 530, 0, 0, 530, 530);
    	gc2.setLineWidth(2);
    	gc2.save();
    	gc2.setStroke(Color.rgb(0, 0, 255));
    	gc2.transform(new Affine(new Rotate(0, (109.18*2.5 - (109.18 - 70)*2.5), (251.91*2.5 - (251.91 - 70)*2.5))));
        gc2.strokeOval(109.18*2.5 - (109.18 - 70)*2.5, 251.91*2.5 - (251.91 - 70)*2.5, 50*0.38*2*2.5, 50*0.38*2*2.5);
        gc2.restore();
        VBox pane2 = new VBox();
        pane2.setAlignment(Pos.CENTER);
        pane2.getChildren().add(canvas2);
        JFXRippler rippler6 = new JFXRippler(pane2);
        tab2.setContent(rippler6);
        JFXDepthManager.setDepth(rippler6, 5);
        tabPane.getTabs().add(tab2);
        
        Tab tab3 = new Tab();
        tab3.setText("黄 斑 中 心");
        
        Canvas canvas3 = new Canvas(530, 530);
        double width3 = 530*2.5;
        double height3 = 530*2.5;
        GraphicsContext gc3 = canvas3.getGraphicsContext2D();
        Image img3 = new Image(getClass().getResourceAsStream("L.jpg"), width3, height3, true, true);
    	gc3.drawImage(img3, (96.61 - 70)*2.5, (232 - 70)*2.5, 530, 530, 0, 0, 530, 530);
    	gc3.setLineWidth(2);
    	gc3.save();
    	gc3.setStroke(Color.rgb(51, 171, 160));
    	gc3.transform(new Affine(new Rotate(0, (96.61*2.5 - (96.61 - 70)*2.5), (232*2.5 - (232 - 70)*2.5))));
        gc3.strokeOval(96.61*2.5 - (96.61 - 70)*2.5, 232*2.5 - (232 - 70)*2.5, 33.5*2*2.5, 36.5*2*2.5);
        gc3.restore();
        
        VBox pane3 = new VBox();
        pane3.setAlignment(Pos.CENTER);
        pane3.getChildren().add(canvas3);
        JFXRippler rippler7 = new JFXRippler(pane3);
        tab3.setContent(rippler7);
        JFXDepthManager.setDepth(rippler7, 5);
        tabPane.getTabs().add(tab3);
        
        SingleSelectionModel<Tab> selectionModel = tabPane.getSelectionModel();
        selectionModel.select(0);
        HBox hbox = new HBox();
        hbox.getChildren().addAll(tabPane);
        hbox.setSpacing(50);
        hbox.setMaxWidth(600);
        hbox.setAlignment(Pos.CENTER);
        leftContent.getChildren().add(hbox);
        
        HBox radioBox = new HBox();
        radioBox.setStyle("-fx-padding:10;");
        radioBox.setAlignment(Pos.CENTER);
        final ToggleGroup group = new ToggleGroup();

        JFXRadioButton javaRadio = new JFXRadioButton("平  均");
        javaRadio.setPadding(new Insets(10));
        javaRadio.setSelected(true);
        javaRadio.setStyle("-fx-text-fill: GREEN;-fx-font-size: 20;");
        javaRadio.setToggleGroup(group);

        JFXRadioButton jfxRadio = new JFXRadioButton("重  叠");
        jfxRadio.setPadding(new Insets(10));
        jfxRadio.setStyle("-fx-text-fill: RED;-fx-font-size: 20;");
        jfxRadio.setToggleGroup(group);

        radioBox.getChildren().add(javaRadio);
        radioBox.getChildren().add(jfxRadio);
        radioBox.setSpacing(20);
        leftContent.getChildren().add(radioBox);
        root.getChildren().add(leftContent);
        
        //leftContent.setCenter(hbox);
        //root.setCenter(leftContent);
        
        HBox centerContent = new HBox();
        centerContent.setMinWidth(20);
        centerContent.setMaxWidth(20);
        root.getChildren().add(centerContent);
        
        VBox rightContent = new VBox();
        rightContent.setStyle("-fx-padding:8;");
        rightContent.setMaxWidth(600);
        rightContent.setMinWidth(600);
        rightContent.setMaxHeight(580);
        rightContent.setMinHeight(580);
        
        BorderPane area1 = new BorderPane();
        HBox area2 = new HBox();
        area1.setMinHeight(40);
        area1.setMaxHeight(40);
        Label stand = new Label("标   准:  ");
        stand.setStyle("-fx-text-fill: GREEN;-fx-font-size: 20;");
        stand.setAlignment(Pos.CENTER);
        area2.getChildren().add(stand);
        
        JFXComboBox<Label> jfxCombo = new JFXComboBox<Label>();
        jfxCombo.setMinHeight(25);
        jfxCombo.setMaxHeight(25);
        jfxCombo.setStyle("-fx-font-size: 16;");
        jfxCombo.getItems().add(new Label("Java 1.8"));
        jfxCombo.getItems().add(new Label("Java 1.7"));
        jfxCombo.getItems().add(new Label("Java 1.6"));
        jfxCombo.getItems().add(new Label("Java 1.5"));
        jfxCombo.setPromptText("请选择一个作为标准");
        area2.getChildren().add(jfxCombo);
        area1.setLeft(area2);
        
        Label analysis = new Label("未融合");
        analysis.setStyle("-fx-text-fill: RED;-fx-font-size: 20;");
        area1.setRight(analysis);
        
        rightContent.getChildren().add(area1);

        JFXScrollPane pane = new JFXScrollPane();
        //ScrollPane pane = new ScrollPane();
        pane.setMinWidth(585);
        pane.setMaxWidth(585);
        pane.setMaxHeight(480);
        pane.setMinHeight(480);
        pane.setAlignment(Pos.CENTER);
        
        Label scrollTitle = new Label("标注数据信息");
        //pane.getTopBar().getChildren().add(scrollTitle);
        pane.getBottomBar().getChildren().add(scrollTitle);
        scrollTitle.setStyle("-fx-text-fill:WHITE; -fx-font-size: 28;");
        JFXScrollPane.smoothScrolling((ScrollPane) pane.getChildren().get(0));

        StackPane.setMargin(scrollTitle, new Insets(0, 0, 0, 30));
        StackPane.setAlignment(scrollTitle, Pos.CENTER_LEFT);
        
        rightContent.getChildren().add(pane);
        root.getChildren().add(rightContent);
        
//        HBox rightEmpty = new HBox();
//        rightEmpty.setMaxWidth(15);
//        rightEmpty.setMinWidth(15);
//        root.getChildren().add(rightEmpty);
        
        // 组装
        //root.getChildren().addAll(leftContent, rightContent);
        Scene scene = new Scene(root, 1250, 620);
        stage.setScene(scene);
        // 添加窗体拉伸效果
        //DrawUtil.addDrawFunc(stage, root);
        // 显示
        stage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}

}
