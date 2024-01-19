package controllers;

import ive.statera.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class MenuController {

  //  Attributes  //

  private LandController landController;

  private BiomeController biomeController;

  public boolean unlockBlockedWasteland;

  @FXML
  private Button unlockWasteland;

  //  Methods  //

  public void home(ActionEvent event) {
    Scene scene = ((Node) event.getSource()).getScene();
    Stage stage = (Stage) scene.getWindow();
    stage.close();
  }

  public void blockUnlockWastelandButton() {
    this.unlockWasteland.setDisable(true);
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
      stage.setTitle("Select biome - Statera");
      stage.setScene(scene);
      stage.getIcons().add(new Image(Application.class.getResource("img/logo_statera.png").openStream()));
      stage.show();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  @FXML
  public void onClickedInformationButton(ActionEvent event) {
    try {
      FXMLLoader loader = new FXMLLoader(getClass().getResource("/ive/statera/Information.fxml"));
      Scene scene = new Scene(loader.load(), 600, 500);
      Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
      stage.setTitle("Informations - Statera");
      stage.setScene(scene);
      stage.getIcons().add(new Image(Application.class.getResource("img/logo_statera.png").openStream()));
      stage.show();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  @FXML
  public void onClickedUnlockWastelandButton(ActionEvent event) {
    this.unlockBlockedWasteland = true;
    this.landController.setUnlockBlockedWasteland(this.unlockBlockedWasteland);
    this.home(event);
  }

  @FXML
  public void onClickedQuitGame() {
    System.exit(0);
  }

  @FXML
  public void onClickedReplayGame(ActionEvent event) {
    this.home(event);
    this.landController.initializeLand();
  }

  //  Getters and setters  //

  public void setLandController(LandController landController) {
    this.landController = landController;
  }
}
