package models;

import enums.BiomeEnum;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;

public class Forest extends Biome {

  public Forest() {
    this.type = BiomeEnum.FOREST;
    this.description = "This plot is a forest.";
    this.waterProportion = 0;
    this.vegetationProportion = 1;
    this.buildingProportion = 0;
    this.cost.replace("Grass", 1);
    this.cost.replace("Water", 1);
    this.color = Color.DARKGREEN;
    this.img = new Image(getClass().getResource("/ive/statera/img/tiles/b_forest.jpg").toExternalForm());
    this.animalProportion = 18;
  }

  public boolean isOccupied() {
    return true;
  }

}
