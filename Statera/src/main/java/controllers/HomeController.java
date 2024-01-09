package controllers;

import ive.statera.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class HomeController {

  @FXML
  private void onClickedStartGameButton(ActionEvent event) {
    FXMLLoader loader = new FXMLLoader(getClass().getResource("/ive/statera/Land.fxml"));
    try {
      Parent root = loader.load();
      Scene scene = new Scene(root, 800, 700);
      Scene currentScene = ((Node) event.getSource()).getScene();
      if (currentScene != null) {
        Stage currentStage = (Stage) currentScene.getWindow();
        currentStage.close();
      }
      Stage gameStage = new Stage();
      gameStage.setTitle("Statera");
      gameStage.setScene(scene);
      gameStage.getIcons().add(new Image(Application.class.getResource("img/logo_statera.png").openStream()));
      gameStage.setResizable(false);
      gameStage.show();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
