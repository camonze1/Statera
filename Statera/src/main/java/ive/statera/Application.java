package ive.statera;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class Application extends javafx.application.Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Application.class.getResource("Start.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 700);
        stage.getIcons().add(new Image(Application.class.getResource("img/statera_logo.png").openStream()));
        stage.setTitle("Statera");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}



