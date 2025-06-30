package com.airport.data;

/**
 * Method: loadReservationsFromCSV(filename)
 *  1. Open the CSV file.
 *             2. Create an empty HashMap to store reservations (key:
 *             flight number, value: list of passengers).
 *             3. Read the file line by line.
 *             4. For each line:
 *     a. Split the line into parts (flight number, date,
 *                                   price, passenger name, passport, aircraft model, aircraft
 *                                           type).
 *     b. Create a Flight object using the flight number,
 *     date, price, and aircraft details.
 *     c. Create a Passenger object using the passenger name
 *     and passport.
 *     d. If the flight number already exists in the
 *     HashMap, get the existing list of passengers and add the
 * new passenger to it.
 *     Summative Assessment: Airport Terminal Management System - 13
 *     e. Otherwise, create a new list of passengers, add
 *     the new passenger to it, and put the list in the HashMap
 *     with the flight number as the key.
 *  5. Close the CSV file.
 *             6. Return the HashMap of reservations.
 *             Method: saveReservationsToCSV(filename, reservations)
 *  1. Open the CSV file in append mode.
 *  2. For each flight number in the reservations HashMap:
 *     a. Get the list of passengers for that flight number.
 *     b. For each passenger in the list:
 *     i. Get the flight details (date, price, aircraft
 *             model, aircraft type).
 *     ii. Write a new line to the CSV file with the
 *     flight number, date, price, passenger name, passport,
 *     aircraft model, and aircraft type.
 *             3. Close the CSV file.
 */

public class CSVUtil {

}
