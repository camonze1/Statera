package models;

import enums.BiomeEnum;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;

public class Desert extends Biome {

  //  Constructor  //

  public Desert() {
    this.type = BiomeEnum.DESERT;
    this.description = "This plot is a desert.";
    this.waterProportion = 0;
    this.vegetationProportion = 0;
    this.buildingProportion = 0;
    this.cost.replace(BiomeEnum.GRASS, 3);
    this.cost.replace(BiomeEnum.WATER, 2);
    this.color = Color.YELLOW;
    this.img = new Image(getClass().getResource("/ive/statera/img/tiles/b_desert.jpg").toExternalForm());
    this.animalProportion = 8;
  }

  //  Methods  //
  
  public boolean isOccupied() {
    return true;
  }

}
