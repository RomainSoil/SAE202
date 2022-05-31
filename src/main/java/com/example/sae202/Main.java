package com.example.sae202;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;

public class Main extends Application {

    private Monde leMonde;
    static GridPane grid;
    static GridPane sect;
    private GestionEvent gestionEvent;

    public void start(final Stage stage) throws Exception {


        int rows = 11;
        int columns = 11;
        stage.setTitle("Monde");
        grid = new GridPane();
        grid.setAlignment(Pos.CENTER);


        for (int i = 0; i < columns; i++) {
            ColumnConstraints column = new ColumnConstraints(70);
            grid.getColumnConstraints().add(column);
        }
        for (int i = 0; i < rows; i++) {
            RowConstraints row = new RowConstraints(70);
            grid.getRowConstraints().add(row);
        }

        for(int i=0 ; i < columns;i++){
            for (int j = 0; j < 1;j++) {
                Text text = new Text("        "+String.valueOf(i));
                grid.setColumnIndex(text,i);
                grid.setRowIndex(text,j);
                grid.getChildren().add(text);
            }
        }
        for(int i=0 ; i < 1;i++){
            for (int j = 0; j < rows;j++) {
                Text text = new Text("        "+String.valueOf(j));
                grid.setColumnIndex(text,i);
                grid.setRowIndex(text,j);
                grid.getChildren().add(text);
            }
        }

        this.leMonde=new Monde();



        leMonde.affichage(grid);

        HBox hboxFin= new HBox();
        HBox hbox= new HBox();
        VBox vbox= new VBox();
        Pane pan = new Pane();

        hboxFin.getChildren().add(grid);
        Group group = new Group();
        Button Nord= new Button("Nord");
        Button Sud= new Button("Sud");
        Button Ouest= new Button("Ouest");
        Button Est= new Button("Est");
        Button Robot1=new Button("Robot1");
        Button Robot2=new Button("Robot2");

        Nord.setLayoutX(43);
        hbox.setLayoutY(25);

        hbox.getChildren().add(Ouest);
        pan.getChildren().add(Nord);
        hbox.getChildren().add(Sud);
        hbox.getChildren().add(Est);
        group.getChildren().addAll(pan,hbox);
        vbox.getChildren().add(group);
        vbox.getChildren().add(Robot1);
        vbox.getChildren().add(Robot2);


        gestionEvent=new GestionEvent();
        gestionEvent.setLeMonde(leMonde);
        gestionEvent.setStage(stage);
        gestionEvent.setGrid(grid);

        Nord.setOnMouseClicked(gestionEvent);
        Sud.setOnMouseClicked(gestionEvent);
        Ouest.setOnMouseClicked(gestionEvent);
        Est.setOnMouseClicked(gestionEvent);
        Robot1.setOnMouseClicked(gestionEvent);
        Robot2.setOnMouseClicked(gestionEvent);

        /*final Image img1= new Image(getClass().getResource("flecheHaut.png").toExternalForm());
        final ImageView icon1= new ImageView(img1);
        avancer.setGraphic(icon1);

        final Image img2= new Image(getClass().getResource("flecheB.png").toExternalForm());
        final ImageView icon2= new ImageView(img2);
        reculer.setGraphic(icon2);

        final Image img3= new Image(getClass().getResource("flecheG.png").toExternalForm());
        final ImageView icon3= new ImageView(img3);
        gauche.setGraphic(icon3);

        final Image img4= new Image(getClass().getResource("flecheD.png").toExternalForm());
        final ImageView icon4= new ImageView(img4);
        droite.setGraphic(icon4);*/
        VBox vBoxT = new VBox();
        VBox affiche = leMonde.affichageScore(vBoxT);
        GridPane tablescore = new GridPane();
        tablescore.setAlignment(Pos.CENTER);
        ColumnConstraints column = new ColumnConstraints(400);
        tablescore.getColumnConstraints().add(column);
        RowConstraints row = new RowConstraints(600);
        tablescore.getRowConstraints().add(row);
        tablescore.setStyle("-fx-background-color: white; -fx-grid-lines-visible: true");
        tablescore.getChildren().add(affiche);
        vbox.getChildren().add(tablescore);


        hboxFin.getChildren().add(vbox);



        grid.setStyle("-fx-background-color: white; -fx-grid-lines-visible: true");
        Scene scene = new Scene(hboxFin,Color.WHITE);
        stage.setScene(scene);
        stage.sizeToScene();
        stage.show();


    }
    public static void Main(String[] args) {
        launch(args);
    }


}
