package models;

import enums.BiomeEnum;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;

public class Desert extends Biome {

    public Desert() {
        this.type = BiomeEnum.DESERT;
        this.description = "This plot is a desert.";
        this.waterProportion = 0;
        this.vegetationProportion = 0;
        this.buildingProportion = 0;
        this.cost.replace("Grass",3);
        this.cost.replace("Water",2);
        this.color= Color.YELLOW;
        this.img = new Image("C:/Users/julie/OneDrive/Documents/Polytech/4a/IVE/life-on-land/Statera/src/main/resources/ive/statera/img/Game Designs/desert.png");
    }

    public boolean isOccupied() {
        return true;
    }

}
