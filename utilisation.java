package application;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class utilisation extends Application{
	private GestionEvent gestionevent;
	@Override
	public void start(Stage stage) throws Exception {
		HBox hbox= new HBox();
		VBox vbox= new VBox();
		Pane pan = new Pane();
		
		Group group = new Group();
		Button avancer= new Button("avancer");
		Button reculer= new Button("reculer");
		Button gauche= new Button("gauche");
		Button droite= new Button("droite");
		
		avancer.setLayoutX(63);
		hbox.setLayoutY(25);
		
		hbox.getChildren().add(gauche);
		pan.getChildren().add(avancer);
		hbox.getChildren().add(reculer);
		hbox.getChildren().add(droite);
		group.getChildren().addAll(pan,hbox);
		vbox.getChildren().add(group);
		
		avancer.setOnKeyReleased(gestionevent);
		reculer.setOnKeyReleased(gestionevent);
		gauche.setOnKeyReleased(gestionevent);
		droite.setOnKeyReleased(gestionevent);
		
		final Image img1= new Image(getClass().getResource("flecheHaut.png").toExternalForm());
		final ImageView icon1= new ImageView(img1);
		avancer.setGraphic(icon1);
		
		final Image img2= new Image(getClass().getResource("flecheB.png").toExternalForm());
		final ImageView icon2= new ImageView(img2);
		reculer.setGraphic(icon2);
		
		final Image img3= new Image(getClass().getResource("flecheG.png").toExternalForm());
		final ImageView icon3= new ImageView(img3);
		gauche.setGraphic(icon3);
		
		final Image img4= new Image(getClass().getResource("flecheD.png").toExternalForm());
		final ImageView icon4= new ImageView(img4);
		droite.setGraphic(icon4);
		Scene scene= new Scene(vbox);
		stage.setScene(scene);
		stage.show();
		
	}
	public static void main(String[] args)
	{
		Application.launch(args);
	}
	

}
