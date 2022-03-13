package console;

import models.Consult;
import models.Pet;
import models.Veterinarian;
import repository.*;

import java.util.Scanner;

public class Console {
    private static final Scanner scannerNumber = new Scanner(System.in);
    private static final Scanner scannerText = new Scanner(System.in);
    private static final ConsultRepository consultRepository = new ConsultRepositoryImpl();
    private static final PetRepository petRepository = new PetRepositoryImpl();
    private static final VeterinarianRepository veterinarianRepository = new VeterinarianRepositoryImpl();
    private static final BackupRepository backupRepository = new BackupRepository();

    public static void startApp() {
        showMenu();

        int option;
        String option2 = null;
        do {
            System.out.print("Choose an option from above: ");
            option = scannerNumber.nextInt();
            switch (option) {
                case 1 -> {
                    showVeterinarianMenu();
                    int opt = askToChoose();
                    switch (opt) {
                        case 1 -> addVeterinarian();
                        case 2 -> showVeterinarian();
                        case 3 -> updateVeterinarian();
                        case 4 -> deleteVeterinarian();
                    }
                }
                case 2 -> {
                    showPetMenu();
                    int opt = askToChoose();
                    switch (opt) {
                        case 1 -> addPet();
                        case 2 -> showPet();
                        case 3 -> updatePet();
                        case 4 -> deletePet();
                    }
                }
                case 3 -> {
                    showConsultMenu();
                    int opt = askToChoose();
                    switch (opt) {
                        case 1 -> addConsult();
                        case 2 -> showConsult();
                        case 3 -> updateConsult();
                        case 4 -> deleteConsult();
                    }
                }
                case 4 -> {
                    showBackUpMenu();
                    int opt = askToChoose();
                    switch (opt) {
                        case 1 -> backupRepository.backUpVeterinarian();
                        case 2 -> backupRepository.backUpPet();
                        case 3 -> backupRepository.backUpConsult();

                    }
                }
                case 0 -> exit();
                case 9 -> startApp();
                default -> System.out.println("You did not choose a valid option !");
            }
        } while (option != 0);
    }

    private static void addVeterinarian() {
        System.out.print("Introduce veterinarian first name: ");
        String firstName = scannerText.next();
        System.out.print("Introduce veterinarian last name: ");
        String lastName = scannerText.next();
        System.out.print("Introduce veterinarian address: ");
        String address = scannerText.next();
        System.out.print("Introduce veterinarian speciality: ");
        String speciality = scannerText.next();
        Veterinarian veterinarian = new Veterinarian(firstName, lastName, address, speciality);
        veterinarianRepository.save(veterinarian);
        System.out.println("Veterinarian added successfully !");
    }

    private static void showVeterinarian() {
        System.out.println("Introduce veterinarian id to show: ");
        System.out.println(veterinarianRepository.findById(scannerNumber.nextInt()));
    }

