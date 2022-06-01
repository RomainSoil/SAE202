package com.example.sae202;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.*;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.text.Text;

public class Monde {

    public Secteur[][] leMonde;
    public Robot robot1;
    public Robot robot2;
    public Entrepot entrepot1;
    public Entrepot entrepot2;
    public Mine mine1;
    public Mine mine2;
    public int tour;
    private Label Tirob1;
    private Label Tjrob1;
    private Label Tirob2;
    private Label Tjrob2;
    private Label Tstockrob1;
    private Label Tstockrob2;

    private Label Tnbminerais1;
    private Label Tnbminerais2;

    private Label Tstockentrepot1;

    private Label Tstockentrepot2;

    public Secteur[][] getLeMonde() {
        return leMonde;
    }

    public boolean EstPasLibre(int x, int y)
    {
        if (leMonde[x][y] instanceof Terrain){
            return false;
        }
        else {return true;}
    }


    public Monde() {
        this.tour=0;
        this.leMonde = new Secteur[10][10];
        for(int i=0 ; i < 10;i++){
            for (int j = 0; j < 10;j++) {
                leMonde[i][j] = new Terrain(i,j);

            }}

        Random2 random2= new Random2(1,10);
        int g = random2.getValue();
        for (int i=0;i<=g;i++)

        {
            Random2 randomX=new Random2(0,10);
            Random2 randomY=new Random2(0,10);
            int x=randomX.getValue();
            int y=randomY.getValue();
            while (this.EstPasLibre(x,y))
            {
                x=new Random2(0,10).getValue();
                y=new Random2(0,10).getValue();
            }



            leMonde[x][y]=new PlanDeau(x,y);

        }

        for (int i=0;i<2;i++) {
            Random2 randomX = new Random2(0, 10);
            Random2 randomY = new Random2(0, 10);
            int x = randomX.getValue();
            int y = randomY.getValue();
            while (this.EstPasLibre(x,y))
            {
                x=new Random2(0,10).getValue();
                y=new Random2(0,10).getValue();
            }


            leMonde[x][y] =new Entrepot(x, y,i);
            if(i==0)
                entrepot1=((Entrepot)leMonde[x][y]);

            if (i==1)
            {
                ((Entrepot) leMonde[x][y]).setNatureStock("OR");
                entrepot2=((Entrepot)leMonde[x][y]);

            }
        }
        for (int i=0;i<2;i++)
        {
            Random2 randomX2=new Random2(0,10);
            Random2 randomY2=new Random2(0,10);
            int x=randomX2.getValue();
            int y=randomY2.getValue();
            while (this.EstPasLibre(x,y))
            {
                x=new Random2(0,10).getValue();
                y=new Random2(0,10).getValue();
            }

            leMonde[x][y]= new Mine(x, y,i);
            if(i==0)
                mine1=((Mine)leMonde[x][y]);
            if (i==1)
            {
                ((Mine) leMonde[x][y]).setNatureMinerais("OR");
                mine2=((Mine)leMonde[x][y]);

            }


        }

        Random2 randomX2=new Random2(0,10);
        Random2 randomY2=new Random2(0,10);
        int x=randomX2.getValue();
        int y=randomY2.getValue();
        while (this.EstPasLibre(x,y)) {
            x = new Random2(0, 10).getValue();
            y = new Random2(0, 10).getValue();
        }

        Random2 CS1 = new Random2(5,10);
        int CapStock1 = CS1.getValue();
        Random2 CE1 = new Random2(1,4);
        int CapEx1 = CE1.getValue();

        robot1 =new Robot(x,y,1,CapStock1,CapEx1,1,0,"nickel",0);
        leMonde[x][y].setrobot1(robot1);

        Random2 randomX3=new Random2(0,10);
        Random2 randomY3=new Random2(0,10);
        int X=randomX3.getValue();
        int Y=randomY3.getValue();
        while (this.EstPasLibre(X,Y)) {
            X = new Random2(0, 10).getValue();
            Y = new Random2(0, 10).getValue();
        }
        Random2 CS2 = new Random2(8,12);
        int CapStock2 = CS2.getValue();
        Random2 CE2 = new Random2(1,4);
        int CapEx2 = CE2.getValue();

        robot2 =new Robot(X,Y,2,CapStock2,CapEx2,1,0,"OR",0);
        leMonde[X][Y].setrobot1(robot2);

    }
    public void affichage(GridPane grid) {


        for (int i = 1; i < 11; i++) {
            for (int j = 1; j < 11; j++) {
                if (leMonde[i-1][j-1] instanceof Terrain) {
                    if (leMonde[i-1][j-1].getRobotPresent())
                    {
                        GridPane sect = ((Terrain) leMonde[i-1][j-1]).Terrain2(grid, i, j);
                        grid.setColumnIndex(sect,i);
                        grid.setRowIndex(sect,j);
                        grid.getChildren().add(sect);
                    }
                    else {
                        GridPane sect = ((Terrain) leMonde[i - 1][j - 1]).Terrain1(grid, i, j);
                        grid.setColumnIndex(sect, i);
                        grid.setRowIndex(sect, j);
                        grid.getChildren().add(sect);
                    }
                } else if (leMonde[i-1][j-1] instanceof PlanDeau) {
                    GridPane sect =((PlanDeau) leMonde[i-1][j-1]).PD(grid, i, j);
                    grid.setColumnIndex(sect,i);
                    grid.setRowIndex(sect,j);
                    grid.getChildren().add(sect);
                } else if (leMonde[i-1][j-1] instanceof Entrepot) {

                    if (leMonde[i-1][j-1].getRobotPresent())
                    {
                        GridPane sect=((Entrepot) leMonde[i-1][j-1]).Entrepot2(grid, i, j, ((Entrepot) leMonde[i-1][j-1]).getNumEnt());
                        grid.setColumnIndex(sect,i);
                        grid.setRowIndex(sect,j);
                        grid.getChildren().add(sect);
                    }
                    else {
                        GridPane sect=((Entrepot) leMonde[i-1][j-1]).Entrepot(grid, i, j, ((Entrepot) leMonde[i-1][j-1]).getNumEnt());
                        grid.setColumnIndex(sect,i);
                        grid.setRowIndex(sect,j);
                        grid.getChildren().add(sect);}

                } else if (leMonde[i-1][j-1] instanceof Mine) {

                    if (leMonde[i-1][j-1].getRobotPresent())
                    {

                        GridPane sect=((Mine) leMonde[i-1][j-1]).Mine2(grid, i, j, ((Mine) leMonde[i-1][j-1]).getNumM());
                        grid.setColumnIndex(sect,i);
                        grid.setRowIndex(sect,j);
                        grid.getChildren().add(sect);

                    }
                    else {
                        GridPane sect=((Mine) leMonde[i-1][j-1]).Mine(grid, i, j, ((Mine) leMonde[i-1][j-1]).getNumM());
                        grid.setColumnIndex(sect,i);
                        grid.setRowIndex(sect,j);
                        grid.getChildren().add(sect);}
                }

            }
        }


    }
    public void setTirob1(){
        Tirob1.setText(String.valueOf(robot1.getX()+1));
    }
    public void setTjrob1(){
        Tjrob1.setText(String.valueOf(robot1.getY()+1));
    }
    public void setTirob2(){
        Tirob2.setText(String.valueOf(robot2.getX()+1));
    }
    public void setTjrob2(){
        Tjrob2.setText(String.valueOf(robot2.getY()+1));
    }

