package models;

import enums.BiomeEnum;
import javafx.scene.image.Image;

public class Jungle extends Biome {

  //  Constructor  //

  public Jungle() {
    this.type = BiomeEnum.JUNGLE;
    this.description = "This plot is a jungle.";
    this.cost.replace(BiomeEnum.FOREST, 2);
    this.cost.replace(BiomeEnum.GRASS, 2);
    this.img = new Image(getClass().getResource("/ive/statera/img/tiles/jungle.jpg").toExternalForm());
    this.animalProportion = 11;
  }

  //  Methods  //

  public boolean isOccupied() {
    return true;
  }

}
