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

  Scenario: The user can get the balance of Water biomes in the land
    Given the land is initialized
    When the user places some biomes
    And he wants to know what is the balance water biomes
    Then the balance of water biomes is displayed

  Scenario: The user can get the balance of Building biomes in the land
    Given the land is initialized
    When the user places some biomes
    And he wants to know what is the balance building biomes
    Then the balance of building biomes is displayed

  Scenario: The user can get the balance of the environment in the land
    Given the land is initialized
    When the user places some biomes
    And he wants to know what is the balance of the environment
    Then the balance of the environment is displayed

  Scenario: The user can get the number of animals in the land
    Given the land is initialized
    When the user places some biomes
    And he wants to know what is the number of animals in the land
    Then the number of animals is displayed

  Scenario: The user can get the number of humans in the land
    Given the land is initialized
    When the user places some biomes
    And he wants to know what is the number of humans in the land
    Then the number of humans is displayed

  Scenario: The user can get the balance of the biosphere in the land
    Given the land is initialized
    When the user places some biomes
    And he wants to know what is the balance of the biosphere
    Then the balance of the biosphere is displayed

  Scenario: The user can get the balance of the quality of life in the land
    Given the land is initialized
    When the user places some biomes
    And he wants to know what is the balance of the quality of life
    Then the balance of the quality of life is displayed

