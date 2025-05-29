//  Part 1. Creating a Class and Instantiating Objects
//   p1.1.1 Create a class with 'String brand, String model, int year'.
public class Car {
    String brand;
    String model;
    int year;

//   p1.1.2 Create a constructor to initialize all variables.
    public Car(String brand, String model, int year) {
        this.brand = brand;
        this.model = model;
        this.year = year;
    }

//   p1.1.3 Create a method 'displayInfo()' that prints the car's details.
    public void displayInfo() {
        System.out.println("Brand: " + brand + ", Model: " + model + ", Year: " + year + ".");
    }

}
