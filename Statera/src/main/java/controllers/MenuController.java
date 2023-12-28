package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class MenuController {

  //  Attributes  //

  private LandController landController;

  private BiomeController biomeController;

  //  Methods  //

  public void home(ActionEvent event) {
    Scene scene = ((Node) event.getSource()).getScene();
    Stage stage = (Stage) scene.getWindow();
    stage.close();
  }

  // FXML Methods  //

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

  @FXML
  public void onClickedQuitGame() {
    System.exit(0);
  }

  @FXML
  public void onClickedReplayGame(ActionEvent event) {
    home(event);
    landController.initializeLand();
  }

  //  Getters and setters  //

  public void setLandController(LandController landController) {
    this.landController = landController;
  }
  
  public BiomeController getBiomeMenuController() {
    return biomeController;
  }
}
