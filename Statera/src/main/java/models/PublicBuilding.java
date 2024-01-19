package models;

import enums.BiomeEnum;
import javafx.scene.image.Image;

public class PublicBuilding extends Biome{
    public PublicBuilding() {
        this.type = BiomeEnum.PUBLICBUILDING;
        this.description = "This plot is a public building.";
        this.cost.replace(BiomeEnum.FOREST, 1);
        this.cost.replace(BiomeEnum.GRASS, 1);
        this.cost.replace(BiomeEnum.WATER, 1);
        this.img = getClass().getResource("/ive/statera/img/tiles/public_building.png");
        this.animalProportion = 0;
    }

    public boolean isOccupied() {
        return true;
    }
}

