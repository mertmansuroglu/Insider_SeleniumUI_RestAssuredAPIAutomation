Feature: Insider Test Cases

  @Insider
  Scenario Outline: I should be able navigate to insider page
    Given I open the browser "<browser>"
    When I  visit insider web page
    Then I check if the page is correctly opened "https://useinsider.com/"
    Then I  should be able to handle the frame
    Then I check if the browser has been closed
    Examples:
      | browser |
      | chrome  |
      | firefox |
  @Insider
  Scenario Outline: I should be able landed to Career page
    Given I open the browser "<browser>"
    When I  visit insider web page
    Then I check if the page is correctly opened "https://useinsider.com/"
    Then I  should be able to handle the frame
    When I open career page
    Then I check if the page is correctly opened "https://useinsider.com/career/"
    And I check if the browser has been closed

    Examples:
      | browser |
      | chrome  |
      | firefox |

  @Insider
  Scenario Outline: I should be able to redirected to Culture section inside Career Page
    Given I open the browser "<browser>"
    When I  visit insider web page
    Then I check if the page is correctly opened "https://useinsider.com/"
    Then I  should be able to handle the frame
    When I open career page
    Then I check if the page is correctly opened "https://useinsider.com/career/"
    When I open culture section
    Then I check if the page is correctly opened "https://useinsider.com/career/#culture"
    Then I check current scroll position after scrolling to culture section <position>
    Then I check if the culture blocks appeared
    And I check if the browser has been closed

    Examples:
      | browser |  | position |
      | chrome  |  | 618      |
      | firefox |  | 649      |

  @Insider
  Scenario Outline: I should be able to redirected to Locations section inside Career Page
    Given I open the browser "<browser>"
    When I  visit insider web page
    Then I check if the page is correctly opened "https://useinsider.com/"
    Then I  should be able to handle the frame
    When I open career page
    Then I check if the page is correctly opened "https://useinsider.com/career/"
    When I open location section
    Then I check if the page is correctly opened "https://useinsider.com/career/#locations"
    Then I check current scroll position after scrolling to culture section <position>
    Then I check if the location blocks appeared
    And I check if the browser has been closed

    Examples:
      | browser |  | position |
      | chrome  |  | 1716     |
      | firefox |  | 1747     |

  @Insider
  Scenario Outline: I should be able to redirected to Teams section inside Career Page
    Given I open the browser "<browser>"
    When I  visit insider web page
    Then I check if the page is correctly opened "https://useinsider.com/"
    Then I  should be able to handle the frame
    When I open career page
    Then I check if the page is correctly opened "https://useinsider.com/career/"
    When I open Teams section
    Then I check if the page is correctly opened "https://useinsider.com/career/#teams"
    Then I check current scroll position after scrolling to culture section <position>
    Then I check if the Teams blocks appeared
    And I check if the browser has been closed
    Examples:
      | browser |  | position |
      | chrome  |  | 2538     |
      | firefox |  | 2570     |

  @Insider
  Scenario Outline: I should be able to redirected to Jobs section inside Career Page
    Given I open the browser "<browser>"
    When I  visit insider web page
    Then I check if the page is correctly opened "https://useinsider.com/"
    Then I  should be able to handle the frame
    When I open career page
    Then I check if the page is correctly opened "https://useinsider.com/career/"
    When I open Jobs section
    Then I check if the page is correctly opened "https://useinsider.com/career/#jobs"
    Then I check current scroll position after scrolling to culture section <position>
    Then I check if the Jobs blocks appeared
    And I check if the browser has been closed
    Examples:
      | browser |  | position |
      | chrome  |  | 4650     |
      | firefox |  | 4680     |

  @Insider
  Scenario Outline: I should be able to redirected to Life section inside Career Page
    Given I open the browser "<browser>"
    When I  visit insider web page
    Then I check if the page is correctly opened "https://useinsider.com/"
    Then I  should be able to handle the frame
    When I open career page
    Then I check if the page is correctly opened "https://useinsider.com/career/"
    When I open Life section
    Then I check if the page is correctly opened "https://useinsider.com/career/#life-at-insider"
    Then I check current scroll position after scrolling to culture section <position>
    Then I check if the Life blocks appeared
    And I check if the browser has been closed
    Examples:
      | browser |  | position |
      | chrome  |  | 5990     |

  @Insider
  Scenario Outline: Check presence of job-list by Location - Istanbul, Turkey and department - Quality Assurance,
    Given I open the browser "<browser>"
    When I  visit insider web page
    Then I check if the page is correctly opened "https://useinsider.com/"
    Then I  should be able to handle the frame
    When I open career page
    And I scroll to Jobs page
    And  I filter jobs by Location - Istanbul, Turkey
    And I filter jobs by department - Quality Assurance
    Then I should see the search result
    And I check if the browser has been closed
    Examples:
      | browser |
      | chrome  |
      | firefox |

  @Insider
  Scenario Outline: Check that all jobs’ Position contains “Quality Assurance”, Department contains “Quality Assurance”, Location contains “Istanbul, Turkey”
    Given I open the browser "<browser>"
    When I  visit insider web page
    Then I check if the page is correctly opened "https://useinsider.com/"
    Then I  should be able to handle the frame
    When I open career page
    And I scroll to Jobs page
    And  I filter jobs by Location - Istanbul, Turkey
    And I filter jobs by department - Quality Assurance
    Then I should see that all jobs position contains contains “Quality Assurance”
    Then I should see that all department contains contains “Quality Assurance”
    Then I should see that all location contains contains “Istanbul, Turkey”
    And I check if the browser has been closed
    Examples:
      | browser |
      | chrome  |
      | firefox |

  @Insider
  Scenario Outline: Select one of the positions, check that correct position page is opened, presence of job description, requirements and click “Apply for this job” button
    Given I open the browser "<browser>"
    When I  visit insider web page
    Then I check if the page is correctly opened "https://useinsider.com/"
    Then I  should be able to handle the frame
    When I open career page
    And I scroll to Jobs page
    And  I filter jobs by Location - Istanbul, Turkey
    And I filter jobs by department - Quality Assurance
    Then I should see that all jobs position contains contains “Quality Assurance”
    Then I should see that all department contains contains “Quality Assurance”
    Then I should see that all location contains contains “Istanbul, Turkey”
    And I should see that presence of job description, requirements and Apply for this job button is valid for the opened job position
    When I click Apply for this job button
    Then I check it redirects us to Application form page
    And I check if the browser has been closed
    Examples:
      | browser |
      | chrome  |
      | firefox |

