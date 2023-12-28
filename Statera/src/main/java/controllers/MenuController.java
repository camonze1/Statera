package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MenuController {
  private LandController landController;
  private BiomeController biomeController;

  @FXML
  public void onClickedSelectBiomeButton(ActionEvent event) {
    try {
      FXMLLoader loader = new FXMLLoader(getClass().getResource("/ive/statera/Biome.fxml"));
      Scene scene = new Scene(loader.load(), 600, 500);
      this.biomeController = loader.getController();
      this.biomeController.setLandController(this.landController);
      Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
      stage.setTitle("Select Biome - Statera");
      stage.setScene(scene);
      stage.show();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public void home(ActionEvent event) {
    Scene scene = ((Node) event.getSource()).getScene();
    Stage stage = (Stage) scene.getWindow();
    stage.close();
  }

  public void onClickedQuitGame() {
    System.exit(0);
  }

  public void setLandController(LandController landController) {
    this.landController = landController;
  }

  public void onClickedReplayGame(ActionEvent event) {
    home(event);
    landController.initializeLand();
  }

  public BiomeController getBiomeMenuController() {
    return biomeController;
  }
}
