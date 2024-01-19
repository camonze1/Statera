Feature: Gestion des terrains

  Scenario: Initialisation du terrain
    Given l'utilisateur ouvre l'application
    When le terrain est initialisé
    Then le terrain devrait avoir une taille de 15x15

  Scenario: Achat d'un biome
    Given l'utilisateur a ouvert l'application
    When l'utilisateur sélectionne un biome
    And l'utilisateur clique sur un terrain libre
    Then le terrain devrait être mis à jour avec le nouveau biome
    And le solde environnemental devrait être mis à jour

  Scenario: Vérification des statistiques
    Given l'utilisateur a ouvert l'application
    When l'utilisateur clique sur "Statistics"
    Then une fenêtre de statistiques devrait s'afficher
    And les statistiques devraient être correctes en fonction du terrain
