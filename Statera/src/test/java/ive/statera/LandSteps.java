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
    private Random random;
    private int NmbrNatBiomes;
    private double NatBiomesBalance;
    @Given("the land is initialized")
    public void LandIsInitialized(){
        land=new Land(25,25);
    }
    @When("the user places some biomes")
    public void BiomesPlaced(){
        random=new Random();
        List<int[]> freeWastelandCoordinates = this.land.getCoordinatesByBiomeType(BiomeEnum.FREEWASTELAND);
        if (!freeWastelandCoordinates.isEmpty()) {
            int[] randomCoordinate = freeWastelandCoordinates.get(this.random.nextInt(freeWastelandCoordinates.size()));
            this.land.setBiome(randomCoordinate[0], randomCoordinate[1], BiomeEnum.GRASS);
            randomCoordinate = freeWastelandCoordinates.get(this.random.nextInt(freeWastelandCoordinates.size()));
            this.land.setBiome(randomCoordinate[0], randomCoordinate[1], BiomeEnum.GRASS);
            randomCoordinate = freeWastelandCoordinates.get(this.random.nextInt(freeWastelandCoordinates.size()));
            this.land.setBiome(randomCoordinate[0], randomCoordinate[1], BiomeEnum.WATER);
            randomCoordinate = freeWastelandCoordinates.get(this.random.nextInt(freeWastelandCoordinates.size()));
            this.land.setBiome(randomCoordinate[0], randomCoordinate[1], BiomeEnum.WATER);
            randomCoordinate = freeWastelandCoordinates.get(this.random.nextInt(freeWastelandCoordinates.size()));
            this.land.setBiome(randomCoordinate[0], randomCoordinate[1], BiomeEnum.FOREST);
            randomCoordinate = freeWastelandCoordinates.get(this.random.nextInt(freeWastelandCoordinates.size()));
            this.land.setBiome(randomCoordinate[0], randomCoordinate[1], BiomeEnum.JUNGLE);
            randomCoordinate = freeWastelandCoordinates.get(this.random.nextInt(freeWastelandCoordinates.size()));
            this.land.setBiome(randomCoordinate[0], randomCoordinate[1], BiomeEnum.DESERT);
            randomCoordinate = freeWastelandCoordinates.get(this.random.nextInt(freeWastelandCoordinates.size()));
            this.land.setBiome(randomCoordinate[0], randomCoordinate[1], BiomeEnum.MOUNTAIN);
            randomCoordinate = freeWastelandCoordinates.get(this.random.nextInt(freeWastelandCoordinates.size()));
            this.land.setBiome(randomCoordinate[0], randomCoordinate[1], BiomeEnum.BUILDING);
            randomCoordinate = freeWastelandCoordinates.get(this.random.nextInt(freeWastelandCoordinates.size()));
            this.land.setBiome(randomCoordinate[0], randomCoordinate[1], BiomeEnum.BUILDING);
            randomCoordinate = freeWastelandCoordinates.get(this.random.nextInt(freeWastelandCoordinates.size()));
            this.land.setBiome(randomCoordinate[0], randomCoordinate[1], BiomeEnum.BUILDING);
            randomCoordinate = freeWastelandCoordinates.get(this.random.nextInt(freeWastelandCoordinates.size()));
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
}
