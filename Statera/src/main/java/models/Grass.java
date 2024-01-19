package models;

import enums.BiomeEnum;
import javafx.scene.image.Image;

public class Grass extends Biome {

  //  Constructor  //

  public Grass() {
    this.type = BiomeEnum.GRASS;
    this.description = "This plot is a grass.";
    this.img = getClass().getResource("/ive/statera/img/tiles/grass.jpg");
    this.animalProportion = 15;
  }

  //  Methods  //

  public boolean isOccupied() {
    return true;
  }
}
