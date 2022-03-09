import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int option;
        displayMenu();

        do {
            option = askToChoose();

            switch (option) {
                case 1 -> {
                    displayVeterinarianMenu();
                    askToChoose();
                }
                case 2 -> {
                    displayPetMenu();
                    askToChoose();
                }
                case 3 -> {
                    displayConsultMenu();
                    askToChoose();
                }
                case 0 -> exit();
                case 9 -> {
                    displayMenu();
                    askToChoose();
                }
                default -> System.out.println("Choose a valid option");
            }
        } while (option == 0);
    }

    public static void displayMenu() {
        System.out.println();
        System.out.println("1. Veterinarian Menu");
        System.out.println("2. Pet Menu");
        System.out.println("3. Consult Menu");
        System.out.println("Press '0' to exit application");
    }

    public static void displayVeterinarianMenu() {
        System.out.println();
        System.out.println("1. Add a new veterinarian");
        System.out.println("2. Display a veterinarian");
        System.out.println("3. Update veterinarian profile");
        System.out.println("4. Delete a veterinarian");
        System.out.println("Press '9' for previous menu");
        System.out.println("Press '0' to exit application");
    }

    public static void displayPetMenu() {
        System.out.println();
        System.out.println("1. Add a new pet");
        System.out.println("2. Display a pet");
        System.out.println("3. Update pet profile");
        System.out.println("4. Delete a pet");
        System.out.println("Press '9' for previous menu");
        System.out.println("Press '0' to exit application");
    }

    public static void displayConsultMenu() {
        System.out.println();
        System.out.println("1. Add a new consult");
        System.out.println("2. Display a consult");
        System.out.println("3. Update consult data");
        System.out.println("4. Delete a consult");
        System.out.println("Press '9' for previous menu");
        System.out.println("Press '0' to exit application");
    }

    public static int askToChoose() {
        System.out.print("Choose an option from above:");
        return scanner.nextInt();
    }

    public static void exit() {
        System.out.println();
        System.out.println("See you soon !");
    }
}
