Feature: Swagger Pet Test Cases


  Scenario: Verify if the new pet is being successfully updated
    Given Add new pet payload "Fino"
    When user calls add new pet api by post http request
    Then Api call is success with status code 200
    And Status in response body is "available"
    And name in response body is "Fino"

  Scenario: Verify if I can update the existing pet with new dog name
    Given I put updated payload "NewUpdatedDog"
    When user calls update api by put http request
    Then Api call is success with status code 200
    And Status in response body is "available"
    And name in response body is "NewUpdatedDog"

  Scenario Outline: Verify if I can log-in and log-out to the system
    Given add requirements as parameters "<username>" "<password>"
    When user calls login api by get http request
    Then Api call is success with status code 200
    And message should include "logged in user"
    When I log out from the system
    Then Api call is success with status code 200
    Examples:
      | username |  | password |
      | test     |  | abc123   |

  Scenario Outline: Verify that I should not be able to log in to the system with invalid credential
    Given add requirements as parameters "<username>" "<password>"
    When user calls login api by get http request
    Then Api call should be with  400 error code
    Examples:
      | username |  | password |
      | invalid  |  | invalid  |

  Scenario: Verify if I can successfully delete the new pet
    Given Add new pet payload "Kiraz"
    When user calls add new pet api by post http request
    Then Api call is success with status code 200
    Then I check pet id extracted from the newly added pet
    When I delete the added pet
    Then Api call is success with status code 200

  Scenario Outline: Verify if I can successfully place an order for a pet
    Given Add new pet payload "Barut"
    When user calls add new pet api by post http request
    Then Api call is success with status code 200
    Then I check pet id extracted from the newly added pet
    When I place an order for a pet
    Then Api call is success with status code 200
    And complete in response body is "<complete>"
    Examples:
      | complete |
      | true     |

  Scenario: Verify that User should not access to pet order which has been deleted
    Given Add new pet payload "Bulut"
    When user calls add new pet api by post http request
    Then Api call is success with status code 200
    Then I check pet id extracted from the newly added pet
    When I place an order for a pet
    Then Api call is success with status code 200
    Then I check order id extracted from the placed order
    When I delete the placed order
    Then Api call is success with status code 200
    Then I check to find purchase order which is deleted in the previous step


  Scenario: Verify that User should be able to access to placed order
    Given Add new pet payload "Gunes"
    When user calls add new pet api by post http request
    Then Api call is success with status code 200
    Then I check pet id extracted from the newly added pet
    When I place an order for a pet
    Then Api call is success with status code 200
    Then I check order id extracted from the placed order
    When I try to find the purchase order by Id
    Then Api call is success with status code 200