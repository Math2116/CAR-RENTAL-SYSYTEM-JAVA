
import java.util.*;

class Car {
    String model;
    double pricePerDay;
    boolean isRented;

    Car(String model, double pricePerDay) {
        this.model = model;
        this.pricePerDay = pricePerDay;
        this.isRented = false;
    }
}

public class CarRentalSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<Car> cars = new ArrayList<>();
        cars.add(new Car("Honda City", 2000));
        cars.add(new Car("Maruti Swift", 1500));
        cars.add(new Car("Toyota Fortuner", 3500));

        int choice;
        do {
            System.out.println("\n===== CAR RENTAL SYSTEM =====");
            System.out.println("1. View Available Cars");
            System.out.println("2. Rent a Car");
            System.out.println("3. Return a Car");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("\nAvailable Cars:");
                    for (int i = 0; i < cars.size(); i++) {
                        Car car = cars.get(i);
                        if (!car.isRented) {
                            System.out.println((i + 1) + ". " + car.model + " - ₹" + car.pricePerDay + "/day");
                        }
                    }
                    break;

                case 2:
                    System.out.println("\nEnter car number to rent:");
                    int rentChoice = sc.nextInt();
                    if (rentChoice >= 1 && rentChoice <= cars.size()) {
                        Car selected = cars.get(rentChoice - 1);
                        if (!selected.isRented) {
                            selected.isRented = true;
                            System.out.println("You have rented " + selected.model + ". Enjoy your ride!");
                        } else {
                            System.out.println("Sorry, this car is already rented.");
                        }
                    } else {
                        System.out.println("Invalid choice!");
                    }
                    break;

                case 3:
                    System.out.println("\nEnter car number to return:");
                    int returnChoice = sc.nextInt();
                    if (returnChoice >= 1 && returnChoice <= cars.size()) {
                        Car selected = cars.get(returnChoice - 1);
                        if (selected.isRented) {
                            selected.isRented = false;
                            System.out.println("You have returned " + selected.model + ". Thank you!");
                        } else {
                            System.out.println("This car was not rented.");
                        }
                    } else {
                        System.out.println("Invalid choice!");
                    }
                    break;

                case 4:
                    System.out.println("Exiting Car Rental System...");
                    break;

                default:
                    System.out.println("Invalid input! Try again.");
            }
        } while (choice != 4);

        sc.close();
    }
}

