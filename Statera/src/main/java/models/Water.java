package models;

import enums.BiomeEnum;
import javafx.scene.image.Image;

public class Water extends Biome {

  // Constructor //

  public Water() {
    this.type = BiomeEnum.WATER;
    this.description = "This plot is a water.";
    this.img = new Image(getClass().getResource("/ive/statera/img/tiles/water.png").toExternalForm());
    this.animalProportion = 10;
  }

  //  Methods  //

  public boolean isOccupied() {
    return true;
  }

}
