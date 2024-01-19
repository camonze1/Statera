Feature: Management of the land

  Scenario: The user can get the number of Natural biomes in the land
    Given the land is initialized
    When the user places some biomes
    And he wants to know how many natural biomes there are in the land
    Then the number of natural biomes are displayed

  Scenario: The user can get the balance of Natural biomes in the land
    Given the land is initialized
    When the user places some biomes
    And he wants to know what is the balance natural biomes
    Then the balance of natural biomes is displayed