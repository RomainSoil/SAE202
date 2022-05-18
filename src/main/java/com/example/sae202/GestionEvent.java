package com.example.sae202;

import javafx.event.Event;
import javafx.event.EventHandler;

public class GestionEvent implements EventHandle{
	Robot rob = new Robot(0,0,1,5,3,0,4);
	@Override
	public void handle(Event event) throws DepassementMonde_Exception {
		if(event.getSource().toString().contains("avancer"))
		{
			rob.Nord();
		}
		else if(event.getSource().toString().contains("reculer"))
		{
			rob.Sud();
		}
		
		else if(event.getSource().toString().contains("gauche"))
		{
			rob.Ouest();
		}
		
		else if(event.getSource().toString().contains("droite"))
		{
			rob.Est();
		}
	}
}
