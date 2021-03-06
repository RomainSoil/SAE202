package com.example.sae202;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class GestionEvent implements EventHandler{
	private Monde leMonde;
	private Robot robot1;
	private Stage stage;
	private GridPane grid;
	private Mine mine;
	private VBox vbox;
	private Entrepot entrepot;




	@Override
	public void handle(Event event) {
		this.leMonde.tour+=1;
		if(event.getEventType() == MouseEvent.MOUSE_CLICKED)
		{
			if((event.getSource() instanceof Button) && (event.getSource().toString().contains("Robot1")))
			{
				robot1=leMonde.robot1;

			}

			else if((event.getSource() instanceof Button) && (event.getSource().toString().contains("Robot2"))) {
				robot1 = leMonde.robot2;

			}




			else if(((event.getSource() instanceof Button) && (event.getSource().toString().contains("Nord"))))
			{
				try {
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
			else if((event.getSource() instanceof Button) && (event.getSource().toString().contains("Sud")))
			{
				try {
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

			else if((event.getSource() instanceof Button) && (event.getSource().toString().contains("Ouest")))
			{
				try {
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

			else if((event.getSource() instanceof Button) && (event.getSource().toString().contains("Est")))
			{
				try {
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
			else if((event.getSource() instanceof Button) && (event.getSource().toString().contains("Extraire")))
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
			else if((event.getSource() instanceof Button) && (event.getSource().toString().contains("Deposer")))
			{
				try {
					robot1.deposer(entrepot);
					vbox.getChildren().set(0,leMonde.affichageScore());
					stage.show();
					if (leMonde.mine1.getNbMinerais()==0 &&leMonde.mine2.getNbMinerais()==0 && leMonde.robot1.getStockage()==0 && leMonde.robot2.getStockage()==0)
					{
						Text win = new Text("VOUS AVEZ GAGN?? !");
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



}

	public void setGrid(GridPane grid) {
		this.grid = grid;
	}

	public void setStage(Stage stage) {
		this.stage = stage;
	}

	public void setLeMonde(Monde leMonde) {
		this.leMonde = leMonde;
	}

	public void setRobot1(Robot rob) {
		this.robot1 = rob;
	}

	public void setMine(Mine mine) {
		this.mine = mine;
	}


	public void setVbox(VBox vbox) {
		this.vbox = vbox;
	}

	public void setEntrepot(Entrepot entrepot) {
		this.entrepot = entrepot;
	}
}
