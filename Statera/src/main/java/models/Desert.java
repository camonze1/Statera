package models;

import enums.BiomeEnum;

public class Desert extends Biome {

    public Desert() {
        this.type = BiomeEnum.DESERT;
        this.description = "This plot is a desert.";
        this.waterProportion = 0;
        this.vegetationProportion = 0;
        this.buildingProportion = 0;
        this.cost.replace("Grass",3);
        this.cost.replace("Water",2);
    }

    public boolean isOccupied() {
        return true;
    }

}
