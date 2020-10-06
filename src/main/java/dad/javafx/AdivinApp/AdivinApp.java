package dad.javafx.AdivinApp;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class AdivinApp extends Application {

	private Label textoLabel;
	private Button comprobarButton;
	private TextField numeroText;
	private int random;
	private int contador;

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub

		random = (int) (Math.random() * 100 + 1);

		textoLabel = new Label();
		textoLabel.setText("Introduce un número del 1 al 100");

		numeroText = new TextField();
		numeroText.setPrefColumnCount(5);
		numeroText.setAlignment(Pos.CENTER);
		numeroText.setMaxWidth(150);

		comprobarButton = new Button();
		comprobarButton.setText("Comprobar");
		comprobarButton.setOnAction(e -> onComprobarButtonAction(e));
		comprobarButton.setDefaultButton(true);

		VBox root = new VBox();
		root.setSpacing(5);
		root.setAlignment(Pos.CENTER);
		root.getChildren().addAll(textoLabel, numeroText, comprobarButton);

		Scene scene = new Scene(root, 320, 200);

		primaryStage.setScene(scene);
		primaryStage.setTitle("AdivinApp");
		primaryStage.show();

	}

	private void onComprobarButtonAction(ActionEvent e) {
		// TODO Auto-generated method stub

		if (numeroText.getText().matches("^[a-zA-Z]+$")) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error");
			alert.setHeaderText("ERROR");
			alert.setContentText("Has introducido una letra, pon un número");

			alert.showAndWait();
		}

		if (numeroText.getText().equals("")) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error");
			alert.setHeaderText("ERROR");
			alert.setContentText("No has introducido nada");

			alert.showAndWait();
		}

		int introducido = Integer.valueOf(numeroText.getText());

		if (introducido < 1 || introducido > 100) {
			Alert alert = new Alert(AlertType.ERROR);
			alert.setTitle("Error");
			alert.setHeaderText("ERROR");
			alert.setContentText("El número introducido no es válido");

			alert.showAndWait();
		}

		if (introducido == random) {
			contador++;
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("GENIAlL");
			alert.setHeaderText("¡Has ganado!");
			alert.setContentText("Sólo has necesitado " + contador + " intento/s.\nVuelve a jugar y hazlo mejor.");
			alert.showAndWait();
		}

		if (random > introducido) {
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("OH NO");
			alert.setHeaderText("¡Has fallado!");
			alert.setContentText("El número a adivinar es mayor que " + introducido + ".\nVuelve a intentarlo.");
			contador++;
			alert.showAndWait();
		}

		if (random < introducido) {
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("OH NO");
			alert.setHeaderText("¡Has fallado!");
			alert.setContentText("El número a adivinar es menor que " + introducido + ".\nVuelve a intentarlo.");
			contador++;
			alert.showAndWait();
		}

	}

	public static void main(String[] args) {
		launch(args);
	}

}
