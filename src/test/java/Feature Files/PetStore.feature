Feature: Petstore feature file for exec

  Scenario: login Petstore WebPage and Checkout the product
    Given Open the Chrome browser
    And Launch petstore url
    When Click on Sign in menu
    And Enter Petstore Username
    And Enter Petstore Password
    When Click on Petstore Login button
    Then Validate User redirects to the Catalog page
    When Click on the Pet Item 'Birds'
    And Click on the Product ID
    When Click on Add to Cart
    And Click on Proceed to Checkout
    When Click on Ship to different address
    And Click on Customer Details Continue button
    When User Enter Customer details asMap
      | First name | Senthilnathan                |
      | Last name  | Kaliyaperumal                |
      | Address 1  | 123, Kamarajar Street        |
      | Address 2  | Thillai Nagar, Thiruvanmiyur |
      | City       | Chennai                      |
      | State      | Tamilnadu                    |
      | Zip        |                       600041 |
      | Country    | India                        |
    And Click on Shipping Address Continue button
    When Click on Confirm button
    Then Validate order ID generated
