package com.example.sae202;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

public class GestionEvent implements EventHandler{
	private Monde leMonde;
	private Robot rob;
	@Override
	public void handle(Event event) {
		if(event.getEventType() == MouseEvent.MOUSE_CLICKED)
		{
			if((event.getSource() instanceof Button) && (event.getSource().toString().contains("avancer")))
			{
				try {
					rob.Nord(leMonde);
				} catch (DepassementMonde_Exception e) {
					e.printStackTrace();
				}
			}
			else if((event.getSource() instanceof Button) && (event.getSource().toString().contains("reculer")))
			{
				try {
					rob.Sud(leMonde);
				} catch (DepassementMonde_Exception e) {
					e.printStackTrace();
				}
			}

			else if((event.getSource() instanceof Button) && (event.getSource().toString().contains("gauche")))
			{
				try {
					rob.Ouest(leMonde);
				} catch (DepassementMonde_Exception e) {
					e.printStackTrace();
				}
			}

			else if((event.getSource() instanceof Button) && (event.getSource().toString().contains("droite")))
			{
				try {
					rob.Est(leMonde);
				} catch (DepassementMonde_Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
}
