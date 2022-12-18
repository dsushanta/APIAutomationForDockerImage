Feature: To test user related scenarios

#  Background: Generating authentication token
#    When I call the authentication endpoint with following details
#      | Email                | Password |
#      | johny.bravo@cn.com   | ohhmama  |
#    Then I should get the authentication token

  Scenario Outline: Post a comment
    When I make a POST call to add a comment "<Comment>"
    Then I get response status code as 200
    And New post with comment "<Comment>" is present in the list of all posts

    Examples:
      |Comment        |
      |Luka Modric    |
      |Kylian Mbappe  |
      |Lionel Messi   |
      |Eden Hazard    |

  Scenario Outline: Post a comment
    When I make a POST call to add a comment "<Comment>"
    Then I get response status code as 200
    And New post with comment "<Comment>" is present in the list of all posts

    Examples:
      |Comment                  |
      |Joey doesn't share food  |
      |How yo doing             |