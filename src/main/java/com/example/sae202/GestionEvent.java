package com.example.sae202;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class GestionEvent implements EventHandler{
	private Monde leMonde;
	private Robot robot1;
	private Stage stage;
	private GridPane grid;
	@Override
	public void handle(Event event) {
		if(event.getEventType() == MouseEvent.MOUSE_CLICKED)
		{
			if((event.getSource() instanceof Button) && (event.getSource().toString().contains("Robot1")))
				robot1=leMonde.robot1;

			if((event.getSource() instanceof Button) && (event.getSource().toString().contains("Robot2")))
				robot1=leMonde.robot2;





			if((event.getSource() instanceof Button) && (event.getSource().toString().contains("Nord")))
			{
				try {
					robot1.Nord(leMonde);
					leMonde.affichage(grid);
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
					stage.show();
				} catch (DepassementMonde_Exception e) {
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


}
