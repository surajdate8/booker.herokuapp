Feature: Validating create booking API

  @CreateBooking
  Scenario Outline: Verify if bookig is successufully created for user
    Given add basic info of user with "<firstname>" "<lastname>"  "<additionalneeds>"
    When user call the "CreateBooking" api using "post" http request
    Then validate with http response code "200"
    And verify bookingID is created for "<firstname>" using "GetBooking"

    Examples: 
      | firstname | lastname | additionalneeds |
      | suraj     | date     | Lunch           |

  @UpdateBooking
  Scenario Outline: Verify if update booking functionality is working
    Given add basic info of user with "<firstname>" "<lastname>"  "<additionalneeds>"
    When user call the "UpdateBooking" api using "put" http request
    Then validate with http response code "200"

    Examples: 
      | firstname | lastname | additionalneeds |
      | suraj     | date     | Lunch           |

  @GetBooking
  Scenario Outline: Verify if get booking functionality is working
    Given user calls request api for "<bookingid>"
    When user call the "GetBooking" api using "get" http request
    Then validate with http response code "200"

    Examples: 
      | bookingid |
      |        10 |

  @DeleteBooking
  Scenario Outline: Verify if delete booking functionality is working
    Given user calls request api for "<bookingid>"
    When user call the "DeleteBooking" api using "delete" http request
    Then validate with http response code "201"

    Examples: 
      | bookingid |
      |        14 |
