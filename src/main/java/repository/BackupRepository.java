package repository;

import models.Consult;
import models.Pet;
import models.Veterinarian;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class BackupRepository {

    private final ConsultRepository consultRepository;
    private final VeterinarianRepository veterinarianRepository;
    private final PetRepository petRepository;

    public BackupRepository() {
        this.consultRepository = new ConsultRepositoryImpl();
        this.petRepository = new PetRepositoryImpl();
        this.veterinarianRepository = new VeterinarianRepositoryImpl();
    }

    public void backUpConsult() {
        try {
            ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("src/main/resources/consult_backup.ser"));
            for (Consult consult : this.consultRepository.findAll()) {
                output.writeObject(consult);
            }
            output.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void backUpVeterinarian() {
        try {
            ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("src/main/resources/veterinarian_backup.ser"));
            for (Veterinarian veterinarian : this.veterinarianRepository.findAll()) {
                output.writeObject(veterinarian);
            }
            output.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void backUpPet() {
        try {
            ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("src/main/resources/pet_backup.ser"));
            for (Pet pet : this.petRepository.findAll()) {
                output.writeObject(pet);
            }
            output.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

