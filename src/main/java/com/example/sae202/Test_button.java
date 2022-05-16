package com.example.sae202;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Test_button extends Application{

	@Override
	public void start(Stage stage) throws Exception {
	
		Group group = new Group();
		Scene scene = new Scene(group, 200,150);
		Button button = new Button();
		
		group.getChildren().add(button);
		stage.setScene(scene);;
		stage.show();
	}
	public static void main(String[] args)
	{
		Application.launch(args);
	}
}
