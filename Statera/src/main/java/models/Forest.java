package models;

import enums.BiomeEnum;
import javafx.scene.image.Image;

public class Forest extends Biome {

  //  Constructor  //

  public Forest() {
    this.type = BiomeEnum.FOREST;
    this.description = "This plot is a forest.";
    this.cost.replace(BiomeEnum.GRASS, 1);
    this.cost.replace(BiomeEnum.WATER, 1);
    this.img = new Image(getClass().getResource("/ive/statera/img/tiles/forest.png").toExternalForm());
    this.animalProportion = 18;
  }

  //  Methods  //
  
  public boolean isOccupied() {
    return true;
  }

}
