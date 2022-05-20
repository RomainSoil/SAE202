package application;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

public class GestionEvent implements EventHandler{
	private Robot rob;
	@Override
	public void handle(Event event) {
		if(event.getEventType() == MouseEvent.MOUSE_CLICKED)
		{
			if((event.getSource() instanceof Button) && (event.getSource().toString().contains("avancer")))
			{
				rob.Nord();
			}
			else if((event.getSource() instanceof Button) && (event.getSource().toString().contains("reculer")))
			{
				rob.Sud();
			}
		
			else if((event.getSource() instanceof Button) && (event.getSource().toString().contains("gauche")))
			{
				rob.Ouest();
			}
		
			else if((event.getSource() instanceof Button) && (event.getSource().toString().contains("droite")))
			{
				rob.Est();
			}
		}
	}
}
