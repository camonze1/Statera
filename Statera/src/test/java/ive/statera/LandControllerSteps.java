package ive.statera;

import controllers.LandController;
import enums.BiomeEnum;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import static org.junit.Assert.*;

public class LandControllerSteps {

    private LandController landController;

    @Given("l'utilisateur ouvre l'application")
    public void utilisateurOuvreApplication() {
        landController = new LandController();
        // Ajoutez ici tout code d'initialisation nécessaire pour votre application
    }

    @When("le terrain est initialisé")
    public void terrainEstInitialise() {
        landController.initializeLand();
    }

    @Then("le terrain devrait avoir une taille de {int}x{int}")
    public void terrainDevraitAvoirTaille(int rows, int cols) {
    assertEquals(rows, landController.getLand().getLandSize()[0]);
    assertEquals(cols, landController.getLand().getLandSize()[1]);
}

@When("l'utilisateur sélectionne un biome")
public void utilisateurSelectionneBiome() {
    landController.setBiomeSelected(BiomeEnum.GRASS); // Remplacez par le biome que vous souhaitez tester
}

@When("l'utilisateur clique sur un terrain libre")
public void utilisateurCliqueTerrainLibre() {
    // Ajoutez ici le code pour simuler le clic sur un terrain libre
    // Peut-être un appel à landController.onPlotClick() avec un Rectangle simulé
}

@Then("le terrain devrait être mis à jour avec le nouveau biome")
public void terrainDevraitMiseAJourAvecNouveauBiome() {
    // Ajoutez ici des assertions pour vérifier que le biome a été correctement mis à jour
}

@Then("le solde environnemental devrait être mis à jour")
public void soldeEnvironnementalDevraitMiseAJour() {
    // Ajoutez ici des assertions pour vérifier que le solde environnemental a été correctement mis à jour
}

@When("l'utilisateur clique sur {string}")
public void utilisateurCliqueSur(String button) {
    if (button.equals("Statistics")) {
        landController.onClickedStatistics(null); // Simule le clic sur le bouton "Statistics"
    }
    // Ajoutez d'autres cas selon les boutons que vous avez dans votre application
}

@Then("une fenêtre de statistiques devrait s'afficher")
public void fenetreStatistiquesDevraitAfficher() {
    // Ajoutez ici des assertions pour vérifier que la fenêtre de statistiques s'est affichée correctement
}

@Then("les statistiques devraient être correctes en fonction du terrain")
public void statistiquesDevraientEtreCorrectes() {
    // Ajoutez ici des assertions pour vérifier que les statistiques sont correctes
}

@Given("l'utilisateur a ouvert l'application")
public void UtilisateurAOuvertLApplication() {
}
}
