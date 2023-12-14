package models;

import enums.BiomeEnum;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;

public class Jungle extends Biome {

    public Jungle() {
        this.type = BiomeEnum.JUNGLE;
        this.description = "This plot is a jungle.";
        this.waterProportion = 0;
        this.vegetationProportion = 1;
        this.buildingProportion = 0;
        this.cost.replace("Forest",2);
        this.cost.replace("Grass",2);
        this.color= Color.GREENYELLOW;
        this.img = new Image("C:/Users/julie/OneDrive/Documents/Polytech/4a/IVE/life-on-land/Statera/src/main/resources/ive/statera/img/Game Designs/forest.png");

    }

    public boolean isOccupied() {
        return true;
    }

}
