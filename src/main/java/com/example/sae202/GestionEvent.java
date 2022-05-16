package com.example.sae202;

import javafx.event.Event;
import javafx.event.EventHandler;

public class GestionEvent implements EventHandler{
	Robot rob = new Robot(0,0,1,5,3,0);
	@Override
	public void handle(Event event) {
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
