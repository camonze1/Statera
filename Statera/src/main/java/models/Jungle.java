package models;

import enums.BiomeEnum;

public class Jungle extends Biome {

    public Jungle() {
        this.type = BiomeEnum.JUNGLE;
        this.description = "This plot is a jungle.";
        this.waterProportion = 0;
        this.vegetationProportion = 1;
        this.buildingProportion = 0;
        this.cost.replace("Forest",2);
        this.cost.replace("Grass",2);

    }

    public boolean isOccupied() {
        return true;
    }

}
