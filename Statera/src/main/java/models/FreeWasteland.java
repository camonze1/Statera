package models;

import enums.BiomeEnum;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;

import java.util.Random;

public class FreeWasteland extends Biome {

  public FreeWasteland() {
    this.type = BiomeEnum.FREEWASTELAND;
    this.description = "This plot is empty.";
    this.waterProportion = 0;
    this.vegetationProportion = 0;
    this.buildingProportion = 0;
    this.color = Color.LIGHTGRAY;
    this.img = new Image(getClass().getResource("/ive/statera/img/tiles/free_wasteland.png").toExternalForm());
    this.animalProportion = 0;

  }

  public boolean isOccupied() {
    return false;
  }

}
