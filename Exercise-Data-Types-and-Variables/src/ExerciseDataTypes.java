public class ExerciseDataTypes {
    public static void main(String[] args){
//        Part 1: Declaring and Assigning Variables
//        Sports Statistics
        String playerName = "Lionel Messi";
        int jerseyNumber = 10;
        String position = "Forward";
        boolean isStarter = true;
        String teamName = "Inter Miami";

//        Movie Information
        String movieTitle = "Star Wars";
        int releaseYear = 1977;
        String rating = "PG";
        boolean isSequel = false;
        String leadActor = "Mark Hamill";

//        Weather Report
        String cityName ="Austin";
        float temperature = 75.0f;
        boolean isRaining = false;
        int humidity = 84;
        String weatherCondition = "mostly cloudy";

//        Flight Information
        String flightNumber = "AA 818";
        String departureCity = "Charlotte";
        String arrivalCity = "Austin";
        int gateNumber = 23;
        int terminal = 1;
        boolean isDelayed = false;

//        Part 2: Printing Variables
        System.out.println("Soccer Player: " + playerName + ". Starting status: " + isStarter + ". Wears jersey number: " + jerseyNumber + ". Position: " + position + ". Team: " + teamName + ".");
        System.out.println("The movie " + movieTitle + " was released in " + releaseYear + " and stars " + leadActor + ". Rating: " + rating + ", Sequel: " + isSequel + ".");
        System.out.println("Weather Report: " + cityName + " has a temperature of " + temperature + "°F with " + weatherCondition + " skies. Currently raining: " + isRaining + " with " + humidity + "%.");
        System.out.println("Flight Status Report: Flight# " + flightNumber + " departing from " + departureCity + " and arriving to " + arrivalCity + " at gate " + gateNumber + " terminal " + terminal + ". Delayed: " + isDelayed);

//        Part 3: Updating Variables
        jerseyNumber = 11;
        isStarter = false;
        rating = "PG-13";
        isSequel = true;
        temperature = 97.5f;
        weatherCondition = "sunny";
        gateNumber = 8;
        isDelayed = true;

        System.out.println("\nUpdated information for Soccer Player: " + playerName + ". New jersey number " + jerseyNumber + " and starting status: " + isStarter);
        System.out.println("Updated information for the movie: " + movieTitle + ". It's new Rating: " + rating + " Sequel: " + isSequel + ".");
        System.out.println("Updated Weather Report for: " + cityName + ". The temperature is now: " + temperature + "°F with " + weatherCondition + " skies.");
        System.out.println("Flight Status update for: " + flightNumber + " that is arriving in " + arrivalCity + ". Updated gate: " + gateNumber + " Delayed: " + isDelayed + ".");

//       Part 4: Working with Boolean Variables
        boolean hasHomework = false;
        boolean isWeekend = false;
        boolean attendedClass = true;

        System.out.println("\nDo I have homework? " + hasHomework);
        System.out.println("Is it the weekend? " + isWeekend);
        System.out.println("Did I attend class today? " + attendedClass);

//       Part 5: Exploring the char Data Type
        char firstInitial = 'J';
        char lastInitial = 'S';
        char favoriteGrade = 'A';

        System.out.println("\nMy initials are " + firstInitial + "." + lastInitial + ". and my favorite grade to get is an " + favoriteGrade + ".");
    }
}
