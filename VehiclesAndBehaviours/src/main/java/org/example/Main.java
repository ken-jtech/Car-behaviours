package org.example;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            // Prompt user to choose between Sedan and SUV
            System.out.println("Choose your vehicle category:");
            System.out.println("1. Sedan");
            System.out.println("2. SUV");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            Vehicle vehicle;

            if (choice == 1) {
                System.out.println("You selected Sedan. Choose your model:");
                System.out.println("1. Toyota Corolla");
                System.out.println("2. Honda Civic");
                System.out.println("3. Hyundai Elantra");
                System.out.println("4. Nissan Sentra");
                System.out.println("5. Chevrolet Impala");
                System.out.println("6. Chrysler 300");

                int modelChoice = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                String model = "";
                String vin = "";
                Engine engine;
                String tyres;

                switch (modelChoice) {
                    case 1:
                        model = "Toyota Corolla";
                        vin = "VINTOYCOR001";
                        engine = new Engine("TOYCOR1234A");
                        tyres = "205/55R16 (All-Season)";
                        break;
                    case 2:
                        model = "Honda Civic";
                        vin = "VINHONCIV001";
                        engine = new Engine("HONCIV2000A");
                        tyres = "215/55R16 (All-Season)";
                        break;
                    case 3:
                        model = "Hyundai Elantra";
                        vin = "VINHYUELA001";
                        engine = new Engine("HYUELA2000A");
                        tyres = "205/55R16 (All-Season)";
                        break;
                    case 4:
                        model = "Nissan Sentra";
                        vin = "VINNISSEN001";
                        engine = new Engine("NISSEN2000A");
                        tyres = "205/60R16 (All-Season)";
                        break;
                    case 5:
                        model = "Chevrolet Impala";
                        vin = "VINCHEIMP001";
                        engine = new Engine("CHEIMP2500A");
                        tyres = "215/60R16 (All-Season)";
                        break;
                    case 6:
                        model = "Chrysler 300";
                        vin = "VINCHRY3001";
                        engine = new Engine("CHRY3003500A");
                        tyres = "225/60R18 (All-Season)";
                        break;
                    default:
                        throw new InvalidInputException("Invalid model choice for Sedan.");
                }

                vehicle = new Sedan(vin, model, engine, tyres);

            } else if (choice == 2) {
                System.out.println("You selected SUV. Choose your model:");
                System.out.println("1. Toyota RAV4");
                System.out.println("2. Honda CR-V");
                System.out.println("3. Nissan Rogue");
                System.out.println("4. Ford Escape");
                System.out.println("5. Chevrolet Equinox");

                int modelChoice = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                String model = "";
                String vin = "";
                Engine engine;
                String tyres;

                switch (modelChoice) {
                    case 1:
                        model = "Toyota RAV4";
                        vin = "VINTOYRAV001";
                        engine = new Engine("TOYRAV2500A");
                        tyres = "225/65R17 (All-Season)";
                        break;
                    case 2:
                        model = "Honda CR-V";
                        vin = "VINHONCRV001";
                        engine = new Engine("HONCRV2000A");
                        tyres = "235/65R17 (All-Season)";
                        break;
                    case 3:
                        model = "Nissan Rogue";
                        vin = "VINNISROG001";
                        engine = new Engine("NISROG2500A");
                        tyres = "225/60R18 (All-Season)";
                        break;
                    case 4:
                        model = "Ford Escape";
                        vin = "VINFORESC001";
                        engine = new Engine("FORESP1500T");
                        tyres = "225/60R17 (All-Season)";
                        break;
                    case 5:
                        model = "Chevrolet Equinox";
                        vin = "VINCHEEQU001";
                        engine = new Engine("CHEEQU1500T");
                        tyres = "225/65R17 (All-Season)";
                        break;
                    default:
                        throw new InvalidInputException("Invalid model choice for SUV.");
                }

                vehicle = new SUV(vin, model, engine, tyres);

            } else {
                throw new InvalidInputException("Invalid vehicle choice.");
            }

            // Display selected vehicle information
            vehicle.displayInfo();

            // Handle start, drive, and stop commands
            handleVehicleOperations(scanner, vehicle);

        } catch (InvalidInputException e) {
            System.err.println("Error: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }

    // Operations for car behaviours
    private static void handleVehicleOperations(Scanner scanner, Vehicle vehicle) {
        String command = "";

        while (!command.equalsIgnoreCase("exit")) {
            System.out.println("\nEnter a command (start, drive, stop, exit):");
            command = scanner.nextLine().trim().toLowerCase();

            switch (command) {
                case "start" -> vehicle.start();
                case "drive" -> vehicle.drive();
                case "stop" -> vehicle.stop();
                case "exit" -> System.out.println("Exiting vehicle operations.");
                default -> System.out.println("Invalid command. Please enter 'start', 'drive', 'stop', or 'exit'.");
            }
        }
    }
}
