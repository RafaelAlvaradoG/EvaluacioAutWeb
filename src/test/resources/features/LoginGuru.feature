@LoginGuru
Feature: Guru Bank

  Scenario: Login a Guru
    Given que estoy en la pagina de inicio de Guru
    When ingremos mis credenciales usuario "68195" y la clave "1234!"
    And hago clic en login
    And valido que estoy logeado correctamente