    public void setTnbminerais1(){Tnbminerais1.setText(String.valueOf(mine1.getNbMinerais()));}
    public void setTnbminerais2(){Tnbminerais2.setText(String.valueOf(mine2.getNbMinerais()));}

    public void setTstockrob1() {Tstockrob1.setText(String.valueOf(robot1.getStockage()));}

    public void setTstockrob2() {Tstockrob2.setText(String.valueOf(robot2.getStockage()));}


    public void setTstockentrepot1(){Tstockentrepot1.setText(String.valueOf(entrepot1.getStock()));}
    public void setTstockentrepot2(){Tstockentrepot2.setText(String.valueOf(entrepot2.getStock()));}



    private String abreg (String nature){
        if (nature.equals("nickel")) {
            nature = "NI";
        }
        else {
            nature = "OR";
        }
        return nature;
    }
    public GridPane affichageScore() {;
        VBox vBox = new VBox();
        vBox.getChildren().add(new Text(" "));
        String AlaLigne = System.getProperty("line.separator");
        Text TA = new Text("  REGLES DU JEU"+AlaLigne+AlaLigne+"  Bonjour," +AlaLigne+ "  Voici les règles du robot mineur :" +AlaLigne+ "  Pour ce jeu, vous avez à votre disposition deux robots correspondant"+AlaLigne+"  à une mine en particulier,"+AlaLigne+"  vous pouvez le remarquer juste au-dessus,"+AlaLigne+"  NI pour le Nickel et OR pour l'Or."+AlaLigne+"  Vous pouvez également voir qu'au niveau des informations ci-dessus,"+AlaLigne+"  vous avez à disposition le numéro de chaque mine,"+AlaLigne+"  de chaque entrepôt et de chaque robot"+AlaLigne+"  ainsi que leurs coordonnées sur la Carte"+AlaLigne+"  et leur capacité de stockage de Minerais."+AlaLigne+
                "  Le but du jeu est de récolter tous les minerais disposés"+AlaLigne+"  dans les mines avec le robot qui correspond"+AlaLigne+"  et ensuite déposer les minerais dans l'entrepôt du même type." +AlaLigne+ "  Tout cela, en essayant de faire le moins de tour possible sur la carte"+AlaLigne+"  et en évitant les plans d'eau."+AlaLigne+"  BON JEU et BONNE CHANCE");

        /*Tour*/

        Text tour =new Text("  Tour : "+ this.tour+"            X / Y               TYPE             STO / CAP");
        vBox.getChildren().add(tour);
        vBox.getChildren().add(new Text("  "));

        /*Mine*/

        Label Timine1 = new Label(String.valueOf(mine1.getX()));
        Label Tjmine1 = new Label(String.valueOf(mine1.getY()));
        Label Timine2 = new Label(String.valueOf(mine2.getX()));
        Label Tjmine2 = new Label(String.valueOf(mine2.getY()));

        Label Tnaturemine1 = new Label(String.valueOf(abreg(mine1.getNature())));
        Label Tnaturemine2 = new Label(String.valueOf(abreg(mine2.getNature())));

        Tnbminerais1 = new Label(String.valueOf(mine1.getNbMinerais()));
        Tnbminerais2 = new Label(String.valueOf(mine2.getNbMinerais()));

        Label Tcapacitemine1 = new Label(String.valueOf(mine1.getCapInit()));
        Label Tcapacitemine2 = new Label(String.valueOf(mine2.getCapInit()));

        Text Mine = new Text("  M"+(mine1.getNumM()+1));
        Text Mine2 = new Text("  M"+(mine2.getNumM()+1));

        HBox hBoxmine = new HBox();
        VBox vBoxmine = new VBox();
        hBoxmine.getChildren().addAll(Mine,new Text("                "),Timine1,new Text(" / "),Tjmine1,new Text("                "),
                Tnaturemine1,new Text("                "),Tnbminerais1,new Text(" / "),Tcapacitemine1);
        vBoxmine.getChildren().add(hBoxmine);

        HBox hBoxmine2 = new HBox();
        VBox vBoxmine2 = new VBox();
        hBoxmine2.getChildren().addAll(Mine2,new Text("                "),Timine2,new Text(" / "),Tjmine2,new Text("                "),
                Tnaturemine2,new Text("                "),Tnbminerais2,new Text(" / "),Tcapacitemine2);
        vBoxmine2.getChildren().add(hBoxmine2);

        vBox.getChildren().addAll(vBoxmine,vBoxmine2);

        /*Entrepot*/

        /*Entrepot*/


        Label Tientrepot1 = new Label(String.valueOf(entrepot1.getX()));
        Label Tjentrepot1 = new Label(String.valueOf(entrepot1.getY()));
        Label Tientrepot2 = new Label(String.valueOf(entrepot2.getX()));
        Label Tjentrepot2 = new Label(String.valueOf(entrepot2.getY()));

        Label Tnatureentrepot1 = new Label(String.valueOf(abreg(entrepot1.getNatureE())));
        Label Tnatureentrepot2= new Label(String.valueOf(abreg(entrepot2.getNatureE())));

        Tstockentrepot1 =new Label(String.valueOf(entrepot1.getStock()));
        Tstockentrepot2 =new Label(String.valueOf(entrepot2.getStock()));

        Label Tcapacitestockentrpot1 = new Label(String.valueOf("170"));
        Label Tcapacitestockentrpot2 = new Label(String.valueOf("170"));

        Text Entrepot = new Text("  E"+(entrepot1.getNumEnt()+1));
        Text Entrepot2 = new Text("  E"+(entrepot2.getNumEnt()+1));

        HBox hBoxentreopt1 = new HBox();
        VBox vBoxentrepot1 = new VBox();
        hBoxentreopt1.getChildren().addAll(Entrepot,new Text("                 "),Tientrepot1,new Text(" / "),Tjentrepot1,new Text("                "),
                Tnatureentrepot1,new Text("                "),Tstockentrepot1,new Text(" / "),Tcapacitestockentrpot1);
        vBoxentrepot1.getChildren().add(hBoxentreopt1);

        HBox hBoxentreopt2 = new HBox();
        VBox vBoxentrepot2 = new VBox();
        hBoxentreopt2.getChildren().addAll(Entrepot2,new Text("                 "),Tientrepot2,new Text(" / "),Tjentrepot2,new Text("                "),
                Tnatureentrepot2,new Text("                "),Tstockentrepot2,new Text(" / "),Tcapacitestockentrpot2);
        vBoxentrepot2.getChildren().add(hBoxentreopt2);

        vBox.getChildren().addAll(vBoxentrepot1,vBoxentrepot2);



        /* Robot*/
        Text Tidrob1 = new Text(String.valueOf("  R"+robot1.getNumRobot()));
        Text Tidrob2 = new Text(String.valueOf("  R"+robot2.getNumRobot()));


        Tirob1 = new Label(String.valueOf( robot1.getX()+1));
        Tjrob1 = new Label(String.valueOf( robot1.getY()+1));
        Tirob2 = new Label(String.valueOf( robot2.getX()+1));
        Tjrob2 = new Label(String.valueOf( robot2.getY()+1));

        Label Tnaturerob1 = new Label(abreg(robot1.getType()));
        Label Tnaturerob2 = new Label(abreg(robot2.getType()));

        Tstockrob1 = new Label(String.valueOf( robot1.getStockage()));
        Tstockrob2 = new Label(String.valueOf( robot2.getStockage()));

        Label Tcapacitestockrob1 = new Label(String.valueOf( robot1.getCapStock()));
        Label Tcapacitestockrob2 = new Label(String.valueOf( robot2.getCapStock()));


        HBox hBoxrob1 = new HBox();
        VBox vBoxrob1 = new VBox();
        hBoxrob1.getChildren().addAll(Tidrob1,new Text("                 "),Tirob1,new Text(" / "),Tjrob1,new Text("                "),
                Tnaturerob1,new Text("                "),Tstockrob1,new Text(" / "),Tcapacitestockrob1);
        vBoxrob1.getChildren().add(hBoxrob1);

        HBox hBoxrob2 = new HBox();
        VBox vBoxrob2 = new VBox();
        hBoxrob2.getChildren().addAll(Tidrob2,new Text("                 "),Tirob2,new Text(" / "),Tjrob2,new Text("                "),
                Tnaturerob2,new Text("                "),Tstockrob2,new Text(" / "),Tcapacitestockrob2);
        vBoxrob2.getChildren().add(hBoxrob2);

        vBox.getChildren().addAll(vBoxrob1,vBoxrob2);

        GridPane tablescore = new GridPane();
        tablescore.setAlignment(Pos.CENTER);
        ColumnConstraints column = new ColumnConstraints(400);
        tablescore.getColumnConstraints().add(column);
        RowConstraints row = new RowConstraints(600);
        tablescore.getRowConstraints().add(row);
        vBox.getChildren().add(new Text(" "));
        vBox.getChildren().add(TA);
        tablescore.setStyle("-fx-background-color: white; -fx-grid-lines-visible: true");
        tablescore.getChildren().add(vBox);

        return tablescore;


    }


}