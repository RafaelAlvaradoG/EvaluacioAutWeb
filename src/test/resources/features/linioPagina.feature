@Loginlinio
Feature: Pagina de linio

  Scenario: Login a Linio
    Given que estoy en la pagina de inicio de Linio
    When ingresemos mis credenciales usuario "magomlg@hotmail.com" y la clave "Isaac2013*"
    And hago click en login
    And valido el ingreso
