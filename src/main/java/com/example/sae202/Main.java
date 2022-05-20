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

public class Main extends Application {
    private Terrain secteur;
    private PlanDeau pd;
    private Entrepot E;
    private Mine M;
    static GridPane grid;
    static GridPane sect;

    public void start(final Stage stage) throws Exception {

        /*partie monde*/
        int rows = 11;
        int columns = 11;
        stage.setTitle("Monde");
        grid = new GridPane();
        grid.setAlignment(Pos.CENTER);


        for(int i = 0; i < columns; i++) {
            ColumnConstraints column = new ColumnConstraints(70);
            grid.getColumnConstraints().add(column);
        }
        for(int i = 0; i < rows; i++) {
            RowConstraints row = new RowConstraints(70);
            grid.getRowConstraints().add(row);
        }
        for(int i=1 ; i < columns;i++){
            for (int j = 1; j < rows;j++) {
                sect = new GridPane();
                secteur = new Terrain();
                sect = secteur.Terrain1(sect,i,j);

                grid.setColumnIndex(sect,i);
                grid.setRowIndex(sect,j);
                grid.getChildren().add(sect);

            }
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

        Random2 random2= new Random2(1,10);
        int g = random2.getValue();
        for (int i=0;i<=g;i++)
        {
            Random2 randomX=new Random2(1,9);
            Random2 randomY=new Random2(1,9);
            int x=randomX.getValue();
            int y=randomY.getValue();
            pd = new PlanDeau(x,y);
            sect = pd.PD(sect,x,y);

            grid.setColumnIndex(sect,x);
            grid.setRowIndex(sect,y);
            grid.getChildren().add(sect);

        }

        for (int i=0;i<2;i++)
        {
            Random2 randomX=new Random2(1,9);
            Random2 randomY=new Random2(1,9);
            int x=randomX.getValue();
            int y=randomY.getValue();
            E = new Entrepot(x,y);
            sect = E.Entrepot(sect,x,y,i);

            grid.setColumnIndex(sect,x);
            grid.setRowIndex(sect,y);
            grid.getChildren().add(sect);

        }

        for (int i=0;i<2;i++)
        {
            Random2 randomX=new Random2(1,9);
            Random2 randomY=new Random2(1,9);
            int x=randomX.getValue();
            int y=randomY.getValue();
            M = new Mine(x,y);
            sect = M.Mine(sect,x,y,i);

            grid.setColumnIndex(sect,x);
            grid.setRowIndex(sect,y);
            grid.getChildren().add(sect);

        }


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