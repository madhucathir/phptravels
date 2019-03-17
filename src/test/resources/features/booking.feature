Feature: Cheapest price Flight Booking

  @smoke
  Scenario Outline: User search for the cheapest flight

    Given user is in landing page
    When user clicks the flights tab and selects the "<TypeOfTrip>"
    And user select "<DepartureAirPort>" and "<ArrivalAirPort>"
    And user selects "<DepartureDate>" and "<ReturnDate>"
    And also selects "<NoOfAdultTickets>" and "<NoOfChildTickets>"
    And user clicks on the search button
    And also user filter by the "<flightCarrier>"
    And user click on bookNow button with the cheapest price
    Then user must be taken to booking page



    Examples:
      |TypeOfTrip    | DepartureAirPort| ArrivalAirPort | DepartureDate       | ReturnDate       | NoOfAdultTickets | NoOfChildTickets | flightCarrier       |
      |  Round Trip  | LCY             | DXB            |  15-December-2020   | 17-December-2020 |   2              |       2          |     Tunisair,Qatar Airways  |