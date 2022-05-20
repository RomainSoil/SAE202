package application;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

public class GestionEvent implements EventHandler{
	private Robot rob;
	DepassementMonde_Exception DE = new DepassementMonde_Exception("Vous avez ne pouvé pas aller plus loin !");
	@Override
	public void handle(Event event) {
		if(event instanceof KeyEvent)
		{
			if(((KeyEvent) event).getCode() == KeyCode.UP)
			{
				rob.Nord();
			}
			else if(((KeyEvent) event).getCode() == KeyCode.DOWN)
			{
				rob.Sud();
			}
		
			else if(((KeyEvent) event).getCode() == KeyCode.LEFT)
			{
				rob.Ouest();
			}
		
			else if(((KeyEvent) event).getCode() == KeyCode.RIGHT)
			{
				rob.Est();
			}
		}
	}
}
