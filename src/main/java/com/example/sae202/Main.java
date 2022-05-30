package com.example.sae202;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;

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







        grid.setStyle("-fx-background-color: white; -fx-grid-lines-visible: true");
        Scene scene = new Scene(grid,Color.WHITE);
        stage.setScene(scene);
        stage.sizeToScene();
        stage.show();


    }
    public static void Main(String[] args) {
        launch(args);
    }


}
