package view;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class AlertBox {
	static Label label=new Label();
	public static void display(String title,String message){
		Stage window=new Stage();
		window.initModality(Modality.APPLICATION_MODAL);
		window.setTitle(title);
		window.setMinWidth(250);
		
		label.setText(message);
		Button closeButton=new Button("Close the window");
		closeButton.setOnAction(e -> window.close());
	VBox layout =new VBox();
	layout.getChildren().addAll(closeButton,label);
	layout.setAlignment(Pos.CENTER);
	Scene scene=new Scene(layout,400,200);
	window.setScene(scene);
	window.showAndWait();;
	}
	
	

}
