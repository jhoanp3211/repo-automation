Feature: crear cuenta en advantage


  @ValidarRegistro
  Scenario: realizar registro
    Given el usuario esta en la pagina principal
    When el usuario rellena el formulario
      | firstName  |secondName|lastName1 | lastName2 | email | phone | city | country | userName | password |
      |            |          |          |           |       |       | lima |         |          | sdc123*K |
    Then el usuario vera el mensaje This is just a dummy form,



