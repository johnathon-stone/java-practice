package com.airport.domain.reservation;

/**
 * Attributes: reservations (HashMap: key = flight number, value = list of passengers)
 * Method: addReservation(flightNumber, passenger)
 * 1. If the flightNumber exists in the reservations
 * HashMap:
 * a. Get the list of passengers for that flight.
 * b. Add the new passenger to the list.
 * 2. Otherwise:
 * a. Create a new list of passengers.
 * b. Add the new passenger to the list.
 * c. Put the list in the reservations HashMap with the flightNumber as the key.
 * Method: getPassengersForFlight(flightNumber)
 * 1. Return the list of passengers associated with the given flightNumber from the reservations HashMap. Return
 an empty list if the flight number isn't found.
 */

public class ReservationSystem {

}
