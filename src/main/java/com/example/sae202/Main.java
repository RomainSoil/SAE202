package com.example.sae202;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;

public class Main extends Application {

    private Monde leMonde;
    static GridPane grid;
    static GridPane sect;
    private GestionEvent gestionEvent;



    private Robot robot1;
    private Stage stage;
    private Mine mine;
    private VBox vbox;
    private Entrepot entrepot;


    public void start(final Stage stage) throws Exception {


        int rows = 11;
        int columns = 11;
        stage.setTitle("Robot Mineur");
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
        HBox hboxR = new HBox();
        HBox ExtDep = new HBox();
        Pane pan = new Pane();

        hboxFin.getChildren().add(grid);
        Group group = new Group();
        Button Nord= new Button("Nord");
        Button Sud= new Button("Sud");
        Button Ouest= new Button("Ouest");
        Button Est= new Button("Est");
        Button Robot1=new Button("Robot1");
        Button Robot2=new Button("Robot2");
        Button Extraire =new Button("Extraire");
        Button Deposer =new Button("Deposer");

        Nord.setLayoutX(43);
        hbox.setLayoutY(25);
        hboxR.getChildren().add(Robot1);
        hboxR.getChildren().add(Robot2);
        ExtDep.getChildren().add(Extraire);
        ExtDep.getChildren().add(Deposer);
        hbox.getChildren().add(Ouest);
        pan.getChildren().add(Nord);
        hbox.getChildren().add(Sud);
        hbox.getChildren().add(Est);
        group.getChildren().addAll(pan,hbox);



        gestionEvent=new GestionEvent();
        gestionEvent.setLeMonde(leMonde);
        gestionEvent.setStage(stage);
        gestionEvent.setGrid(grid);
        gestionEvent.setMine(leMonde.mine1);
        gestionEvent.setEntrepot(leMonde.entrepot1);

        Nord.setOnMouseClicked(gestionEvent);
        Sud.setOnMouseClicked(gestionEvent);
        Ouest.setOnMouseClicked(gestionEvent);
        Est.setOnMouseClicked(gestionEvent);
        Robot1.setOnMouseClicked(gestionEvent);
        Robot2.setOnMouseClicked(gestionEvent);
        Extraire.setOnMouseClicked(gestionEvent);
        Deposer.setOnMouseClicked(gestionEvent);

        gestionEvent.setVbox(vbox);
        vbox.getChildren().add(leMonde.affichageScore());




        vbox.getChildren().add(group);
        vbox.getChildren().add(hboxR);
        vbox.getChildren().add(ExtDep);


        hboxFin.getChildren().add(vbox);



        grid.setStyle("-fx-background-color: white; -fx-grid-lines-visible: true");
        Scene scene = new Scene(hboxFin,Color.WHITE);

        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            public void handle(KeyEvent event) {

                if(event.getCode() == KeyCode.X)
                {
                    robot1=leMonde.robot1;

                }

                else if(event.getCode() == KeyCode.C) {
                    robot1 = leMonde.robot2;

                }





                else if(event.getCode() == KeyCode.Z)
                {
                    try {
                        leMonde.tour = leMonde.tour +1;
                        robot1.Nord(leMonde);
                        leMonde.affichage(grid);
                        vbox.getChildren().set(0,leMonde.affichageScore());
                        if (leMonde.leMonde[robot1.getX()][robot1.getY()] instanceof Mine) {
                            mine=((Mine)leMonde.leMonde[robot1.getX()][robot1.getY()]);
                        }
                        if (leMonde.leMonde[robot1.getX()][robot1.getY()] instanceof Entrepot) {
                            entrepot=((Entrepot)leMonde.leMonde[robot1.getX()][robot1.getY()]);
                        }


                        stage.show();

                    } catch (DepassementMonde_Exception e) {
                        e.printStackTrace();
                    }
                }
                else if(event.getCode() == KeyCode.S)
                {
                    try {
                        leMonde.tour = leMonde.tour+1 ;
                        robot1.Sud(leMonde);
                        leMonde.affichage(grid);
                        vbox.getChildren().set(0,leMonde.affichageScore());

                        if (leMonde.leMonde[robot1.getX()][robot1.getY()] instanceof Mine) {
                            mine=((Mine)leMonde.leMonde[robot1.getX()][robot1.getY()]);
                        }
                        if (leMonde.leMonde[robot1.getX()][robot1.getY()] instanceof Entrepot) {
                            entrepot=((Entrepot)leMonde.leMonde[robot1.getX()][robot1.getY()]);
                        }

                        stage.show();
                    } catch (DepassementMonde_Exception e) {
                        e.printStackTrace();
                    }
                }

                else if(event.getCode() == KeyCode.Q)
                {
                    try {
                        leMonde.tour = leMonde.tour +1;
                        robot1.Ouest(leMonde);
                        leMonde.affichage(grid);
                        vbox.getChildren().set(0,leMonde.affichageScore());

                        if (leMonde.leMonde[robot1.getX()][robot1.getY()] instanceof Mine) {
                            mine=((Mine)leMonde.leMonde[robot1.getX()][robot1.getY()]);
                        }
                        if (leMonde.leMonde[robot1.getX()][robot1.getY()] instanceof Entrepot) {
                            entrepot=((Entrepot)leMonde.leMonde[robot1.getX()][robot1.getY()]);
                        }

                        stage.show();
                    } catch (DepassementMonde_Exception e) {
                        e.printStackTrace();
                    }
                }

                else if(event.getCode() == KeyCode.D)
                {
                    try {
                        leMonde.tour = leMonde.tour +1 ;
                        robot1.Est(leMonde);
                        leMonde.affichage(grid);
                        vbox.getChildren().set(0,leMonde.affichageScore());

                        if (leMonde.leMonde[robot1.getX()][robot1.getY()] instanceof Mine) {
                            mine=((Mine)leMonde.leMonde[robot1.getX()][robot1.getY()]);
                        }
                        if (leMonde.leMonde[robot1.getX()][robot1.getY()] instanceof Entrepot) {
                            entrepot=((Entrepot)leMonde.leMonde[robot1.getX()][robot1.getY()]);
                        }

                        stage.show();
                    } catch (DepassementMonde_Exception e) {
                        e.printStackTrace();
                    }
                }
                else if(event.getCode() == KeyCode.J)
                {
                    try {
                        robot1.recolter(mine);
                        vbox.getChildren().set(0,leMonde.affichageScore());
                        stage.show();



                    } catch (DepassementCapaciteExtraction e){

                        e.printStackTrace();
                    }
                    catch (DepassementStockage_Exception e){
                        e.printStackTrace();
                    }
                    catch (CapaciteDeMine e){
                        e.printStackTrace();
                    }
                }
                else if(event.getCode() == KeyCode.K)
                {
                    try {
                        robot1.deposer(entrepot);
                        vbox.getChildren().set(0,leMonde.affichageScore());
                        stage.show();
                        if (leMonde.mine1.getNbMinerais()==0 &&leMonde.mine2.getNbMinerais()==0 && leMonde.robot1.getStockage()==0 && leMonde.robot2.getStockage()==0)
                        {
                            Text win = new Text("VOUS AVEZ GAGNÉ !");
                            win.setTextAlignment(TextAlignment.CENTER);
                            StackPane vBoxWin = new StackPane();
                            vBoxWin.getChildren().add(win);
                            vBoxWin.setAlignment(win, Pos.CENTER);
                            Scene scnWin = new Scene(vBoxWin,500,200);
                            Stage stageWin =new Stage();
                            stageWin.setScene(scnWin);
                            stageWin.sizeToScene();
                            stageWin.setTitle("VICTOIRE");
                            stageWin.show();
                        }

                    }
                    catch (DepassementStockage_Exception e){

                        e.printStackTrace();
                    }
                    catch (SecteurContenance_Exception e){

                        e.printStackTrace();
                    }

                }

            }

        });

        stage.setScene(scene);
        stage.sizeToScene();
        stage.show();


    }
    public static void Main(String[] args) {
        launch(args);
    }


}