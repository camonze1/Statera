package models;

import enums.BiomeEnum;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;

public class PublicBuilding extends Biome{
    public PublicBuilding() {
        this.type = BiomeEnum.PUBLICBUILDING;
        this.description = "This plot is a public building.";
        this.waterProportion = 0;
        this.vegetationProportion = 0;
        this.buildingProportion = 1;
        this.cost.replace(BiomeEnum.FOREST, 1);
        this.cost.replace(BiomeEnum.GRASS, 1);
        this.cost.replace(BiomeEnum.WATER, 1);
        this.color = Color.BLACK;
        this.img = new Image(getClass().getResource("/ive/statera/img/tiles/building.png").toExternalForm());
        this.animalProportion = 0;
    }

    public boolean isOccupied() {
        return true;
    }
}