    private static void updateVeterinarian() {
        try {
            System.out.println("Introduce veterinarian id to update: ");
            int option = scannerNumber.nextInt();
            Veterinarian veterinarian = veterinarianRepository.findById(option).orElseThrow();

            System.out.print("Introduce updated veterinarian first name: ");
            veterinarian.setFirstName(scannerText.next());

            System.out.print("Introduce updated veterinarian last name: ");
            veterinarian.setLastName(scannerText.next());

            System.out.print("Introduce updated veterinarian address: ");
            veterinarian.setAddress(scannerText.next());

            System.out.print("Introduce updated veterinarian speciality: ");
            veterinarian.setSpeciality(scannerText.next());

            veterinarianRepository.update(veterinarian);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        System.out.println("Veterinarian updated successfully !");

    }

    private static void deleteVeterinarian() {
        try {
            System.out.println("Introduce veterinarian id to delete: ");
            Veterinarian veterinarian = veterinarianRepository.findById(scannerNumber.nextInt()).orElseThrow();
            veterinarianRepository.delete(veterinarian);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

    }

    private static void addConsult() {
        System.out.print("Introduce consult date: ");
        String date = scannerText.next();
        System.out.print("Introduce consult description: ");
        String description = scannerText.next();

        Consult consult = new Consult(date, description);
        try {
            System.out.println("Introduce pet id for this consult: ");
            consult.setPet(petRepository.findById(scannerNumber.nextInt()).orElseThrow());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        consultRepository.save(consult);
        System.out.println("Consult added successfully !");
    }

    private static void showConsult() {
        System.out.println("Introduce consult id to show: ");
        System.out.println(consultRepository.findById(scannerNumber.nextInt()));
    }

    private static void updateConsult() {
        try {
            System.out.println("Introduce consult id to update: ");
            int option = scannerNumber.nextInt();
            Consult consult = consultRepository.findById(option).orElseThrow();

            System.out.print("Introduce updated consult date: ");
            consult.setDate(scannerText.next());

            System.out.print("Introduce updated consult description: ");
            consult.setDescription(scannerText.next());

            System.out.print("Introduce pet id for updated consult: ");
            consult.setPet(petRepository.findById(scannerNumber.nextInt()).orElseThrow());

            consultRepository.update(consult);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        System.out.println("Consult added successfully !");

    }

    private static void deleteConsult() {
        try {
            System.out.println("Introduce consult id to delete: ");
            Consult consult = consultRepository.findById(scannerNumber.nextInt()).orElseThrow();
            consultRepository.delete(consult);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    private static void addPet() {
        System.out.print("Introduce pet breed: ");
        String breed = scannerText.next();

        System.out.print("Introduce pet birth date: ");
        String birthDate = scannerText.next();

        System.out.print("Introduce pet owner name: ");
        String owner = scannerText.next();

        System.out.print("Is the pet vaccinated ? (yes/no): ");
        boolean isVaccinated = scannerText.next().equalsIgnoreCase("yes");

        Pet pet = new Pet(breed, birthDate, isVaccinated, owner);
        petRepository.save(pet);

        System.out.println("Pet added successfully !");
    }

    private static void showPet() {
        System.out.println("Introduce pet id to show: ");
        System.out.println(petRepository.findById(scannerNumber.nextInt()));
    }

    private static void updatePet() {
        try {
            System.out.println("Introduce pet id to update: ");
            int option = scannerNumber.nextInt();

            Pet pet = petRepository.findById(option).orElseThrow();

            System.out.print("Introduce updated pet breed: ");
            pet.setBreed(scannerText.next());

            System.out.print("Introduce updated pet birth date: ");
            pet.setBirthDate(scannerText.next());

            System.out.print("Is this pet vaccinated? ");
            pet.setVaccinated(scannerText.next().equalsIgnoreCase("yes"));

            System.out.print("Introduce updated pet owner name: ");
            pet.setOwner(scannerText.next());

            petRepository.update(pet);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        System.out.println("Pet updated successfully !");

    }

    private static void deletePet() {
        try {
            System.out.println("Introduce pet id to delete: ");
            Pet pet = petRepository.findById(scannerNumber.nextInt()).orElseThrow();
            petRepository.delete(pet);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    public static void showMenu() {
        System.out.println();
        System.out.println("1. Veterinarian Menu");
        System.out.println("2. Pet Menu");
        System.out.println("3. Consult Menu");
        System.out.println("4. BackUp Menu");
        System.out.println("Press '0' to exit application");
    }

    public static void showBackUpMenu() {
        System.out.println();
        System.out.println("1. Veterinarian ");
        System.out.println("2. Pet ");
        System.out.println("3. Consult ");
        System.out.println("Press '0' to exit application");
    }

    public static void showVeterinarianMenu() {
        System.out.println();
        System.out.println("1. Add a new veterinarian");
        System.out.println("2. Display a veterinarian");
        System.out.println("3. Update veterinarian profile");
        System.out.println("4. Delete a veterinarian");
        System.out.println("Press '9' for previous menu");
        System.out.println("Press '0' to exit application");
    }

    public static void showPetMenu() {
        System.out.println();
        System.out.println("1. Add a new pet");
        System.out.println("2. Display a pet");
        System.out.println("3. Update pet profile");
        System.out.println("4. Delete a pet");
        System.out.println("Press '9' for previous menu");
        System.out.println("Press '0' to exit application");
    }

    public static void showConsultMenu() {
        System.out.println();
        System.out.println("1. Add a new consult");
        System.out.println("2. Display a consult");
        System.out.println("3. Update consult data");
        System.out.println("4. Delete a consult");
        System.out.println("Press '9' for previous menu");
        System.out.println("Press '0' to exit application");
    }

    public static int askToChoose() {
        System.out.print("Choose an option from above: ");
        return scannerNumber.nextInt();
    }

    public static void exit() {
        System.out.println();
        System.out.println("See you soon !");
    }
}
