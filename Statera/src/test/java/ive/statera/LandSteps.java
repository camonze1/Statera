package ive.statera;

import enums.BiomeEnum;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import models.Land;

import java.util.List;
import java.util.Random;

public class LandSteps {
    private Land land;
    private int NmbrNatBiomes;
    private double NatBiomesBalance;
    private double WaterBiomesBalance;
    private double BuildingBiomesBalance;
    private double EnvironmentBalance;
    private double BiosphereBalance;
    private double QOLBalance;
    private int NmbrAnimals;
    private int NmbrHumans;

    @Given("the land is initialized")
    public void LandIsInitialized(){
        land=new Land(25,25);
    }
    @When("the user places some biomes")
    public void BiomesPlaced(){
        Random random = new Random();
        List<int[]> freeWastelandCoordinates = this.land.getCoordinatesByBiomeType(BiomeEnum.FREEWASTELAND);
        if (!freeWastelandCoordinates.isEmpty()) {
            int[] randomCoordinate = freeWastelandCoordinates.get(random.nextInt(freeWastelandCoordinates.size()));
            this.land.setBiome(randomCoordinate[0], randomCoordinate[1], BiomeEnum.GRASS);
            randomCoordinate = freeWastelandCoordinates.get(random.nextInt(freeWastelandCoordinates.size()));
            this.land.setBiome(randomCoordinate[0], randomCoordinate[1], BiomeEnum.GRASS);
            randomCoordinate = freeWastelandCoordinates.get(random.nextInt(freeWastelandCoordinates.size()));
            this.land.setBiome(randomCoordinate[0], randomCoordinate[1], BiomeEnum.WATER);
            randomCoordinate = freeWastelandCoordinates.get(random.nextInt(freeWastelandCoordinates.size()));
            this.land.setBiome(randomCoordinate[0], randomCoordinate[1], BiomeEnum.WATER);
            randomCoordinate = freeWastelandCoordinates.get(random.nextInt(freeWastelandCoordinates.size()));
            this.land.setBiome(randomCoordinate[0], randomCoordinate[1], BiomeEnum.FOREST);
            randomCoordinate = freeWastelandCoordinates.get(random.nextInt(freeWastelandCoordinates.size()));
            this.land.setBiome(randomCoordinate[0], randomCoordinate[1], BiomeEnum.JUNGLE);
            randomCoordinate = freeWastelandCoordinates.get(random.nextInt(freeWastelandCoordinates.size()));
            this.land.setBiome(randomCoordinate[0], randomCoordinate[1], BiomeEnum.DESERT);
            randomCoordinate = freeWastelandCoordinates.get(random.nextInt(freeWastelandCoordinates.size()));
            this.land.setBiome(randomCoordinate[0], randomCoordinate[1], BiomeEnum.MOUNTAIN);
            randomCoordinate = freeWastelandCoordinates.get(random.nextInt(freeWastelandCoordinates.size()));
            this.land.setBiome(randomCoordinate[0], randomCoordinate[1], BiomeEnum.BUILDING);
            randomCoordinate = freeWastelandCoordinates.get(random.nextInt(freeWastelandCoordinates.size()));
            this.land.setBiome(randomCoordinate[0], randomCoordinate[1], BiomeEnum.BUILDING);
            randomCoordinate = freeWastelandCoordinates.get(random.nextInt(freeWastelandCoordinates.size()));
            this.land.setBiome(randomCoordinate[0], randomCoordinate[1], BiomeEnum.BUILDING);
            randomCoordinate = freeWastelandCoordinates.get(random.nextInt(freeWastelandCoordinates.size()));
            this.land.setBiome(randomCoordinate[0], randomCoordinate[1], BiomeEnum.PUBLICBUILDING);
        }
    }
    @And("he wants to know how many natural biomes there are in the land")
    public void getNmbrNatBiomes(){
        NmbrNatBiomes=land.getNumberOfNaturalBiome();
    }

    @Then("the number of natural biomes are displayed")
    public void DisplayNmbrNatBiomes(){
        System.out.println("The number of natural biomes in the land is: "+NmbrNatBiomes);
    }
    @And("he wants to know what is the balance natural biomes")
    public void getNatBiomesBalance(){
        NatBiomesBalance=land.getBalanceOfNaturalBiome();
    }

    @Then("the balance of natural biomes is displayed")
    public void DisplayNatBiomesBalance(){
        System.out.println("The balance of natural biomes in the land is: "+NatBiomesBalance+"%");
    }
    @And("he wants to know what is the balance water biomes")
    public void getWaterBiomesBalance(){
        WaterBiomesBalance=land.getBalanceOfWaterBiome();
    }

    @Then("the balance of water biomes is displayed")
    public void DisplayWaterBiomesBalance(){
        System.out.println("The balance of water biomes in the land is: "+WaterBiomesBalance+"%");
    }
    @And("he wants to know what is the balance building biomes")
    public void getBuildingBiomesBalance(){
        BuildingBiomesBalance=land.getBalanceOfBuildingBiome();
    }

    @Then("the balance of building biomes is displayed")
    public void DisplayBuildingBiomesBalance(){
        System.out.println("The balance of building biomes in the land is: "+BuildingBiomesBalance+"%");
    }
    @And("he wants to know what is the balance of the environment")
    public void getEnvironmentBalance(){
        EnvironmentBalance=land.environmentBalance();
    }

    @Then("the balance of the environment is displayed")
    public void DisplayEnvironmentBalance(){
        System.out.println("The balance of the environment in the land is: "+EnvironmentBalance+"%");
    }
    @And("he wants to know what is the number of animals in the land")
    public void getNmbrOfAnimals(){
        NmbrAnimals=land.getNumberOfAnimals();
    }
    @Then("the number of animals is displayed")
    public void DisplayNmbrOfAnimals(){
        System.out.println("There are "+NmbrAnimals+" animals in the land");
    }
    @And("he wants to know what is the number of humans in the land")
    public void getNmbrOfHumans(){
        NmbrHumans=land.getNumberOfAnimals();
    }
    @Then("the number of humans is displayed")
    public void DisplayNmbrOfHumans(){
        System.out.println("There are "+NmbrHumans+" humans in the land");
    }
    @And("he wants to know what is the balance of the biosphere")
    public void getBiosphereBalance(){
        BiosphereBalance=land.getBiosphereBalance();
    }

    @Then("the balance of the biosphere is displayed")
    public void DisplayBiosphereBalance(){
        System.out.println("The balance of the biosphere in the land is: "+BiosphereBalance+"%");
    }
    @And("he wants to know what is the balance of the quality of life")
    public void getQOLBalance(){
        QOLBalance=land.getQualityOfLifeBalance();
    }

    @Then("the balance of the quality of life is displayed")
    public void DisplayQOLBalance(){
        System.out.println("The balance of the quality of life in the land is: "+QOLBalance+"%");
    }

}
